package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    /**
     * 依据id查询数据
     */
    Blog getBlog(Integer id);

    /**
     *插入数据
     */
    void insert(Blog blog);

    void delete(Integer id);

    void update(Blog blog);

    List<Blog> getall();
    List<Map<String,Object>> getmaplist();
    void insertlist(List<Blog> list);
}
