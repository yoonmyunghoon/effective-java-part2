package me.whiteship.chapter04.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 코드 18-2 래퍼 클래스 - 상속 대신 컴포지션을 사용했다. (117-118쪽)
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
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
        InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
        s.addAll(List.of("틱", "탁탁", "펑"));
        /**
         * 2. 3이 나옴
         * -> HashSet 의 addAll 메서드를 사용하지만 상속을 한게 아니기 때문에 사이드 이펙트가 없다.
         * -> addAll 내부적으로 호출하는 add 메서드(자기사용)도 HashSet 의 add 를 사용함(단순히 HashSet 의 addAll 을 호출한 것)
         */
        System.out.println(s.getAddCount());
    }
}
