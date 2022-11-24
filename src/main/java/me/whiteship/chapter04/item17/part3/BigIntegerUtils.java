package me.whiteship.chapter04.item17.part3;

import java.math.BigInteger;

public class BigIntegerUtils {

    /**
     * 8. 불변 클래스인데 상속이 가능한 경우
     *      - 매개변수로 들어온 val 가 불변인지 확실하지 않음
     *      - 방어적 복사를 사용해야 한다. BigInteger 인스턴스를 새로 만들어서 제공
     */
    public static BigInteger safeInstance(BigInteger val) {
        return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());
    }
}
