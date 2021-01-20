package team.univ.magic_conch.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserRole role = UserRole.ROLE_USER;
    private String name;

    @Builder.Default
    private String profileImg = "/image/default_profile_image.png";

    @Builder.Default
    private LocalDate createDate = LocalDate.now();

    /**
     * 프로필 이미지 변경
     * @param profileImg 신규 프로필 이미지 경로
     */
    public void changeProfileImage(String profileImg) {
        this.profileImg = profileImg;
    }
}
