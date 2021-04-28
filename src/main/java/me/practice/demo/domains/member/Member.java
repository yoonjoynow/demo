package me.practice.demo.domains.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.practice.demo.domains.common.Address;
import me.practice.demo.domains.common.Contact;

import javax.persistence.*;
import javax.validation.constraints.Email;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private MemberSex sex;

    @Embedded
    private Address address;
    @Embedded
    private Contact contact;

    @Builder
    public Member(String email, String password, String name, MemberSex sex, Address address, Contact contact) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.contact = contact;
    }

}
