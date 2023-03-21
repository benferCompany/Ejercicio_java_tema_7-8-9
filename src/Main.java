

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Función Reverse
        System.out.println("--------------------------------");

        System.out.println(reverse("hola mundo"));
        System.out.println("--------------------------------");

        // Lección 1
        System.out.println("Lección - 1");
        System.out.println("--------------------------------");

        String[] arrayString  = new String[]{"Nombre", "apellido", "dirección", "telefono", "profesión"};

        for(String dato : arrayString){
            System.out.println(dato);
        }

        System.out.println("--------------------------------");

        //Lección 2

        System.out.println("Lección - 2");
        System.out.println("--------------------------------");

        int[][] arrayBidimensional = {{1,2},{3,4},{5,6}};

        for (int[] ints : arrayBidimensional) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }

        System.out.println("--------------------------------");

        //Lección 3
        System.out.println("Lección - 3");
        System.out.println("--------------------------------");

        Vector<String> vector = new Vector<>();

        vector.add("Benjamín");
        vector.add("Fernanda");
        vector.add("Eunice");
        vector.add("Anna");
        vector.add("Naim");

        System.out.println(vector);

        vector.remove(1);
        vector.remove(2);
        System.out.println(vector);




        System.out.println("--------------------------------");

        //Lección 4
        System.out.println("Lección - 4");
        System.out.println("--------------------------------");

        /*El problema del uso del Vector es cuando pasa la capacidad maxima se duplica hasta llegar a la cantidad requerida,
        y ese proceso consume mucho recurso...*/

        System.out.println("El problema de Vector es cuando pasa la capacidad maxima se duplica hasta llegar a la cantidad requerida,");
        System.out.println("y ese proceso consume mucho recurso");

        System.out.println("--------------------------------");

        //Lección 5
        System.out.println("Lección - 5");
        System.out.println("--------------------------------");

        ArrayList<String> lista = new ArrayList<>();

        lista.add("Elemento - 1");
        lista.add("Elemento - 2");
        lista.add("Elemento - 3");
        lista.add("Elemento - 4");
        System.out.println("---------------Iterado ArrayList-----------------");
        for(String l: lista){
            System.out.println(l);
        }

        LinkedList<String> listaLinkedList = new LinkedList<>(lista);

        System.out.println("---------------Iterado LinkedList-----------------");
        for(String l : listaLinkedList){
            System.out.println(l);
        }


        System.out.println("--------------------------------");

        //Lección 6
        System.out.println("Lección - 6");
        System.out.println("--------------------------------");
        ArrayList<Integer> arrayInteger = new ArrayList<>();

       for(int i = 1 ; i <= 10; i ++){
           arrayInteger.add(i);
       }

        for(int i = 0; i < arrayInteger.size()-1; i++){
            if(arrayInteger.get(i)%2==0){

                arrayInteger.remove(i);

            }
            System.out.println(arrayInteger.get(i));

        }

        System.out.println("--------------------------------");

        //Lección 7
        System.out.println("Lección - 7");
        System.out.println("--------------------------------");

        try {
            DividePorCero(3,0);
        }catch(Exception e){
            System.out.println("Esto no puede hacerse");
        }


        System.out.println("--------------------------------");

        //Lección 8
        System.out.println("Lección - 8");
        System.out.println("--------------------------------");

        try{
            copiarFichero("entrada.txt","salida.txt");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }


        System.out.println("--------------------------------");

        //Lección 8
        System.out.println("Lección - 8");
        System.out.println("--------------------------------");
        try{
            programa();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }




    }

    public static String reverse(String texto){
        return new StringBuilder(texto).reverse().toString();
    }

    public static void DividePorCero(int num1, int num2) throws ArithmeticException{
        int resultado = num1/num2;
        System.out.println(resultado);
    }

    public static void copiarFichero(String entrada,String salida) throws IOException {

        InputStream in = new FileInputStream(entrada);
        byte[] datos = in.readAllBytes();

        PrintStream out = new PrintStream(salida);
        out.write(datos);

    }

    public static void programa() throws IOException {


        HashMap<Integer,String> articulos = new HashMap<>();

        ArrayList<String> lista = new ArrayList<>();

        articulos.put(1,"Banana");
        articulos.put(2,"Manzana");
        articulos.put(3,"Tomate");
        articulos.put(4,"Uva");
        articulos.put(5,"Ciruela");


        int articulo;

        System.out.println("Bienvenido, Por favor ingrease un articulo para llenar tu canasta.");

        for (int i=1;i <articulos.size()+1;i++){
            System.out.println(i+" "+articulos.get(i));
        }

        int cerrar = articulos.size()+1;
        System.out.println("Presione "+cerrar+" para terminar");


        while(true){
           try {
               Scanner sc = new Scanner(System.in);
               articulo = sc.nextInt();
           }catch (Exception e){
               articulo=0;
           }

            if(articulo==cerrar){

                break;
            }
            if(articulos.get(articulo)!=null){
                lista.add(articulos.get(articulo));
                System.out.println("Se ha agregado "+articulos.get(articulo)+ " a la canasta");
            }else{
                System.out.println("Por favor ingrese un dato valio");
            }


        }



        String cadena="";
        for (String l : lista){
            cadena= cadena+l+"\n";
        }

        agregarCanastaAlFichero( cadena,"canasta.txt");
    }

    public static void agregarCanastaAlFichero(String entrada,String salida) throws IOException {

        if(entrada.equals("")){
            entrada="Tu canasta no tiene frutas.";
            System.out.println("Tu canasta no tiene articulos, por favor vuelva a iniciar el programa y elija una o mas frutas para su canasta");
        }else{
            System.out.println("Esta es la lista de articulos que elejiste");
            System.out.println(entrada);
            System.out.println("Las frutas que elejiste fueron cargado en un archivo canasta.txt en su carpeta prinpical.");
        }
        byte[] datos = entrada.getBytes();

        PrintStream out = new PrintStream(salida);
        out.write(datos);

    }

}