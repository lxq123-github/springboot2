package com.lxq.springboot.service;


import com.lxq.springboot.pojo.UrlPojo;

import java.util.List;

/**
 * URL服务层
 */
public interface UrlService {
    List<UrlPojo> findAllUrl();
}
