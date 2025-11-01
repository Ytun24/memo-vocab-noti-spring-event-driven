package com.example.memo_vocab.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import static java.lang.Thread.sleep;

@Slf4j
public class AsyncUtil {

    public static StopWatch stopWatch = new StopWatch();

    public static void delay(long delayMilliSeconds)  {
        try{
            sleep(delayMilliSeconds);
        }catch (Exception e){
            log.info("Exception is :" + e.getMessage());
        }

    }

    public static String transForm(String s) {
        AsyncUtil.delay(500);
        return s.toUpperCase();
    }

    public static void startTimer(){
        stopWatchReset();
        stopWatch.start();
    }

    public static void timeTaken(){
        stopWatch.stop();
        log.info("Total Time Taken : " +stopWatch.getTime());
    }

    public static void stopWatchReset(){
        stopWatch.reset();
    }

    public static  int noOfCores(){
        return Runtime.getRuntime().availableProcessors();
    }
}
