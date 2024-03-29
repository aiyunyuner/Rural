package com.TypeDelta.pojo;


import lombok.Data;

import java.util.Date;

/**
 * @author delta
 */
@Data
public class User {
    private int id;
    private String name;
    private String password;
    private int valid;
    private Date created;
    private String error;
    private Integer result;
    private String image;
    private Integer maner;
    private Integer u_id;
}
