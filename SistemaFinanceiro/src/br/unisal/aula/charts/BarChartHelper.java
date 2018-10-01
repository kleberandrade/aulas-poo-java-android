package br.unisal.aula.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartHelper {
    
    private BarChartHelper(){}
    
    public static ChartPanel criar(String[] labels, double[] values){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < labels.length; i++) {
            dataset.addValue(values[i], labels[i], "");
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                null, null, null,                           
                dataset, PlotOrientation.VERTICAL, 
                true, true, false);
           
        ChartPanel panel = new ChartPanel(chart);
        return panel;
    }
    
}
