package me.whiteship.chapter04.item16.dimension;

import java.awt.*;

/**
 * 8. java.awt 패키지가 아님에도 필드에 바로 접근할 수 있다.
 * -> 안전하게 쓰기 위해서 사용할때 마다 copy 해서 사용해야함
 * -> 성능 문제, 귀찮음 등이 동반됨
 */
public class DimensionExample {

    public static void main(String[] args) {
        Button button = new Button("hello button");
        button.setBounds(0, 0, 20, 10);

        Dimension size = button.getSize();
        System.out.println(size.height);
        System.out.println(size.width);

        doSomething(size);
    }

    private static void doSomething(Dimension dimension) {

//        dimension.width = 100000; // 이렇게 변경해버릴수도 있음 -> 안전하지 않음

        // 이렇게 복사해서 사용해야함.. 매우 귀찮..
        Dimension dimension1 = new Dimension();
        dimension1.width = dimension.width;
        dimension1.height = dimension.height;
    }

}
