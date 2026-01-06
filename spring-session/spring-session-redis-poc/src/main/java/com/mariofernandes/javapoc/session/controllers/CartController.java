package com.mariofernandes.javapoc.session.controllers;

import com.mariofernandes.javapoc.session.dto.CartItem;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import static com.mariofernandes.javapoc.session.util.Constants.CART_SESSION_KEY;
import static com.mariofernandes.javapoc.session.util.Constants.RESPONSE_SUCCESSFULLY;

@RestController
@RequestMapping("/cart")
public class CartController {

    private static final Logger LOG = LoggerFactory.getLogger(CartController.class);

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody CartItem item, HttpSession session) {
        LOG.info("Session ID: {}", session.getId());
        Map<String, CartItem> cart = new HashMap<>();

        if (session.getAttribute(CART_SESSION_KEY) instanceof Map<?, ?> storedCart) {
            LOG.info("Retrieving cart items from session");
            for (Map.Entry<?, ?> entry : storedCart.entrySet()) {
                LOG.info("Existing cart item: key={}, value={}", entry.getKey(), entry.getValue());
                cart.put((String) entry.getKey(), (CartItem) entry.getValue());
            }
        }
        LOG.info("Adding item to cart: {}", item);
        cart.put(item.productId(), item);
        session.setAttribute(CART_SESSION_KEY, cart);

        return ResponseEntity.ok(String.format(RESPONSE_SUCCESSFULLY, "Item added to cart", session.getId()));
    }

    @GetMapping
    public ResponseEntity<Map<String, CartItem>> viewCart(HttpSession session) {
        LOG.info("Session ID: {}", session.getId());
        Map<String, CartItem> cart = new HashMap<>();

        if (session.getAttribute(CART_SESSION_KEY) instanceof Map<?, ?> storedCart) {
            LOG.info("Retrieving cart items from session");
            for (Map.Entry<?, ?> entry : storedCart.entrySet()) {
                LOG.info("Cart item: key={}, value={}", entry.getKey(), entry.getValue());
                cart.put((String) entry.getKey(), (CartItem) entry.getValue());
            }
        }

        LOG.info("Current cart contents: {}", cart);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart(HttpSession session) {
        session.removeAttribute(CART_SESSION_KEY);

        return ResponseEntity.ok(String.format(RESPONSE_SUCCESSFULLY, "Cart cleared", session.getId()));
    }

}
