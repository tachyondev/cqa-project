package com.worker;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.config.Config;
import com.learning.classifiers.LinearRegressionPredication;
import com.preprocessing.TestBuilder;

@WebServlet("/testworker")
public class TestWorker extends  HttpServlet{
	LinearRegressionPredication linearRegressionPredication;
	TestBuilder testBuilder;
	@Override
	public void init() throws ServletException {
		linearRegressionPredication = new LinearRegressionPredication();
		testBuilder = new TestBuilder();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Worker Class");
	}
	   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		executeIt(req, resp);
		//resp.getWriter().write(req.getParameter("mRate")+"\n"+req.getParameter("T2M")+"\n"+req.getParameter("test"));
	}
	
	private void executeIt(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		
		if(req.getParameter("test").contentEquals("start"))
		{
			System.out.println("Starting file writtting");
			boolean isWrittenPM10 = testBuilder.buildTestFile(Config.buildPM10, req.getParameter("mRate"), req.getParameter("T2M"),Config.rootPath+"\\test\\test_pm10.csv");
			boolean isWrittenO3 = testBuilder.buildTestFile(Config.buildO3, req.getParameter("mRate"), req.getParameter("T2M"),Config.rootPath+"\\test\\test_o3.csv");
			System.out.println("isWritten - "+ isWrittenPM10+" - "+ isWrittenO3);
			
			if(isWrittenPM10 &&  isWrittenO3)
			{
				System.out.println("Calling predications");
				double O3 = linearRegressionPredication.testModuleO3(Config.rootPath+"\\train\\train_o3_part.csv", Config.rootPath+"\\test\\test_o3.csv", Config.rootPath+"\\module\\lrO3.module");
				double PM10 = linearRegressionPredication.testModulePM10(Config.rootPath+"\\train\\train_pm10_part.csv", Config.rootPath+"\\test\\test_pm10.csv", Config.rootPath+"\\module\\lrPM10.module");
				System.out.println("Predication Results:"+O3+" - "+ PM10);
				if(O3!=-1 && PM10 != -1)
				{
					StringBuilder builder = new StringBuilder();
					builder.append("**** Testing Started ****\n");
					builder.append("- Bulding Test Class \n");
					builder.append("- Loading Test Classes \n");
					builder.append("- Modules Loaded Successfully \n");
					builder.append("- Predications:- \n\n");
					builder.append("1. PM10: "+PM10+" \n");
					builder.append(" 2. O3: "+O3+" \n\n");
					builder.append("Successfully Done !!!");
					resp.getWriter().write(builder.toString());
				}else
				{
					if(O3 == -1)
					{
						resp.getWriter().write("error -13");
					}else if(PM10 ==-1)
					{
						resp.getWriter().write("error -110");

					}else 
					{
						resp.getWriter().write("error -1");
					}
				}
				
			}else
			{
				resp.getWriter().write("error 1");
			}
			
		}		
		
	}
}
