package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 留言信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface MessageMapper extends BaseMapper<Message> {

    /**
     * 查询留言信息
     *
     * @param id 留言信息主键
     * @return 留言信息
     */
    public Message selectMessageById(Long id);

    /**
     * 查询留言信息列表
     *
     * @param message 留言信息
     * @return 留言信息集合
     */
    public List<Message> selectMessageList(Message message);


    int deleteBy(Message message);

    Message getOneBy(Message message);

}
