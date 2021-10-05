package com.zh.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseBean {
    /*
    * 自增长id
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
