package hello.core.member;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository{

    // branche test
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member meber) {
        store.put(meber.getId(), meber);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
