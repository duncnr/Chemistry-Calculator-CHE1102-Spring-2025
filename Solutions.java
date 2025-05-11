
public class Solutions {
    // molarity = moles solute / liters solution
    static double molarityM(double solute, double solution) {
        return solute / solution;
    }

    // moles solute = molarity * liters solution
    static double molarityN(double molarity, double solution) {
        return molarity * solution;
    }

    // liters solution = moles solute / molarity
    static double molarityL(double solute, double molarity) {
        return solute / molarity;
    }

    // molality = moles solute / kg solvent
    static double molalityM(double solute, double solvent) {
        return solute / solvent;
    }

    // moles solute = molality * kg solvent
    static double molalityN(double molality, double solvent) {
        return molality * solvent;
    }

    // kg solvent = moles solute / molality
    static double molalityKg(double solute, double molality) {
        return solute / molality;
    }

    // mass % solute = (grams solute / grams solution) * 100
    static double massPrcnt(double solute, double solvent) {
        return (solute / (solute + solvent)) * 100;
    }

    // X solute = moles solute / moles solution
    static double moleRatioU(double solute, double solvent) {
        return solute / (solvent + solute);
    }

    // X solvent = moles solvent / moles solution
    static double moleRatioV(double solute, double solvent) {
        return solvent / (solvent + solute);
    }

    // ppm = solute / solution * 1000000
    static double ppm(double solute, double solvent) {
        return (solute / (solute + solvent)) * 1000000;
    }

    // mmHg solution = mmHg solvent * X solvent
    static double vaporPresh(double solute, double solvent, double vaporPressure) {
        return vaporPressure * moleRatioV(solute, solvent);
    }

    // change in freezing point = fp depression constant * (moles solute / kg
    // solvent)
    static double freezeDepress(double solute, double solvent, double depressionConstant) {
        return depressionConstant * molalityM(solute, solvent);
    }

    // change in boiling point = bp elevation constant * (moles solute / kg solvent)
    static double boilElevat(double solute, double solvent, double elevationConstant) {
        return elevationConstant * molalityM(solute, solvent);
    }
}
