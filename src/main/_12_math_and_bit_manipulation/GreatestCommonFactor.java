package _12_math_and_bit_manipulation;

public class GreatestCommonFactor {
    public static int LCF(int a, int b) {
        if(a % b == 0){
            return b;
        }else {
            return LCF(b, a % b);
        }
    }

    public static int LCM(int a, int b) {
        return a * b / LCF(a, b);
    }

    public static void main(String[] args) {
        System.out.println(LCF(8, 12));
    }
}
