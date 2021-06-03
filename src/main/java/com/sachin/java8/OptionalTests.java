package com.sachin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTests {

	public static void main(String[] args) {
		testOptionalWithNull();
	}

	private static void testOptionalWithNull() {
		List<String> list = Arrays.asList("sachin", "sonal", "aarav");
		Optional.of(list).orElse(new ArrayList<String>()).forEach(System.out::println);
		list = null;
		Optional.of(list).ifPresent(llist -> llist.forEach(System.out::println));
	}
}
