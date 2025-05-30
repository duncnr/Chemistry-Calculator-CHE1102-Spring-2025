import java.util.Scanner;

public class EquilibriumDriver {
    double saved[] = new double[10];

    EquilibriumDriver(Scanner sc, String tabs, double[] saved) {
        tabs = "\t" + tabs;

        for (int i = 0; i < 10; ++i) {
            this.saved[i] = saved[i];
        }

        int choice = 1;
        while (choice > 0) {
            System.out.print("\n" +
                    tabs + "Select a number 1-4 based on the options below:\n" +
                    tabs + "  1) Equilibrium Constant\n" +
                    tabs + "  2) Kp to Kc Equilibrium Constant\n" +
		    tabs + "  3) Initially Charged Equilibrium\n" +
                    tabs + "  4) Gibbs Free Energy\n" +
                    tabs + "  5) Help\n" +
                    tabs + "Enter: ");
            choice = sc.nextInt();
            select(sc, tabs, choice);
        }
    }

    private void select(Scanner sc, String tabs, int choice) {
        tabs = "\t" + tabs;

        int unknown, numReact, numProd;
	double reConc[], proConc[];
	double T, R;
        switch (choice) {
            case 0:
                break;

            case 1:
		System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) K\n" +
                        tabs + "  2) product concentration\n" +
                        tabs + "  3) reactant concentration\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

		System.out.print("\n" + tabs + "Enter number of reactants: ");
		numReact = sc.nextInt();

		int reCof[] = new int[numReact];
		if(numReact > 0) {
   		    System.out.println(tabs + "Enter reactant coefficents:");
		    for(int i = 0; i < numReact; ++i) {
			System.out.print(tabs + "    r" + (i + 1) + ": ");
			reCof[i] = sc.nextInt();
		    }
		}

		System.out.print("\n" + tabs + "Enter number of products: ");
		numProd = sc.nextInt();

		int proCof[] = new int[numProd];
		if(numProd > 0) {
		    System.out.println(tabs + "Enter product coefficents: ");
		    for(int i = 0; i < numProd; ++i) {
			System.out.print(tabs + "    p" + (i + 1) + ": ");
			proCof[i] = sc.nextInt();
		    }
		}

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "K, concentration products, concentration reactants\n" +
                        tabs + "  ... and omit what is unknown");

		double K, p, r;
                switch (unknown) {
                    case 1:
	                for (int i = 0; i < (numReact + numProd); ++i) {
        	            saved[i] = HelpDriver.help(sc, tabs);
                	    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
               		}
                	System.out.println();

                        p = 1;
			for(int i = 0; i < numProd; ++i) {
			    p *= Math.pow(saved[i], proCof[i]);
			}

			r = 1;
			for(int i = 0; i < numReact; ++i) {
			    r *= Math.pow(saved[(i + numProd)], reCof[i]);
			}

			System.out.println(tabs + "K = " + Equilibrium.equilConstK(p, r));
                        break;

                    case 2:
			for (int i = 0; i < (1 + numReact); ++i) {
        	            saved[i] = HelpDriver.help(sc, tabs);
                	    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
               		}
                	System.out.println();

			K = saved[0];

			r = 1;
			for(int i = 0; i < numReact; ++i) {
			    r *= Math.pow(saved[(i + 1)], reCof[i]);
			}

			int pCof = 0;
			for(int i = 0; i < numProd; ++i) {
			    pCof += proCof[i];
			}

			// System.out.println(tabs + "[p] = " + Equilibrium.equilConstP(K, r, (double) pCof));

			break;

                    case 3:
		        for (int i = 0; i < (1 + numProd); ++i) {
        	            saved[i] = HelpDriver.help(sc, tabs);
                	    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
               		}
                	System.out.println();

			K = saved[0];

			p = 1;
			for(int i = 0; i < numProd; ++i) {
			    p *= Math.pow(saved[(i + 1)], proCof[i]);
			}

			int rCof = 0;
			for(int i = 0; i < numReact; ++i) {
			    rCof += reCof[i];
			}

   		        // System.out.println(tabs + "[r] = " + Equilibrium.equilConstR(K, p, (double) rCof));
                        
			break;

                    default:
                        break;
                }
                break;

            case 2:
		System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) Kp\n" +
                        tabs + "  2) Kc\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "Kp, Kc, T, Delta n\n" +
                        tabs + "  ... and omit what is unknown");

                for (int i = 0; i < 3; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }	
                System.out.println();

		double Dn;
		R = 0.08206;
		switch(unknown) {
		    case 1:
			double Kc = saved[0];
			T = saved[1];
			Dn = saved[2];
			System.out.println("\n" + tabs + "Kp = " + Equilibrium.equilConstKp(Kc, R, T, Dn));
			break;

		    case 2:
			double Kp = saved[0];
			T = saved[1];
			Dn = saved[2];
			System.out.println("\n" + tabs + "Kc = " + Equilibrium.equilConstKc(Kp, R, T, Dn));
			break;

		    default: break;
		}
                break;

	    case 3: 
		System.out.print("\n" + tabs + "Enter number of reactants: ");
		numReact = sc.nextInt();

		System.out.print("\n" + tabs + "Enter K of the reaction: ");
		saved[0] = sc.nextDouble();
		System.out.println("\n" + tabs + "\tItem 1 saved");

		System.out.println("\n" + tabs + "Enter initial concentrations of reactants:");
		for(int i = 0; i < numReact; ++i) {
	            saved[i + 1] = HelpDriver.help(sc, "    " + tabs);
                    System.out.println(tabs + "\tItem " + (i + 2) + " saved");
		}
		System.out.println();

		double x, r1e;
		switch(numReact) {
		    case 1:
			x = Equilibrium.quadratic1(saved[0], saved[1]);

			r1e = saved[1] - (2 * x);

			System.out.println(tabs + "r1 equilibrum = " + r1e);
			System.out.println(tabs + "p1 & p2 equilibrium = " + x);

			break;

		    case 2:
			 
			x = Equilibrium.quadratic2(saved[0], saved[1], saved[2]);
						
			r1e = saved[1] - x;
			double r2e = saved[2] - x;
			double pe = 2 * x;
			 
			System.out.println(tabs + "r1 equilibrium = " + r1e);
			System.out.println(tabs + "r2 equilibrium = " + r2e);
			System.out.println(tabs + "p1 equilibrium = " + pe);
			
			break;
		
		    default:  // assume 0
			break;
		}
		break;

	    case 4: 
		System.out.print("\n" +
                        tabs + "Select unknown variable:\n" +
                        tabs + "  1) Delta G\n" +
                        tabs + "  2) Kc\n" +
                        tabs + "Enter: ");
                unknown = sc.nextInt();

                System.out.println("\n" + tabs + "Now store all knowns in the order: " +
                        "Delta G, Kc\n" +
                        tabs + "  ... and omit what is unknown");

                for (int i = 0; i < 1; ++i) {
                    saved[i] = HelpDriver.help(sc, tabs);
                    System.out.println(tabs + "\tItem " + (i + 1) + " saved");
                }
                System.out.println();

		R = 8.314;
		T = 298.15;
		switch(unknown) {
		    case 1:
			double Kc = saved[0];
			System.out.println(tabs + "Delta G = " + Equilibrium.gibbsFreeDG(R, T, Kc));
			break;

		    case 2:
			double dG = saved[0];
			System.out.println(tabs + "Kc = " + Equilibrium.gibbsFreeKc(dG, R, T));
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
