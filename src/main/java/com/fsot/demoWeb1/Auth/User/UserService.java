package com.fsot.demoWeb1.Auth.User;

import com.fsot.demoWeb1.Entity.User;
import com.fsot.demoWeb1.Repo.UserRepo;
import com.fsot.demoWeb1.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    // load username và password cho phần xác thực
    @Override
    public UserDetails loadUserByUsername(String username)  {
        User user = userRepository.checkLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    // JWTAuthenticationFilter sẽ sử dụng hàm này
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomUserDetails(user);
    }
}
