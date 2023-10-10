package com.app.ptever.repository;

import com.app.ptever.dao.UserDAO;
import com.app.ptever.domain.dto.PasswordMailDTO;
import com.app.ptever.domain.dto.UserDTO;
import com.app.ptever.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final JavaMailSender javaMailSender;
    @Override
    public Optional<UserVO> login(UserVO userVO) {
        return userDAO.login(userVO);
    }

    @Override
    public void save(UserVO userVO) {
        userDAO.write(userVO);
    }

    @Override
    public Optional<UserVO> checkByEmail(String userEmail) {
        return userDAO.findByEmail(userEmail);
    }

    @Override
    public void deactivateUser(UserVO userVO) {
        userDAO.modifyUserState(userVO);
    }

    @Override
    public void resave(UserVO userVO) {
        userDAO.reWrite(userVO);
    }

    @Override
    public void saveNewPassword(String userEmail, String userPassword) {
        userDAO.changePassword(userEmail, userPassword);
    }

    @Override
    public String getNewTempPW() {
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        StringBuilder str = new StringBuilder();

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str.append(charSet[idx]);
        }
        return str.toString();
    }

    @Override
    public PasswordMailDTO createMailAndChangePassword(String userEmail) {
        String str = getNewTempPW();
        PasswordMailDTO passwordMailDTO = new PasswordMailDTO();
        passwordMailDTO.setMailAddress(userEmail);
        passwordMailDTO.setMailTitle("[PTever] 피테버 임시비밀번호 안내 이메일입니다.");
        passwordMailDTO.setMailContent("안녕하세요. 피테버 임시비밀번호 안내 이메일입니다." +
                " 회원님의 임시비밀번호는 " + str + " 입니다. 로그인 후 비밀번호를 꼭 변경해주세요! 감사합니다.");
        saveNewPassword(userEmail, str);
        return passwordMailDTO;
    }

    @Override
    public void sendEmail(PasswordMailDTO passwordMailDTO) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(passwordMailDTO.getMailAddress()); // 메일 수신자
            mimeMessageHelper.setSubject(passwordMailDTO.getMailTitle()); // 메일 제목
            mimeMessageHelper.setText(passwordMailDTO.getMailContent(), true); // 메일 본문 내용, HTML 여부
            javaMailSender.send(mimeMessage);
            log.info("Success");
        } catch (MessagingException e) {
            log.info("fail");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveKakao(UserDTO userDTO) {
        userDAO.writeKakao(userDTO);
    }

    @Override
    public void reactivateToActiveByKakao(UserDTO userDTO) {
        userDAO.modifyToActiveByKakao(userDTO);
    }


}
