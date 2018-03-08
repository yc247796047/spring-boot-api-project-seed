package com.company.project.model;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * Created by yangchun on 2018/2/26.
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    @Range(min = 1, max = 9, message = "age只能从1-9")
    private Integer age;

    private String cupSize;



    public Girl() {
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
