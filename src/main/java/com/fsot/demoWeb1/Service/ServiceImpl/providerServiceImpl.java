package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.Entity.ProviderEntity;
import com.fsot.demoWeb1.Repo.ProviderRepo;
import com.fsot.demoWeb1.Service.ProviderService;
import com.google.gson.Gson;
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
public class providerServiceImpl implements ProviderService {
    @Autowired
    ProviderRepo providerRepo;

    @Override
    public List<ProviderEntity> findAll() {
        return providerRepo.findAll();
    }

    @Override
    public ProviderEntity save(String providerDTO, MultipartFile logo) {
        Gson gson = new Gson();
        ProviderEntity providerEntity = gson.fromJson(providerDTO,ProviderEntity.class);
        MultipartFile multipartFile = logo;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");



        if(providerEntity.getId()!=null)
        {
            ProviderEntity oldProvider = providerRepo.findById(providerEntity.getId()).get();
            providerEntity.setModifiedDate(date);
            if(providerEntity.getLogo()!=null)
            {
                Path filePath = Paths.get("D:\\JAVA_FPT\\demoWeb1\\upload\\"+ providerEntity.getLogo());
                try {
                    System.out.println(filePath);
                    Files.delete(filePath);

                }catch (Exception e)
                {
                    System.out.println(e);
                }
            }

        }


        if(!logo.isEmpty())
        {


            try {
                String fileName = df.format(date)+"_"+multipartFile.getOriginalFilename();
                String path = "D:\\JAVA_FPT\\demoWeb1\\upload\\providers\\" + fileName;
                logo.transferTo(new File(path));
                providerEntity.setLogo("providers/"+fileName);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        providerEntity.setStatus(true);
        providerEntity.setCreatedDate(new Date());



        return providerRepo.save(providerEntity);
    }
}
