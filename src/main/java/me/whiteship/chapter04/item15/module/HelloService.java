package me.whiteship.chapter04.item15.module;

import me.whiteship.name.NameService;

public class HelloService {

    /**
     * name-service 처럼 모듈을 만들고 비공개로 설정해도
     * 모듈이 아닌곳(effective-java-part2)에서는 바로 사용할 수 있음 -> 이런 이유로 모듈을 잘 사용하지 않음
     * effective-java-part2 는 자바 모듈이 아님(module-info.java 파일 정의 안함)
     */
    public static void main(String[] args) {
        NameService service = new NameService();
        System.out.println(service.getName());
    }
}
