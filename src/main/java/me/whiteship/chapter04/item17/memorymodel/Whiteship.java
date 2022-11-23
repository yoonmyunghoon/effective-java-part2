package me.whiteship.chapter04.item17.memorymodel;

/**
 * 10. JMM(자바 메모리 모델)
 *      - 어떻게 프로그램을 실행해야 적합한 건지 룰(규칙)을 정한 것
 * 11. final
 *      - final 을 사용한 필드들이 모두 세팅이 되어야 해당 객체를 참조할 수 있다.
 *      - 다른 스레드에서 객체를 참조하더라도 final 필드들은 안전하게 초기화되어있음을 보장한다.
 *      - 반드시 초기화되어야하는 값들은 final 을 사용해서 안전한게 초기화하자.
 */
public class Whiteship {

    private final int x;

    private final int y;

    public Whiteship() {
        this.x = 1;
        this.y = 2;
    }

    public static void main(String[] args) {
        // 순서가 바뀌어도 한 스레드 안에서는 유효함
        // 멀티 스레드 환경에서는 초기화 과정에서 필드값들이 공유되어 불완전한 상태의 객체를 참조하는 경우가 생길 수 있다.
        // Object w = new Whiteship()
        // whiteship = w
        // w.x = 1
        // w.y = 2

        Whiteship whiteship = new Whiteship();
    }


}
