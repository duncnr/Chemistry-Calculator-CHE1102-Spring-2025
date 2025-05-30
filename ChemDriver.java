import java.util.Scanner;

public class ChemDriver {
    static double saved[] = new double[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 1;

        System.out.println("Press 0 to exit at anytime or enter to proceed");
        String opening = sc.nextLine();

        try {
            choice = Integer.parseInt(opening);
        } catch (NumberFormatException e) {}

        while (choice > 0) {
            System.out.print("Select a number 0-8 based on the options below:\n" +
                    "  0) Exit\n" +
		    "  1) Gas Laws\n" +
		    "  2) Solutions\n" +
                    "  3) Kinetics\n" +
		    "  4) Equilibrium\n" +
		    "  5) Acid Base Equilibrium\n" +
		    "  6) Buffers\n" +
		    "  7) Electrochemistry\n" +
                    "  8) Help\n" +
                    "Enter: ");
            choice = sc.nextInt();
            select(sc, choice);
            System.out.println();
        }
        sc.close();
    }

    private static void select(Scanner sc, int choice) {
        switch (choice) {
            case 0:
                break;

	    case 1:
		new GasLawDriver(sc, "", saved);
		break;

            case 2:
                new SolutionDriver(sc, "", saved);
                break;

            case 3:
                new KineticDriver(sc, "", saved);
                break;

            case 4:
		new EquilibriumDriver(sc, "", saved);
                break;

	    case 5:
		new AcidBaseEquiDriver(sc, "", saved);
		break;

	    case 6:
		new BufferDriver(sc, "", saved);
		break;

	    case 7:
		new ElectroDriver(sc, "", saved);
		break;

            default:
		System.out.println("\t" + HelpDriver.help(sc, ""));
                break;
        }
    }
}
