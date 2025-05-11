import java.util.Scanner;

public class HelpDriver {
    public static double help(Scanner sc, String tabs) {
        System.out.print("\n" + tabs + "---------Processing Help---------\n" +
                tabs + "     1) mol -> mol conversion\n" +
		tabs + "     2) stoichiometric conversion\n" +
                tabs + "     3) g -> mol\n" +
                tabs + "     4) mol -> g\n" +
                tabs + "     5) mg -> g\n" +
                tabs + "     6) kg -> g\n" +
                tabs + "     7) g -> kg\n" +
                tabs + "     8) mL -> L\n" +
//		tabs + "     9) mm Hg -> atm\n" +
//		tabs + "     10) in Hg -> atm\n" +
//		tabs + "     11) atm -> mm Hg\n" +
//		tabs + "     12) in Hg -> mm Hg\n" +
//		tabs + "     13) atm -> in Hg\n" +
//		tabs + "     14) mm Hg -> in Hg\n" +
//		tabs + "     15) atm -> psi\n" +
//		tabs + "     16) mm Hg -> psi\n" +
//		tabs + "     17) in Hg -> psi\n" +
		tabs + "     18) celsius -> kelvin\n" +
		tabs + "     19) sec -> min\n" +
                tabs + "     20) ENTER VALUE\n" +
                tabs + "   Enter: ");
        int choice = sc.nextInt();

        System.out.println();

        double init, end, g, n, mw, mL, mm, in, atm;
        switch (choice) {
            case 0:
                return 0;

            case 1:
                System.out.print(tabs + "\tEnter initial grams: ");
                g = sc.nextDouble();
                System.out.print(tabs + "\tEnter initial molecular weight: ");
		mw = sc.nextDouble();
                System.out.print(tabs + "\tEnter inital moles: ");
                init = sc.nextDouble();
                System.out.print(tabs + "\tEnter ending moles: ");
        	end = sc.nextDouble();
                return Help.moleToMole(g, mw, init, end);

	    case 2:
                System.out.print(tabs + "\tEnter inital moles: ");
                init = sc.nextDouble();
                System.out.print(tabs + "\tEnter ending moles: ");
                end = sc.nextDouble();
		System.out.print(tabs + "\tEnter value to convert: ");
		double lambda = sc.nextDouble();
                return Help.stoichConversion(init, end, lambda);

            case 3:
                System.out.print(tabs + "\tEnter grams: ");
                g = sc.nextDouble();
                System.out.print(tabs + "\tEnter molecular weight: ");
                mw = sc.nextDouble();
                return Help.molPerGram(g, mw);

            case 4:
                System.out.print(tabs + "\tEnter moles: ");
                n = sc.nextDouble();
                System.out.print(tabs + "\tEnter molecular weight: ");
                mw = sc.nextDouble();
                return Help.gramPerMol(n, mw);

            case 5:
                System.out.print(tabs + "\tEnter milligrams: ");
                double mg = sc.nextDouble();
                return Help.milligramToGram(mg);

            case 6:
                System.out.print(tabs + "\tEnter kilograms: ");
                double kg = sc.nextDouble();
                return Help.kilogramToGram(kg);

            case 7:
                System.out.print(tabs + "\tEnter grams: ");
                g = sc.nextDouble();
                return Help.gramToKilogram(g);

            case 8:
                System.out.print(tabs + "\tEnter milliliters: ");
                mL = sc.nextDouble();
                return Help.milliliterToLiter(mL);

	    case 9:
                System.out.print(tabs + "\tEnter millimeters mercury (Hg): ");
                mm = sc.nextDouble();
                return Help.mmHgToAtm(mm);

	    case 10:
                System.out.print(tabs + "\tEnter inches mercury (Hg): ");
                in = sc.nextDouble();
                return Help.inHgToAtm(in);

	    case 11:
                System.out.print(tabs + "\tEnter atmospheres: ");
                atm = sc.nextDouble();
                return Help.atmTommHg(atm);
            
	    case 12:
                System.out.print(tabs + "\tEnter inches mercury (Hg): ");
                in = sc.nextDouble();
                return Help.atmTommHg(Help.inHgToAtm(in));
            
	    case 13:
                System.out.print(tabs + "\tEnter atmospheres: ");
                atm = sc.nextDouble();
                return Help.atmToinHg(atm);
            
	    case 14:
                System.out.print(tabs + "\tEnter millimeters mercury (Hg): ");
                mm = sc.nextDouble();
                return Help.atmToinHg(Help.mmHgToAtm(mm));

            case 15:
                System.out.print(tabs + "\tEnter atmospheres: ");
                atm = sc.nextDouble();
                return Help.atmToPsi(atm);
            
	    case 16:
                System.out.print(tabs + "\tEnter millimeters mercury (Hg): ");
                mm = sc.nextDouble();
                return Help.atmToPsi(Help.mmHgToAtm(mm));
            
	    case 17:
                System.out.print(tabs + "\tEnter inches mercury (Hg): ");
                in = sc.nextDouble();
                return Help.atmToPsi(Help.inHgToAtm(in));

	    case 18:
                System.out.print(tabs + "\tEnter celsius: ");
                double t = sc.nextDouble();
                return Help.celsiusToKelvin(t);

	    case 19: 
		System.out.print(tabs + "\tEnter seconds: ");
		double s = sc.nextDouble();
		return Help.secToMin(s);

	    default:
                System.out.print(tabs + "\tEnter value: ");
                double ret = sc.nextDouble();
                return ret;
        }
    }
}
