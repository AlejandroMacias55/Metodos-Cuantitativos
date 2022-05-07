/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodografico;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Alejandro Macias
 */
public class Graficar {
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String titulo;
    private String tituloEjeX;
    private String tituloEjeY;
    

    public Graficar(String titulo, String tituloEjeX, String tituloEjeY) {
        this.titulo = titulo;
        this.tituloEjeX = tituloEjeX;
        this.tituloEjeY = tituloEjeY;
        this.grafica = null;
        this.series = new XYSeriesCollection();
    }
    
    public void agregarSerie(int id,double x, double y) {
        XYSeries serie = new XYSeries(id);
        this.series.addSeries(serie);
        if(x==0){
            serie.add(99,y);
            serie.add(0,y);
        }else if(y==0){
            serie.add(x,0);
            serie.add(x,99);
        }else{
            serie.add(x,0);
            serie.add(0,y);
        }
    } 
    
    public void crearGraficaPuntos() {
        
        this.grafica = ChartFactory.createXYLineChart(titulo, tituloEjeX, tituloEjeY, series);
        ChartFrame pane1 = new ChartFrame("", this.grafica);
        pane1.setSize(700, 700);
        pane1.setLocationRelativeTo(null);
        pane1.setVisible(true);
      
    }

}