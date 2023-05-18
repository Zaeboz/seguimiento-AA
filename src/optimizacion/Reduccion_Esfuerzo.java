package optimizacion;

import java.io.*;
import java.util.*;

//Operación Módulo y and a nivel binario, para números que sean potencia de dos.
public class Reduccion_Esfuerzo{
	
	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo1[]= new int [2000000];
	
	public Reduccion_Esfuerzo (){
		int i,j,k,lon;

		lon = arreglo1.length;
		
		for (i=0;i<lon;i++)
			arreglo1[i]=(int)(Math.random () * 10000001);
		
		a= new Date();
		Iprim=a.getTime();

		for (i=0;i<lon;i++)
			j=arreglo1[i]% 1024;
			
		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));

		c= new Date();		
		Iprim=c.getTime();

		for (i=0;i<lon;i++)
			k=arreglo1[i] & 1023;
				    
	    d= new Date();
	    Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));
	}
	
	public static void main (String[] args) throws IOException
	{
	 	Reduccion_Esfuerzo a = new Reduccion_Esfuerzo();
	}
}
	
