package com.TypeDelta.pojo;

import lombok.Data;

/**
 * @author delta
 */
@Data

public class Sight {
    private String name;
    private Integer id;
    private Integer click;
    private String where;
    private String image;
    private Integer type;
    private SightsType sightsType;
    private String desc;
    private String u_id;

    private Integer likeCount;

    private String color;
}
