package com.fsot.demoWeb1.API.Admin;

import com.fsot.demoWeb1.DTO.AdvertisementDTO;
import com.fsot.demoWeb1.Service.IAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdvertisementAPI {

    @Autowired
    IAdvertisementService service;
    @PostMapping("/add-advertisement")
    public AdvertisementDTO addAdvertisement(@RequestParam("advertisementDTO") String advertisementDTO,
                                             @RequestParam("file") MultipartFile banner)
    {
        return service.addAdvertisement(advertisementDTO, banner);
    }
}
