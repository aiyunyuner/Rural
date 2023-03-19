package com.TypeDelta.mapper;

import com.TypeDelta.pojo.Sight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SightsMapperTest {
@Autowired
private SightsMapper sightsMapper;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSightsTypeOne() {
        List<Sight> sightsAllByType = sightsMapper.getSightsAllByType(3);

        System.out.println(sightsAllByType.toString());
    }

    @Test
    public void getSightsAllByType() {
    }
}