package hello.core.beanfind;

import hello.core.discont.DiscontPolicy;
import hello.core.discont.FixDiscontPolicy;
import hello.core.discont.RateDiscontPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다")
    void findBeanByParentTypeDuplicate(){
//        DiscontPolicy bean = ac.getBean(DiscontPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscontPolicy.class));
    }
    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    void findBeanByParentTypeBeanName(){
        DiscontPolicy rateDiscontPolicy = ac.getBean("rateDiscontPolicy", DiscontPolicy.class);
        assertThat(rateDiscontPolicy).isInstanceOf(RateDiscontPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType(){
        RateDiscontPolicy bean = ac.getBean(RateDiscontPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscontPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType(){
        Map<String, DiscontPolicy> beansOfType = ac.getBeansOfType(DiscontPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("key : "+ key + ", beansOfType.keySet : "+beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("오브젝트 부모로 모두 조회하기")
    void findAllBeanByObjectType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("s + \"value = \"+beansOfType.get(s) = " + s + "value = "+beansOfType.get(s));
        }
    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscontPolicy reteDiscontPolicy() {
            return new RateDiscontPolicy();
        }

        @Bean
        public DiscontPolicy fixDiscontPolicy() {
            return new FixDiscontPolicy();
        }
    }
}
