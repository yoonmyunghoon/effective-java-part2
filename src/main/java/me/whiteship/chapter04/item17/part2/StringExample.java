package me.whiteship.chapter04.item17.part2;

public class StringExample {

    public static void main(String[] args) {
        String name = "whiteship";

        // 단점 대안 2) 가변 동반 클래스 제공
        StringBuilder nameBuilder = new StringBuilder(name);
        nameBuilder.append("keesun");
        nameBuilder.append("reynold");

        System.out.println(nameBuilder);
    }
}
