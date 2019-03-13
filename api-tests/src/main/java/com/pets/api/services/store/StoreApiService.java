package com.pets.api.services.store;

import com.pets.api.assertions.AssertableResponse;
import com.pets.api.pets.ApiClient;
import io.qameta.allure.Step;

import static com.pets.api.ApiClientsUtils.RESPONSE_HANDLER;
import static com.pets.api.ApiClientsUtils.supplier;
import static com.pets.api.pets.ApiClient.Config.*;
import static com.pets.api.pets.ApiClient.api;

public class StoreApiService {

    private final ApiClient apiClient;

    public StoreApiService() {
        this.apiClient = api(
                apiConfig()
                        .reqSpecSupplier(supplier()));
    }
    
    @Step("GET inventory operation.")
    public AssertableResponse getInventory() {
        return new AssertableResponse(
                apiClient.store()
                        .getInventory()
                        .execute(RESPONSE_HANDLER)
                        .then());
    }
    
    @Step("GET purchase oper.")
    public AssertableResponse getPurchase(Object id) {
        return new AssertableResponse(
                apiClient.store()
                        .getOrderById()
                        .orderIdPath(id)
                        .execute(RESPONSE_HANDLER)
                        .then());
    }
}
