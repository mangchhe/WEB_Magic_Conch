package team.univ.magic_conch.question;

import lombok.Getter;
import team.univ.magic_conch.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    private String title;
    private String content;
    private int view;

    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bundle_id")
    private Bundle bundle;
}
