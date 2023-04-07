package com.TypeDelta.pojo;

import lombok.Data;

@Data
public class LogMe {
    private Integer id;
    private Integer u_id;
    private String ip;
    private String where;
    private String action;
    private String time;

    private Integer num;
    private Integer value;

    private String type;
    private String name;
}
