public class Equilibrium {
    // K = [products] / [reactants]
    static double equilConstK(double p, double r) {
	return p / r;
    }

    // [p1] = ([reactants] * K)^(1/p1Cof)
    static double equilConstP1(double K, double r, double pCof) {
	return Math.pow(K * r, 1 / pCof);
    }

    // Kp = Kc * (R * T)^{\Delta N}
    static double equilConstKp(double Kc, double R, double T, double Dn) {
        return Kc * Math.pow(R * T, Dn);
    }

    // Kc = Kp / (R * T)^{\Delta N}
    static double equilConstKc(double Kp, double R, double T, double Dn) {
    	return Kp / Math.pow(R * T, Dn);
    }

    static double quadratic1(double K, double initial) {
	double sqK = Math.sqrt(K);
	return initial * sqK / (1 + 2 * sqK);
    }

    static double quadratic2(double K, double r1, double r2) {
	double a = K - 4;
	double b = -K * (r1 + r2);
	double c = K * r1 * r2;
	
	double sqrt = Math.sqrt(b * b - 4 * a * c);
	double den = 2 * a;
	double add = (-b + sqrt) / den;
	double sub = (-b - sqrt) / den;

	double addRes1 = r1 - add;
	double addRes2 = r2 - add;
	return (addRes1 > 0 && addRes2 > 0) ? add : sub;
    }

    static double gibbsFreeDG(double R, double T, double K) {
	return -R * T * Math.log(K) / 1000;
    }

    static double gibbsFreeKc(double G, double R, double T) {
	return Math.exp(G / (-R * T));
    }
}
