package com.pickx3.domain.entity.user_package;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "UserInfo")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userNum")
    private Long id;
    @Column(name="userName")
    private String name;

    @Column(name = "userId")
    private String email;
    @JsonIgnore
    @Column(name="userPwd")
    private String password;

    @Column(name = "userNick")
    private String nickName;

    @Column(name = "userPhone")
    private String phone;

    @Column(name = "userIntro")
    private String intro;

    @Column(name = "userImg")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "userRole")
    private Role role;

    @Column(name = "userEmailVerified")
    private Boolean emailVerified = false;

    @Enumerated(EnumType.STRING)
    @Column(name="userSnsType")
    private AuthProvider provider;

    @Column(name = "userProviderId")
    private String providerId;


    @Builder
    private User(String name, String email, String imageUrl, Role role, Boolean emailVerified, String password, AuthProvider provider, String providerId, String nickName) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.role = role;
        this.emailVerified = emailVerified;
        this.password = password;
        this.provider = provider;
        this.providerId = providerId;
        this.nickName = nickName;
    }

    public User update(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        return this;
    }


}
