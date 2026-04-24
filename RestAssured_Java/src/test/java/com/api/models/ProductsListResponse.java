package com.api.models;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) //this will make sure if new property is added to response test case will still run
public class ProductsListResponse {

    private List<Product> products;
    private int total; // Added these common DummyJSON fields
    private int skip;
    private int limit;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {
        private Integer id;
        private String title;
        private String description;
        private String category;
        private Double price;
        private Double discountPercentage;
        private Double rating;
        private Integer stock;
        private List<String> tags; // Array of Primitives
        private String brand;
        private String sku;
        private Integer weight;
        private Dimensions dimensions; // Nested Object
        private String warrantyInformation;
        private String shippingInformation;
        private String availabilityStatus;
        private List<Review> reviews; // Array of Objects
        private String returnPolicy;
        private Integer minimumOrderQuantity;
        private Meta meta; // Nested Object
        private List<String> images;
        private String thumbnail;
    }

    @Data
    public static class Dimensions {
        private Double width;
        private Double height;
        private Double depth;
    }

    @Data
    public static class Review {
        private int rating;
        private String comment;
        private String date;
        private String reviewerName;
        private String reviewerEmail;
    }

    @Data
    public static class Meta {
        private String createdAt;
        private String updatedAt;
        private String barcode;
        private String qrCode;
    }
}
