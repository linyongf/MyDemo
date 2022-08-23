package com.linyf.demo.jdbc_template_data_sources.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private long id;
    private String username;
    private String address;
}
