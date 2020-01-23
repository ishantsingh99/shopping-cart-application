package com.caseStudy.eCart.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component

@Entity
    @Table(name="users")
@EntityListeners(AuditingEntityListener.class)
    public class userDetails {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long uid;
        @Column(name="username")
        private String username;
        @Column(name="password")
        private String password;
        @Column(name="active")
        private int active;
        @Column(name="role")
        private String role;
        public int getActive() {
            return active;
        }

        public void setActive(int active) {
            this.active = active;
        }

        public String getUsername() {
                return username;
            }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Long getUid() {
            return uid;
        }

        public void setUid(long id) {
            this.uid = id;
        }

        public String getRole() {
        return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
}


