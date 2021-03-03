package com.example.content.service.impl;

import com.example.content.entity.Share;
import com.example.content.mapper.ShareDao;
import com.example.content.service.ShareService;
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
public class ShareServiceImpl extends ServiceImpl<ShareDao, Share> implements ShareService {

    @Override
    public Share getShareById(Integer id) {
        return getById(id);
    }
}
