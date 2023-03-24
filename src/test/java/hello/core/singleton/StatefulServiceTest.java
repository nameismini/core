package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 1000원 주문
        int userAPrice = statefulService1.order("userA", 1000);
        int userBPrice = statefulService2.order("userB", 2000);

        int price = statefulService1.getPrice();
        System.out.println("userAPrice = " + userAPrice);;
        System.out.println("userBPrice = " + userBPrice);;

//        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(2000);
    }


    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}