package io.github.sboe0705.sample.jpa.model;

import jakarta.persistence.*;

@Entity
// required for InheritanceType.SINGLE_TABLE
//@DiscriminatorValue("ARTICLE")
public class Article extends Content {

    private String topic;

    private String summary;

    public String getTopic() {
        return topic;
    }

    public String getSummary() {
        return summary;
    }

}
