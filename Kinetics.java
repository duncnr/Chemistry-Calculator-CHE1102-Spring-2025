public class Kinetics {
   // rate = rateConstant * [r1] * [r2] * ... * [rN]
   static double rateLawRXN(double rConst, double... reactants) {
      double product = 1;
      for(double reactant : reactants) {
         product *= reactant;
      }
      return rConst * product;
   }

   // rConstant = rate / ([r1] * [r2] * ... * [rN])
   static double rateLawK(double rate, double... reactants) {
      double product = 1;
      for(double reactant : reactants) {
         product *= reactant;
      }
      return rate / product;
   }

   // [r1] = rate / rConstant
   static double rateLawR(double rate, double rConst) {
      return rate / rConst;
   }

   // [rN] = rate / (rateConstant * [r1] * [r2] * ... * [rN-1])
   static double rateLawR(double rate, double rConst, double... reactants) {
      double product = 1;
      for(double reactant : reactants) {
         product *= reactant;
      }
      return rate / (rConst * product);
   }

   // [rX] order = log(rate1 / rate2) / log(concentration1 / concentration2) 
   static double initialRates(double conc1, double conc2, double rate1, double rate2) {
      return Math.log(rate1 / rate2) / Math.log(conc1 / conc2);
   }

   // t_1/2 = 0.693 / k
   static double fOrdHalfLife(double kt) {
      return 0.693 / kt;
   }

   // [A]0 = e^kt * [A]t
   static double fOrdConcVTimeA0(double At, double k, double t) {
      return Math.exp(k * t) * At;
   }

   // [A]t = [A]0 / e^kt
   static double fOrdConcVTimeAt(double A0, double k, double t) {
      return A0 / Math.exp(k * t);
   }

   // t = ln([A]0 / [A]t) / k
   // k = ln([A]0 / [A]t) / t
   static double fOrdConcVTimeKT(double A0, double At, double kt) {
      return Math.log(A0 / At) / kt;
   }

   // 1 / (t_1/2 * [A]0) = k
   // 1 / (t_1/2 * k) = [A]0
   // 1 / ([A]0 * k) = t_1/2
   static double sOrdHalfLife(double tA0, double kA0) {
      return 1 / (tA0 * kA0);
   }

   // [A]0 = -1 / (k * t - 1 / [A]t)
   static double sOrdConcVTimeA0(double At, double k, double t) {
      return -1 / (k * t - 1 / At);
   }

   // [A]t = 1 / (k * t + 1 / [A]0)
   static double sOrdConcVTimeAt(double A0, double k, double t) {
      return 1 / (k * t + 1 / A0);
   }

   // t = (1 / [A]t - 1 / [A]0) / k
   // k = (1 / [A]t - 1 / [A]0) / t
   static double sOrdConcVTimeKT(double At, double A0, double kt) {
      return (1 / At - 1 / A0) / kt;
   }
}
