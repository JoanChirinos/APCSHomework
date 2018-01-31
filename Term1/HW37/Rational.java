/*
  Joan Chirinos
  APCS pd08
  HW37 -- Be More Rational
  2017-11-20
*/

public class Rational implements Comparable {

    // Instance Variables
    public int p;
    public int q;

    // Default constructor
    public Rational() {
	p = 0;
	q = 1;
    }

    // Overloaded constructor
    public Rational(int numerator, int denominator) {
	this();
	if (denominator == 0)
	    sop("You can't divide by 0!");
	else {
	    p = numerator;
	    q = denominator;
	}
    }
    
    //Returns the rational number as a fraction-like string
    public String toString() {
	return p + "/" + q;
    }

    //returns floating point approximation of rational using a double
    public double floatValue() {
	return ((double) p / q);
    }

    //Takes a Rational object and multiplies by this Rational object
    //Doesn't return anything, instead it modifies this object and leaves
    //the parameter alone
    //Doesn't reduce the fraction
    public void multiply(Rational number) {
        p = this.p * number.p;
	q = this.q * number.q;
    }

    //Works the same as multiply, but divides instead
    public void divide(Rational number) {
	if (number.p != 0) {
	    p = this.p * number.q;
	    q = this.q * number.p;
	}
	else sop("Divide by 0 error!");
    }
    
    //Same as multiply, but adds instead
    public void add(Rational number) {
	
	p = (this.p * number.q) + (this.q * number.p);
	q = this.q * number.q;
    }

    //Same as add, but subtracts instead
    public void subtract(Rational number) {
	p = (this.p * number.q) - (this.q * number.p);
	q = this.q * number.q;
    }

    //Uses Euclidean Algorithm to get gcd
    //If p % q == 0, then than means q is the gcd.
    //Otherwise, p = q and q is the remainder of p / q. Then try again
    public int gcd() {
	//I like this commented code better, but Brown said to use 2 methods
	/*
	if (p % q == 0) return q;
	Rational temp = new Rational(q, p % q);
	return temp.gcd();
	*/
	return gcd(p, q);
    }

    public static int gcd(int n, int d) {
	if (n % d == 0) return d;
	return gcd(d, n % d);

	//Brown's code (I also don't like this one xD)
	/*
	int a, b, x;
	a = n;
	b = d;
	while (a % b != 0) {
	    x = a;
	    a = b;
	    b = x % b;
	}
	return b;
	*/
    }

    //Divides p and q by gcd
    public void reduce() {
        int gcd = gcd();
	p /= gcd;
	q /= gcd;
    }

    //Compares the floatValues of this object and parameter
    public int compareTo(Rational number) {
	//Don't floaty point because 2/3 != 400/600
	/*
	if (this.floatValue() == number.floatValue()) return 0;
	if (this.floatValue() > number.floatValue()) return 1;
	return -1;
	*/


	//Brown's code

	int thisNum, otherNum;
	thisNum = this.p * number.q;
	otherNum = this.q * number.p;
	
	return thisNum - otherNum;
    }

    public static void main(String[] args) {
	sop("\n====================");
	sop("Testing constructors and toString: Should print 0/1, 1/2, 2/3");
	sop("====================\n");
	Rational num1 = new Rational();
	Rational num2 = new Rational(1, 2);
	Rational num3 = new Rational(2, 3);
	sop(num1);
	sop(num2);
	sop(num3);
	sop("\n====================");
	sop("Testing floatValue: Should print 0.0, 0.5, 0.6666666666666666");
	sop("====================\n");
	sop(num1.floatValue());
	sop(num2.floatValue());
	sop(num3.floatValue());
	sop("/n====================");
	sop("Testing multiply and divide: Should print 2/6, 6/12, 18/24");
	sop("====================\n");
        num2.multiply(num3);
	sop(num2);
	num2.divide(num3);
	sop(num2);
	num2.divide(num3);
	sop(num2);
	sop("\n====================");
	sop("Testing add and subtract: Should print 9/18 and 9/54");
	sop("====================\n");
        Rational num4 = new Rational(1, 6);
	Rational num5 = new Rational(1, 3);
	num4.add(num5);
	sop("1/6 + 1/3 = " + num4);
	num4.subtract(num5);
	sop("9/18 - 1/3 = " + num4);
	sop("\n====================");
	sop("Testing reduce: Should print 1/2 and 7/11");
	sop("====================\n");
	Rational num6 = new Rational(3, 6);
	Rational num7 = new Rational(7, 11);
	sop(num6);
	num6.reduce();
	sop("--> " + num6);
	sop("");
	sop(num7);
	num7.reduce();
	sop("--> " + num7);
	sop("\n====================");
	sop("Testing compareTo: Should print -1, 0, 1");
	sop("====================\n");
	Rational num8 = new Rational(20, 10);
	Rational num9 = new Rational(1, 7);
	Rational num10 = new Rational(3, 21);
	sop("1/7 compared to 20/10 --> " + num9.compareTo(num8));
	sop("1/7 compared to 3/21 --> " + num9.compareTo(num10));
	sop("20/10 compared to 3/21 --> " + num8.compareTo(num10));
	sop("");
    }


    //SOP Methods
    public static void sop(String x) {
	System.out.println(x);
    }

    public static void sop(double x) {
	System.out.println(x);
    }

    public static void sop(Rational x) {
	System.out.println(x);
    }

    public static void sop(int x) {
	System.out.println(x);
    }
}
