package com.tinyurl.service;

import cn.hutool.core.lang.Snowflake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IdGeneratorService {

    @Value("${snowflake.workerId}")
    private Long workerId;
    @Value("${snowflake.dataCentreId}")
    private Long dataCentreId;
    private Snowflake snowflake;

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

    public String generate(){
        initializeSnowflake();
        return new Id(snowflake.nextIdStr()).getValue();
    }

}
