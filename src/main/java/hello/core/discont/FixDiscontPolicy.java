package hello.core.discont;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

//@Component
public class FixDiscontPolicy implements DiscontPolicy {
    private int discontFixAmount = 1000;

    @Override
    public int discont(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discontFixAmount;
        } else {
            return 0;
        }
    }
}
