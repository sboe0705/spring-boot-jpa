package io.github.sboe0705.sample.jpa;

import io.github.sboe0705.sample.jpa.data.AnnouncementRepository;
import io.github.sboe0705.sample.jpa.data.ArticleRepository;
import io.github.sboe0705.sample.jpa.data.CommentRepository;
import io.github.sboe0705.sample.jpa.data.UserRepository;
import io.github.sboe0705.sample.jpa.model.Article;
import io.github.sboe0705.sample.jpa.model.PriorityLevel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
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

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AnnouncementRepository announcementRepository;


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
        assertThat(articleRepository.findAll())
                .hasSize(2)
                .extracting(Article::getId, Article::getTitle, Article::getTopic, Article::getSummary, Article::getText)
                .containsExactlyInAnyOrder(
                        tuple(1L, "Healthy Breakfast Ideas", "Food", "Simple meals for busy mornings", "Nutritionists suggest quick breakfast options like overnight oats, yogurt bowls, and whole-grain wraps to maintain energy throughout the day."),
                        tuple(51L, "AI in Modern Healthcare", "Technology", "How AI tools assist doctors", "Artificial intelligence is increasingly used to support diagnostics, streamline hospital workflows, and deliver personalized treatments.")
                );
    }

    @Test
    void testCommentMigration() {
        assertThat(commentRepository.count()).isEqualTo(1);
        assertThat(commentRepository.findById(101L))
                .isPresent()
                .get()
                .hasFieldOrPropertyWithValue("id", 101L)
                .hasFieldOrPropertyWithValue("title", "Great Article!")
                .hasFieldOrPropertyWithValue("text", "I really enjoyed reading this piece, very insightful and well-written.")
                .hasFieldOrPropertyWithValue("likes", 100);
    }

    @Test
    void testAnnouncementMigration() {
        assertThat(announcementRepository.count()).isEqualTo(1);
        assertThat(announcementRepository.findById(151L))
                .isPresent()
                .get()
                .hasFieldOrPropertyWithValue("id", 151L)
                .hasFieldOrPropertyWithValue("title", "System Maintenance")
                .hasFieldOrPropertyWithValue("text", "The platform will undergo scheduled maintenance tonight between 02:00 and 03:00 UTC.")
                .hasFieldOrPropertyWithValue("priority", PriorityLevel.HIGH)
                .hasFieldOrPropertyWithValue("audience", "All users");
    }

}
