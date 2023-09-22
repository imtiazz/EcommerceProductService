package com.myEcommerce.product.ThirdPartyAPIs;

import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.dtos.GenericproductDTOs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductClient {
    RestTemplate restTemplate=new RestTemplate();

   // @Value("${fakeStore.api.url}")
    private String productBaseURL;
    private  String productPath;

    private RestTemplateBuilder restTemplateBuilder;


    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakeStore.api.baseUrl}") String productBaseUrl,
                                  @Value("${fakeStore.api.path.products}") String productPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productBaseURL=productBaseUrl;
        this.productPath=productPath;
    }

    public FakeStorePostDTOs createProduct(GenericproductDTOs product) {
        //concatenate string
        String productRequestBaseUrl=productBaseURL+productPath;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStorePostDTOs> response=restTemplate.postForEntity(productRequestBaseUrl,product,FakeStorePostDTOs.class);
        return response.getBody();
    }


    public FakeStorePostDTOs getProductById(Long id) throws NoSuchElementFoundException {
        //concatenate string
        String specificProducturl=productBaseURL+productPath+"/{id}";
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStorePostDTOs> response= restTemplate.getForEntity(specificProducturl,FakeStorePostDTOs.class,id);
        if (response.getBody() == null)
            throw new NoSuchElementFoundException("No element found");
        return response.getBody();
    }


    public FakeStorePostDTOs updateProduct(Long id,GenericproductDTOs product) {
//      //concatenate String
        String specificProducturl=productBaseURL+productPath+"/{id}";
        RestTemplate restTemplate=restTemplateBuilder.build();
        HttpEntity<GenericproductDTOs> request=new HttpEntity<>(product);
        // specificProducturl="https://fakestoreapi.com/products/{id}";
        ResponseEntity<FakeStorePostDTOs> response= restTemplate.exchange(specificProducturl, HttpMethod.PUT,request, FakeStorePostDTOs.class,id);
        return  response.getBody();

    }

    public FakeStorePostDTOs deleteProduct(Long id) {

        //concatenate String
        String specificProducturl=productBaseURL+productPath+"/{id}";
        RestTemplate restTemplate=restTemplateBuilder.build();
        //RequestCallback requestCallback = restTemplate.httpEntityCallback(FakeStorePostDTOs.class);
        RequestCallback requestCallback=restTemplate.acceptHeaderRequestCallback(FakeStorePostDTOs.class);
        ResponseExtractor<ResponseEntity<FakeStorePostDTOs>> responseExtractor = restTemplate.responseEntityExtractor(FakeStorePostDTOs.class);
        ResponseEntity<FakeStorePostDTOs> responseEntity= restTemplate.execute(specificProducturl,HttpMethod.DELETE,requestCallback,responseExtractor,id);
        return responseEntity.getBody();
    }

    public List<FakeStorePostDTOs> getAllProduct() {
        //concatenate String
        String productRequestBaseUrl=productBaseURL+productPath;
        RestTemplate restTemplate=restTemplateBuilder.build();
        // ResponseEntity<FakeStorePostDTOs[]> response=restTemplate.getForEntity(productRequestBaseUrl,FakeStorePostDTOs[].class);
        ResponseEntity<FakeStorePostDTOs[]> response=restTemplate.getForEntity(productRequestBaseUrl,FakeStorePostDTOs[].class);
               return Arrays.asList(response.getBody());
    }
}
