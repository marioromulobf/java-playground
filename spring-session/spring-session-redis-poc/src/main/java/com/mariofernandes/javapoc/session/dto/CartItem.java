package com.mariofernandes.javapoc.session.dto;

import java.math.BigDecimal;
import java.io.Serializable;

public record CartItem(String productId, String name, BigDecimal price, int quantity) implements Serializable {

}
