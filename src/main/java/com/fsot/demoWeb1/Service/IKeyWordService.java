package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.Entity.KeyWordEntitySearch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IKeyWordService {
    List<KeyWordEntitySearch> findAll();
    List<KeyWordEntitySearch> findOne();
    List<KeyWordEntitySearch> findAllByKey(String key);
}
