package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VideoMapper;
import com.ruoyi.system.domain.Video;
import com.ruoyi.system.service.IVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 视频信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-05-07
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {
    @Resource
    private VideoMapper videoMapper;

    /**
     * 查询视频信息
     *
     * @param id 视频信息主键
     * @return 视频信息
     */
    public Video selectVideoById(Long id){
        return videoMapper.selectVideoById(id);
    }

    /**
     * 查询视频信息列表
     *
     * @param video 视频信息
     * @return 视频信息
     */
    @Override
    public List<Video> selectVideoList(Video video)
    {
        return videoMapper.selectVideoList(video);
    }

    @Override
    public int deleteBy(Video video) {
        return videoMapper.deleteBy(video);
    }

    @Override
    public Video getOneBy(Video video) {
        return videoMapper.getOneBy(video);
    }

}
