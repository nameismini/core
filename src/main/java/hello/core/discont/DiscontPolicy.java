package hello.core.discont;

import hello.core.member.Member;

public interface DiscontPolicy {
    int discont(Member member, int price);
}
