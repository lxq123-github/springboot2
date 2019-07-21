package com.lxq.springboot.dao;

import com.lxq.springboot.pojo.UrlPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * url映射数据库操作
 */
@Mapper
public interface UrlMapper {
    @Select("select * from spring.`urlmgr`")
    List<UrlPojo> findAllUrl();
}
