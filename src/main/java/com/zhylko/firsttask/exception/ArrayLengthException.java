package com.zhylko.firsttask.exception;

public class ArrayLengthException extends Exception {
	private static final long serialVersionUID = 1L;

	public ArrayLengthException(int length) {
		super (new String("Illegal array length: " + length));
	}
}
