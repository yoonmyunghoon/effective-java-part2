package me.whiteship.chapter04.item17.part3;

/**
 * 코드 17-1 불변 복소수 클래스 (106-107쪽)
 * 불변 클래스 만들 때 고려할 것
 * 7. 패키지 밖에서 상속을 막을 수 있는 또 다른 방법
 *      - private(클래스 내부에서만) or package-private(같은 패키지 내에서만) 생성자 + 정적 팩터리
 *      - 패키지 내에서 상속을 통해 확장이 가능해지면 다수의 구현 클래스를 만들 수 있다.
 *      - 패키지 외부에서는 인스터스를 생성할 수 없다. -> 정적 팩터리로 내부에서 제공
 */
public class Complex {
    private final double re;
    private final double im;

    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex I    = new Complex(0, 1);

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // private 생성자 -> 내부 클래스에서 상속 가능
    private static class MyComplex extends Complex {
        private MyComplex(double re, double im) {
            super(re, im);
        }
    }

    public double realPart()      { return re; }
    public double imaginaryPart() { return im; }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    /**
     * 코드 17-2 정적 팩터리(private 생성자와 함께 사용해야 한다.) (110-111쪽)
     * 여러 구현 클래스 중에서 선택해서 제공할 수 있음 -> 유연성
     *      - final 을 사용해서 상속을 완전히 막아버리면 확장성, 유연성이 사라짐
     * 인스턴스를 캐싱해서 제공할 수도 있음 -> 약간의 성능 향상
     */
    public static Complex valueOf(double re, double im) {
        return new MyComplex(re, im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        // == 대신 compare를 사용하는 이유는 63쪽을 확인하라.
        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }
    @Override public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
