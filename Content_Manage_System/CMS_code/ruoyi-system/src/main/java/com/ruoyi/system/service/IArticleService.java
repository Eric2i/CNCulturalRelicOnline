package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Article;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 文章资讯Service接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface IArticleService extends IService<Article>{

    /**
     * 查询文章资讯
     *
     * @param id 文章资讯主键
     * @return 文章资讯
     */
    public Article selectArticleById(Long id);

    /**
     * 查询文章资讯列表
     *
     * @param article 文章资讯
     * @return 文章资讯集合
     */
    public List<Article> selectArticleList(Article article);

    int deleteBy(Article article);

    Article getOneBy(Article article);
}
