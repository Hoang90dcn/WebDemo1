package com.fsot.demoWeb1.API;

import com.fsot.demoWeb1.Entity.User;
import com.fsot.demoWeb1.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAPI {

    @Autowired
    IUserService service;

    @PostMapping("/dang-ky")
    User dangKy(@RequestBody User user)
    {
        return  service.save(user);
    }

    @PostMapping("/login")
    User  login(@RequestBody User user)
    {
        User t = service.findByAcAndPass(user.getAccount());
        System.out.println(t.getFullname());
        return service.findByAcAndPass(user.getAccount());
    }
    @GetMapping("/find-all-user")
    List<User> findAll()
    {
        return service.findAll();
    }
}
