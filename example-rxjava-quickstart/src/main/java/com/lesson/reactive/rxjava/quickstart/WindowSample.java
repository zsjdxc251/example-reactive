package com.lesson.reactive.rxjava.quickstart;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengshijun
 * @version created on 2019/3/20.
 */
@Slf4j
public class WindowSample {


	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(1);
		Observable<String> inputEventStream = Observable.create(observableEmitter -> {
			for (int i = 0; i >= 0; i++) {
				observableEmitter.onNext("我是生产者........." + i);
			}

		});
		AtomicInteger atomicInteger = new AtomicInteger(0);
		inputEventStream.window(1000, TimeUnit.MILLISECONDS)
				.flatMap(map -> {

					AtomicInteger atomicInteger1 = new AtomicInteger(atomicInteger.incrementAndGet());
					AtomicInteger ac = new AtomicInteger(0);
					Observable<String> observable = map.scan("1", (v1, v2) -> {

						ac.incrementAndGet();
						return v1+"---------"+atomicInteger1.get();

					});

					System.out.println(map.blockingLast());


					return observable;
				})
				.subscribe(value -> {
					System.out.println(value);

					Calendar calendar = Calendar.getInstance();
					int i = calendar.get(Calendar.SECOND);
					log.info("我会{}就被唤醒触发...",i);
				});


		Thread.sleep(2000);


	}


	public static void initWindow() {

	}
}
