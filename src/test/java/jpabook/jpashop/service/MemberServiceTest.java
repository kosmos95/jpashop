package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //junit 실행시 스프링과 같이 실행하기 위해 넣는 것
@SpringBootTest //스프링 부트를 띄운 상태로 테스트
@Transactional // 트랜젝션 걸고 테스트 하고 다시 롤백 해버림
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    @Test
    @Rollback(false)
    public void 회원가입() throws Exception {

        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {

        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다!!!

        /*
        이렇게도 할수 있다. 코드 지저분해서 @Test(expected = IllegalStateException.class)로 처리

        memberService.join(member1);
        try {
            memberService.join(member2); //예외가 발생해야 한다!!!
        } catch (IllegalStateException e) {
            return;
        }
        */

        //then
        fail("예외가 발생해야 한다.");
    }

}