package me.practice.demo.domains.member.infra;

import me.practice.demo.domains.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member findMember = em.find(Member.class, id);

        return Optional.ofNullable(findMember);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        Member findMember = null;

        try {
            findMember = em.createQuery("select m from Member m where m.email = :email", Member.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return Optional.ofNullable(findMember);
        }

        return Optional.ofNullable(findMember);
    }

    @Override
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .getResultList();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public Long deleteById(Long id) {
        em.remove(em.find(Member.class, id));
        return id;
    }

}
