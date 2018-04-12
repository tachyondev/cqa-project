package com.preprocessing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestBuilder {
	
	
	public boolean buildTestFile(String baseString,String mortalityRate,String T2M,String testDatasetFile)
	{
		boolean isWritten = false;
		try {
				String dataToBeWrite = null; 
				String featuresData = mortalityRate+","+T2M+",?";
				dataToBeWrite = baseString+"\n"+featuresData;
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(testDatasetFile)));
				bufferedWriter.write(dataToBeWrite);
				bufferedWriter.close();
				isWritten = true;
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			isWritten = false;
		}
		return isWritten;
	}
}
