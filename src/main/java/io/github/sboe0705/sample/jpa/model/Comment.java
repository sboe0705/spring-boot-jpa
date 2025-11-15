package io.github.sboe0705.sample.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
// required for InheritanceType.SINGLE_TABLE
//@DiscriminatorValue("COMMENT")
public class Comment extends Content{

    @Column(nullable = false)
    public int likes;

}
