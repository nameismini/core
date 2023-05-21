package hello.core;

import hello.core.member.MemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

    @Autowired
    OrderService orderService;

    @Autowired
    MemberRepository memberRepository;
    @Test
    void contextLoads() {
        System.out.println("orderService : "+orderService);
        OrderServiceImpl orderService = new OrderServiceImpl();
       orderService.createOrder(1L, "member1", 1000);

    }

}
