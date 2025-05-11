public class Help {
    
    // moles of ending substance = (moles initial substance * ending conversion) / initial conversion
    static double moleToMole(double initAmount, double molecularWeight, double initMoles, double endingMoles) {
        return (initAmount * endingMoles) / (molecularWeight * initMoles);
    }

    static double stoichConversion(double initMoles, double finalMoles, double amount) {
	return finalMoles / initMoles * amount;
    }

    // grams of substance = moles of substance * molecular weight of substance
    static double gramPerMol(double moles, double molWeight) {
        return moles * molWeight;
    }

    // moles of substance grams of substance / molecular weight of stubstance
    static double molPerGram(double grams, double molWeight) {
        return grams / molWeight;
    }

    // gram = milligram / 1000
    static double milligramToGram(double milligram) {
        return milligram / 1000;
    }

    // gram = kilogram * 1000
    static double kilogramToGram(double kilogram) {
        return kilogram * 1000;
    }
    
    //liter = milliliters / 1000
    static double milliliterToLiter(double milliliter) {
        return milliliter / 1000;
    }

    // kilogram = gram / 1000
    static double gramToKilogram(double gram) {
        return gram / 1000;
    }
    
    // 1 atm = 760 mmHg
    static double mmHgToAtm(double mmHg) {
	return mmHg / 760;
    }

    // 1 atm = 29.92 inHg
    static double inHgToAtm(double inHg) {
	return inHg / 29.92;
    }

    // 760 mmHg = 1 atm
    static double atmTommHg(double atm) {
	return atm * 760;
    }

    // 29.92 inHg = 1 atm
    static double atmToinHg(double atm) {
	return atm * 29.92;
    }

    // 14.7 psi = 1 atm
    static double atmToPsi(double atm) {
	return atm * 14.7;
    }

    // kelvin = celsius + 273.15
    static double celsiusToKelvin(double celsius) {
	return celsius + 273.15;
    }

    // 1 min = 60 sec
    static double secToMin(double sec) {
        return sec / 60;
    }
}










// end
