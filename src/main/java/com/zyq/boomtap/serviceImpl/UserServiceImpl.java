package com.zyq.boomtap.serviceImpl;

import com.zyq.boomtap.mapper.UserMapper;
import com.zyq.boomtap.model.po.User;
import com.zyq.boomtap.model.vo.UserVO;
import com.zyq.boomtap.service.UserService;
import com.zyq.boomtap.utils.POJOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserVO login(UserVO userVO) {
        User user = toPO(userVO);
        User userFromDB = userMapper.getByNameAndPassword(user);
        return toVO(userFromDB);
    }




    UserVO toVO(User user){
        UserVO userVO=new UserVO();
        POJOConverter.convert(user, userVO);
        return userVO;
    }

    User toPO(UserVO userVO){
        User user=new User();
        POJOConverter.convert(userVO, user);
        return user;
    }
}
