package me.practice.demo.domains.member;

import lombok.*;
import me.practice.demo.domains.common.Address;
import me.practice.demo.domains.common.Contact;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class SignUpRequestDto {

    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    private String sex;
    private String phone;
    private String contact;
    private String city;
    private String street;
    private String zipCode;

    public Member toEntity() {
        return Member.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .sex(checkSex(this.sex))
                .contact(Contact.builder().phone(this.phone).contact(this.contact).build())
                .address(Address.builder().city(this.city).street(this.street).zipCode(this.zipCode).build())
                .build();
    }

    public MemberSex checkSex(String sex) {
        return sex.equals(MemberSex.MALE.toString()) ? MemberSex.MALE : MemberSex.FEMALE;
    }

}
