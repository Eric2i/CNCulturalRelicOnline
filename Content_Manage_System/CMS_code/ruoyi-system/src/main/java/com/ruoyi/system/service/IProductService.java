package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 商品Service接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface IProductService extends IService<Product>{

    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    public Product selectProductById(String id);

    /**
     * 查询商品列表
     *
     * @param product 商品
     * @return 商品集合
     */
    public List<Product> selectProductList(Product product);

    int deleteBy(Product product);

    Product getOneBy(Product product);
}
