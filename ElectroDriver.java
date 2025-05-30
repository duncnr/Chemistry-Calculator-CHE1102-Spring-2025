import java.util.Scanner;

public class ElectroDriver {
    double saved[] = new double[10];

    ElectroDriver(Scanner sc, String tabs, double[] saved) {
        tabs = "\t" + tabs;

        for (int i = 0; i < 10; ++i) {
            this.saved[i] = saved[i];
        }

        int choice = 1;
        while (choice > 0) {
            System.out.print("\n" +
                    tabs + "Select a number 1-4 based on the options below:\n" +
                    tabs + "  1) Coulombs\n" +
		    tabs + "  2) Relationship bewteen Coulombs and mass\n" +
		    tabs + "  3) E cell\n" +
                    tabs + "  4) Gibbs Free Energy\n" +
                    tabs + "  5) Help\n" +
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
		System.out.print("\n" + 
			tabs + "Enter unknown:\n" +
			tabs + "  1) C Coulombs\n" +
			tabs + "  2) amp amperes\n" +
			tabs + "  3) s sec\n" +
			tabs + "Enter: ");
		unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: C, amp, s\n" +
                        tabs + "  ... and omit what is unknown");

                for (int i = 0; i < 2; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

		switch(unknown) {
		    case 1:
			System.out.println("\n" + tabs + "C = " + Electrochemistry.coulombC(saved[0], saved[1]));
			break;

		    case 2:
			System.out.println("\n" + tabs + "amps = " + Electrochemistry.coulombAS(saved[0], saved[1]));
			break;

		    case 3:
			System.out.println("\n" + tabs + "s = " + Electrochemistry.coulombAS(saved[0], saved[1]));
			break;

		    default:
			break;
		}
		break;

	    case 2: 
		String[] menu2 = {"coulombs", "initial mass", 
			"mol e- coefficient", "oxidation", "reduction", 
			"molecular weight"};

		System.out.print("\n" + tabs + "Enter unknown:\n" +
			tabs + "  1) mass\n" +
			tabs + "  2) coulombs\n" +
			tabs + "Enter: ");
		unknown = sc.nextInt();
		int uni = unknown - 1;

		System.out.print("\n" + tabs + "Enter " + menu2[uni] + ": ");
		saved[0] = sc.nextDouble();

		for(int i = 0; i < 2; ++i) {
		    System.out.print(tabs + "Enter " + menu2[2] + " of the " + menu2[3 + i] + " half-reaction: ");
		    saved[i + 1] = sc.nextDouble();
		}

		System.out.print(tabs + "Enter " + menu2[5] + " of oxidizing agent: ");
		saved[3] = sc.nextDouble();

		System.out.print(tabs + "Enter efficiency %: ");
		saved[4] = sc.nextDouble();

		if(unknown == 1)
		    System.out.println("\n" + tabs + "grams = " + Electrochemistry.massC(saved[0],
					    						 saved[1],
											 saved[2],
											 saved[3],
											 saved[4]));
		else if(unknown == 2)
		    System.out.println("\n" + tabs + "coulombs = " + Electrochemistry.coulM(saved[0],
					    						    saved[1],
											    saved[2],
											    saved[3],
											    saved[4]));

		break;

	    case 3:
		String[] menu3 = {"E red", "E ox"};
		
		System.out.println();
		for(int i = 0; i < 2; ++i) {
		    System.out.print(tabs + "Enter " + menu3[i] + ": ");
		    saved[i] = sc.nextDouble();
		}

		System.out.println("\n" + tabs + "E cell = " + (saved[0] + saved[1]));
		break;

	    case 4:
		String[] menu4 = {"mol E", "E cell"};

		System.out.println();
		for(int i = 0; i < 2; ++i) {
		    System.out.print(tabs + "Enter " + menu4[i] + ": ");
		    saved[i] = sc.nextDouble();
		}

		System.out.println("\n" + tabs + "Delta G = " + Electrochemistry.gibbsFree(saved[0], saved[1]));
		break;

	    case 5:
                System.out.println("\n" + tabs + HelpDriver.help(sc, tabs));
		break;
	
	    default:
		break;
	}
    }
}
