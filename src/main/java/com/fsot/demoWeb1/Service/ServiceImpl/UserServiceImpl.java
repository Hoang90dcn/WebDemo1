package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.DTO.UserDTO;
import com.fsot.demoWeb1.Entity.RoleEntity;
import com.fsot.demoWeb1.Entity.User;
import com.fsot.demoWeb1.Repo.UserRepo;
import com.fsot.demoWeb1.Service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public User save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        user.setPassword(encoder.encode(user.getPassword()));
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(2l);
        user.getRoles().add(roleEntity);
        return userRepo.save(user);
    }

    @Override
    public User updateStatus(Long id) {
        User user = userRepo.findById(id).get();
        user.setStatus(!user.isStatus());

        return userRepo.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByAcAndPass(String acc) {
        return userRepo.checkLogin(acc);
    }

    @Override
    public UserDTO updateRoles(UserDTO user) {
        User userEntity = mapper.map(user, User.class);
        userRepo.save(userEntity);

        return mapper.map(userRepo.save(userEntity),UserDTO.class);
    }
}
