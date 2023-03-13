package com.TypeDelta.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sights")
@Log4j2
@RefreshScope
/**
 * @Author: TypeDelta
 * 对sights的管理
 */
public class SightsController {

}
