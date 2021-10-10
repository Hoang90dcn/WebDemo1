package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.DTO.AdvertisementDTO;
import com.fsot.demoWeb1.Entity.Advertisement;
import com.fsot.demoWeb1.Entity.ProviderEntity;
import com.fsot.demoWeb1.Repo.AdvertisementRepo;
import com.fsot.demoWeb1.Service.IAdvertisementService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements IAdvertisementService {
    @Autowired
    AdvertisementRepo advertisementRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public List<AdvertisementDTO> findAllWithStatus() {
        return null;
    }

    @Override
    public List<AdvertisementDTO> findAll() {
        return null;
    }

    @Override
    public AdvertisementDTO addAdvertisement(String advertisementDTO, MultipartFile banner) {
        Gson gson = new Gson();
        Advertisement advertisementEntity = gson.fromJson(advertisementDTO, Advertisement.class);
        MultipartFile multipartFile = banner;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");


        if (advertisementEntity.getId() != null) {
            Advertisement oldAdvertisementEntity = advertisementRepo.findById(advertisementEntity.getId()).get();
            advertisementEntity.setModifiedDate(date);
            if (advertisementEntity.getBanner() != null) {
                Path filePath = Paths.get("D:\\JAVA_FPT\\demoWeb1\\slides\\" + advertisementEntity.getBanner());
                try {
                    System.out.println(filePath);
                    Files.delete(filePath);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        if(!banner.isEmpty())
        {


            try {
                String fileName = df.format(date)+"_"+multipartFile.getOriginalFilename();
                String path = "D:\\JAVA_FPT\\demoWeb1\\upload\\slides\\" + fileName;
                banner.transferTo(new File(path));
                advertisementEntity.setBanner("slides/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        advertisementEntity.setCreatedDate(new Date());


        return mapper.map(advertisementRepo.save(advertisementEntity),AdvertisementDTO.class);
    }

    @Override
    public AdvertisementDTO updateStatus(String advertisementDTO, MultipartFile banner) {
        Gson gson = new Gson();
        Advertisement advertisementEntity = gson.fromJson(advertisementDTO, Advertisement.class);
        MultipartFile multipartFile = banner;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");


        if (advertisementEntity.getId() != null) {
            Advertisement oldAdvertisementEntity = advertisementRepo.findById(advertisementEntity.getId()).get();
            advertisementEntity.setModifiedDate(date);
            if (advertisementEntity.getBanner() != null) {
                Path filePath = Paths.get("D:\\JAVA_FPT\\demoWeb1\\slides\\" + advertisementEntity.getBanner());
                try {
                    System.out.println(filePath);
                    Files.delete(filePath);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        if(!banner.isEmpty())
        {


            try {
                String fileName = df.format(date)+"_"+multipartFile.getOriginalFilename();
                String path = "D:\\JAVA_FPT\\demoWeb1\\upload\\slides\\" + fileName;
                banner.transferTo(new File(path));
                advertisementEntity.setBanner("slides/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        advertisementEntity.setCreatedDate(new Date());


        return mapper.map(advertisementRepo.save(advertisementEntity),AdvertisementDTO.class);
    }
}
