package me.whiteship.chapter04.item16.point.field;

/**
 * 5. package-private 클래스 또는 private 중첩 클래스라면 필드를 public 으로 설정해줘도 된다.
 * 6. 패키지 내부에서만 사용하는 코드이기 때문에 괜찮다.
 * -> 그래도 메서드 접근이 좀 더 좋다.(필드명 변경, 메서드에서 부가 작업 등 장점이 존재)
 */
class PackagePrivatePoint {
    public double x;
    public double y;
}
