package optimizacion;

import java.io.*;
import java.util.*;

/* Se ejecuta la misma operación pero con datos de tipo entero y flotante*/
public class Tipos_Variables{

	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo[]= new int [5000000];
	double arreglo1[]= new double [5000000];
	int operacion[]= {1,2,3,4,5};
	double operacion1[]= {1,2,3,4,5};

	public Tipos_Variables()
	{

		int longi=arreglo.length , i, j=0;
		a= new Date();
		Iprim=a.getTime();
		for (i=0;i<longi;i++){
			arreglo[i]= operacion[j++] + i*i + 1500;
			if (j==5)
				j=0;
		}
		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));

		c= new Date();		
		Iprim=c.getTime();
		for (i=0;i<longi;i++){
			arreglo1[i]= operacion1[j++] + i*i + 1500.0;
			if (j==5)
				j=0;
		}
		d= new Date();
		Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));

	}

	public static void main (String[] args) throws IOException
	{
		Tipos_Variables a = new Tipos_Variables();
	}
}

