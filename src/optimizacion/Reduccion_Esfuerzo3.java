package optimizacion;

import java.io.*;
import java.util.*;

//Operación división por potencias de dos, es equivalente a log(n) corrimientos de bits
//a la derecha:
public class Reduccion_Esfuerzo3{
	
	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo1[]= new int [2000000];
	
	public Reduccion_Esfuerzo3 (){
		int i,k,lon;
		double j;
		

		lon = arreglo1.length;
		
		for (i=0;i<lon;i++)
			arreglo1[i]=(int)(Math.random () * 10000001);
		
		a= new Date();
		Iprim=a.getTime();

		for (i=0;i<lon;i++)
			j=arreglo1[i]/8;
				

		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));

		c= new Date();		
		Iprim=c.getTime();

		for (i=0;i<lon;i++)
			j=arreglo1[i]>>3;
			
	    
	    d= new Date();
	    Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));
	}
	
	public static void main (String[] args) throws IOException
	{
	 	Reduccion_Esfuerzo3 a = new Reduccion_Esfuerzo3();
	}
}
	
