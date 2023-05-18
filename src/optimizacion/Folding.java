package optimizacion;

import java.io.*;
import java.util.*;

/*Reducción de expresiones*/

public class Folding{
	
	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo1[]= new int [3000000];
	
	public Folding(){
		int i,k,lon,l,m,j;
		

		lon = arreglo1.length;
		
		for (i=0;i<lon;i++)
			arreglo1[i]=(int)(Math.random () * 10000001);
		
		a= new Date();
		Iprim=a.getTime();
		k=8500;
		l=15250;
		m=450;

		for (i=0;i<lon;i++)
			j=arreglo1[i]*((k+l)*m)/150;
	
		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));

		c= new Date();		
		Iprim=c.getTime();

		for (i=0;i<lon;i++)
			j=arreglo1[i]*71250;

	    d= new Date();
	    Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));
	}
	
	public static void main (String[] args) throws IOException
	{
	 	Folding a = new Folding();
	}
}
	
