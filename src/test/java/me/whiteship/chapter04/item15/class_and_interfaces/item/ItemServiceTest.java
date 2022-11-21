package me.whiteship.chapter04.item15.class_and_interfaces.item;

import me.whiteship.chapter04.item15.class_and_interfaces.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    MemberService memberService;

    @Test
    void itemService() {
        ItemService service = new ItemService(memberService);
        assertNotNull(service);

        // 이렇게 바로 접근할 수 있도록 package-private 으로 하는 것도 괜찮음
        assertNotNull(service.memberService);
        // getter 를 package-private 로 해도 괜찮음
//        assertNotNull(service.getMemberService());
    }

}