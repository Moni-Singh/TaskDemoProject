package com.example.taskdemo.webservices;


import com.example.taskdemo.model.Countries;
import com.example.taskdemo.model.request.LoginRequest;
import com.example.taskdemo.model.response.LoginResponse;
import com.example.taskdemo.model.response.ProductDetails;
import com.example.taskdemo.model.response.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
//    POST LOGIN API
    @POST(AppUrls.LOGIN)
    Call<LoginResponse> getLogin(@Body LoginRequest loginRequest);

    //GET PRODUCT
    @GET(AppUrls.GET_PRODUCT)
    Call<List<Products>> getAllProducts();

    //GET PRODUCT BY LIMIT
    @GET(AppUrls.GET_PRODUCT)
    Call<List<Products>> getProducts(@Query("limit") int limit);

    @GET(AppUrls.GET_PRODUCT_BY_ID)
    Call<ProductDetails>getProductDetails(@Path("id") int productId);

    @GET("countryInfoJSON")
    Call<Countries> getCountries(
            @Query("lang") String lang,
            @Query("username") String userName,
            @Query("style") String style);
}
