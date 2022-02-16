package hello.core.annotation;
import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.*;

// 이 아래의 4 친구들은 @Qualifier 에 들어가서 직접 가져온 친구들.
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented

@Qualifier("mainDiscountPolicy")

//직접 애노테이션 만들기! 매번 @Qualifier(" ") 이 안에 문자열로 넣으면 실수 가능하고, 컴파일시점에 오류를 잡아주지 못하니까.
public @interface MainDiscountPolicy {
}

