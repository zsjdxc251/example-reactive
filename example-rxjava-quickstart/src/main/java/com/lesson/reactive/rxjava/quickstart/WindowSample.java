package com.lesson.reactive.rxjava.quickstart;

import com.alibaba.fastjson.JSON;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengshijun
 * @version created on 2019/3/20.
 */
@Slf4j
public class WindowSample {


	static Map<Integer,AtomicInteger> count = new ConcurrentHashMap<>();

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(1);
		Observable<String> inputEventStream = Observable.create(observableEmitter -> {
			for (int i = 0; i >=0; i++) {
				observableEmitter.onNext("我是生产者........." + i);
			}

		});

		new Thread(()->{

			while (true) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println(JSON.toJSONString(count,true));
			}
		}).start();
		AtomicInteger atomicInteger = new AtomicInteger(0);
		inputEventStream.window(1000, TimeUnit.MILLISECONDS)

				.subscribe(value -> {

					AtomicInteger integer = new AtomicInteger(0);
					final int number = atomicInteger.incrementAndGet();
					String date = DateFormatUtils.format(System.currentTimeMillis(),"mm:ss.SSS");
					value.subscribe(v->{

						AtomicInteger a = count.get(number);

						if (a == null){
							a = new AtomicInteger(0);
							count.put(number,a);
						} else {
							a.incrementAndGet();
						}

					});

					Calendar calendar = Calendar.getInstance();

					int i = calendar.get(Calendar.SECOND);
					log.info("我会{}就被唤醒触发...",i);
				});


		Thread.sleep(1000);


	}


	public static void initWindow() {

	}
}
