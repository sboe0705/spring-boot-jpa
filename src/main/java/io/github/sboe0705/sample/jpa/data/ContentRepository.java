package io.github.sboe0705.sample.jpa.data;

import io.github.sboe0705.sample.jpa.model.Content;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepository<T extends Content> extends CrudRepository<T, Long> {
}
