package com.lxq.springboot.service.impl;

import com.lxq.springboot.dao.UrlMapper;
import com.lxq.springboot.form.UrlPojo;
import com.lxq.springboot.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * URL服务层实现
 */
@Service
@Transactional
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlMapper urlMapper;
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED, readOnly = true)
    public List<UrlPojo> findAllUrl() throws Exception{
        return urlMapper.findAllUrl();
    }
}
