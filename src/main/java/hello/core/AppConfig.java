package hello.core;

import hello.core.discont.DiscontPolicy;
import hello.core.discont.FixDiscontPolicy;
import hello.core.discont.RateDiscontPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //    @Bean(name="/member/memberService")
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    //master last commit
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discontPolicy());
    }

    @Bean
    public DiscontPolicy discontPolicy() {
//        return new FixDiscontPolicy();
        System.out.println("call AppConfig.discontPolicy");
        System.out.println("develop branch");
        System.out.println("Tag Test");
        System.out.println("hot!");
        return new RateDiscontPolicy();
    }
}
