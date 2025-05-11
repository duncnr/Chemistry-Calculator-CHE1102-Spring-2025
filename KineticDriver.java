import java.util.Scanner;

public class KineticDriver {
    double saved[] = new double[10];

    KineticDriver(Scanner sc, String tabs, double[] saved) {
        tabs = "\t" + tabs;

        for (int i = 0; i < 10; ++i) {
            this.saved[i] = saved[i];
        }

        int choice = 1;
        while (choice > 0) {
            System.out.print("\n" +
                    tabs + "Select a number 1-7 based on the options below:\n" +
                    tabs + "  1) Rate Law Expression\n" +
                    tabs + "  2) Method of Initial Rates\n" +
                    tabs + "  3) First Order Concentration v. Time\n" +
                    tabs + "  4) First Order Half-Life\n" +
                    tabs + "  5) Second Order Concentration v. Time\n" +
                    tabs + "  6) Second Order Half-Life\n" +
                    tabs + "  7) Help\n" +
                    tabs + "Enter: ");
            choice = sc.nextInt();
            select(sc, tabs, choice);
        }
    }

    private void select(Scanner sc, String tabs, int choice) {
        tabs = "\t" + tabs;

        int unknown, numReact;
	double k, A0, At, t;
        switch (choice) {
            case 0:
                break;

            case 1:
                System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) rate\n" +
                        tabs + "  2) k\n" +
                        tabs + "  3) reactant\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.print("\n" + tabs + "Enter number of reactants: ");
                numReact = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "rate, k, concentration reactants\n" +
                        tabs + "  ... and omit what is unknown");

                for (int i = 0; i < (1 + numReact); ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }
                System.out.println();

                double reactants[];
                if (unknown == 3) {
                    --numReact;
                    reactants = new double[numReact];
                    for (int i = 0; i < numReact; ++i) {
                        System.out.print("\n" + tabs + "Enter the order of [r" + (i + 1) + "]: ");
                        int order = sc.nextInt();
                        reactants[i] = Math.pow(saved[i + 2], order);
                    }
                } else {
                    reactants = new double[numReact];
                    for (int i = 0; i < numReact; ++i) {
                        System.out.print(tabs + "Enter the order of [r" + (i + 1) + "]: ");
                        int order = sc.nextInt();
                        reactants[i] = Math.pow(saved[i + 1], order);
                    }
                }

                double Ta;
                switch (unknown) {
                    case 1:
                        k = saved[0];
                        System.out.println("\n" + tabs + "rate = " + Kinetics.rateLawRXN(k, reactants));
                        break;

                    case 2:
                        Ta = saved[0];
                        System.out.println("\n" + tabs + "k = " + Kinetics.rateLawK(Ta, reactants));
                        break;

                    case 3:
                        Ta = saved[0];
                        k = saved[1];
                        if (numReact != 0) {
                            System.out.println("\n" + tabs + "[react] = " + Kinetics.rateLawR(Ta, k, reactants));
                        } else
                            System.out.println("\n" + tabs + "[react] = " + Kinetics.rateLawR(Ta, k));
                        break;

                    default:
                        break;
                }
                break;

            case 2:
                System.out.print("\n" + tabs + "Enter number of reactants: ");
                numReact = sc.nextInt();

                double trials[][] = new double[numReact][5];
                for (int i = 0; i < numReact; ++i) {
		    trials[i][0] = 0;
                    System.out.println("\n" + tabs + "--Enter trial data where the concentration of reactant " + (i + 1) + " differs--");
                    System.out.print(tabs + "    (Trial A) Enter initial concentration: ");
                    trials[i][1] = sc.nextDouble();
                    System.out.print(tabs + "    (Trial A) Enter initial rate: ");
		    trials[i][2] = sc.nextDouble();
                    System.out.print(tabs + "    (Trial B) Enter initial concentration: ");
		    trials[i][3] = sc.nextDouble();
                    System.out.print(tabs + "    (Trial B) Enter initial rate: ");
		    trials[i][4] = sc.nextDouble();
                }

                for(int i = 0; i < trials.length; ++i) {
                    double ta = trials[i][1];
                    double tb = trials[i][3];

                    if (ta < tb) trials[i][0] = 1;
                }

		System.out.println();
		for(int i = 0; i <trials.length; ++i) {
		    if(trials[i][0] == 1) {
			System.out.println(tabs + "rxn order of [r" + (i + 1) + "] = " +
			    (int) (Kinetics.initialRates(
				    trials[i][3],
				    trials[i][1],
				    trials[i][4],
				    trials[i][2]) + 0.5));
		    }
		    else{
			System.out.println(tabs + "rxn order of [r" + (i + 1) + "] = " +
			    (int) (Kinetics.initialRates(
				    trials[i][1],
				    trials[i][3],
				    trials[i][2],
				    trials[i][4]) + 0.5));
		    }
		}
                break;

	    case 3:
                System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) [A]0 initial concentration\n" +
                        tabs + "  2) [A]t instantaneous concentration\n" +
			tabs + "  3) k rate constant\n" +
			tabs + "  4) t time past\n" + 
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "[A]0, [A]t, k, t\n" +
                        tabs + "  ... and omit what is unknown");

		for(int i = 0; i < 3; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
		}

		switch(unknown) {
		    case 1:
			At = saved[0];
			k = saved[1];
			t = saved[2];
                        System.out.println("\n" + tabs + "[A]0 = " + Kinetics.fOrdConcVTimeA0(At, k, t));
			break;

		    case 2:
			A0 = saved[0];
			k = saved[1];
			t = saved[2];
                        System.out.println("\n" + tabs + "[A]t = " + Kinetics.fOrdConcVTimeAt(A0, k, t));
			break;

		    case 3:
			A0 = saved[0];
			At = saved[1];
			t = saved[2];
                        System.out.println("\n" + tabs + "k = " + Kinetics.fOrdConcVTimeKT(A0, At, t));
			break;

		    case 4:
			A0 = saved[0];
			At = saved[1];
			k = saved[2];
                        System.out.println("\n" + tabs + "t = " + Kinetics.fOrdConcVTimeKT(A0, At, k));
			break;

		    default: break;
		}

		break;

	    case 4:
                System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) t0.5 half-life\n" +
                        tabs + "  2) k rate constant\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "t0.5, k\n" +
                        tabs + "  ... and omit what is unknown");

                saved[0] = HelpDriver.help(sc, tabs);
                System.out.println(tabs + "\tItem 1 saved");

		switch(unknown) {
		    case 1:
                        System.out.println("\n" + tabs + "t0.5 = " + Kinetics.fOrdHalfLife(saved[0]));
			break;

		    case 2:
                        System.out.println("\n" + tabs + "k = " + Kinetics.fOrdHalfLife(saved[0]));
			break;

		    default: break;
		}
		break;

	    case 5:
                System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) [A]t instantaneous concentration\n" +
                        tabs + "  2) [A]0 initial concentration\n" +
			tabs + "  3) k rate constant\n" +
			tabs + "  4) t time past\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "[A]t, [A]0, k, t\n" +
                        tabs + "  ... and omit what is unknown");

		for(int i = 0; i < 3; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
		}

		switch(unknown) {
		    case 1:
			A0 = saved[0];
			k = saved[1];
			t = saved[2];
                        System.out.println("\n" + tabs + "[A]t = " + Kinetics.sOrdConcVTimeAt(A0, k, t));
			break;

		    case 2:
			At = saved[0];
			k = saved[1];
			t = saved[2];
                        System.out.println("\n" + tabs + "[A]0 = " + Kinetics.sOrdConcVTimeA0(At, k, t));
			break;

		    case 3:
			A0 = saved[0];
			At = saved[1];
			t = saved[2];
                        System.out.println("\n" + tabs + "k = " + Kinetics.sOrdConcVTimeKT(A0, At, t));
			break;

		    case 4:
			A0 = saved[0];
			At = saved[1];
			k = saved[2];
                        System.out.println("\n" + tabs + "t = " + Kinetics.sOrdConcVTimeKT(A0, At, k));
			break;

		    default: break;
		}

		break;

	    case 6:
                System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
			tabs + "  1) k rate constant\n" +
			tabs + "  2) [A]0 initial concentration\n" +
                        tabs + "  3) t0.5 half-life\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "k, [A]0, t0.5\n" +
                        tabs + "  ... and omit what is unknown");

		for(int i = 0; i < 2; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
		}

		switch(unknown) {
		    case 1:
			A0 = saved[0];
			t = saved[1];
                        System.out.println("\n" + tabs + "k = " + Kinetics.sOrdHalfLife(A0, t));
			break;

		    case 2:
			k = saved[0];
			t = saved[1];
                        System.out.println("\n" + tabs + "[A]0 = " + Kinetics.sOrdHalfLife(k, t));
			break;

		    case 3:
			A0 = saved[0];
			k = saved[1];
                        System.out.println("\n" + tabs + "t0.5 = " + Kinetics.sOrdHalfLife(A0, k));
			break;

		    default: break;
		}

		break;

            default:
                System.out.println("\n" + tabs + HelpDriver.help(sc, tabs));
                break;
        }
    }
}
