import java.util.Scanner;

public class SolutionDriver {
    double saved[] = new double[10];

    SolutionDriver(Scanner sc, String tabs, double[] saved) {
        tabs = "\t" + tabs;
        for (int i = 0; i < 10; ++i) {
            this.saved[i] = saved[i];
        }

        int choice = 1;
        while (choice > 0) {
            System.out.print("\n" + 
                    tabs + "Select a number 1-9 based on the options below:\n" +
                    tabs + "  1) Molarity\n" +
                    tabs + "  2) Molality\n" +
                    tabs + "  3) Mass Percent (solute)\n" +
                    tabs + "  4) Mole Ratio (compound)\n" +
                    tabs + "  5) Parts Per Million\n" +
                    tabs + "  6) Vapor Pressure\n" +
                    tabs + "  7) Boiling Point Elevation\n" +
                    tabs + "  8) Freezing Point Depression\n" +
                    tabs + "  9) Help\n" +
                    tabs + "Enter: ");
            choice = sc.nextInt();
            select(sc, tabs, choice);
        }
    }

    private void select(Scanner sc, String tabs, int choice) {
        tabs = "\t" + tabs;

        int unknown;
        double n;
        switch (choice) {
            case 0:
                break;

            case 1:
                System.out.print("\n" + tabs + "Select unknown variable:\n" +
                        tabs + "  1) M molarity\n" +
                        tabs + "  2) n solute\n" +
                        tabs + "  3) L solution\n" +
                        tabs + "Enter: ");
		unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: M, n, L\n" +
                        tabs + "  ... and omit what is unknown");

                for (int i = 0; i < 2; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                double M, L;
                switch (unknown) {
                    case 1:
                        n = saved[0];
                        L = saved[1];
                        System.out.println("\n" + tabs + "M = " + Solutions.molarityM(n, L));
                        break;

                    case 2:
                        M = saved[0];
                        L = saved[1];
                        System.out.println("\n" + tabs + "n = " + Solutions.molarityN(M, L));
                        break;

                    case 3:
                        M = saved[0];
                        n = saved[1];
                        System.out.println("\n" + tabs + "L = " + Solutions.molarityL(n, M));
                        break;

                    default:
                        HelpDriver.help(sc, tabs);
                        break;
                }
                break;

            case 2:
                System.out.print("\n" + tabs + "Select unknown variable:\n" +
                        tabs + "  1) m molality\n" +
                        tabs + "  2) n solute\n" +
                        tabs + "  3) kg solvent\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: m, n, kg\n" +
                        tabs + "  ... and omit what is unknown");

                for (int i = 0; i < 2; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                double m, kg;
                switch (unknown) {
                    case 1:
                        n = saved[0];
                        kg = saved[1];
                        System.out.println("\n" + tabs + "m = " + Solutions.molalityM(n, kg));
                        break;

                    case 2:
                        m = saved[0];
                        kg = saved[1];
                        System.out.println("\n" + tabs + "n = " + Solutions.molalityN(m, kg));
                        break;

                    case 3:
                        m = saved[0];
                        n = saved[1];
                        System.out.println("\n" + tabs + "kg = " + Solutions.molalityKg(n, m));
                        break;

                    default:
                        HelpDriver.help(sc, tabs);
                        break;
                }
                break;

            case 3:
                System.out.println("\n" + tabs + "Store masses in the order of: g solute, g solvent");

                for (int i = 0; i < 2; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                System.out.println("\n" + tabs + "mass% = " + Solutions.massPrcnt(saved[0], saved[1]) + "%");
                break;

            case 4:
                System.out.print("\n" + tabs + "Select compound of interest:\n" +
                        tabs + "  1) solute\n" +
                        tabs + "  2) solvent\n" +
                        tabs + "Enter: ");
		unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Store moles in the order of: n solute, n solvent");

                for (int i = 0; i < 2; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                switch (unknown) {
                    case 1:
                        System.out.println("\n" + tabs + "molFrac_solute = " + Solutions.moleRatioU(saved[0], saved[1]));
                        break;

                    case 2:
                        System.out.println("\n" + tabs + "molFrac_solvent = " + Solutions.moleRatioV(saved[0], saved[1]));
                        break;

                    default:
                        System.out.println("\n" + tabs + "Sorry! this feature is currently unavaliable");
                        break;
                }
                break;

            case 5:
                System.out.println("\n" + tabs + "Store items in the order of: g solute, g solvent");

                for (int i = 0; i < 2; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                System.out.println("\n" + tabs + "ppm = " + Solutions.ppm(saved[0], saved[1]));
                break;

            case 6:
                System.out.println("\n" + tabs + "Store items in the order of: n solute, n solvent, mmHg solvent");

                for (int i = 0; i < 3; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                System.out.println("\n" + tabs + "VP solution = " + Solutions.vaporPresh(saved[0], saved[1], saved[2]) + " mm Hg");
                break;

            case 7:
                System.out.println("\n" + tabs + "Store items in the order of: n solute, kg solvent, Kb solvent");

                for (int i = 0; i < 3; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                System.out.println("\n" + tabs + "\\DeltaTb = " + Solutions.boilElevat(saved[0], saved[1], saved[2]));
                break;

            case 8:
                System.out.println("\n" + tabs + "Store items in the order of: n solute, kg solvent, Kf solvent");

                for (int i = 0; i < 3; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }

                System.out.println("\n" + tabs + "\\DeltaTf = " + Solutions.freezeDepress(saved[0], saved[1], saved[2]));
                break;

            default:
                System.out.println("\n" + tabs + HelpDriver.help(sc, tabs));
                break;
        }
    }
}
