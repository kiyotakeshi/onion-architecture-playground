package com.example.dddsample.infrastructure.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kiyota
 */
@Mapper
public interface TaskMapper {
    Task selectById(@Param("id") int id);

    List<Task> selectAll();

    void save(Task task);

    void deleteById(@Param("id") int id);

    Task update(Task task);
}
