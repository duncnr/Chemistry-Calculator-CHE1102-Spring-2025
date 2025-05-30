import java.util.Scanner;

public class BufferDriver {
    double saved[] = new double[10];

    BufferDriver(Scanner sc, String tabs, double[] saved) {
        tabs = "\t" + tabs;

        for (int i = 0; i < 10; ++i) {
            this.saved[i] = saved[i];
        }

        int choice = 1;
        while (choice > 0) {
            System.out.print("\n" +
                    tabs + "Select a number 1-3 based on the options below:\n" +
                    tabs + "  1) Henderson-Hasselbalch\n" +
		    tabs + "  2) Determination of Ksp (at 25C)\n" +
                    tabs + "  3) Help\n" +
                    tabs + "Enter: ");
            choice = sc.nextInt();
            select(sc, tabs, choice);
        }
    }

    private void select(Scanner sc, String tabs, int choice) {
        tabs = "\t" + tabs;

	int unknown;
	switch(choice) {
	    case 1:
		String[] menu = {"Ka", "Kb", "[acid]", "[base]", "[conj. base]", "[conj. acid]"};
		System.out.print("\n" + 
			tabs + "Enter buffer base:\n" +
			tabs + "  1) weak acid\n" +
			tabs + "  2) weak base\n" +
			tabs + "Enter: ");
		unknown = sc.nextInt();

		int uni = unknown - 1;

		System.out.println();
		for(int i = 0; i < menu.length; ++i) {
		    if(i % 2 == uni % 2) {
		    	System.out.print(tabs + "Enter " + menu[i] + ": ");
		    	saved[i / 2] = sc.nextDouble(); 
		    }
		}

		if(uni == 0)
		    System.out.println("\n" + tabs + "pH = " + Buffers.hhKa(saved[0], saved[1], saved[2]));
		else
		    System.out.println("\n" + tabs + "pH = " + Buffers.hhKb(saved[0], saved[1], saved[2]));
		break;

	    case 2:
		String[] menu2 = {"Ksp of reaction", "coefficient of r1", "coefficient of r2"};

		System.out.println();
		for(int i = 0; i < menu2.length; ++i) {
		    System.out.print(tabs + "Enter " + menu2[i] + ": ");
		    saved[i] = sc.nextDouble();
		}
		System.out.println();

		saved = Buffers.ksp(saved, saved[0], saved[1], saved[2]);

		for(int i = 0; i < 2; ++i)
		    System.out.println(tabs + "[r" + (i + 1) + "] = " + saved[i]);

		break;

	    default:
                System.out.println("\n" + tabs + HelpDriver.help(sc, tabs));
		break;
	}
    }
}
