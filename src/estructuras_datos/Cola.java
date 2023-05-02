package estructuras_datos;

public class Cola 
{
	private ListaSimple cola;
	
	private int capacidad;
	
	private int cantidadIngresos;
	
	public Cola()
	{
		cola = new ListaSimple();
		
		cantidadIngresos = 0;
	}
	
	public int peek()
	{
		cola.getNodoPrimero();

		return (int) cola.obtenerValorNodo(cola.getTamanio());
	}
	
	public void agregar(int elemento,String nombre)
	{	
		if(cantidadIngresos<capacidad)
		{
		
		cola.agregarfinal(elemento);
		
		cantidadIngresos++;
		
		}else
		{
			System.out.println("La cola esta llena");
		}
	}
	
	public int poll()
	{
		int dato = peek();
		
		cola.eliminarPrimero();
		
		return dato;
	}
	
	public boolean colaVacia ()
	{
		if(cola.getTamanio()== 0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public static boolean compararColas (Cola cola1, Cola cola2)
	{
		boolean centi = false;
		
		if(cola1.getCapacidad() == cola2.getCapacidad())
		{
			for(int i = 0; i <= cola1.getCapacidad() - 1;i++)
			{
				centi = cola1.peek() == cola2.peek();
				
				cola1.poll();
				
				cola2.poll();
			}
		}
		
		return centi;		
	}
	
	public int obtenerLongitud()
	{
		return cola.getTamanio();
	}

	public void eliminar()
	{
		cola.eliminarPrimero();
	}

	public String toString()
	{
		return cola.toString();
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	
}
