package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); // 그냥 ApplicationContext에서는 제공X. ConfigurableApplicationContext 로 받음.
    }

    @Configuration
    static class LifeCycleConfig {
//        @Bean(initMethod = "init", destroyMethod = "close") // 추론기능이 있는 destroyMethod. 만약 추론 기능 없애고 싶으면 ""으로.
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient(); // 스프링 빈은 객체를 먼저 생성하고
            networkClient.setUrl("http://hello-spring.dev");  // 의존관계 주입. (단 생성자 주입은 객체 생성시에 일어난다는 점에서 예외)
            return networkClient;
        }
    }
}
