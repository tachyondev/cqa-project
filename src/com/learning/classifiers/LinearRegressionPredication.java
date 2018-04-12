package com.learning.classifiers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVLoader;


public class LinearRegressionPredication {

	public String trainModulePM10(String trainFilePath,String moduleSavePath)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("**** Training started for PH10 **** \n\n");
		System.out.println("**** Training started for PH10 ****  \n\n");
		try {
//			ArffLoader arffLoader = new ArffLoader();
//			arffLoader.setFile(new File(trainFilePath));
			CSVLoader csvLoader = new CSVLoader();
			csvLoader.setFile(new File(trainFilePath));
			Instances trainIntances = csvLoader.getDataSet();
			trainIntances.setClassIndex(trainIntances.numAttributes()-1);
			builder.append(" - Class attributes set \n");
			System.out.println(" - Class attributes set \n");
			LinearRegression linearRegression = new LinearRegression();
			linearRegression.buildClassifier(trainIntances);
			builder.append("- Traning deatils \n");
			System.out.println("- Traning deatils \n");
			builder.append(linearRegression.toString()+"\n\n");
			System.out.println(linearRegression.toString()+"\n\n");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(moduleSavePath)));
			objectOutputStream.writeObject(linearRegression);
			objectOutputStream.close();
			builder.append("Module Saved to the Path");
			System.out.println("Module Saved to the Path");
			return builder.toString().trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public String trainModuleO3(String trainFilePath,String moduleSavePath)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("**** Training started for O3 \n\n");
		try {
			//ArffLoader arffLoader = new ArffLoader();
			//arffLoader.setFile(new File(trainFilePath));
			CSVLoader csvLoader = new CSVLoader();
			csvLoader.setFile(new File(trainFilePath));
			Instances trainIntances = csvLoader.getDataSet();
			trainIntances.setClassIndex(trainIntances.numAttributes()-1);
			builder.append(" - Class attributes set \n");
			LinearRegression linearRegression = new LinearRegression();
			linearRegression.buildClassifier(trainIntances);
			builder.append("- Traning deatils \n");
			builder.append(linearRegression.toString()+"\n\n");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(moduleSavePath)));
			objectOutputStream.writeObject(linearRegression);
			objectOutputStream.close();
			builder.append("Module Saved to the Path");
			return builder.toString().trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

//	public String evaluationModulePM10(String trainFilePath,String moduleSavePath)
//	{
//		StringBuilder builder = new StringBuilder();
//		builder.append("**** Evalution Start ****");
//		try {
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		
//		return builder.toString();
//	}

	
	
	public double testModulePM10(String trainFilePath,String testFilePath,String moduleSavaPath)
	{
		double result = -1;
		try {
//			ArffLoader arffLoader = new ArffLoader();
//			arffLoader.setFile(new File(trainFilePath));
			CSVLoader csvLoaderTrain = new CSVLoader();
			csvLoaderTrain.setFile(new File(trainFilePath));
			Instances trainInstaces = csvLoaderTrain.getDataSet();
			trainInstaces.setClassIndex(trainInstaces.numAttributes()-1);
			
//			ArffLoader arffLoaderTest = new ArffLoader();
//			arffLoaderTest.setFile(new File(testFilePath));
			CSVLoader csvLoaderTest = new CSVLoader();
			csvLoaderTest.setFile(new File(testFilePath));
			Instances testInstaces = csvLoaderTest.getDataSet();
			testInstaces.setClassIndex(testInstaces.numAttributes()-1);
			System.out.println(testInstaces.toSummaryString());
		
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(moduleSavaPath)));
			LinearRegression linearRegression = (LinearRegression) objectInputStream.readObject();
			objectInputStream.close();
			Evaluation  evaluation = new Evaluation(trainInstaces);
			double []pre = evaluation.evaluateModel(linearRegression,testInstaces);
			for (int i = 0; i < pre.length; i++) {
				System.out.println(pre[i]+"\t");
			}
			if(pre.length<1 )
			{
				//error
			return result;
			}else
			{
				result  = pre[0];
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}

	public double testModuleO3(String trainFilePath,String testFilePath,String moduleSavaPath)
	{
		double result = -1;
		try {
//			ArffLoader arffLoader = new ArffLoader();
//			arffLoader.setFile(new File(trainFilePath));
			CSVLoader csvLoaderTrain = new CSVLoader();
			csvLoaderTrain.setFile(new File(trainFilePath));
			Instances trainInstaces = csvLoaderTrain.getDataSet();
			trainInstaces.setClassIndex(trainInstaces.numAttributes()-1);
			
//			ArffLoader arffLoaderTest = new ArffLoader();
//			arffLoaderTest.setFile(new File(testFilePath));
			CSVLoader csvLoaderTest = new CSVLoader();
			csvLoaderTest.setFile(new File(testFilePath));
			Instances testInstaces = csvLoaderTest.getDataSet();
			testInstaces.setClassIndex(testInstaces.numAttributes()-1);
			System.out.println(testInstaces.toSummaryString());
		
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(moduleSavaPath)));
			LinearRegression linearRegression = (LinearRegression) objectInputStream.readObject();
			objectInputStream.close();
			Evaluation  evaluation = new Evaluation(trainInstaces);
			double []pre = evaluation.evaluateModel(linearRegression,testInstaces);
			for (int i = 0; i < pre.length; i++) {
				System.out.println(pre[i]+"\t");
			}
			if(pre.length<1 )
			{
				//error
			return result;
			}else
			{
				result  = pre[0];
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}

	
	
	
	public String trainModulePM10New(String trainFilePath,String moduleSavePath)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("**** Training started for PH10 **** \n\n");
		System.out.println("**** Training started for PH10 ****  \n\n");
		try {
//			ArffLoader arffLoader = new ArffLoader();
//			arffLoader.setFile(new File(trainFilePath));
			CSVLoader csvLoader = new CSVLoader();
			csvLoader.setFile(new File(trainFilePath));
			Instances trainIntances = csvLoader.getDataSet();
			trainIntances.setClassIndex(trainIntances.numAttributes()-1);
			builder.append(" - Class attributes set \n");
			System.out.println(" - Class attributes set \n");
			
//			LinearRegression linearRegression = new LinearRegression();
//			linearRegression.buildClassifier(trainIntances);
			MultilayerPerceptron multilayerPerceptron = new MultilayerPerceptron();
			multilayerPerceptron.buildClassifier(trainIntances);
			
			builder.append("- Traning deatils \n");
			System.out.println("- Traning deatils \n");
			builder.append(multilayerPerceptron.toString()+"\n\n");
			System.out.println(multilayerPerceptron.toString()+"\n\n");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(moduleSavePath)));
			objectOutputStream.writeObject(multilayerPerceptron);
			objectOutputStream.close();
			builder.append("Module Saved to the Path");
			System.out.println("Module Saved to the Path");
			return builder.toString().trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public double testModulePM10New(String trainFilePath,String testFilePath,String moduleSavaPath)
	{
		double result = -1;
		try {
//			ArffLoader arffLoader = new ArffLoader();
//			arffLoader.setFile(new File(trainFilePath));
			CSVLoader csvLoaderTrain = new CSVLoader();
			csvLoaderTrain.setFile(new File(trainFilePath));
			Instances trainInstaces = csvLoaderTrain.getDataSet();
			trainInstaces.setClassIndex(trainInstaces.numAttributes()-1);
			
//			ArffLoader arffLoaderTest = new ArffLoader();
//			arffLoaderTest.setFile(new File(testFilePath));
			CSVLoader csvLoaderTest = new CSVLoader();
			csvLoaderTest.setFile(new File(testFilePath));
			Instances testInstaces = csvLoaderTest.getDataSet();
			testInstaces.setClassIndex(testInstaces.numAttributes()-1);
			System.out.println(testInstaces.toSummaryString());
		
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(moduleSavaPath)));
//			LinearRegression linearRegression = (LinearRegression) objectInputStream.readObject();
			MultilayerPerceptron multilayerPerceptron = (MultilayerPerceptron) objectInputStream.readObject();
			objectInputStream.close();
			Evaluation  evaluation = new Evaluation(trainInstaces);
			double []pre = evaluation.evaluateModel(multilayerPerceptron,testInstaces);
			for (int i = 0; i < pre.length; i++) {
				System.out.println(pre[i]+"\t");
			}
			if(pre.length<1 )
			{
				//error
			return result;
			}else
			{
				result  = pre[0];
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
}
