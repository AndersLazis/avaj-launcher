package com.anderslazis.avaj.simulator;

public class MyException extends  Exception{
	public MyException(String message){
		super(AnsiColor.colorize(("[ERROR]: " + (message)), AnsiColor.RED));
	}
}
