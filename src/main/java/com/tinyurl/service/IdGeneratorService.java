package com.tinyurl.service;

import cn.hutool.core.lang.Snowflake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IdGeneratorService {

    @Value("${snowflake.workerId}")
    private Long workerId;
    @Value("${snowflake.dataCentreId}")
    private Long dataCentreId;
    private Snowflake snowflake;

    private synchronized void initializeSnowflake(){
        if(this.snowflake == null){
//            this.snowflake = new Snowflake(workerId, dataCentreId);
//            private final long twepoch;
//            private final long workerId;
//            private final long dataCenterId;
//            private final boolean useSystemClock;
//            this.snowflake = new Snowflake();

            Date epochDate = new Date(); // -> epoch date
            long workerId = 31; // between 0 and 31
            long dataCenterId = 31; // between 0 and 31
            boolean isUseSystemClock = true;
            long timeOffset = 0;
            long randomSequenceLimit = 4095; // between 0 and 4095

            this.snowflake = new Snowflake(epochDate, workerId, dataCenterId, isUseSystemClock, timeOffset, randomSequenceLimit);
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
