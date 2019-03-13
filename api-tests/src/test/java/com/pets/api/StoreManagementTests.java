package com.pets.api;

import com.pets.api.services.store.StoreApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.pets.api.condition.Conditions.statusCode;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.containsString;

@ExtendWith({BaseExtension.class})
public class StoreManagementTests {
    
    
    private StoreApiService storeApiService = new StoreApiService();

    @Test
    void testCanGetInventory() {
        
        storeApiService.getInventory()
                .shouldHave(statusCode(SC_OK));
        
    }

    @Test
    void testCanGetPurchase() {
        
        storeApiService.getPurchase(1)
                .shouldHave(statusCode(SC_CREATED));
        
    }
}
