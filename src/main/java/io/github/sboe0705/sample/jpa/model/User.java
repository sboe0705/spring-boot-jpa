package io.github.sboe0705.sample.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "unique_fullname", columnNames = {"firstname", "lastname"}))
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(nullable = false)
    private String lastname;

    private String nickname;

    @OneToMany(mappedBy = "author")
    private List<Content> contents;

}
