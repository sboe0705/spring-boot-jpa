package io.github.sboe0705.sample.jpa;

import io.github.sboe0705.sample.jpa.data.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("testdata")
class FlywayMigrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testUserMigration() {
        assertThat(userRepository.count()).isEqualTo(1);
        assertThat(userRepository.findById(1L))
                .isPresent()
                .get()
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("firstname", "Max")
                .hasFieldOrPropertyWithValue("lastname", "Mustermann")
                .hasFieldOrPropertyWithValue("nickname", "Maxi");
    }

}
