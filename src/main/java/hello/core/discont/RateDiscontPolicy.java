package hello.core.discont;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscontPolicy implements DiscontPolicy {
    private int discontPercent = 10;


    @Override
    public int discont(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discontPercent / 100;
        } else {
            return 0;
        }
    }
}
