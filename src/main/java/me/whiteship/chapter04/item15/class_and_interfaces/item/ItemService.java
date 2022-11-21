package me.whiteship.chapter04.item15.class_and_interfaces.item;

import me.whiteship.chapter04.item15.class_and_interfaces.member.MemberService;

public class ItemService {

    /**
     * private, package-private 은 내부 구현
     * public 클래스의 public, protected 은 공개 API
     * 상수를 제외한 인스턴스 필드들은 되도록이면 public 이 아니어야 한다.(아이템 16)
     */
    public static final String NAME = "reynold";

    /**
     * 이렇게 참조변수를 public static final 로 선언하는건 안됨
     * 외부에서 변경하게 되면 사용하는 다른 클라이언트에서는 오류가 날 수 있음
     * 접근할 수 있는 메서드 같은 것도 만들면 안됨
     */
    public static final String[] NAMES = new String[10];

    /**
     * 테스트를 위해서 같은 패키지에서 접근할 수 있도록 변경해줌
     * 굳이 getter 를 만들지 않아도 됨
     * 만약 꼭 private 으로 하고 싶으면 getter 를 package-private 으로 제공해주면 됨
     */
//    private MemberService memberService;
    MemberService memberService;

    boolean onSale;
    protected int saleRate; // 이 클래스를 상속한 클래스에서는 다 사용할 수 있음 -> 범위가 엄청 넓어짐

    public ItemService(MemberService memberService) {
        if (memberService == null) {
            throw new IllegalArgumentException("MemberService should not be null.");
        }
        this.memberService = memberService;
    }

//    MemberService getMemberService() {
//        return memberService;
//    }
}
