package com.worker;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.config.Config;
import com.learning.classifiers.LinearRegressionPredication;

@WebServlet("/trainworker")
public class TrainWorker extends  HttpServlet{
	LinearRegressionPredication linearRegressionPredication;

	@Override
	public void init() throws ServletException {
		linearRegressionPredication = new LinearRegressionPredication();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Worker Class");
	}
	   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		executeIt(req, resp);
	}
	
	private void executeIt(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		
		
		if(req.getParameter("train").contentEquals("PM10"))
		{
	
			String data = linearRegressionPredication.trainModulePM10(Config.rootPath+"\\train\\train_pm10_part.csv", Config.rootPath+"\\module\\lrPM10.module");
			resp.getWriter().write(data);
			
		}else if(req.getParameter("train").contentEquals("O3"))
		{
			String data = linearRegressionPredication.trainModuleO3(Config.rootPath+"\\train\\train_o3_part.csv", Config.rootPath+"\\module\\lrO3.module");
			resp.getWriter().write(data);
			
		}
		
		
	}
}
