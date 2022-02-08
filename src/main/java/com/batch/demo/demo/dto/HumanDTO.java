package com.batch.demo.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class HumanDTO implements Serializable {
    private String name;
    private BigDecimal salary;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
