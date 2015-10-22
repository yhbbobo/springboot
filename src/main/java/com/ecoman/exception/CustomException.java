package com.ecoman.exception;

public class CustomException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errno;
	public CustomException(int errno,String errmsg){
		super(errmsg);
		this.errno = errno;
	}
	public int getErrno() {
		return errno;
	}
	public void setErrno(int errno) {
		this.errno = errno;
	}
	
}
