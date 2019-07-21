package com.lxq.springboot.service;


import com.lxq.springboot.form.UrlPojo;

import java.util.List;

/**
 * URL服务层
 */
public interface UrlService {
    List<UrlPojo> findAllUrl() throws Exception;
}
