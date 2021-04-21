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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
//        Cart cart = new Cart();
//        CartEntity cartEntity = CartService.findById(id).get();
//        System.out.println(cartEntity.getListDetailOders().size());
//
//        cart.setTatol(cartEntity.getTotal());
//        List<DetailOder> detailOderList = detailOderSevice.findAllByIdCart(id);
//        cart.setId_user(cartEntity.);
//        for(DetailOder item : detailOderList)
//        {
//            CartItem cartItem = new CartItem();
//            ProductEntity pro = prodcutService.findById(item.getId().getProduct_ID());
//
//            cartItem.setProductId(item.getId().getProduct_ID());
//            cartItem.setQuantity(item.getAmount());
//            cartItem.setThumnail(pro.getThumnail());
//            cartItem.setAvatar(pro.getAvatar());
//            cartItem.setProductName(pro.getName());
//            cartItem.setTotalMoney(item.getAmount()*pro.getPrice());
//            cartItem.setPrice(pro.getPrice());
//            cart.getList().add(cartItem);
//        }

        return null;
    }

    @Override
    public List<CartEntity> findAllNewCart(int page) {
        Sort sort = Sort.by("createdDate").ascending();
        Pageable pageable = PageRequest.of(page, 10,sort);
         return CartService.findAllNewCart(pageable);


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
}
