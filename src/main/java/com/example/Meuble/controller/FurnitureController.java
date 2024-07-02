package com.example.Meuble.controller;

import com.example.Meuble.entity.CartItem;
import com.example.Meuble.entity.Furniture;
import com.example.Meuble.service.CartItemService;
import com.example.Meuble.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FurnitureController {
    @Autowired
    private final FurnitureService furnitureService;
    @Autowired
    private final CartItemService cartItemService;

    public FurnitureController(FurnitureService furnitureService, CartItemService cartItemService) {
        this.furnitureService = furnitureService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("furnitures", furnitureService.getAllFurniture());
        return "home";
    }

    @GetMapping("/addForm")
    public String addForm(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "addFurniture";
    }

    @PostMapping("/addFurniture")
    public String addFurniture(@ModelAttribute("furniture") Furniture furniture) {
        furnitureService.saveFurniture(furniture);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("furnitureId") Long id) {
        Furniture furnitureToDelete = furnitureService.getFurnitureById(Math.toIntExact(id));
        if (furnitureToDelete != null) {
            furnitureService.deleteFurniture(furnitureToDelete);
        }
        return "redirect:/";

    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("furnitureId") Long furnitureId, @RequestParam("quantity") int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setFurnitureId(Math.toIntExact(furnitureId));
        cartItem.setQuantity(quantity);
        cartItemService.addToCart(cartItem);
        return "redirect:/";
    }



}
