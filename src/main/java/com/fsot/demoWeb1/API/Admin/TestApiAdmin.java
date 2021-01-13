package com.fsot.demoWeb1.API.Admin;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/admin")
public  class TestApiAdmin {
    @GetMapping("/tes-admin")
    public  String test()
    {
        return "huy hoangf";
    }
    @PostMapping("/test-file")
    public  void uploadFile(@RequestBody  MultipartFile file) {
        String fullPart ="D:\\JAVA_FPT\\demoWeb1\\image\\product\\"+ file.getOriginalFilename();
        try {
            file.transferTo(new File(fullPart));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
