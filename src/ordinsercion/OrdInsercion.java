
package ordinsercion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrdInsercion {


    public static void main(String[] args) {
        List<Integer> numbersCien = new ArrayList<>();
        List<Integer> numbersMil = new ArrayList<>();
        List<Integer> numbersDiezMil = new ArrayList<>();

        //Rutas relativas de los tres archivos
        String filePath1 = "./src/ordinsercion/DataCien.txt";
        String filePath2 = "./src/ordinsercion/DataMil.txt";
        String filePath3 = "./src/ordinsercion/DataDiezMil.txt";

        //-----------------LECTURA DE LOS CIEN DATOS-----------------------
        try {
            File file = new File(filePath1);
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Leer el archivo línea por línea
            String line;
            while ((line = br.readLine()) != null) {
                // Convierte la línea a número y añádelo a la lista
                int numberCien = Integer.parseInt(line);
                // Agregar cada línea al ArrayList
                numbersCien.add(numberCien);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a número: " + e.getMessage());
        }

        // Convertir la lista con los CIEN DATOS a un arreglo de enteros
        int[] numbersArrayCien = new int[numbersCien.size()];
        for (int i = 0; i < numbersCien.size(); i++) {
            numbersArrayCien[i] = numbersCien.get(i);
        }
        //-----------------LECTURA DE LOS MIL DATOS-----------------------
        try {
            File file = new File(filePath2);
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Leer el archivo línea por línea
            String line;
            while ((line = br.readLine()) != null) {
                // Convierte la línea a número y añádelo a la lista
                int numberMil = Integer.parseInt(line);
                // Agregar cada línea al ArrayList
                numbersMil.add(numberMil);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a número: " + e.getMessage());
        }

        // Convertir la lista de los MIL DATOS a un arreglo de enteros
        int[] numbersArrayMil = new int[numbersMil.size()];
        for (int i = 0; i < numbersMil.size(); i++) {
            numbersArrayMil[i] = numbersMil.get(i);
        }

        //-----------------LECTURA DE LOS DIEZ MIL DATOS-----------------------
        try {
            File file = new File(filePath3);
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Leer el archivo línea por línea
            String line;
            while ((line = br.readLine()) != null) {
                // Convierte la línea a número y añádelo a la lista
                int numberDiezMil = Integer.parseInt(line);
                // Agregar cada línea al ArrayList
                numbersDiezMil.add(numberDiezMil);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a número: " + e.getMessage());
        }

        // Convertir la lista de los DIEZ MIL DATOS a un arreglo de enteros
        int[] numbersArrayDiezMil = new int[numbersDiezMil.size()];
        for (int i = 0; i < numbersDiezMil.size(); i++) {
            numbersArrayDiezMil[i] = numbersDiezMil.get(i);
        }
        
        //Ejecucion del ordenamiento por insercion
        insercion(numbersArrayCien);
        insercion(numbersArrayMil);
        insercion(numbersArrayDiezMil);
        
        //Ejecucion del ordenamiento por monticulo
        heap(numbersArrayCien);
        heap(numbersArrayMil);
        heap(numbersArrayDiezMil);
    }
    
    //Este ordenamiento funciona igual que como organizamos tarjetas en la vida real 
    public static void insercion(int arreglo[]){
        int contadorPasosIn=0;
        int contadorCiclosIn=0;
        
        for (int i = 1; i < arreglo.length; i++){
            
            int aux = arreglo[i]; //En donde me ubico en el arreglo
            contadorPasosIn+=1;
            
            //Recorro parte izquierda del arreglo
            for (int j = i - 1; j < i & j >= 0 ; j--){
                contadorCiclosIn+=1;
                if(arreglo[j] > aux){ //Si en mi recorrido me encuentro con alguien menor a donde estoy, haz esto
                    arreglo[j+1] = arreglo[j]; //Muevo el mayor una posicion al frente abriendo campo para el menor
                    arreglo[j] = aux; //En la posicion libre pongo al menor
                    contadorPasosIn+=2;
                }
                contadorPasosIn+=3;
            }
            contadorPasosIn+=4;
        }
        contadorPasosIn+=2;
        
        /*DESCOMENTAR SI SE QUIERE VER EL ARREGLO ORDENADO
        System.out.println("El arreglo ordenado por insercion es : " + "\n");
        for (int k = 0; k < arreglo.length; k++){
            System.out.println(arreglo[k]);
        }*/
        
        System.out.println("El tamano del arreglo es: " + arreglo.length);
        System.out.println("El numero de ciclos por inserccion son: " +contadorCiclosIn);
        System.out.println("El numero de pasos por inserccion son: " +contadorPasosIn + "\n");
    
    }
    
    //ORDENAMIENTO POR MONTICULO
    private static int contadorCiclosHeap = 0; // Contador de ciclos
    public static void heap(int aprueba[]) {
        contadorCiclosHeap = 0;
        int n = aprueba.length; 
        int contadorPasosHeap = 0; // Contador de pasos
    
        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--){
            
            heapify(aprueba, n, i,contadorPasosHeap);
            contadorPasosHeap+=1;//pregunta
            contadorPasosHeap+=1;// llama al metodo
            contadorPasosHeap+=1;// itera 
            
        }
         contadorPasosHeap += 1;//La comparación que no entra al for 
         contadorPasosHeap+=1;//inicialización de la variable i=n
        
        // Extraer un elemento del montículo uno por uno
        for (int i = n - 1; i >= 0; i--) {
           
             // Mover el nodo raíz actual al final 
            int temp = aprueba[0];
            aprueba[0] = aprueba[i];
            aprueba[i] = temp;
             
       
            // Llamar a max heapify en el montículo reducido
            heapify(aprueba, i, 0,contadorPasosHeap);
            contadorPasosHeap +=1;//pregunta
            contadorPasosHeap +=4;// Proceso interno 4 pasos 
            contadorPasosHeap+=1;// itera 
            
        }
        contadorPasosHeap += 1; // La comparación que no entra al for 
        contadorPasosHeap+=1;//inicialización de la variable i=n 
            //------------------------------------------------------
            
            
        /*DESCOMENTAR SI SE QUIERE VER EL ARREGLO ORDENADO    
        System.out.println("\nEl arreglo ordenado por monticulo(heap) es : " + "\n");
        for (int k = 0; k < aprueba.length; k++) {
        System.out.print(aprueba[k] + " ");           
        }*/
        
        System.out.println("El tamano del arreglo es: " + aprueba.length);
        System.out.println("El numero de pasos con Monticulo es: " + contadorPasosHeap);
        System.out.println("El numero de ciclos con Monticulo es: " + contadorCiclosHeap + "\n");
            
    }
    
    // Para hacer el montículo de un subarreglo de aprueba con nodo i
    public static int heapify(int aprueba[], int n, int i,int contadorPasosHeap) {
         // Contador de ciclos
        int mayor = i; // Inicializar el mayor como raíz
        int izq = 2 * i + 1; // izquierda = 2*i + 1
        int der = 2 * i + 2; // derecha = 2*i + 2
    
        // Si el hijo izquierdo es mayor que la raíz
        if (izq < n && aprueba[izq] > aprueba[mayor]){
            mayor = izq;
            contadorPasosHeap+=1;
        }    
        contadorPasosHeap+=1;
    
        // Si el hijo derecho es mayor que el mayor hasta ahora
        if (der < n && aprueba[der] > aprueba[mayor]){
            mayor = der;
            contadorPasosHeap+=1;
        }
        contadorPasosHeap+=2;
        // Si el mayor no es la raíz
        if (mayor != i) {
            int intercambiar = aprueba[i];
            aprueba[i] = aprueba[mayor];
            aprueba[mayor] = intercambiar;
            contadorPasosHeap+=4;
            
            // Recursivamente hacer el montículo del subarreglo afectado
            heapify(aprueba, n, mayor,contadorPasosHeap);
        }
        contadorCiclosHeap+=1;
        return contadorPasosHeap;
    }
    
}
