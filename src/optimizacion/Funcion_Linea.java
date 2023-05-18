package optimizacion;

import java.io.*;
import java.util.*;
/* Elimine los llamados a funciones pequeñas, estos consumen tiempo*/
public class Funcion_Linea
{
	
	Date a,b,c,d;
	long Iprim,Fprim;
	int arreglo[]= new int [3000000];
	int arreglo1[]= new int [3000000];
	
	public Funcion_Linea(){
		int i,lon,a1,b1,c1;
	

		lon = arreglo.length;
		
		for (i=0;i<lon;i++)
			arreglo[i]=(int)(Math.random () * 10000001);
		
		a= new Date();
		Iprim=a.getTime();

		for (i=0;i<lon;i++){
			a1= i+1;
			b1= i*2;
			c1= i+3;
			arreglo1[i]=arreglo[i]* Fun (a1, b1, c1);
		}
	
		b= new Date();
		Fprim=b.getTime();
		System.out.println ("\n\n\tTiempo consumido por el primer ciclo: " + (Fprim-Iprim));

		c= new Date();		
		Iprim=c.getTime();

		for (i=0;i<lon;i++){
			arreglo1[i]=arreglo[i] * ((i*i + 3*i +2)%(i+3));
		}

	    d= new Date();
	    Fprim=d.getTime();
		System.out.println ("\n\n\tTiempo consumido por el segundo ciclo: " + (Fprim-Iprim));
	}
	
	public int Fun (int a, int b, int c){
		int j,k;
		j=a * b;
		k=Fun1(j,c);
		return k;
	}
	

	public int Fun1 (int j, int c){
		int k;
		k=j % c;
		return k;
	}
	
	
	public static void main (String[] args) throws IOException
	{
	 	Funcion_Linea a = new Funcion_Linea();
	}
}
	

