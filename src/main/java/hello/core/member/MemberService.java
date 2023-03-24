package hello.core.member;

public interface MemberService {

    //회원등록
    void join(Member member);

    //회원찾기
    Member findMember(Long memberId);

}
