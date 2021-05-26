package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Product;
import com.example.demo.entity.vo.storeVo;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-23
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductMapper productMapper;
    @Override
    public List<Product> getProductList() {
        return baseMapper.selectList(null);
    }

    /**
     * 搜索商品（用户）
     * @param input
     * @return
     */
    @Override
    public List<Product> productSearch(String input) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.like("productName",input).or().like("type",input);
        return baseMapper.selectList(wrapper);
    }

    /**
     * 新增商品（管理员用）
     * @param product
     * @return
     */
    @Override
    public Boolean createNewProduct(Product product) {
        List<Product> products = baseMapper.selectList(null);
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductId().equals(product.getProductId())){
                return false;
            }
        }
        baseMapper.insert(product);
        return true;
    }

    /**
     * 推荐热销商品
     */
    @Override
    public List<Product> hotProducts() {
        QueryWrapper<Product> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("salesVolume");
        wrapper.last("limit 8");
        List<Product> list=baseMapper.selectList((wrapper));
        return list;
    }

    /**
     *推荐库存多的商品
     */
    @Override
    public List<Product> recomProducts() {
        QueryWrapper<Product> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("inventory");
        wrapper.last("limit 8");
        List<Product> list=baseMapper.selectList((wrapper));
        return list;
    }

    /**
     * 点击商品查看详情
     */
    @Override
    public Product getProductInfo(String productId) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("productId",productId);
        return baseMapper.selectOne(wrapper);
    }

    /**
     * 商品分类
     */
    @Override
    public List<Product> classProducts(String classKey) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        if(classKey.equals("1")){
            wrapper.eq("type","水乳");
        }
        if(classKey.equals("2")){
            wrapper.eq("type","精华水");
        }
        if(classKey.equals("3")){
            wrapper.eq("type","精华液");
        }
        if(classKey.equals("4")){
            wrapper.eq("type","面霜");
        }
        if(classKey.equals("5")){
            wrapper.eq("type","眼霜");
        }
        if(classKey.equals("6")){
            wrapper.eq("type","眼精华");
        }
        if(classKey.equals("7")){
            wrapper.eq("type","身体乳");
        }
        if(classKey.equals("8")){
            wrapper.eq("type","防晒");
        }
        if(classKey.equals("9")){
            wrapper.eq("type","粉底液");
        }
        if(classKey.equals("10")){
            wrapper.eq("type","气垫");
        }
        if(classKey.equals("11")){
            wrapper.eq("type","眼影");
        }
        if(classKey.equals("12")){
            wrapper.eq("type","眼线笔");
        }
        if(classKey.equals("13")){
            wrapper.eq("type","睫毛膏");
        }
        if(classKey.equals("14")){
            wrapper.eq("type","眉笔");
        }
        if(classKey.equals("15")){
            wrapper.eq("type","腮红");
        }
        if(classKey.equals("16")){
            wrapper.eq("type","修容");
        }
        if(classKey.equals("17")){
            wrapper.eq("type","高光");
        }
        if(classKey.equals("18")){
            wrapper.eq("type","唇釉");
        }
        if(classKey.equals("19")){
            wrapper.eq("type","唇膏");
        }
        if(classKey.equals("20")){
            wrapper.eq("type","定妆喷雾");
        }
        if(classKey.equals("21")){
            wrapper.eq("type","散粉");
        }
        if(classKey.equals("22")){
            wrapper.eq("type","美妆工具");
        }
        return baseMapper.selectList(wrapper);
    }

    /**
     * 获取店铺信息
     * @param productId
     * @return
     */
    @Override
    public storeVo getStoreInfo(String productId) {
        storeVo currentStore=productMapper.getStoreInfo(productId);
        return currentStore;
    }

    /**
     * 根据店铺获取化妆品信息
     * @param storeId
     * @return
     */
    @Override
    public List<Product> getProductByStore(Integer storeId) {
        QueryWrapper<Product> wrapper=new QueryWrapper<>();
        wrapper.eq("storeId",storeId);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public String addProPic(MultipartFile file) throws IOException {
        BASE64Encoder bEncoder=new BASE64Encoder();
        String[] suffixArra=file.getOriginalFilename().split("\\.");
        String preffix="data:image/jpg;base64,".replace("jpg", suffixArra[suffixArra.length - 1]);
        String base64EncoderImg=preffix + bEncoder.encode(file.getBytes()).replaceAll("[\\s*\t\n\r]", "");

        return base64EncoderImg;
    }

    @Override
    public Product getProductInfoByName(String productName) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("productName",productName);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public Boolean updatePro(String productId,Integer num) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("productId",productId);
        Product product=baseMapper.selectOne(wrapper);
        product.setInventory(product.getInventory()-num);
        product.setSalesVolume(product.getSalesVolume()+num);
        baseMapper.updateById(product);
        return true;
    }
}
