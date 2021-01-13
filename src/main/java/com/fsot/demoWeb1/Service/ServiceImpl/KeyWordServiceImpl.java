package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.Entity.KeyWordEntitySearch;
import com.fsot.demoWeb1.Repo.KeyWordRepo;
import com.fsot.demoWeb1.Service.IKeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyWordServiceImpl implements IKeyWordService {
    @Autowired
    KeyWordRepo service;
    @Override
    public List<KeyWordEntitySearch> findAll() {
        return service.findAll();
    }

    @Override
    public List<KeyWordEntitySearch> findOne() {
        return null;
    }

    @Override
    public List<KeyWordEntitySearch> findAllByKey(String key) {
        return service.findAllIdProduct(key);
    }
}
