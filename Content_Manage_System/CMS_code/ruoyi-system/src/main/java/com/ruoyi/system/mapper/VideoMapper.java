package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 视频信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-05-07
 */
public interface VideoMapper extends BaseMapper<Video> {

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
