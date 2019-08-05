package com.lxq.springboot.mapper;

import com.lxq.springboot.form.UrlForm;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * url映射数据库操作
 */
@Mapper
public interface UrlMapper {

  List<UrlForm> findAllUrl();
}
