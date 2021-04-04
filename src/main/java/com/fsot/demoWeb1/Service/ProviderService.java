package com.fsot.demoWeb1.Service;
import com.fsot.demoWeb1.Entity.ProviderEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public interface ProviderService {
     List<ProviderEntity>  findAll();
     ProviderEntity save(String providerDTO, MultipartFile logo);

}
