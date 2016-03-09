package me.syf.exception;

@SuppressWarnings("serial")
public class UserExistException extends Exception{
	
	public UserExistException()
	{
		super();
	}
	public UserExistException(String msg)
	{
		super(msg);
	}
	public UserExistException(Throwable cause)
	{
		super(cause);
	}
	public UserExistException(String msg,Throwable cause)
	{
		super(msg,cause);
	}

}
