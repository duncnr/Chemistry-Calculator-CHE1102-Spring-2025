public class Buffers {
    static double hhKa(double Ka, double waConc, double cbConc) {
	return -Math.log10(Ka) + Math.log10(cbConc / waConc);
    }

    static double hhKb(double Kb, double wbConc, double caConc) {
	return AcidBaseEquilibrium.pHOH(hhKa(Kb, wbConc, caConc));
    }

    static double[] ksp(double[] arr, double K, double cof1, double cof2) {
	double power = cof1 + cof2;
	double den = Math.pow(cof1, cof1) * Math.pow(cof2, cof2);
	double ms = Math.pow(K / den, 1 / power);		// molar solubility

	arr[0] = cof1 * ms;
	arr[1] = cof2 * ms;

	return arr;
    }
}

