package com.example.content.service;

import com.example.content.entity.Share;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChaosBear
 * @since 2021-03-03
 */
public interface ShareService extends IService<Share> {
    Share getShareById(Integer id);
}
