import java.util.Scanner;

public class GasLawDriver {
    double saved[] = new double[10];

    GasLawDriver(Scanner sc, String tabs, double[] saved) {
        tabs = "\t" + tabs;

        for (int i = 0; i < 10; ++i) {
            this.saved[i] = saved[i];
        }

        int choice = 1;
        while (choice > 0) {
            System.out.print("\n" +
                    tabs + "Select a number based on the options below:\n" +
                    tabs + "  1) Combined Gas Law Equation\n" +
		    tabs + "  2) Boyle's Law\n" +
		    tabs + "  3) Charles' Law\n" +
		    tabs + "  4) Gay-Lussac's Law\n" +
                    tabs + "  5) Ideal Gas Law Equation\n" +
                    tabs + "  6) Help\n" +
                    tabs + "Enter: ");
            choice = sc.nextInt();
            select(sc, tabs, choice);
        }
    }

    private void select(Scanner sc, String tabs, int choice) {
        tabs = "\t" + tabs;

	int unknown;
	double p1, v1, t1, p2, v2, t2;
	double c = 1;
	switch (choice) {
            case 0:
                break;

            case 1:
                System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) P pressure\n" +
                        tabs + "  2) V volume\n" +
                        tabs + "  3) T temperature\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "(unknown) P, V, T, (known) P, V, T\n" +
                        tabs + "  ... and omit what is unknown");

		for (int i = 0; i < 5; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                switch (unknown) {
                    case 1:
			v1 = saved[0];
			t1 = saved[1];
			p2 = saved[2];
			v2 = saved[3];
			t2 = saved[4];
                        System.out.println("\n" + tabs + "pressure = " + GasLaws.combinedP(v1, t1, p2, v2, t2));
                        break;

                    case 2:
			p1 = saved[0];
			t1 = saved[1];
			p2 = saved[2];
			v2 = saved[3];
			t2 = saved[4];
                        System.out.println("\n" + tabs + "volume = " + GasLaws.combinedV(p1, t1, p2, v2, t2));
                        break;

                    case 3:
			p1 = saved[0];
			v1 = saved[1];
			p2 = saved[2];
			v2 = saved[3];
			t2 = saved[4];
                        System.out.println("\n" + tabs + "temperature = " + GasLaws.combinedT(p1, v1, p2, v2, t2));
                        break;

                    default:
                        break;
                }
                break;

            case 2:
		System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) P pressure\n" +
                        tabs + "  2) V volume\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "(unknown) P, V, (known) P, V\n" +
                        tabs + "  ... and omit what is unknown");

                for (int i = 0; i < 3; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                switch (unknown) {
                    case 1:
			v1 = saved[0];
			p2 = saved[1];
			v2 = saved[2];
                        System.out.println("\n" + tabs + "pressure = " + GasLaws.combinedP(v1, c, p2, v2, c));
                        break;

                    case 2:
			p1 = saved[0];
			p2 = saved[1];
			v2 = saved[2];
                        System.out.println("\n" + tabs + "volume = " + GasLaws.combinedV(p1, c, p2, v2, c));
                        break;

                    default:
                        break;
                }
                break;

            case 3:
		System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) V volume\n" +
                        tabs + "  2) T temperature\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "(unknown) V, T, (known) V, T\n" +
                        tabs + "  ... and omit what is unknown");

                for (int i = 0; i < 3; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                switch (unknown) {
                    case 1:
			t1 = saved[0];
			v2 = saved[1];
			t2 = saved[2];
                        System.out.println("\n" + tabs + "volume = " + GasLaws.combinedV(c, t1, c, v2, t2));
                        break;

                    case 2:
			v1 = saved[0];
			v2 = saved[1];
			t2 = saved[2];
                        System.out.println("\n" + tabs + "temperature = " + GasLaws.combinedT(c, v1, c, v2, t2));
                        break;

                    default:
                        break;
                }
                break;

            case 4:
	 	System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) P pressure\n" +
                        tabs + "  2) T temperature\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "(unknown) P, T, (known) P, T\n" +
                        tabs + "  ... and omit what is unknown");

                switch (unknown) {
                    case 1:
			t1 = saved[0];
			p2 = saved[1];
			t2 = saved[2];
                        System.out.println("\n" + tabs + "pressure = " + GasLaws.combinedP(c, t1, p2, c, t2));
                        break;

                    case 2:
			p1 = saved[0];
			p2 = saved[1];
			t2 = saved[2];
                        System.out.println("\n" + tabs + "temperature = " + GasLaws.combinedT(p1, c, p2, c, t2));
                        break;

                    default:
                        break;
                }	
                break;

	    case 5:
	 	System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) P pressure\n" +
                        tabs + "  2) V volume\n" +
			tabs + "  3) n moles\n" +
			tabs + "  4) T temperature\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "P, V, n, T\n" +
                        tabs + "  ... and omit what is unknown");

                for (int i = 0; i < 3; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

		double p, v, n, t;
		double r = 0.08206;
                switch (unknown) {
                    case 1:
			v = saved[0];
			n = saved[1];
			t = saved[2];
                        System.out.println("\n" + tabs + "pressure = " + GasLaws.idealP(v, n, r, t));
                        break;

                    case 2:
			p = saved[0];
			n = saved[1];
			t = saved[2];
                        System.out.println("\n" + tabs + "volume = " + GasLaws.idealV(p, n, r, t));
                        break;

		    case 3:
			p = saved[0];
			v = saved[1];
			t = saved[2];
                        System.out.println("\n" + tabs + "moles = " + GasLaws.idealN(p, v, r, t));
			break;

		    case 4:
			p = saved[0];
			v = saved[1];
			n = saved[2];
	                System.out.println("\n" + tabs + "temperature = " + GasLaws.idealT(p, v, n, r));
			break;

                    default:
                        break;
                }	
		break;

            default:
                System.out.println("\n" + tabs + HelpDriver.help(sc, tabs));
                break;
        }
    }
}
