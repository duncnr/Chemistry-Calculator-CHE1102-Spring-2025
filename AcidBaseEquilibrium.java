public class AcidBaseEquilibrium {
    // Kw = [H+] * [OH-]
    static double conc(double HOH) {
	return 1.0E-14 / HOH;
    }

    static double pHOHconc(double HOH) {
	return -Math.log10(HOH);
    }

    static double concpHOH(double pHOH) {
	return Math.pow(10, -pHOH);
    }

    static double pHOH(double pHOH) {
	return 14 - pHOH;
    }

    static double kpHOH(double initial, double pHOH) {
	double conc = concpHOH(pHOH);
	return Math.pow(conc, 2) / (initial - conc);
    }

    static double kpHOHpHOH(double initial, double pHOH) {
	double conc = concpHOH(pHOH(pHOH));
	return kpHOH(initial, pHOH);
    }

    static double pKab(double initial, double K) {
	// a = -1;
	double b = -K;
	double c = K * initial;

	double sqrt = Math.sqrt(b * b + 4 * c);
	double den = -2;
	double add = (-b + sqrt) / den;
	double sub = (-b - sqrt) / den;

	double conc = (add > 0) ? add : sub;
	return pHOHconc(conc);
    }

    static double pKabKab(double initial, double K) {
	return pHOH(pKab(initial, K));
    }
}
