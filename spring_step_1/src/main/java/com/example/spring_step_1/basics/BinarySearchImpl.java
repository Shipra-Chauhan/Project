package com.example.spring_step_1.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {

	@Autowired
	//@Qualifier("quick") or @Qualifier("bubble")
	private SortAlgorithm sortAlgorithm;
	
	//private SortAlgorithm bubbleSortAlgorithm;
	//private SortAlgorithm quickSortAlgorithm;
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		
		/*int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		System.out.println(bubbleSortAlgorithm);*/
		
		
		/*int[] sortedNumbers = quickSortAlgorithm.sort(numbers);
		System.out.println(quickSortAlgorithm);*/
		
		
		
		
		// Search the array
		return 3;
	}

}
