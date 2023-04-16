package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 商品Mapper接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface ProductMapper extends BaseMapper<Product> {

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
