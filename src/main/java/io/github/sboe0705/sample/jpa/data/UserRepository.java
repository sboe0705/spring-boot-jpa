package io.github.sboe0705.sample.jpa.data;

import io.github.sboe0705.sample.jpa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
