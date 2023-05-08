package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Video;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 视频信息Service接口
 *
 * @author ruoyi
 * @date 2023-05-07
 */
public interface IVideoService extends IService<Video>{

    /**
     * 查询视频信息
     *
     * @param id 视频信息主键
     * @return 视频信息
     */
    public Video selectVideoById(Long id);

    /**
     * 查询视频信息列表
     *
     * @param video 视频信息
     * @return 视频信息集合
     */
    public List<Video> selectVideoList(Video video);

    int deleteBy(Video video);

    Video getOneBy(Video video);
}
