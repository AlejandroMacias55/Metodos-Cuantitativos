/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodografico;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Ventanas.Ventana;

/**
 *
 * @author Alejandro Macias
 */
public class Restricciones {
    public ArrayList<Ecuaciones> ecu;
    public double[] FO = new double[2]; 
    Scanner teclado = new Scanner(System.in);
    public static int num = 0;
    public Graficar g = new Graficar("", "X", "Y");
    public double resultadoBueno;
    public double Maxmin; 
    
    
    public void inRestricciones(double vard1, double vard2, double varr1, double varr2, double varr3, double varr4, double varr5, double varr6, double ct1, double ct2, double ct3,int opcion, int bandera){
        
        Ventana v = new Ventana();
        ecu = new ArrayList<>();
        int numRes=0;

        Maxmin=opcion;
        System.out.println("opcion:"+opcion);

        FO[0]=vard1;
        FO[1]=vard2; 
        System.out.println("X:"+vard1);
        System.out.println("y:"+vard2);

        System.out.println("Bandera "+bandera);
        numRes=3;
  
        if(v.bandera==1){
            numRes=2;
        }
        
        if(numRes==3){
            num=1;
            double[] ecuacion  = new double[3];
            ecuacion[0] = varr1;
            ecuacion[1] = varr2;
            ecuacion[2] = ct1;
            ecu.add(new Ecuaciones(ecuacion));
            encontrarPunto(varr1,varr2,ct1);
            num=2;
            double[] ecuacion1  = new double[3];
            ecuacion1[0] = varr3;
            ecuacion1[1] = varr4;
            ecuacion1[2] = ct2;
            ecu.add(new Ecuaciones(ecuacion1));
            encontrarPunto(varr3,varr4,ct2);
            num=3;
            double[] ecuacion2  = new double[3];
            ecuacion2[0] = varr5;
            ecuacion2[1] = varr6;
            ecuacion2[2] = ct3;
            ecu.add(new Ecuaciones(ecuacion2));
            encontrarPunto(varr5,varr6,ct3);
          
           

        }
        if(numRes==2){
            num=1;
            double[] ecuacion  = new double[3];
            ecuacion[0] = varr1;
            ecuacion[1] = varr2;
            ecuacion[2] = ct1;
            ecu.add(new Ecuaciones(ecuacion));
            encontrarPunto(varr1,varr2,ct1);
            num=2;
            double[] ecuacion1  = new double[3];
            ecuacion1[0] = varr3;
            ecuacion1[1] = varr4;
            ecuacion1[2] = ct2;
            ecu.add(new Ecuaciones(ecuacion1));
            encontrarPunto(varr3,varr4,ct2);
         
        }

       
    }
    
    public  void encontrarPunto(double x, double y, double Constante){
        double PuntoX = 0, PuntoY = 0;
        if(x != 0){
            PuntoX = Constante/x;
        }else{
            PuntoX=0;
        }
        if(y != 0){
            PuntoY = Constante/y;
        }else{
            PuntoY = 0;
        }
        
        g.agregarSerie(num,PuntoX,PuntoY);
        
        System.out.println(x+" + " + y + " = "+ Constante );
        System.out.println("Coordenadas: ("+ PuntoX+ "," +PuntoY + ")");
    }
    
    public void recorrer(){
        double A,B,C,D,E,F;
        double resultadoX, resultadoY;
        for(int i = 0; i<ecu.size();i++){
            double R1[] = ecu.get(i).getVector();
            for(int j = 1; j<ecu.size();j++){
                double R2[] = ecu.get(j).getVector();
                A =R1[0];
                B =R1[1];
                C =R1[2];
                D =R2[0];
                E =R2[1];
                F =R2[2];

                resultadoX = ((C*E)-(B*F))/((A*E)-(B*D));
                resultadoY = ((A*F)-(C*D))/((A*E)-(B*D));
                System.out.println(resultadoX +" "+ resultadoY);
                funcionObjetivo(resultadoX, resultadoY);
            }
        }
    }
    
    public void funcionObjetivo(double x, double y){
        double resultado = FO[0]*x+FO[1]*y;
        if (Maxmin==1){
        if(comprobarRestricciones(x,y) == true){
        if (resultado> resultadoBueno){
            resultadoBueno = resultado;
        }
        }
        }else {
            if(comprobarRestricciones(x,y) == true){
                
        if (resultado< resultadoBueno){
            resultadoBueno = resultado;
        }
        } 
        }
        }
    
    public boolean comprobarRestricciones(double x, double y){
        for(int i = 0;i<ecu.size();i++){
            double R1[] = ecu.get(i).getVector();
            if(((R1[0] * x) + (R1[1] * y)) > R1[2]){
            return false;
        }
        }
        return true;
    }
    
}
