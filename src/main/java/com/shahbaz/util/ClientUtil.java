package com.shahbaz.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ClientUtil {
	
	//1. create Pie chart
	public void generatePiePriority(String path,List<Object[]> data) {
		//a. create dataset for pie and add data to it.
		DefaultPieDataset dataset=new DefaultPieDataset();
		
		for(Object[] ob:data) {
			dataset.setValue(String.valueOf(ob[0]), Double.valueOf(ob[1].toString()));
		}
		
		//b. create jFree chart object with dataset and other details
		JFreeChart chart=ChartFactory.createPieChart3D("PRIORITY OF WORK", dataset);
		
		// read chart area object
		PiePlot<?> plot=(PiePlot<?>)chart.getPlot();
		PieSectionLabelGenerator gen=new StandardPieSectionLabelGenerator("{0}:{1} ({2})",new DecimalFormat("0"),new DecimalFormat("0%"));
		plot.setLabelGenerator(gen);
		
		//c. convert jfreechart object as image
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"priority.jpg"), chart, 500, 450);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//1. create Pie chart
		public void generatePieType(String path,List<Object[]> data) {
			//a. create dataset for pie and add data to it.
			DefaultPieDataset dataset=new DefaultPieDataset();
			
			for(Object[] ob:data) {
				dataset.setValue(String.valueOf(ob[0]), Double.valueOf(ob[1].toString()));
			}
			
			//b. create jFree chart object with dataset and other details
			JFreeChart chart=ChartFactory.createPieChart3D("TYPES OF WORK", dataset);
			
			// read chart area object
			PiePlot<?> plot=(PiePlot<?>)chart.getPlot();
			PieSectionLabelGenerator gen=new StandardPieSectionLabelGenerator("{0}:{1} ({2})",new DecimalFormat("0"),new DecimalFormat("0%"));
			plot.setLabelGenerator(gen);
			
			//c. convert jfreechart object as image
			try {
				ChartUtils.saveChartAsJPEG(new File(path+"types.jpg"), chart, 500, 450);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//1. create Pie chart
		public void generatePieNature(String path,List<Object[]> data) {
			//a. create dataset for pie and add data to it.
			DefaultPieDataset dataset=new DefaultPieDataset();
			
			for(Object[] ob:data) {
				dataset.setValue(String.valueOf(ob[0]), Double.valueOf(ob[1].toString()));
			}
			
			//b. create jFree chart object with dataset and other details
			JFreeChart chart=ChartFactory.createPieChart3D("NATURE OF WORK", dataset);
			
			// read chart area object
			PiePlot<?> plot=(PiePlot<?>)chart.getPlot();
			PieSectionLabelGenerator gen=new StandardPieSectionLabelGenerator("{0}:{1} ({2})",new DecimalFormat("0"),new DecimalFormat("0%"));
			plot.setLabelGenerator(gen);
			
			//c. convert jfreechart object as image
			try {
				ChartUtils.saveChartAsJPEG(new File(path+"nature.jpg"), chart, 500, 450);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
