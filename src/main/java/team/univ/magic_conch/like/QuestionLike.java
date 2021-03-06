package team.univ.magic_conch.like;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import team.univ.magic_conch.question.Question;
import team.univ.magic_conch.user.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    public QuestionLike(User user, Question question) {
        this.user = user;
        this.question = question;
    }
}
