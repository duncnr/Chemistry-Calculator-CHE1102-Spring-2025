public class Electrochemistry {
    static double coulombC(double sec, double amps) {
	return sec * amps;
    }

    static double coulombAS(double C, double sa) {
	return C / sa;
    }

    static double massC(double C, double cofEOhr, double cofERhr, double mwRA, double efficiency) {
	double molE = C / 96485;

	double molEconv;
	if((cofEOhr % cofERhr == 0) || (cofERhr % cofEOhr == 0)) {
	    if(cofEOhr > cofERhr) molEconv = cofEOhr;
	    else molEconv = cofERhr;
	}
	else molEconv = cofERhr * cofEOhr;

	return mwRA * molE / molEconv * (efficiency / 100);
    }

    static double coulM(double initgRA, double cofEOhr, double cofERhr, double mwRA, double efficiency) {
	initgRA = initgRA / (efficiency / 100);
	
	double molEconv;
	if((cofEOhr % cofERhr == 0) || (cofERhr % cofEOhr == 0)) {
	    if(cofEOhr > cofERhr) molEconv = cofEOhr;
	    else molEconv = cofERhr;
	}
	else molEconv = cofERhr * cofEOhr;

	return initgRA * molEconv * 96485 / mwRA;
    }

    static double gibbsFree(double n, double Ecell) {
	return -(n * 96485 * Ecell);
    }
}
