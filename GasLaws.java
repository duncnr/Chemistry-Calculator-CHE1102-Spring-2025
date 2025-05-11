public class GasLaws {
   // P_u = (P_k * V_k * T_u) / (T_k * V_u)
   static double combinedP(double vu, double tu, double pk, double vk, double tk) {
      return (pk * vk * tu) / (tk * vu);
   }
   // V_u = (P_k * V_k * T_u) / (T_k * P_u)
   static double combinedV(double pu, double tu, double pk, double vk, double tk) {
      return (pk * vk * tu) / (tk * pu);
   }
   // T_u = (T_k * P_u * V_u) / (P_k * V_k)
   static double combinedT(double pu, double vu, double pk, double vk, double tk) {
      return (tk * pu * vu) / (pk * vk);
   }

   // P = (n * R * T) / V
   static double idealP(double v, double n, double r, double t) {
      return (n * r * t) / v;
   }

   // V = (n * R * T) / P
   static double idealV(double p, double n, double r, double t) {
      return (n * r * t) / p;
   }

   // n = (P * V) / (R * T)
   static double idealN(double p, double v, double r, double t) {
      return (p * v) / (r * t);
   }

   // T = (P * V) / (n * R)
   static double idealT(double p, double v, double n, double r) {
      return (p * v) / (n * r);
   }
}
