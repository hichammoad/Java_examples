package tps_3ISI.tp02.e02;

class A {
	public void f(double x) {
		System.out.println("A.f(double = " + x + ")");
	}
}

class B extends A {
}

class C extends A {
	public void f(long q) {
		System.out.println("C.f(long = " + q + ")");
	}
}

class D extends C {
	public void f(int n) {
		System.out.println("D.f(int = " + n + ")");
	}
}

class F extends C {
	public void f(float x) {
		System.out.println("F.f(float = " + x + ")");
	}

	public void f(int n) {
		System.out.println("F.f(int = " + n + ")");
	}
}

public class Poly {
	public static void main(String args[]) {
		byte bb = 1;
		short p = 2;
		int n = 3;
		long q = 4;
		float x = 5.f;
		double y = 6;
		System.out.println("******A*******");
		A a = new A();
		a.f(bb);
		a.f(x);
		System.out.println("******B*******");
		B b = new B();
		b.f(bb);
		a.f(x);
		a = b;
		a.f(bb);
		a.f(x);
		System.out.println("******C*******");
		C c = new C();
		c.f(bb);
		c.f(q);
		c.f(x);
		a = c;
		a.f(bb);
		a.f(q);
		a.f(x);
		System.out.println("******D*******");
		D d = new D();
		d.f(bb);
		d.f(q);
		d.f(y);
		a = d;
		a.f(bb);
		a.f(q);
		a.f(y);
		System.out.println("******F*******");

		F f = new F();
		f.f(bb);
		f.f(n);
		f.f(x);
		f.f(y);
		a = f;
		a.f(bb);
		a.f(n);
		a.f(x);
		a.f(y);
		c = f;
		c.f(bb);
		c.f(n);
		c.f(x);
		c.f(y);
	}
}
