import java.util.*;

class P{
  void m1(){
    System.out.print("M1");
  }

  void m2(){
    System.out.print("M2");
  }
}

class Child extends P{
  void m3(){
    System.out.print("M3");
  }
}

public class upcasting_Downcasting {

    public static void main(String[] args) {

      /*Error*/
      // Child c = new P();  //Compile-time error: Type mismatch
      // c.m3();


      /* Works*/
      // 1. Upcasting (Implicit): Child hidden inside a Parent reference
      P p = new Child(); 
      // 2. Downcasting (Explicit): Safely restoring the Child reference
      Child c = (Child) p; 
      // 3. Now you can safely call Child-specific methods
      c.m3(); // Outputs: M3
    }
}