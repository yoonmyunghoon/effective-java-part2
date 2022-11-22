package me.whiteship.chapter04.item17.part2;

/**
 * 코드 17-1 불변 복소수 클래스 (106-107쪽)
 * 5. 장점
 *      1) 함수형 프로그래밍에 적합하다.(피연산자를 이용해서 결과를 반환하지만, 피연산자가 변경되지는 않음)
 *      2) 클라이언트쪽에서도 사용하기에 단순하다.
 *      3) 스레드 안전하며 따로 동기화할 필요 없다.
 *      4) 한 스레드 내에서도 여러 인스턴스에서 안심하고 공유할 수 있다.
 *      5) 불변 객체 끼리는 내부 데이터를 공유할 수 있다.
 *      6) 객체를 만들 때 불변 객체로 구성하면 이점이 많다.
 *      7) 실패 원자성을 제공한다.(메서드로 먼가 처리하다가 예외가 발생해도 객체는 상태 변화 없음)
 * 6. 단점
 *      1) 값이 다르다면 반드시 별도의 객체로 만들어야 한다.
 *      대안 1) 다단계 연산 제공: 연산마다 새로운 객체를 만드는게 아니라 여러번의 연산을 거쳐서 한번만 객체를 생성하도록 제공
 *      대안 2) 가변 동반 클래스 제공
 */
public final class Complex {
    private final double re;
    private final double im;

    // 4) 이렇게 상수로 만들어서 사용해도 됨, 인스턴스를 참조하고 있지만 불변이기 때문에 안전함 -> 오히려 재사용하는 것이 좋음
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex I    = new Complex(0, 1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart()      { return re; }
    public double imaginaryPart() { return im; }

    public Complex plus(Complex c) {
        // 1) 이런식으로 피연산자의 필드값을 변경하지 않는다.(불변 객체이므로 변경할 수 없음) -> 함수형 프로그래밍에 어울림
//        re = c.re;
//        im = c.im;
        return new Complex(re + c.re, im + c.im);
    }

    // 코드 17-2 정적 팩터리(private 생성자와 함께 사용해야 한다.) (110-111쪽)
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
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
