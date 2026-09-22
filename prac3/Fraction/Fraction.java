import java.util.Objects;

public class Fraction {

    private int num;
    private int den;

    // Constructor
    public Fraction(int num, int den) {

        int g = gcd(num, den);

        this.num = num / g;
        this.den = den / g;
    }

    // GCD method
    private int gcd(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // toString()
    @Override
    public String toString() {
        return num + "/" + den;
    }

    // equals()
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Fraction)) {
            return false;
        }

        Fraction f = (Fraction) o;

        return num == f.num && den == f.den;
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }
}