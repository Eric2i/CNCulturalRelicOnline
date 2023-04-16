package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ProductMapper;
import com.ruoyi.system.domain.Product;
import com.ruoyi.system.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 商品Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Resource
    private ProductMapper productMapper;

    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    public Product selectProductById(String id){
        return productMapper.selectProductById(id);
    }

    /**
     * 查询商品列表
     *
     * @param product 商品
     * @return 商品
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    @Override
    public int deleteBy(Product product) {
        return productMapper.deleteBy(product);
    }

    @Override
    public Product getOneBy(Product product) {
        return productMapper.getOneBy(product);
    }

}
