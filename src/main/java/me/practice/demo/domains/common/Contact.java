package me.practice.demo.domains.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class Contact {

    private String phone;
    private String contact;

    @Builder
    public Contact(String phone, String contact) {
        this.phone = phone;
        this.contact = contact;
    }

}
