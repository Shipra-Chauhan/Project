package com.spring_boot.example.first_basic.exception;

public class BookIdMismatchException extends Exception {

	private static final long serialVersionUID = 1L;

	private static long id1;
	private static long id2;

	public static long getId1() {
		return id1;
	}

	public static void setId1(long id1) {
		id1 = id1;
	}

	public static long getId2() {
		return id2;
	}

	public static void setId2(long id2) {
		id2 = id2;
	}

	public void getMessage(Exception e) {

		System.out.println("Book Mismatch between " + id1 +" and " +id2);
	}
}
