package io.github.sboe0705.sample.jpa.model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

}
