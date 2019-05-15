package com.spring_boot.example.first_basic.exception;

public class BookNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void getMessage(Exception e) {
		
		System.out.println("Book Not Found. "+e);
	}

}
