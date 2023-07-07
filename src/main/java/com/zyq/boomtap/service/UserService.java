package com.zyq.boomtap.service;

import com.zyq.boomtap.model.vo.UserVO;

public interface UserService {

    public UserVO login(UserVO userVO);

    public void deleteById(Integer id);

}
