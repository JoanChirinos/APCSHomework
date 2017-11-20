/*
  Joan Chirinos
  APCS pd08
  HW36 -- Be Rational
  2017-11-1
*/

public class Rational {

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
	if (denominator == 0) {
	    sop("You can't divide by 0!");
	}
	else {
	    p = numerator;
	    q = denominator;
	}
    }

    public String toString() {
	return p + "/" + q;
    }

    public double floatValue() {
	return ((double) p / q);
    }

    public void multiply(Rational number) {
	String newNumber = number.toString();
	int slashIndex = newNumber.indexOf("/");
	int numP = Integer.parseInt(newNumber.substring(0, slashIndex));
	int numQ = Integer.parseInt(newNumber.substring(slashIndex + 1));
	p *= numP;
	q *= numQ;
    }

    public void divide(Rational number) {
        String newNumber = number.toString();
	int slashIndex = newNumber.indexOf("/");
	int numQ = Integer.parseInt(newNumber.substring(0, slashIndex));
	int numP = Integer.parseInt(newNumber.substring(slashIndex + 1));
	p *= numP;
	q *= numQ;
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
}
