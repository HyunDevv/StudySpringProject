package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Slf4j
@Service
public class AsyncService {

    @Async("async-thread")
    public CompletableFuture run(){ // CompletableFuture는 api가 한 번에 여러 request가 나가고 결과로 모아 리턴 할 떄(하나로 join을 시킬 때) 사용
        return new AsyncResult(hello()).completable();
    }


    public String hello(){
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(2000);
                log.info("thread sleep ... ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "async hello";

    }
}
