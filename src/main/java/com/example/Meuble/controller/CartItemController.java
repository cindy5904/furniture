package com.example.Meuble.controller;

import com.example.Meuble.entity.CartItem;
import com.example.Meuble.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }
    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("cartItemId") int id) {
        cartItemService.removeFromCart(id);
        return "redirect:/cart";
    }

    @PostMapping("/clearCart")
    public String clearCart() {
        cartItemService.clearCart();
        return "redirect:/cart";
    }

}
