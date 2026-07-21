/*Try-Catch Exception 
    Order of Catch block matters. Parent class catch block should be after the child class catch block. 
    Otherwise, it will give compile time error.

    







*/


public class tryCatch {

    public  int divide(int a, int b){
        return a/b;
    }

    public static void main(String[] args) {
        tryCatch tc = new tryCatch();
        // int res = tc.divide(10, 0);
        // System.out.println(res);

        try {
            int res = tc.divide(10,0);
        }catch(Exception e){
            System.out.print("Exception Occurred");
        }catch(ArithmeticException e){
            System.out.println("Arithmetic Exception Occurred");
        }
    }
}
