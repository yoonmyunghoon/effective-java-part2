package me.whiteship.chapter04.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// 코드 18-1 잘못된 예 - 상속을 잘못 사용했다! (114쪽)
public class InstrumentedHashSet<E> extends HashSet<E> {
    // 추가된 원소의 수
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    // 없애면 제대로 나오지만, 매번 이렇게 상위 클래스 내부 구현에 의존할 수는 없다. -> 캡슐화가 깨지게 됨
    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    // 아예 새롭게 재정의? -> 어렵고, 오류 및 성능 문제가 발생할 수 있다. 상위 클래스의 private 필드가 필요한 경우 구현 불가능
    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "탁탁", "펑"));
        /**
         * 1. 3이 나와야하는데 6이 나옴 -> 상속한 클래스의 내부 구현을 알아야 정확히 오버라이딩할 수 있음(캡슐화가 깨짐)
         */
        System.out.println(s.getAddCount());
    }
}
