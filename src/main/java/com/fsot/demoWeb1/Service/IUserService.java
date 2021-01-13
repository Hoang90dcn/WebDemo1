package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    User save(User user);
    User findById(Long id);
    List<User> findAll();
    User findByAcAndPass(String acc);
}
