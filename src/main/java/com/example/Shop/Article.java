package com.example.Shop;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class Article {
    private int id;

    @NotNull
    @NotEmpty
    private String name;


    @Size(max = 200)
    private String description;

    @DecimalMin(value = "0.00")
    private BigDecimal price;

    public Article(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = BigDecimal.valueOf(price).setScale(2,
                RoundingMode.HALF_UP);
    }
}