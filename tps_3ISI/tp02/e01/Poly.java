package tps_3ISI.tp02.e01;

class A {
	public void affiche() {
		System.out.println("je suis A");
	}
}

class B extends A {
}

class C extends A {
	public void affiche() {System.out.println("je suis C");}
}

class D extends C {public void affiche() {System.out.println("je suis D");}
}

class E extends B {
}

class F extends C {
}

public class Poly {
	public static void main(String args[]) {
		A a = new A();
		a.affiche();
		B b = new B();
		b.affiche();
		a = b;
		a.affiche();
		C c = new C();
		c.affiche();
		a = c;
		a.affiche();
		D d = new D();
		d.affiche();
		a = d;
		a.affiche();
		c = d;
		c.affiche();
		E e = new E();
		e.affiche();
		a = c;
		a.affiche();
		b = e;
		b.affiche();
		F f = new F();
		a = f;
		a.affiche();
		c = f;
		c.affiche();
	}
}
