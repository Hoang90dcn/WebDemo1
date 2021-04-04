package com.fsot.demoWeb1.API;


import com.fsot.demoWeb1.Entity.ProviderEntity;
import com.fsot.demoWeb1.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")


public class ProviderAPI  {
    @Autowired
    ProviderService service;
    @GetMapping("/find-all-provides")
    public  List<ProviderEntity> findALL()
    {
        return service.findAll();
    }
}
