package optimizacion;

import java.io.*;
import java.util.*;
/*Desenvolver ciclos pequeños y constantes*/

public class Desenvolvimiento1
{
	
	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo[]= new int [5];
	int operacion[]= {1,2,3,4,5};
	
	public Desenvolvimiento1(){

		int longi=arreglo.length , i, j=0;

		a= new Date();
		Iprim=a.getTime();

		for (i=0;i<longi;i++){
	    	arreglo[i]= operacion[j++]+ i*i + 1500;
	    	if (j==5){
	    		j=0;
		    	for (int k=0 ; k <= 4; k++)
		    		operacion[k]=operacion[k]+2;
		    }
	    }
		
		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));

		c= new Date();		
		Iprim=c.getTime();
		
		for (i=0;i<longi;i++){
	    	arreglo[i]= operacion[j++]+ i*i + 1500;
	    	if (j==5){
	    		j=0;
		    	operacion[0]=operacion[0]+2;
		    	operacion[1]=operacion[1]+2;
		    	operacion[2]=operacion[2]+2;
		    	operacion[3]=operacion[3]+2;
		    	operacion[4]=operacion[4]+2;
		    }
	    }
		
	    d= new Date();
	    Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));
	}
	
	public static void main (String[] args) throws IOException
	{
	 	Desenvolvimiento1 a = new Desenvolvimiento1();
	}
}
	
