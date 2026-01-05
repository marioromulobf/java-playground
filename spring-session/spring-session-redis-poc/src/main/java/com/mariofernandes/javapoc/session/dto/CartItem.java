package com.mariofernandes.javapoc.session.dto;

import java.math.BigDecimal;

public record CartItem(String productId, String name, BigDecimal price, int quantity) {

}
