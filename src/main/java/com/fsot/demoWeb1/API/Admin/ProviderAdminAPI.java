package com.fsot.demoWeb1.API.Admin;

import com.fsot.demoWeb1.Entity.ProviderEntity;
import com.fsot.demoWeb1.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class ProviderAdminAPI {

    @Autowired
    ProviderService service;

    @PostMapping("/add-provider")
    public ProviderEntity addProvider (@RequestParam("provider") String provider,
                                        @RequestParam("logo")MultipartFile logo)
    {
        return service.save(provider,logo);
    }

}
