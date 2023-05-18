package optimizacion;

import java.io.*;
import java.util.*;
/*Paralelizar los ciclos, siempre y cuando no haya dependencia de datos posteriores o
 *anteriores.*/

public class Desenvolvimiento
{

	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo[]= new int [50];
	int operacion[]= {1,2,3,4,5};

	public Desenvolvimiento()
	{
		int longi=arreglo.length , i, j=0;
		a= new Date();
		Iprim=a.getTime();
		for (i=0;i<longi;i++)
		{
			arreglo[i]= operacion[j++]+ i*i + 1500;
			if (j==5)
				j=0;
		}

		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));
		
		
		c= new Date();		
		Iprim=c.getTime();
		for (i=0;i<longi;i+=5){
			arreglo[i]= operacion[j++]+ i * i + 1500;
			arreglo[i+1]= operacion[j++]+ (i+1)*(i+1)+ 1500;
			arreglo[i+2]= operacion[j++]+ (i+2)*(i+2)+ 1500;
			arreglo[i+3]= operacion[j++]+ (i+3)*(i+3)+ 1500;
			arreglo[i+4]= operacion[j++]+ (i+4)*(i+4)+ 1500;
			j=0;
		}
		d= new Date();
		Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));

	}

	public static void main (String[] args) throws IOException
	{
		Desenvolvimiento a = new Desenvolvimiento();
	}
}

