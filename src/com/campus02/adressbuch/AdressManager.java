package com.campus02.adressbuch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AdressManager 
{
ArrayList<Adress> myList = new ArrayList<>();

public AdressManager(ArrayList<Adress> myList) 
{
	super();
	this.myList = myList;
}

public void loadFromCsv (String path,String seperator ) throws AdressLoadExceptio, IOException, AdressLoadWrongFormatException
{
	File input = new File(path);
	BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(input)));

	String inputString;
	String[] splitted;
	while ((inputString =bf.readLine())!= null)
	{
		splitted = inputString.split(seperator);
		if (splitted.length ==4){
		Adress in = new Adress(splitted[0], splitted[1], splitted[2], splitted[3]);
		myList.add(in);}
		else 
		{
			bf.close();
			throw new AdressLoadWrongFormatException();
		}
		
		}
	bf.close();
}

public void exportToCsv(String path, String seperator) throws AdressExportExeption, IOException
{
	File output = new File(path);
	PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output))));
	if (output.exists())
	{
		System.out.println("File already exists!");
	}
	else {
	for (Adress adress : myList) 
	{
		pw.println(adress.getFirstname()+seperator+adress.lastname+seperator+adress.getMobileNumber()+seperator+adress.getEmail());	
	}}
	pw.flush();
	pw.close();

	
}
}
