package com.example.dddsample.infrastructure.mapper;

import com.example.dddsample.infrastructure.repository.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author kiyota
 */
@Mapper
public interface TaskMapper {
    Task selectById(@Param("id") int id);
}
