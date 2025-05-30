import java.util.Scanner;

public class AcidBaseEquiDriver {
    double saved[] = new double[10];

    AcidBaseEquiDriver(Scanner sc, String tabs, double[] saved) {
        tabs = "\t" + tabs;

        for (int i = 0; i < 10; ++i) {
            this.saved[i] = saved[i];
        }

        int choice = 1;
        while (choice > 0) {
            System.out.print("\n" +
                    tabs + "Select a number 1-3 based on the options below:\n" +
                    tabs + "  1) Relationship between [H], [OH], pH, and pOH\n" +
		    tabs + "  2) Relationship between Ka, Kb, pH, and pOH\n" +
                    tabs + "  3) Help\n" +
                    tabs + "Enter: ");
            choice = sc.nextInt();
            select(sc, tabs, choice);
        }
    }

    private void select(Scanner sc, String tabs, int choice) {
        tabs = "\t" + tabs;

        int get, with;
	int geti, withi;
	double ans;
        switch (choice) {
	    case 1:
		String[] menu1 = {"[H+]", "[OH-]", "pH", "pOH"};

		System.out.print("\n" + tabs + "Select unknown variable:\n");
                for(int i = 0; i < menu1.length; ++i)
		    System.out.println(tabs + "  " + (i + 1) + ") " + menu1[i]);
                System.out.print(tabs + "Enter: ");
                get = sc.nextInt();

		geti = get - 1;

		System.out.print("\n" + tabs + "Select known variable:\n");
		for(int i = 0; i < menu1.length; ++i) {
		    if(i < geti) {
			System.out.println(tabs + "  " + (i + 1) + ") " + menu1[i]);
		    }
		    else if(i > geti) {
			System.out.println(tabs + "  " + i + ") " + menu1[i]);
		    }
		}
		System.out.print(tabs + "Enter: ");
		with = sc.nextInt();

		if(with >= get) ++with;

		withi = with - 1;

		System.out.print("\n" + tabs + "Enter " + menu1[withi] + ": ");
		saved[0] = sc.nextDouble();

		ans = relation(geti, withi, saved[0]);

		System.out.println("\n" + tabs + menu1[geti] + " = " + ans);
		break;

	    case 2: 
		String[] menu2 = {"Ka", "Kb", "pH", "pOH"};

		System.out.print("\n" + tabs + "Select unknown variable:\n");
                for(int i = 0; i < menu2.length; ++i)
		    System.out.println(tabs + "  " + (i + 1) + ") " + menu2[i]);
                System.out.print(tabs + "Enter: ");
                get = sc.nextInt();

		geti = get - 1;

		System.out.print("\n" + tabs + "Select known variable:\n");
		for(int i = 0; i < menu2.length / 2; ++i) {
		    if(geti > 1) {
			System.out.println(tabs + "  " + (i + 1) + ") " + menu2[i]);
		    }
		    else {
			System.out.println(tabs + "  " + (i + 1) + ") " + menu2[i + 2]);
		    }
		}
		System.out.print(tabs + "Enter: ");
		with = sc.nextInt();

		withi = with - 1;

		if(geti < 1) withi += 2;

		System.out.print("\n" + tabs + "Enter initial concentration: ");
		saved[0] = sc.nextDouble();
		System.out.print(tabs + "Enter " + menu2[withi] + ": ");
		saved[1] = sc.nextDouble();

		ans = relation2(geti, withi, saved[0], saved[1]);

		System.out.println("\n" + tabs + menu2[geti] + " = " + ans);
		break;

 	    default:
                System.out.println("\n" + tabs + HelpDriver.help(sc, tabs));
		break;
	}
    }

    // 0 <= (get && with) < 4
    private double relation(int get, int with, double use) {
	int withcat = with / 2;
	int getcat = get / 2;

	if(withcat == getcat) {
	    if(getcat == 0) return AcidBaseEquilibrium.conc(use);
	    else return AcidBaseEquilibrium.pHOH(use);
	}
	
	if(get % 2 == with % 2) {
	    if(getcat == 0) 
		return AcidBaseEquilibrium.concpHOH(use);
	    else return AcidBaseEquilibrium.pHOHconc(use);
	}
	
	if(getcat == 0)
	    return AcidBaseEquilibrium.concpHOH(AcidBaseEquilibrium.pHOH(use));
	return AcidBaseEquilibrium.pHOHconc(AcidBaseEquilibrium.conc(use));
    }

    private double relation2(int get, int with, double initial, double use) {
	int getcat = get / 2;
	int getr = get % 2;
	int withr = with % 2;

	if(getcat == 0) {
	    if(getr == withr) return AcidBaseEquilibrium.kpHOH(initial, use);
	    else return AcidBaseEquilibrium.kpHOHpHOH(initial, use);
	}
	if(getr == withr) return AcidBaseEquilibrium.pKab(initial, use);
	else return AcidBaseEquilibrium.pKabKab(initial, use);
    }
}
