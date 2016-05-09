package com.campus02.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ErrorMessage 
{
	String errorLevel;
	String errorMessage;
	String errorTime;
	public ErrorMessage(String errorLevel, String errorMessage) {
		if (errorLevel.matches("FATAL")||errorLevel.matches("ERROR")||
				errorLevel.matches("INFO")||errorLevel.matches("DEBUG"))
		{
		this.errorLevel = errorLevel;
		this.errorMessage = errorMessage;
		this.errorTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		}
		else
			System.out.println("Unerlaubtes Errorlevel");
		}
	public String getErrorLevel() {
		return errorLevel;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getErrorTime() {
		return errorTime;
	}
	
	public String toLine()
	{
		String output = new String(getErrorTime()+": "+ getErrorLevel()+" - "+getErrorMessage());
		return output;
	}

}
