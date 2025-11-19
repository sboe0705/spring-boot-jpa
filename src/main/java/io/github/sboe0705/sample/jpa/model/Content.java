package io.github.sboe0705.sample.jpa.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// required for InheritanceType.SINGLE_TABLE
//@DiscriminatorColumn(name = "content_type")
public abstract class Content {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User author;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

}
