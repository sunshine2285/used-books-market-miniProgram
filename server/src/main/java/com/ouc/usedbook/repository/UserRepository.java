package com.ouc.usedbook.repository;

import com.ouc.usedbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/5/31 22:29
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 通过邮件和密码查找用户
     *
     * @param mail     邮件
     * @param password 密码
     * @return {@link User}
     */
    @Query
    public User findByMailAndPassword(String mail, String password);
}