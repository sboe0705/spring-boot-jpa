package io.github.sboe0705.sample.jpa;

import io.github.sboe0705.sample.jpa.data.ArticleRepository;
import io.github.sboe0705.sample.jpa.data.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@SpringBootTest
@ActiveProfiles("testdata")
// required to clean up in-memory database containing migration steps containing (test) data
@DirtiesContext(classMode = AFTER_CLASS)
class FlywayMigrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

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

    @Test
    void testArticleMigration() {
        assertThat(articleRepository.count()).isEqualTo(1);
        assertThat(articleRepository.findById(1L))
                .isPresent()
                .get()
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("title", "Healthy Breakfast Ideas")
                .hasFieldOrPropertyWithValue("topic", "Food")
                .hasFieldOrPropertyWithValue("summary", "Simple meals for busy mornings")
                .hasFieldOrPropertyWithValue("text", "Nutritionists suggest quick breakfast options like overnight oats, yogurt bowls, and whole-grain wraps to maintain energy throughout the day.");
    }

}
