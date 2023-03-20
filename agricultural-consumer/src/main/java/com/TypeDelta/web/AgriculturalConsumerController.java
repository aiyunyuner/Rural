package com.TypeDelta.web;

import com.TypeDelta.client.AgriculturalClient;
import com.TypeDelta.pojo.Agricultural;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agricultural")
@Log4j2
@RefreshScope
public class AgriculturalConsumerController {
    @Autowired
    private AgriculturalClient agriculturalClient;

    @GetMapping("/all")
    List<Agricultural> getAll() {
        return agriculturalClient.getAll();
    }

    @PostMapping("/one")
    Agricultural getAgriculturalById(Integer id) {
        return agriculturalClient.getAgriculturalById(id);
    }


    @PostMapping("insert")
    Integer insertAgricultural(Agricultural agricultural) {
        return agriculturalClient.insertAgricultural(agricultural);
    }
}
