package com.tinyurl.controller;

import cn.hutool.core.lang.Snowflake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class IdGeneratorController {

    @Value("${snowflake.workerId}")
    private Long workerId;
    @Value("${snowflake.dataCentreId}")
    private Long dataCentreId;

    private Snowflake snowflake = null; /*= new Snowflake(1L, 31L);*/

    private synchronized void initializeSnowflake(){
        if(this.snowflake == null){
            this.snowflake = new Snowflake(workerId, dataCentreId);
        }
    }

    public static class Id{
        private String value;

        public Id(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
    }

    @GetMapping("/generate")
    public Id generate(){
//        return "<h1>tiny.url</h1>";
        initializeSnowflake();
        return new Id(snowflake.nextIdStr());
    }

}
