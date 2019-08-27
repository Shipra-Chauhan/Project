package com.example.spring_step_1.basics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		return numbers;
	}
}
