/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodografico;

/**
 *
 * @author Alejandro Macias
 */
public class Ecuaciones {
     private double vector[];
    
    public Ecuaciones(double[] Vector){
        this.vector = Vector;
    }
    
    public Ecuaciones(){
       
    }
    
     public void setVector(double[] vector) {
        this.vector = vector;
    }
    
    public double[] getVector() {
        return vector;
    }
    
    @Override
    public String toString(){
      String aux = "";
      for(int x=0 ;x<getVector().length;x++){
          aux+="("+getVector()[x]+")";
        };
        return aux;
    }
}
