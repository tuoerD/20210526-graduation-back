package com.example.demo.service;

import com.example.demo.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.vo.storeVo;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.io.IOException;
import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-23
 */
public interface ProductService extends IService<Product> {

    List<Product> getProductList();

    Boolean createNewProduct(Product product);

    List<Product> productSearch(String input);

    List<Product> hotProducts();

    Product getProductInfo(String productId);

    List<Product> recomProducts();

    List<Product> classProducts(String classKey);

    storeVo getStoreInfo(String productId);

    List<Product> getProductByStore(Integer storeId);

    String addProPic(MultipartFile file) throws IOException;

    Product getProductInfoByName(String productName);

    Boolean updatePro(String productId,Integer num);

    Boolean editInventory(String productId, Integer inventory);
}
