package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ArticleMapper;
import com.ruoyi.system.domain.Article;
import com.ruoyi.system.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 文章资讯Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Resource
    private ArticleMapper articleMapper;

    /**
     * 查询文章资讯
     *
     * @param id 文章资讯主键
     * @return 文章资讯
     */
    public Article selectArticleById(Long id){
        return articleMapper.selectArticleById(id);
    }

    /**
     * 查询文章资讯列表
     *
     * @param article 文章资讯
     * @return 文章资讯
     */
    @Override
    public List<Article> selectArticleList(Article article)
    {
        return articleMapper.selectArticleList(article);
    }

    @Override
    public int deleteBy(Article article) {
        return articleMapper.deleteBy(article);
    }

    @Override
    public Article getOneBy(Article article) {
        return articleMapper.getOneBy(article);
    }

}
