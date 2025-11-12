package com.zhylko.firsttask.exception;

public class CustomArrayIndexOutOfBoundsException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public CustomArrayIndexOutOfBoundsException(int index) {
		super(new String("CustomArray index is out of bounds: " + index));
	}
}
