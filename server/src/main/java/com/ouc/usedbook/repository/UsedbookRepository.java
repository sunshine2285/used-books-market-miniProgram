package com.ouc.usedbook.repository;

import com.ouc.usedbook.entity.Usedbook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/1 23:09
 */
public interface UsedbookRepository extends JpaRepository<Usedbook, Long> {
}
