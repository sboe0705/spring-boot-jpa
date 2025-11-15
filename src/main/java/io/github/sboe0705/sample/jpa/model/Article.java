package io.github.sboe0705.sample.jpa.model;

import jakarta.persistence.*;

@Entity
// required for InheritanceType.SINGLE_TABLE
//@DiscriminatorValue("ARTICLE")
public class Article extends Content {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    private String topic;

    private String summary;

}
