package com.myEcommerce.product.services;

import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.ThirdPartyAPIs.FakeStoreProductClient;
import com.myEcommerce.product.ThirdPartyAPIs.FakeStorePostDTOs;
import com.myEcommerce.product.dtos.GenericproductDTOs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//
//@Service("FakeStoreProductService")
//
//public class FakeStoreProductService  implements ProductService{
//    private FakeStoreProductClient fakeStoreProductClient;
//
//
//    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient) {
//        this.fakeStoreProductClient = fakeStoreProductClient;
//    }
//
//    public  GenericproductDTOs convertToGenericProductDTOs(FakeStorePostDTOs fakeStorePostDTOs){
//        GenericproductDTOs genericproductDTOs=new GenericproductDTOs();
//        genericproductDTOs.setId(fakeStorePostDTOs.getId());
//        genericproductDTOs.setTitle(fakeStorePostDTOs.getTitle());
//        genericproductDTOs.setCategory(fakeStorePostDTOs.getCategory());
//        genericproductDTOs.setPrice(fakeStorePostDTOs.getPrice());
//        genericproductDTOs.setDescription(fakeStorePostDTOs.getDescription());
//        genericproductDTOs.setImage(fakeStorePostDTOs.getImage());
//        return genericproductDTOs;
//
//    }
////    @Override
////    public GenericproductDTOs createProduct(GenericproductDTOs product) {
////        return convertToGenericProductDTOs(fakeStoreProductClient.createProduct(product));
////    }
////
////    @Override
////    public GenericproductDTOs getProductById(Long id) throws NoSuchElementFoundException {
//////
////        return convertToGenericProductDTOs(fakeStoreProductClient.getProductById(id));
////    }
////
////    @Override
////    public GenericproductDTOs updateProduct(Long id,GenericproductDTOs product) {
////
////        return convertToGenericProductDTOs(fakeStoreProductClient.updateProduct(id,product));
////
////    }
////
////    @Override
////    public GenericproductDTOs deleteProduct(Long id) {
////        return  convertToGenericProductDTOs(fakeStoreProductClient.deleteProduct(id));
////
////    }
////
////    @Override
////    public List<GenericproductDTOs> getAllProduct() {
////        ArrayList<GenericproductDTOs> result=new ArrayList<>();
////        for(FakeStorePostDTOs fakeStorePostDTOs:fakeStoreProductClient.getAllProduct()){
////            result.add(convertToGenericProductDTOs(fakeStorePostDTOs));
////        }
////        return result;
////    }
//}
