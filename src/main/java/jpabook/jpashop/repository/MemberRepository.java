package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }
    public Member findOne(Long id) {

        return em.find(Member.class, id); //단건 조회
    }
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)//jpql ql의 대상이 테이블이 아니라 entity
                .getResultList(); 
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
