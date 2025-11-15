package io.github.sboe0705.sample.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    private String nickname;

    @OneToMany(mappedBy = "author")
    private List<Content> contents;

}
