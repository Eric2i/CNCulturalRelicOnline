package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 分类Service接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface ICategoryService extends IService<Category>{

    /**
     * 查询分类
     *
     * @param id 分类主键
     * @return 分类
     */
    public Category selectCategoryById(Long id);

    /**
     * 查询分类列表
     *
     * @param category 分类
     * @return 分类集合
     */
    public List<Category> selectCategoryList(Category category);

    int deleteBy(Category category);

    Category getOneBy(Category category);
}
