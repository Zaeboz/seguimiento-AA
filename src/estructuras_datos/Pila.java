package estructuras_datos;



public class Pila 
{
		private ListaSimple pila;
		
		public Pila ()
		{
			pila = new ListaSimple();
		}

		public void push(String elemento, String nombre)
		{
			Nodo nuevo = new Nodo(elemento);
				
			pila.agregarInicio(nuevo);

		}
		
		public String peek()
		{
			pila.getNodoPrimero();
			
			return String.valueOf(pila.obtenerPosicionNodo(pila.getNodoPrimero()));
		}
		
		public String pop()
		{
			String dato = peek();
			
			pila.eliminarPrimero();
			
			return dato;
		}

		public boolean pilaVacia()
		{
			return pila.getTamanio() == 0;
		}
		
		public String toString()
		{
			return pila.toString();
		}

		public static String invertirString(String palabra)
		{
			StringBuilder salida = new StringBuilder();
			char[] pal = palabra.toCharArray();
			Pila pila = new Pila();

			for (char c : pal) {
				pila.push(String.valueOf(c), "Nodo");
			}
			
			for (int j=0 ; j<pal.length;j++)
			{
				salida.append(pila.pop());
			}
			return salida.toString();
		}

		
}
