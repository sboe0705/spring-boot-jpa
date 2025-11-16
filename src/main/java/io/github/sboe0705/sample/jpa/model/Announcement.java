package io.github.sboe0705.sample.jpa.model;

import jakarta.persistence.*;

@Entity
// required for InheritanceType.SINGLE_TABLE
//@DiscriminatorValue("ANNOUNCEMENT")
public class Announcement extends Content{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PriorityLevel priority;

    private String audience;

}
