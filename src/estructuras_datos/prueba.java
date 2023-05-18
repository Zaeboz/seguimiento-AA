package estructuras_datos;

public class prueba
{
    int[] arreglo = new int [5000000], arreglo1 = new int [5000000], operacion = {1,2,3,4,5};

    public prueba ()
    {
        int k = 0;
        for (int i=0; i<arreglo.length; i+=5)
        {
            arreglo[i] = operacion[k++] + (i*i*i*i);
            arreglo[i+1] = operacion[k++] + ((i+1)*(i+1)*(i+1)*(i+1));
            arreglo[i+2] = operacion[k++] + ((i+2)*(i+2)*(i+2)*(i+2));
            arreglo[i+3] = operacion[k++] + ((i+3)*(i+3)*(i+3)*(i+3));
            arreglo[i+4] = operacion[k++] + ((i+4)*(i+4)*(i+4)*(i+4));
            k = 0;
        }
        for (int i=0; i<arreglo1.length; i++)
        {
            arreglo1[i] = (i*i*i*i) * 2;
            arreglo[i] = arreglo1[i] - arreglo[i];
        }
    }
}
