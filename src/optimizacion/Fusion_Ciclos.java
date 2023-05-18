package optimizacion;

import java.io.*;
import java.util.*;

public class Fusion_Ciclos{
	
	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo[]= new int [5000000];
	int arreglo1[]= new int [5000000];
	int operacion[]= {1,2,3,4,5};
	
	public Fusion_Ciclos(){

		int longi=arreglo.length , i, j=0;

		a= new Date();
		Iprim=a.getTime();

		for (i=0;i<longi;i++){
	    	arreglo[i]= operacion[j++]+ i*i + 1500;
	    	if (j==5)
	    		j=0;
	    }
		for (i=0;i<longi;i++)
	    	arreglo1[i]= arreglo[i] + i;
	    	
	    for (i=0;i<longi;i++)
	    	arreglo[i]= arreglo1[i] -2500;
	    

		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));

		c= new Date();		
		Iprim=c.getTime();

		for (i=0;i<longi;i++){
	    	arreglo[i]= operacion[j++]+ i*i + 1500;
	    	if (j==5)
	    		j=0;
		    arreglo1[i]= arreglo[i] + i;
		   	arreglo[i]= arreglo1[i] -2500;
	    }
	    	
	    d= new Date();
	    Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));
	}
	
	public static void main (String[] args) throws IOException
	{
	 	Fusion_Ciclos a = new Fusion_Ciclos();
	}
}
	
