package com.TypeDelta.pojo;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private Integer u_id;
    private Integer p_id;
    private String context;
    private String time;
    private User user;
}
