package com.ouc.usedbook.service;

import com.ouc.usedbook.entity.Usedbook;
import com.ouc.usedbook.repository.UsedbookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/2 12:44
 */
@Service
public class UsedbookService {

    final UsedbookRepository usedbookRepository;

    public UsedbookService(UsedbookRepository usedbookRepository) {
        this.usedbookRepository = usedbookRepository;
    }

    public List<Usedbook> findAll() {
        return usedbookRepository.findAll();
    }

    public Optional<Usedbook> findByBid(Long bid) {
        return usedbookRepository.findById(bid);
    }

    public List<Usedbook> findByUid(Long uid) {
        return usedbookRepository.findAllByUid(uid);
    }

    public Usedbook add(Usedbook usedbook){
        return usedbookRepository.saveAndFlush(usedbook);
    }

    public void delete(Long bid){
        usedbookRepository.deleteById(bid);
    }

    public Usedbook update(Usedbook usedbook){
        return usedbookRepository.saveAndFlush(usedbook);
    }
}
