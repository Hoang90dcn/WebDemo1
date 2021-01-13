package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.DTO.Cart;
import com.fsot.demoWeb1.Entity.CartEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICartService {
    Cart findById(Long id);
    List<CartEntity> findAllNewCart(int page);
    void saveCart(Cart cart);
    Page<CartEntity> findAll();
}
