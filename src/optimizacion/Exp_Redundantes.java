package optimizacion;

import java.io.*;
import java.util.*;

public class Exp_Redundantes{
	
	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo1[]= new int [3000000];
	
	public Exp_Redundantes(){
		int i,k,lon,l,m;
		double j;
		

		lon = arreglo1.length;
		
		for (i=0;i<lon;i++)
			arreglo1[i]=(int)(Math.random () * 10000001);
		
		a= new Date();
		Iprim=a.getTime();

		for (i=0;i<lon;i++)
			j=arreglo1[i]*Math.pow(i,3) + Math.pow(i,3) ;
	
		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));

		c= new Date();		
		Iprim=c.getTime();

		for (i=0;i<lon;i++)
			j=Math.pow(i,3)*(arreglo1[i] + 1 );

	    d= new Date();
	    Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));
	}
	
	public static void main (String[] args) throws IOException
	{
	 	Exp_Redundantes a = new Exp_Redundantes();
	}
}
	
