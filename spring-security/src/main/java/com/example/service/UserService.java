package com.example.service;

import com.example.domain.MyUser;

public interface UserService {

    MyUser selectByUserName(String username);

    boolean add(MyUser user) ;
}


