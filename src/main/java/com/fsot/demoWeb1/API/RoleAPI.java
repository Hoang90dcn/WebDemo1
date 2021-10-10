package com.fsot.demoWeb1.API;

import com.fsot.demoWeb1.DTO.RoleDTO;
import com.fsot.demoWeb1.DTO.UserDTO;
import com.fsot.demoWeb1.Service.IRoleService;
import com.fsot.demoWeb1.Service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RoleAPI {


    @Autowired
    IRoleService service;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/get-all-roles")
    List<RoleDTO> findAll()
    {

        Type listType = new TypeToken<List<RoleDTO>>(){}.getType();
        List<RoleDTO>  list = mapper.map(service.findAll(), listType);
        return list;
    }
}
