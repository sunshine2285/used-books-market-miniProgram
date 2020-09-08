package com.ouc.usedbook.repository;

import com.ouc.usedbook.entity.Usedbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/1 23:09
 */
public interface UsedbookRepository extends JpaRepository<Usedbook, Long> {
    /**
     * 根据uid找到所有对应的二手书列表
     *
     * @param uid 用户id
     * @return {@link List<Usedbook>}
     */
    @Query
    List<Usedbook> findAllByUid(Long uid);


}
