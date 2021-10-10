package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.DTO.AdvertisementDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface IAdvertisementService {

    List<AdvertisementDTO> findAllWithStatus();
    List<AdvertisementDTO> findAll();
    AdvertisementDTO addAdvertisement(String advertisementDTO, MultipartFile banner);
    AdvertisementDTO updateStatus(String advertisementDTO, MultipartFile banner);

}
