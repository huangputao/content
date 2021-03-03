package com.example.content.service.impl;

import com.example.content.entity.Notice;
import com.example.content.mapper.NoticeDao;
import com.example.content.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChaosBear
 * @since 2021-03-03
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements NoticeService {

}
