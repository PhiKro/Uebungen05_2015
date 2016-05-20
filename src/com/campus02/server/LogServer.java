package com.campus02.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class LogServer {

	public static void backuplog(String inFile, String outFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inFile)));
				PrintWriter pw = new PrintWriter(outFile);) {
			String line;
			while ((line = br.readLine()) != null) {
				pw.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cleanlog(String delFile) throws FileIsDirectoryException, FileNotThereException {
		File toDel = new File(delFile);
		if (toDel.exists() && !toDel.isDirectory()) {
			toDel.delete();
		} else if (toDel.isDirectory())
			throw new FileIsDirectoryException();
		else if (!toDel.exists()) {
			throw new FileNotThereException();
		}
	}

	public static void main(String[] args){
		//backuplog("c:\\Temp\\worker.log", "c:\\Temp\\worker.bkp");
		try 
		{
			cleanlog("c:\\Temp");
		}
		catch (FileIsDirectoryException | FileNotThereException e) {
			e.printStackTrace();
		}
	}
}
