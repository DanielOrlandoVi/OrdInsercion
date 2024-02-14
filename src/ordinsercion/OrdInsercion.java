
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
    }
    
    //Este ordenamiento funciona igual que como organizamos tarjetas en la vida real 
    public static void insercion(int arreglo[]){
        for (int i = 1; i < arreglo.length; i++){
            
            int aux = arreglo[i]; //En donde me ubico en el arreglo
            
            //Recorro parte izquierda del arreglo
            for (int j = i - 1; j < i & j >= 0 ; j--){
                if(arreglo[j] > aux){ //Si en mi recorrido me encuentro con alguien menor a donde estoy, haz esto
                arreglo[j+1] = arreglo[j]; //Muevo el mayor una posicion al frente abriendo campo para el menor
                arreglo[j] = aux; //En la posicion libre pongo al menor
                }
            }
        }
        System.out.println("El arreglo ordenado por insercion es : " + "\n");
        for (int k = 0; k < arreglo.length; k++){
            System.out.println(arreglo[k]);
        }
    
    }
    
}
