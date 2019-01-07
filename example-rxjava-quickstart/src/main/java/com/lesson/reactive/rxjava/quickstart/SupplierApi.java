package com.lesson.reactive.rxjava.quickstart;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.*;

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
public class SupplierApi {



    public static void main(String[] args){



        Flowable<String> flowable = Flowable.just("","");

        Single<String> single = Single.just("");


        Observable<String> observable = Observable.just("","");

        Observable<String>  subject = Subject.just("","");

        Observable.create((value)->{

            value.onNext("123123");

        }).subscribe(value->{
            System.out.println(value);
        });




        Observable<String> asyncSubject = AsyncSubject.just("","");



        Observable<String> behaviorSubject = BehaviorSubject.just("","");



        Observable<String> publishSubject = PublishSubject.just("","");


        Observable<String> replaySubject = ReplaySubject.just("","");

    }
}
