package com.fsot.demoWeb1.API;

import com.fsot.demoWeb1.Auth.JWT.JwtTokenProvider;
import com.fsot.demoWeb1.DTO.Cart;
import com.fsot.demoWeb1.Entity.CartEntity;
import com.fsot.demoWeb1.Repo.DetailOderRepo;
import com.fsot.demoWeb1.Service.ICartService;
import com.fsot.demoWeb1.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CartAPI {
    @Autowired
    IProductService productService;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private ICartService cartService;

//    @PostMapping("/add-item")
//    ResponseEntity<ResponEntity> addCart(@RequestBody CartItem data, final ModelMap model,
//                                         final HttpServletRequest request, final HttpServletResponse response)
//    {
//        ProductEntity dataProduct = productService.findById(data.getProductId());
//        data.setPrice(dataProduct.getPrice());
//
//       Long  totalMoneydata = data.getPrice() * data.getQuantity();
//        HttpSession httpSession = request.getSession();
//        httpSession.setAttribute("cart",null);
//        Cart cart = null;
//        if(httpSession.getAttribute("GIO_HANG")!=null) {
//            cart = (Cart) httpSession.getAttribute("GIO_HANG");
//        }
//        else
//        {
//            cart = new Cart();
//            httpSession.setAttribute("GIO_HANG", cart);
//        }
//        boolean check = false;
//
//
//        for(CartItem item : cart.getList())
//        {
//            if(item.getProductId() ==  data.getProductId()) {
//                item.setQuantity(item.getQuantity()+data.getQuantity());
//                check = true;
//                break;
//            }
//        }
//        if(!check) {
//
//            data.setProductName(dataProduct.getName());
//            data.setAvatar(dataProduct.getAvatar());
//            cart.getList().add(data);
//            httpSession.setAttribute("cart", cart.getList().size());
//
//        }
//        System.out.println(cart.getList().get(0).getQuantity());
//        cart.setTatol(cart.getTatol()+totalMoneydata);
//
//        return ResponseEntity.ok(new ResponEntity(String.valueOf(cart.getList().size()), 500));
//    }
//    @PostMapping("/load-product-from-cart")
//    public ResponseEntity<Cart> loadCart(@RequestBody Cart cart)
//
//    {
//        System.out.println(cart.getList().size());
//
//        for(CartItem item : cart.getList())
//        {
//            ProductEntity pro = productService.findById(item.getProductId());
//            item.setProductName(pro.getName());
//            item.setPrice(pro.getPrice());
//            item.setAvatar(pro.getAvatar());
//            item.setThumnail(pro.getThumnail());
//            item.setTotalMoney(item.getPrice()*item.getQuantity());
//
//            cart.setTatol(item.getTotalMoney()+cart.getTatol());
//        }
//
//        return  ResponseEntity.ok(cart);
//    }
    @PostMapping("/save-cart")
    public CartEntity saveCart(@RequestHeader("X-Token") String token, @RequestBody Cart cart)
    {

        CartEntity entity = new CartEntity();
        cartService.saveCart(cart,token);
        return entity;
    }


}
