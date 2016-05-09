package com.campus02.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger 
{
	private String path;

	public Logger(String path) {
		this.path = path;
	}
	
	private void logMessage(ErrorMessage message) throws IOException
	{
		File output = new File(path);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(output, true)));
		pw.println(message.toLine());
		pw.flush();
		pw.close();
	}

	@SuppressWarnings("unused")
	private void logFatal(String message) throws IOException
	{
		ErrorMessage fatal = new ErrorMessage("FATAL", message);
		logMessage(fatal);
	}
	@SuppressWarnings("unused")
	private void logError(String message) throws IOException
	{
		ErrorMessage error = new ErrorMessage("ERROR", message);
		logMessage(error);
	}
	@SuppressWarnings("unused")
	private void logInfo(String message) throws IOException
	{
		ErrorMessage info = new ErrorMessage("INFO", message);
		logMessage(info);
	}
	@SuppressWarnings("unused")
	private void logDebug(String message) throws IOException
	{
		ErrorMessage debug = new ErrorMessage("DEBUG", message);
		logMessage(debug);
	}
	
}
