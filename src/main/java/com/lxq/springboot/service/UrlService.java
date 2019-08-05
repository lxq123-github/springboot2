package com.lxq.springboot.service;


import com.lxq.springboot.form.UrlForm;
import java.util.List;

/**
 * URL服务层
 */
public interface UrlService {

  List<UrlForm> findAllUrl() throws Exception;
}
