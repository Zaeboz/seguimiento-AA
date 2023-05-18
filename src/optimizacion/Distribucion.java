package optimizacion;

import java.io.*;
import java.util.*;

public class Distribucion {
	
	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo1[]= new int [500000];
	int arreglo2[]= new int [500000];
	int arreglo3[]= new int [500000];
	int arreglo4[]= new int [500000];
	int arreglo5[]= new int [500000];
	
	public Distribucion (){
		int i,j,k,lon;

		lon = arreglo1.length;
		for (i=0;i<lon;i++){
			arreglo2[i]= (int)(Math.random () * 10000001);
			arreglo3[i]= (int)(Math.random () * 10000001);
			arreglo4[i]= (int)(Math.random () * 10000001);
			arreglo5[i]= (int)(Math.random () * 10000001);
		}
			
		a= new Date();
		Iprim=a.getTime();
		
		for (i=0;i<lon-1;i++){
			arreglo1[i]=arreglo2[i] * arreglo3[i];
			arreglo2[i]=arreglo1[i] + arreglo3[i];
			arreglo3[i]=arreglo3[i] - arreglo2[i];
			arreglo4[i]= arreglo4[i+1] + arreglo5[i];
			arreglo3[i]= arreglo3[i+1] + arreglo5[i];
			arreglo2[i]= arreglo2[i+1] + arreglo5[i];
			arreglo1[i]= arreglo1[i+1] + arreglo5[i];
		}

		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));

		c= new Date();		
		Iprim=c.getTime();

		for (i=0;i<lon;i++){
			arreglo1[i]=arreglo2[i] * arreglo3[i];
			arreglo2[i]=arreglo1[i] + arreglo3[i];
			arreglo3[i]=arreglo3[i] - arreglo2[i];
		}

		
		for (j=0;j<lon-1;j++){
			k=j+1;
			arreglo4[j]= arreglo4[k] + arreglo5[j];
			arreglo3[j]= arreglo3[k] + arreglo5[j];
			arreglo2[j]= arreglo2[k] + arreglo5[j];
			arreglo1[j]= arreglo1[k] + arreglo5[j];
		}
	    
	    d= new Date();
	    Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));
	}
	
	public static void main (String[] args) throws IOException
	{
	 	Distribucion a = new Distribucion();
	}
}
	
