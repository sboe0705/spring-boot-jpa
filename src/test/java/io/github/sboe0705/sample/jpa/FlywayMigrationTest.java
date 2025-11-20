package io.github.sboe0705.sample.jpa;

import io.github.sboe0705.sample.jpa.data.AnnouncementRepository;
import io.github.sboe0705.sample.jpa.data.ArticleRepository;
import io.github.sboe0705.sample.jpa.data.CommentRepository;
import io.github.sboe0705.sample.jpa.data.UserRepository;
import io.github.sboe0705.sample.jpa.model.*;
import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
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
        assertThat(userRepository.count()).isEqualTo(2);
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
                .extracting(Article::getId, Article::getTitle, Article::getText, Article::getTopic, Article::getSummary)
                .containsExactlyInAnyOrder(
                        tuple(1L, "Healthy Breakfast Ideas", "Nutritionists suggest quick breakfast options like overnight oats, yogurt bowls, and whole-grain wraps to maintain energy throughout the day.", "Food", "Simple meals for busy mornings"),
                        tuple(51L, "AI in Modern Healthcare", "Artificial intelligence is increasingly used to support diagnostics, streamline hospital workflows, and deliver personalized treatments.", "Technology", "How AI tools assist doctors")
                );
    }

    @Test
    void testCommentMigration() {
        assertThat(commentRepository.findAll())
                .hasSize(1)
                .extracting(Comment::getId, Comment::getTitle, Comment::getText, Comment::getLikes)
                .containsExactlyInAnyOrder(
                        tuple(101L, "Great Article!", "I really enjoyed reading this piece, very insightful and well-written.", 100)
                );
    }

    @Test
    void testAnnouncementMigration() {
        assertThat(announcementRepository.findAll())
                .hasSize(1)
                .extracting(Announcement::getId, Announcement::getTitle, Announcement::getText, Announcement::getPriority, Announcement::getAudience)
                .containsExactlyInAnyOrder(
                        tuple(151L, "System Maintenance", "The platform will undergo scheduled maintenance tonight between 02:00 and 03:00 UTC.", PriorityLevel.HIGH, "All users")
                );
    }

    @Test
    void testUniqueUsersFullname() {
        User unknown = new User();
        unknown.setFirstname("unknown");
        unknown.setLastname("unknown");
        Assertions.assertThatThrownBy(() -> userRepository.save(unknown))
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasCauseInstanceOf(ConstraintViolationException.class)
                .hasMessageContaining("unique_fullname");
    }

}
