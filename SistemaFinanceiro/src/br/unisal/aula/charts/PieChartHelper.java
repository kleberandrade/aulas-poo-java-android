package br.unisal.aula.charts;

import br.unisal.aula.models.ItemFinanceiro;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieChartHelper {
 
    private PieChartHelper(){}
    
    public static ChartPanel criar(JComboBox lista, List<ItemFinanceiro> itens){
        Map<String, Double> valoresMap = new HashMap<>();
        for (int i = 0; i < lista.getItemCount(); i++) {
            valoresMap.put((String)lista.getItemAt(i), 0.0);
        }
        
        for (int i = 0; i < itens.size(); i++) {
            ItemFinanceiro item = itens.get(i);
            String categoria = item.getCategoria();
            Double valor = valoresMap.get(categoria);
            valor += item.getValor();
            valoresMap.put(categoria, valor);
        }
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < lista.getItemCount(); i++) {
            String categoria = (String)lista.getItemAt(i);
            Double valor = valoresMap.get(categoria);
            dataset.setValue(categoria, valor);
        }
        
        JFreeChart chart = ChartFactory.createPieChart("", dataset, true, true, false);
        
        PieSectionLabelGenerator label = new StandardPieSectionLabelGenerator("{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(label);
        
        ChartPanel painel = new ChartPanel(chart);
        return painel;
    }
    
}
