public class solidRhombus {
    public static void solid_Rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            //space
            for (int j = 1; j <=n-i; j++) {
                System.out.print(" ");
            }
             //stars
             for (int j = 1; j <=n; j++) {
                System.out.print("*");
            }
            System.err.println();
        }
        
    }
    public static void main(String[] args) {
        solid_Rhombus(5);
    }
}
