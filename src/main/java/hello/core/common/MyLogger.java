package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component

// 스프링 컨테이너는 CGLIB 이라는 바이트 코드 조작 라이브러리를 사용하여
// MyLogger 를 상속받은 가짜 프록시 객체를 생성
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void log(String message) {
        System.out.println("["+uuid+"]"+"["+requestURL+"] "+ message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("["+uuid+"] request scope bean close:" + this);
    }
}
