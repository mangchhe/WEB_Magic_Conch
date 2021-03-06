package team.univ.magic_conch.bundle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import team.univ.magic_conch.bundle.dto.BundleDTO;
import team.univ.magic_conch.tag.Tag;
import team.univ.magic_conch.user.User;
import team.univ.magic_conch.visibility.Visibility;

import java.util.List;
import java.util.Optional;

public interface BundleService {

    /**
     * 번들 식별자로 번들 검색
     * @param id
     * @return Optional<Bundle>
     */
     Optional<Bundle> findById(Long id);

    /**
     * 신규 번들 생성
     * @param name
     * @param tag
     * @param user
     * @param visibility
     */
    void create(String name, Tag tag, User user, Visibility visibility);

    /**
     * username 으로 해당 사용자가 생성한 번들 목록 반환
     * @param username 번들 소유자
     * @param pageable 페이징 처리용
     * @return 번들 페이징
     */
    List<Bundle> getBundleByUsername(String username, Pageable pageable);
    BundleDTO.BundleDetails getBundleDetails(Long id);

}
