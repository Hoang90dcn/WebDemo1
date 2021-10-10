package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.Auth.JWT.JwtTokenProvider;
import com.fsot.demoWeb1.DTO.Cart;
import com.fsot.demoWeb1.DTO.CartItem;
import com.fsot.demoWeb1.Entity.CartEntity;
import com.fsot.demoWeb1.Entity.DetailOder;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import com.fsot.demoWeb1.Entity.User;
import com.fsot.demoWeb1.Repo.CartRepo;
import com.fsot.demoWeb1.Repo.DetailOderRepo;
import com.fsot.demoWeb1.Service.ICartService;
import com.fsot.demoWeb1.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartRepo CartService;
    @Autowired
    private DetailOderRepo detailOderSevice;
    @Autowired
    private IProductService prodcutService;
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Override
    public Cart findById(Long id) {


        return null;
    }

    @Override
    public List<CartEntity> findAllNewCart() {
//        Sort sort = Sort.by("createdDate").ascending();
//        Pageable pageable = PageRequest.of(page, 10,sort);
        //pageable
         return CartService.findAllNewCart();


    }

    @Override
    public void saveCart(Cart cart, String token) {


        try {
            //convert DTO to entity
            // tính tổng giỏ hàng
            for(CartItem item : cart.getList())
            {
                ProductEntity pro = prodcutService.findById(item.getId());
                item.setName(pro.getName());
                item.setPrice(pro.getPrice());
                item.setAvatar(pro.getAvatar());
                cart.setTatol(item.getAmount()*item.getPrice()+cart.getTatol());

            }

            // tạo 1 giỏ hàng
            CartEntity cartEntity = new CartEntity();
            // mặc định chưa xác nhận
            cartEntity.setConfirm(false);

            //lấy id user
            Long id_user = tokenProvider.getUserIdFromJWT(token);
            // set tất cả các thuộc tính của giỏ hàng
            User user = new User();
            user.setId(id_user);
            cartEntity.setUser(user);
            cartEntity.setTotal(cart.getTatol());
            cartEntity.setAddress(cart.getAddress());
            cartEntity.setModifiedDate(new Date());
            cartEntity = CartService.save(cartEntity);

            for(CartItem item : cart.getList())
            {
                ProductEntity pro = prodcutService.findById(item.getId());
                DetailOder detailOder = new DetailOder(cartEntity,pro,item.getAmount(),item.getPrice());
                System.out.println();
                detailOderSevice.save(detailOder);

            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public Page<CartEntity> findAll() {
        return null;
    }

    @Override
    public CartEntity confirm(Long id_cart) {
        CartEntity cartEntity = CartService.findById(id_cart).get();
        cartEntity.setConfirm(true);
        cartEntity.setModifiedDate(new Date());
        CartService.save(cartEntity);
        return cartEntity;
    }

    @Override
    public CartEntity cancelCart(Long id_cart) {
        CartEntity cartEntity = CartService.findById(id_cart).get();
        cartEntity.setStatus(false);
        cartEntity.setModifiedDate(new Date());
        CartService.save(cartEntity);


        return cartEntity;
    }
}
