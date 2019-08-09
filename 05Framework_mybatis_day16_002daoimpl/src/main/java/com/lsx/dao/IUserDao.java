package com.lsx.dao;

import com.lsx.domain.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserDao {
    List<User> findAll();

    /**
     * 增加 User
     * @param u
     */
    void saveUser(User u);

    /**
     * 删除用户
     * @param id
     */
    void delUser(@Param(value = "userid") Integer userid);

    /**
     * 更新用户
     * @param u
     */
    void updateUser(User u);


    void findUser();

    User findOne(@Param(value = "id") Integer id);

    /**
     * 模糊查询
     */
    List<User> findByName(@Param(value = "name") String name);

    /**
     * 多表查询
     */

    /**
     * 事务操作
     */

}
