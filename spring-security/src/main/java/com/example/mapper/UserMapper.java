package com.example.mapper;

import com.example.domain.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insert(MyUser MyUser);

    int delete(int id);

    int update(MyUser MyUser);

    MyUser load(int id);

    List<MyUser> pageList(int offset, int pagesize);

    int pageListCount(int offset,int pagesize);

    MyUser selectByPrimaryKey(String username);
}

