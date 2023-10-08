package com.example.store.Service;

import com.example.store.Model.User;
import com.example.store.Repository.UserRepository;
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

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
