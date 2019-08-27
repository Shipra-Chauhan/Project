package com.example.spring_step_1.basics;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@ComponentScan    // or @ComponentScan("com.example.spring_step_1.basics")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {

	@Autowired
	//@Qualifier("quick") or @Qualifier("bubble")
	private SortAlgorithm sortAlgorithm;
	
	//private SortAlgorithm bubbleSortAlgorithm;
	//private SortAlgorithm quickSortAlgorithm;
	
	private Logger LOGGER = LoggerFactory.getLogger(BinarySearchImpl.class);
	
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
	
	@PreDestroy
	public void destroy() {
		LOGGER.info("Pre Destroy");
	}
	

	@PostConstruct
	public void construct() {
		LOGGER.info("Post Construct");
	}
	
	
}
