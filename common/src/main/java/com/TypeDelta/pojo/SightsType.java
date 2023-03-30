package com.TypeDelta.pojo;

import lombok.Data;

import java.util.List;

@Data
public class SightsType  {
    private String sights_type;
    private Integer type_id;
    private Integer parent_id;

    private List<Sight> sightList;

}
