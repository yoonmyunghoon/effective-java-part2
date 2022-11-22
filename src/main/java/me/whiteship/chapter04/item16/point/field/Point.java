package me.whiteship.chapter04.item16.point.field;

/**
 * public 클래스에서 public 필드를 제공해주면 캡슐화의 장점을 제공하지 못한다.
 * 1. 필드 이름을 변경하면 사용하는 클라이언트에서 다 변경해줘야한다.
 * 2. 필드의 값을 세팅할 때 제한을 주거나, 가져올 때 부수 작업을 할 수 없다.
 */
public class Point {
    public double x;
    public double y;

    public static void main(String[] args) {
        Point point = new Point();
        point.x = 10;
        point.y = 20;

        System.out.println(point.x);
        System.out.println(point.y);
    }
}
