package tut03.test;

import tut03.package1.A;
import tut03.package1.B;
import tut03.package1.C;
import tut03.package2.D;

public class TestAccess {
	
	public static void main(String[] args) {
		
		A objA = new A();
		objA.methodA();  	
	    System.out.println("---");
		B objB = new B();
		objB.methodB();
	    System.out.println("---");		
		C objC = new C();
		objC.methodC();
	    System.out.println("---");
		D objD = new D();
		objD.methodD();
	}
}
