package hello.core.order;

import hello.core.discont.DiscontPolicy;
import hello.core.discont.FixDiscontPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscontPolicy discontPolicy = new FixDiscontPolicy();

//    @Autowired
//    private final MemberRepository memberRepository;
    private MemberRepository memberRepository;
    //final 은 필수로 값이 있어야함, 생성자에서 값 전달중
//    @Autowired
    private DiscontPolicy discontPolicy;

//    @Autowired(required = false) // Autowired의 기본 동작은 주입할 대상이 없으면 오류발생, 주입할 대상이 없어도 동작하게 하는 옵션
    public void setDiscontPolicy(DiscontPolicy discontPolicy) {
        System.out.println("discontPolicy = " + discontPolicy);
        this.discontPolicy = discontPolicy;
    }

//    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }
/*
    public OrderServiceImpl(){

    }*/

    //    @Autowired
    // Autowired 가 없어도 @Component 붙은 class에 생성자가 하나일때는 자동으로 생성된다
    public OrderServiceImpl(MemberRepository memberRepository, DiscontPolicy discontPolicy) {
        System.out.println("memberRepository 생성자 : " + memberRepository);
        System.out.println("discontPolicy 생성자 : " + discontPolicy);
        this.memberRepository = memberRepository;
        this.discontPolicy = discontPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discontPrice = discontPolicy.discont(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discontPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
