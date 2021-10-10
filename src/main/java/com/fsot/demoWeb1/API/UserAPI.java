package com.fsot.demoWeb1.API;

import com.fsot.demoWeb1.DTO.CartDTO;
import com.fsot.demoWeb1.DTO.UserDTO;
import com.fsot.demoWeb1.Entity.User;
import com.fsot.demoWeb1.Service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserAPI {

    @Autowired
    IUserService service;

    @Autowired
    ModelMapper mapper;

    @PostMapping("/dang-ky")
    User dangKy(@RequestBody User user)
    {
        return  service.save(user);
    }

    @PutMapping("/update-status")
    User updateStatus(@RequestParam Long id){
        return service.updateStatus(id);

    }
    @GetMapping("/find-all-user")
    List<UserDTO> findAll()
    {

        Type listType = new TypeToken<List<UserDTO>>(){}.getType();
        List<UserDTO>  list = mapper.map(service.findAll(), listType);

        return list;
    }
    @PostMapping("/update-role")
    UserDTO updateRole(@RequestBody UserDTO user)
    {



        return service.updateRoles(user);
    }
}
