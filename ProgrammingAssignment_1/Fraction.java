public class Fraction {
    private int n, d; // numerator and denominator

    // Constructor
    public Fraction(int n) {
        this.n = n;
        d = 1;
    }

    public Fraction(int n, int d) {
        this.n = n;
        this.d = d;
    }

    // Add, substract, multiply, divide
    public void add(Fraction f2) {
        if (d == f2.getDenominator())
            n = n + f2.getNumerator();
        else {
            n = (n * f2.getDenominator()) + (f2.getNumerator() * d);
            d = d * f2.getDenominator();
        }
    }

    public void substract(Fraction f2) {
        if (d == f2.getDenominator())
            n = n - f2.getNumerator();
        else {
            n = (n * f2.getDenominator()) - (f2.getNumerator() * d);
            d = d * f2.getDenominator();
        }
    }

    public void multiply(Fraction f2) {
        n = n * f2.getNumerator();
        d = d * f2.getDenominator();
    }

    public void divide(Fraction f2) {
        if (d == f2.getDenominator())
            d = f2.getNumerator();
        else {
            n = n * f2.getDenominator();
            d = d * f2.getNumerator();
        }
    }

    public void reduce() {
        for (int i = 2; i <= n || i <= d; i++) {
            if (n % i == 0 && d % i == 0) {
                n /= i;
                d /= i;
            }
        }
    }

    // print the faction such as 2/3
    public void printFraction() {
        System.out.println(n + "/" + d);
    }

    // getter and setter
    public int getNumerator() {
        return n;
    }

    public int getDenominator() {
        return d;
    }

    public void setNumberator(int n) {
        this.n = n;
    }

    public void setDenomitnator(int d) {
        this.d = d;
    }
}