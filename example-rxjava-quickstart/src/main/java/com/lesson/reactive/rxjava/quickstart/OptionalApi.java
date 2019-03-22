package com.lesson.reactive.rxjava.quickstart;

import java.util.Optional;

/**
 * @author zhengshijun
 * @version created on 2019/2/11.
 */
public class OptionalApi {


	public static void main(String[] args) {

		Optional.of("11").ifPresent(System.out::println);
	}
}
