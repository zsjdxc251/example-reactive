package com.lesson.reactive.reactor.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @author zhengshijun
 * @version created on 2019/1/5.
 */
@Slf4j
public class ReactorQuickstartBootstrap {



    public static void main(String[] args) throws InterruptedException {




        Flux.just(1,2,3)


                // .subscribeOn(Schedulers.elastic())
                .publishOn(Schedulers.elastic())
                .map(value->{

                    return "+"+value;
                })
//                .subscribe(value->{
//                    if (StringUtils.equals(value,"+2")) {
//
//                        throw new RuntimeException("发生异常");
//                    }
//                    log.info("value:{}",value);
//                },throwable -> {
//                    log.error("消费异常：{}",throwable);
//                },()->{
//                    log.info("完成回调");
//
//                },subscription ->{   // 背压
//                    log.info("背压");
//                    subscription.request(3);
//
//                });
         .subscribe(new Subscriber() {
             @Override
             public void onSubscribe(Subscription s) {

             }

             @Override
             public void onNext(Object o) {

             }

             @Override
             public void onError(Throwable t) {

             }

             @Override
             public void onComplete() {

             }
         });


        Thread.currentThread().join();

    }
}
