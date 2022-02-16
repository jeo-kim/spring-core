package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//
////    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
////    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    private DiscountPolicy discountPolicy;  // 그러나.... 구현체에 의존하지 않은 지금.. 당연히 null pointer exception.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
