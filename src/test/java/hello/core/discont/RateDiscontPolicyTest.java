package hello.core.discont;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscontPolicyTest {
    RateDiscontPolicy discontPolicy = new RateDiscontPolicy();

    @Test
    @DisplayName("VIP 10%적용")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discont = discontPolicy.discont(member, 10000);
        //then
        assertThat(discont).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 10%적용이 안되어야 한다")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        //when
        int discont = discontPolicy.discont(member, 20000);
        //then
        assertThat(discont).isEqualTo(1000);
    }
}