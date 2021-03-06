package team.univ.magic_conch.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.univ.magic_conch.answer.dto.AnswerDTO;
import team.univ.magic_conch.answer.dto.CreateAnswerDTO;
import team.univ.magic_conch.question.Question;
import team.univ.magic_conch.question.QuestionRepository;
import team.univ.magic_conch.user.User;
import team.univ.magic_conch.user.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = false)
    public AnswerDTO createAnswer(CreateAnswerDTO createAnswerDTO) {

        Optional<User> user = userRepository.findByUsername(createAnswerDTO.getUsername());
        Optional<Question> question = questionRepository.findById(createAnswerDTO.getQuestionId());
        Answer answer = null;

        if(user.isPresent() && question.isPresent()){
            answer = Answer.builder()
                    .content(createAnswerDTO.getContent())
                    .question(question.get())
                    .user(user.get())
                    .build();
            answerRepository.save(answer);
        }

        return answerRepository.findById(answer.getId()).get().entityToAnswerDTO();
    }

    @Override
    public List<AnswerDTO> answer(Long questionId) {
        return answerRepository.findAllByQuestionId(questionId).stream()
                .map(Answer::entityToAnswerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public long getCountByQuestionID(Long questionId) {
        return answerRepository.countByQuestionId(questionId);
    }

}
