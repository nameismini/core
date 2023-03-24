package hello.core.order;

import hello.core.discont.DiscontPolicy;
import hello.core.discont.FixDiscontPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscontPolicy discontPolicy = new FixDiscontPolicy();

    private final MemberRepository memberRepository;
    private final DiscontPolicy discontPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscontPolicy discontPolicy) {
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
