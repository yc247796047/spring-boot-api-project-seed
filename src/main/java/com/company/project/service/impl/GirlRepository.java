package com.company.project.service.impl;

import com.company.project.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yangchun on 2018/2/26.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

//    通过年龄查询
    public List<Girl> findByAge(Integer age);

}

