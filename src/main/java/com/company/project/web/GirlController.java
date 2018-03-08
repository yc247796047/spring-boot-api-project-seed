package com.company.project.web;

import com.company.project.core.ResultGenerator;
import com.company.project.model.Girl;
import com.company.project.service.GirlService;
import com.company.project.service.impl.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/01/26.
 */

@RestController

public class GirlController {

    @Autowired
    private GirlService girlService;

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param cupSize
     * @param age
     * @return
     */

//    @PostMapping(value = "/girls")
//    public Girl girlAdd(@RequestParam(value = "cupsize") String cupSize,
//                        @RequestParam(value = "age")  Integer age) {
//        Girl girl = new Girl();
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//        return girlRepository.save(girl);
//    }
     @PostMapping(value = "/girls")
        public String girlAdd(@Valid @ModelAttribute Girl girl, BindingResult result) {
                 System.out.println(girl.getAge());
            System.out.println(girl.getCupSize());
            girlRepository.save(girl);
            ResultGenerator.genFailResult(result.toString());
            return "nihao";
        }

    /**
     * 通过id查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }


    /**
     * 更新女生
     *
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupsize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除女生
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/girls/{id}")
    public List<Girl> girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
        return girlRepository.findAll();
    }

    /**
     * 通过age查询一个女生
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 同事插入两个女生
     *
     * @return
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

}



