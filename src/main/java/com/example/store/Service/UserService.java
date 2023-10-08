package Service;

import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void registerUser(User user) {
        // 비밀번호 암호화 및 다른 필요한 로직을 수행할 수 있습니다.
        userRepository.save(user);
    }

    // 다른 사용자 관련 비즈니스 로직들
}
