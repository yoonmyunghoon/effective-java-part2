package me.whiteship.chapter04.item17.part1;

/**
 * 1. 불변 클래스
 *      - 객체가 생성되서 소멸될 때까지 상태가 변하지 않도록 설계한 클래스
 *      - 설계, 구현, 사용하기 쉬우며, 오류가 생길 여지가 적고 안전하다.
 *      - 스레드 세이프하다.
 *      - 인스턴스를 캐싱해두고 여러 스레드가 사용할 수 있다. -> 성능상 이점
 * 2. 불변 클래스 만드는 다섯가지 규칙
 *      - 객체 상태 변경 메서드(setter)를 제공하지 않는다.
 *      - 상속(클래스 확장)을 할 수 없도록 한다. -> final or only private 생성자
 *      - 모든 필드를 final 로 선언한다.
 *      - 모든 필드를 private 으로 선언한다.
 *      - 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.
 */
public final class PhoneNumber {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }


}
