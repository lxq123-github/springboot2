package com.lxq.springboot.service.impl;

import com.lxq.springboot.dao.UrlMapper;
import com.lxq.springboot.pojo.UrlPojo;
import com.lxq.springboot.service.UrlService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * URL服务层实现
 */
@Service
@Transactional
public class UrlServiceImpl implements UrlService {
    @Resource
    private UrlMapper urlMapper;
    @Override
    public List<UrlPojo> findAllUrl() {
        return urlMapper.findAllUrl();
    }
}
