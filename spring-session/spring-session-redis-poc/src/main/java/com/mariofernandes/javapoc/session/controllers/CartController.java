package com.mariofernandes.javapoc.session.controllers;

import com.mariofernandes.javapoc.session.dto.CartItem;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.mariofernandes.javapoc.session.util.Constants.CART_SESSION_KEY;
import static com.mariofernandes.javapoc.session.util.Constants.RESPONSE_SUCCESSFULLY;

@RestController("/cart")
public class CartController {

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody CartItem item, HttpSession session) {
        @SuppressWarnings("unchecked")
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute(CART_SESSION_KEY);
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute(CART_SESSION_KEY, cart);
        }

        cart.put(item.productId(), item);
        return ResponseEntity.ok(String.format(RESPONSE_SUCCESSFULLY, "Item added to cart", session.getId()));
    }

    @GetMapping
    public ResponseEntity<Map<String, CartItem>> viewCart(HttpSession session) {
        @SuppressWarnings("unchecked")
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute(CART_SESSION_KEY);
        if (cart == null) {
            cart = new HashMap<>();
        }
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart(HttpSession session) {
        session.removeAttribute(CART_SESSION_KEY);

        return ResponseEntity.ok(String.format(RESPONSE_SUCCESSFULLY, "Cart cleared", session.getId()));
    }

}
