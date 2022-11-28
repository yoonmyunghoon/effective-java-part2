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

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

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
