package io.github.sboe0705.sample.jpa.data;

import io.github.sboe0705.sample.jpa.model.Announcement;
import io.github.sboe0705.sample.jpa.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends ContentRepository<Announcement> {
}
