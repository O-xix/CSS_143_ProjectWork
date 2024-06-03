public class CustomMath {
    //5.1: Class Constraints
    /*
     * All methods & data must be static.
     */

    //5.2: Data Items:
    public static final double PI = Math.PI;
    public static final double E = Math.E;

    /*
     * Why is it safe to make these variables public?
     *  These are constants that are universal, so it doesn't require any modification. Data privacy leak also won't really occur.
     * How do you access these variables from another class?
     *  Should still be mostly the same as Objects, such as ClassName.VariableName.
     */

    //5.3: Methods:
    /**
     * 
     * @param a
     * @param b
     * @return
     */
    public static double max(double a, double b) {
        if (a < b) 
            return b;
        else if (a > b) 
            return a;
        return a;
    }
    public static int max(int a, int b) {
        if (a < b) 
            return b;
        else if (a > b) 
            return a;
        return a;
    }
    public static double min(double a, double b) {
        if (a < b) 
            return a;
        else if (a > b) 
            return b;
        return a;
    }
    public static int min(int a, int b) {
        if (a < b) 
            return a;
        else if (a > b) 
            return b;
        return a;
    }
    public static int pow(int base, int exp) {
        if (exp == 0) {
            return 1;
        } 
        else if (exp > 0) {
            return base * pow(base, exp - 1);
        } 
        //negative exponent
        else {
            return 1 / (base * pow(base, -exp - 1));
        }
    }
}
