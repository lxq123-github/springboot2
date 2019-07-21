package com.lxq.springboot.dao;

import com.lxq.springboot.form.UrlPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * url映射数据库操作
 */
@Mapper
public interface UrlMapper {
    List<UrlPojo> findAllUrl();
}
