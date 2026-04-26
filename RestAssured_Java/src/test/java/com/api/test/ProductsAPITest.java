package com.api.test;

import com.api.base.ProductsService;
import com.api.models.ProductsListRequestResponse;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.List;

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

        ProductsListRequestResponse productsListResponse = response.as(ProductsListRequestResponse.class);
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

        ProductsListRequestResponse productsListResponse = response.as(ProductsListRequestResponse.class);
        assertFalse(productsListResponse.getProducts().isEmpty(), "Product list is empty!");
        assertEquals(productsListResponse.getProducts().size(), 5, "Number of products returned are not as per limit param");
        assertEquals(productsListResponse.getProducts().get(0).getId(),11, "skip param is not working as expected");
    }

    @Test(description = "Verify single product is returning")
    public void getSingleResourceTest() {
        ProductsService productsService = new ProductsService();
        Response response = productsService.getProducts("1");
        System.out.println("response"+response.asPrettyString());

        ProductsListRequestResponse.Product productResponse = response.as(ProductsListRequestResponse.Product.class);
        assertNotNull(response.path("category"), "Object is null");
        assertEquals(productResponse.getId(),1, "Product id is not as expected");
        assertNotNull(productResponse.getTitle(), "Product Title is not empty");
        assertNotNull(productResponse.getCategory(), "Product Category should not be null");
    }

    @Test(description = "Verify user is getting correct error code in response")
    public void notAbleToGetInvalidProductTest() {
        ProductsService productsService = new ProductsService();
        Response response = productsService.getProducts("999999");
        assertEquals(response.statusCode(),404, "Product  which is expected");
    }

    @Test(description = "Verify user is able to add new product")
    public void addProductTest() {
        String productName = "QA Test Product";
        Double productPrice = 999.0;
        ProductsListRequestResponse.Product productReq, productRes;

        ProductsService productsService = new ProductsService();
        productReq = new ProductsListRequestResponse.Product();
        productReq.setTitle(productName);
        productReq.setPrice(productPrice);

        Response res = productsService.addProducts("add",productReq);
        productRes = res.as(ProductsListRequestResponse.Product.class);

        assertEquals(productRes.getTitle(),productName, "Product name is not" + productName);
        assertEquals(productRes.getPrice(),productPrice, "Price is not " + productPrice );
    }

    @Test(description = "Verify highest prices product is higher than 1000")
    public void highestPricedProductTest() {
        ProductsService productsService = new ProductsService();
        Response response = productsService.getProducts("");
        ProductsListRequestResponse productsListResponse = response.as(ProductsListRequestResponse.class);
        List<ProductsListRequestResponse.Product> pr =  productsListResponse.getProducts();
        assertFalse(productsListResponse.getProducts().isEmpty(), "Product list is empty!");

        Double highestPrice = 0.0;

        for(ProductsListRequestResponse.Product prd: pr){
            if(prd.getPrice()>highestPrice) {
                highestPrice = prd.getPrice();
            }
        }
        System.out.println(highestPrice);
        assertTrue(highestPrice>1000, "Product price is less than 1000");
    }
}

