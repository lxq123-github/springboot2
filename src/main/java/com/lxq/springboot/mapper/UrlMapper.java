package com.lxq.springboot.mapper;

import com.lxq.springboot.form.UrlForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * url映射数据库操作
 */
@Mapper
public interface UrlMapper {
    List<UrlForm> findAllUrl();
}
