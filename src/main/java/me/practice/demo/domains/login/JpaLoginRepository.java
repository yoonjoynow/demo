package me.practice.demo.domains.login;

import me.practice.demo.domains.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class JpaLoginRepository  implements LoginRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Member> findOne(String email, String password) {
        TypedQuery<Member> query = em.createQuery("select m from Member m" +
                                                            " where m.email = :email" +
                                                            " and m.password = :password", Member.class)
                                                            .setParameter("email", email)
                                                            .setParameter("password", password);
        Member findMember = query.getResultList().get(0);
        return Optional.ofNullable(findMember);
    }

}
