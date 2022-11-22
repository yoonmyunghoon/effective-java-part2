package me.whiteship.chapter04.item17.part2;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class BigIntExample {

    public static void main(String[] args) {
        BigInteger ten = BigInteger.TEN;
        // 5) 가지고 있는 배열(mag)을 그대로 넘겨줌, 불변이기 때문에 불변 객체에 넘겨줘서 같이 사용하는건 안전함
        BigInteger minusTen = ten.negate();

        // 6) Set 내부에 불변 객체가 들어가기 때문에 좀 더 안정적임
        final Set<Point> points = new HashSet<>();
        Point firstPoint = new Point(1, 2);
        points.add(firstPoint);

//        firstPoint.x = 10; // 이런식으로 변경할 수 없음

    }
}
