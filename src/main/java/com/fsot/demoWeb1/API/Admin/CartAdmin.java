package com.fsot.demoWeb1.API.Admin;

import com.fsot.demoWeb1.DTO.Cart;
import com.fsot.demoWeb1.Entity.CartEntity;
import com.fsot.demoWeb1.Entity.DetailOder;
import com.fsot.demoWeb1.Entity.User;
import com.fsot.demoWeb1.Repo.CartRepo;
import com.fsot.demoWeb1.Service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class CartAdmin {
    @Autowired
    ICartService cartService;

    @Autowired
    CartRepo cartRepo;
    @GetMapping("/find-all-new-cart")
    public List<CartEntity> findAllNewCart(@RequestParam int page)
    {

        return  cartService.findAllNewCart(page);
    }
    @GetMapping("/find-all-new-cart1")
    public List<DetailOder> findAllNewCart1(@RequestParam Long id)
    {
        CartEntity cartEntity = cartRepo.findById(id).get();
        return  cartEntity.getListDetailOders();
    }

    @GetMapping("/find-all-new-cart2")
    public User findAllNewCart2(@RequestParam Long id)
    {
        CartEntity cartEntity = cartRepo.findById(id).get();
        return  cartEntity.getUser();
    }
}
