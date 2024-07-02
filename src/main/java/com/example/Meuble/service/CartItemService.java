package com.example.Meuble.service;

import com.example.Meuble.entity.CartItem;
import com.example.Meuble.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService implements ICartItemService{
    private CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem addToCart(CartItem cartItem) {

        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem removeFromCart(int id) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(id);
        if (cartItemOptional.isPresent()) {
            cartItemRepository.deleteById(id);
            return cartItemOptional.get();
        }
        return null;
    }

    @Override
    public void clearCart() {
        cartItemRepository.deleteAll();
    }
}
