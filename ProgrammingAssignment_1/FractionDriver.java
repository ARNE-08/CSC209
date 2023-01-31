public class FractionDriver {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = new Fraction(2);
        Fraction f4 = new Fraction(3);

        System.out.print("f1 = ");
        f1.printFraction();
        System.out.print("f2 = ");
        f2.printFraction();

        f1.add(f2);
        System.out.print("After add = ");
        f1.printFraction();

        f1.substract(f2);
        System.out.print("After substract = ");
        f1.printFraction();

        f1.multiply(f2);
        System.out.print("After multiply = ");
        f1.printFraction();

        f1.divide(f3);
        System.out.print("After divide = ");
        f1.printFraction();

        f1.reduce();
        System.out.print("After reduce = ");
        f1.printFraction();

        System.out.print("\n--------Same Denominator case--------\n\n");
        System.out.print("f3 = ");
        f3.printFraction();
        System.out.print("f4 = ");
        f4.printFraction();

        f3.add(f4);
        System.out.print("After add = ");
        f3.printFraction();

        f3.substract(f4);
        System.out.print("After substract = ");
        f3.printFraction();

        f3.multiply(f4);
        System.out.print("After multiply = ");
        f3.printFraction();

        f3.divide(f4);
        System.out.print("After divide = ");
        f3.printFraction();

        f3.reduce();
        System.out.print("After reduce = ");
        f3.printFraction();
    }
}
