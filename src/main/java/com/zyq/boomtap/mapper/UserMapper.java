package com.zyq.boomtap.mapper;

import com.zyq.boomtap.model.po.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//自动生成该接口的实现类对象，并交给容器管理！！！（代理对象）
@Mapper
@Repository//按道理不应该加？但是加了之后autowired不会爆红。。。
public interface UserMapper {

    //不需要xml
    @Select("select * from user")
    public List<User> list();

    //需要xml
    public List<User> womanList();

    /**
     *根据用户名和密码查询员工
     * @param user
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User getByNameAndPassword(User user);

    /**
     * 按id删除
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void deleteById (Integer id);
}
