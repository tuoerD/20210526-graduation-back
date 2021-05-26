package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.entity.vo.storeVo;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-23
 */
@RestController
@RequestMapping("/demo/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("getProductList")
    public List<Product> getProductList(){
        return productService.getProductList();
    }

    /**
     * 搜索商品（用户）
     */
    @PostMapping("productSearch")
    public List<Product> productSearch(String input){
        return productService.productSearch(input);
    }

    /**
     * 新增商品（管理员用）
     */
    @PostMapping("createNewProduct")
    public int createNewProduct(String productId,String productName,Float startPrice,Float nowPrice,Integer inventory,String picture,Integer storeId,String type){

        Product product=new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setStartPrice(startPrice);
        product.setNowPrice(nowPrice);
        product.setInventory(inventory);
        product.setPicture(picture);
        product.setStoreId(storeId);
        product.setType(type);

        if(productService.createNewProduct(product)==false){
            return -1;
        }
        else{
            return 1;
        }
    }

    @PostMapping("addProPic")
    public String addProPic(@RequestParam("file") MultipartFile file) throws IOException {
        return productService.addProPic(file);
    }

    /**
     * 推荐热销商品
     */
    @PostMapping("hotProducts")
    public List<Product> hotProducts(){
        return productService.hotProducts();
    }

    /**
     * 推荐库存多的商品
     */
    @PostMapping("recomProducts")
    public List<Product> recomProducts(){
        return productService.recomProducts();
    }

    /**
     * 点击商品查看详情
     */
    @PostMapping("getProductInfo/{productId}")
    public Product getProductInfo(@PathVariable String productId){
        return productService.getProductInfo(productId);
    }

    /**
     * 商品分类
     */
    @PostMapping("classProducts")
    public List<Product> classProducts(String classKey){
        return productService.classProducts(classKey);
    }

    /**
     * 根据化妆品获取店铺信息
     * @param productId
     * @return
     */
    @PostMapping("getStoreInfo")
    public storeVo getStoreInfo(String productId){
        return productService.getStoreInfo(productId);
    }

     /**
     * 根据店铺获取化妆品信息
     * @param storeId
     * @return
     */
    @PostMapping("getProductByStore")
    public List<Product> getProductByStore(Integer storeId){
        return productService.getProductByStore(storeId);
    }
}

