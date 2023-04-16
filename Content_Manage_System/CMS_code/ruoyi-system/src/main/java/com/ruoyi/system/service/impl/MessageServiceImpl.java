package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MessageMapper;
import com.ruoyi.system.domain.Message;
import com.ruoyi.system.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 留言信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {
    @Resource
    private MessageMapper messageMapper;

    /**
     * 查询留言信息
     *
     * @param id 留言信息主键
     * @return 留言信息
     */
    public Message selectMessageById(Long id){
        return messageMapper.selectMessageById(id);
    }

    /**
     * 查询留言信息列表
     *
     * @param message 留言信息
     * @return 留言信息
     */
    @Override
    public List<Message> selectMessageList(Message message)
    {
        return messageMapper.selectMessageList(message);
    }

    @Override
    public int deleteBy(Message message) {
        return messageMapper.deleteBy(message);
    }

    @Override
    public Message getOneBy(Message message) {
        return messageMapper.getOneBy(message);
    }

}
