package me.whiteship.chapter04.item16.point.method;

/**
 * 코드 16-2 접근자와 변경자(mutator) 메서드를 활용해 데이터를 캡슐화한다. (102쪽)
 * 3. 필드명이 바뀌어도 메서드명은 그대로 사용할 수 있다. -> 클라이언트에서 수정을 안해도 된다.
 * 4. 메서드 안에서 부수 작업을 더 해줄 수 있다.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        // 부가 작업
        return x;
    }
    public double getY() { return y; }

    public void setX(double x) {
        // 부가 작업
        this.x = x;
    }
    public void setY(double y) { this.y = y; }
}
