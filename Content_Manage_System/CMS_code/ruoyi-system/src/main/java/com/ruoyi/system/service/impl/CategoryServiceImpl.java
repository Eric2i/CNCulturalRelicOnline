package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CategoryMapper;
import com.ruoyi.system.domain.Category;
import com.ruoyi.system.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 分类Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 查询分类
     *
     * @param id 分类主键
     * @return 分类
     */
    public Category selectCategoryById(Long id){
        return categoryMapper.selectCategoryById(id);
    }

    /**
     * 查询分类列表
     *
     * @param category 分类
     * @return 分类
     */
    @Override
    public List<Category> selectCategoryList(Category category)
    {
        return categoryMapper.selectCategoryList(category);
    }

    @Override
    public int deleteBy(Category category) {
        return categoryMapper.deleteBy(category);
    }

    @Override
    public Category getOneBy(Category category) {
        return categoryMapper.getOneBy(category);
    }

}
