package com.api.test;

import com.api.base.ProductsService;
import com.api.models.ProductsListResponse;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ProductsAPITest {

    @Test(description = "Verify Products API is working fine")
    public void getProductsTest() {
        ProductsService productsService = new ProductsService();
        Response response = productsService.getProducts("");
        System.out.println(response.asPrettyString());
        assertNotNull(response.asPrettyString());
        assertTrue(response.getTime() < 2000, "Response time is greater than 2s which is ="+ response.getTime());
        System.out.println("response time "+response.getTime());
    }

    @Test(description = "Verify Products JSON validation for id and price")
    public void productsSchemaAssertionsTest() {
        ProductsService productsService = new ProductsService();
        Response response = productsService.getProducts("");

        ProductsListResponse productsListResponse = response.as(ProductsListResponse.class);
        assertFalse(productsListResponse.getProducts().isEmpty(), "Product list is empty!");
        assertTrue(productsListResponse.getProducts().get(0).getId() instanceof Integer, "Id is not number");
        assertNotNull(productsListResponse.getProducts().get(0).getTitle(), "Title is missing");
        assertTrue(productsListResponse.getProducts().get(0).getPrice()>0, "Price is not greater than 0");
        // Check the raw response to see if the key is actually in the payload
        assertNotNull(response.path("products[0].discountPercentage"), "Field 'discountPercentage' is missing from the JSON response!");
    }

    @Test(description = "Verify Products skip and limit params are working")
    public void productsQueryParamsTest() {
        ProductsService productsService = new ProductsService();
        Response response = productsService.getProducts("?limit=5&skip=10");

        ProductsListResponse productsListResponse = response.as(ProductsListResponse.class);
        assertFalse(productsListResponse.getProducts().isEmpty(), "Product list is empty!");
        assertEquals(productsListResponse.getProducts().size(), 5, "Number of products returned are not as per limit param");
        assertEquals(productsListResponse.getProducts().get(0).getId(),11, "skip param is not working as expected");
    }
}

