package com.lesson.reactive.rxjava.quickstart;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Future;

/**
 *
 *   生产
 *  {@link java.util.function.Supplier}
 *
 *
 *  create 方式
 *
 *  {@link Flowable}
 *  {@link Single}
 *
 *  {@link Observable}
 *    {@link Subject}
 *      {@link AsyncSubject}
 *      {@link BehaviorSubject}
 *      {@link PublishSubject}
 *      {@link ReplaySubject}
 *
 *
 * @author zhengshijun
 * @version created on 2019/1/6.
 */
@Slf4j
public class SupplierApi {



    public static void main(String[] args){


        Observable.never().subscribe(value->{
            System.out.println(value);
        },throwable -> {
            log.error(StringUtils.EMPTY,throwable);
        });



    }
}
