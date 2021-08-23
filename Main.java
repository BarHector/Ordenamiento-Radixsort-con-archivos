package Ordenamiento.RadixsortArchivos;

import java.util.Scanner;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int orden=0;
        String nameFile="";
        
        System.out.print("\nIngresa el nombre del archivo a ordenar(debe de incluir la extension): ");
        nameFile = read.next();
        File archivo = new File(nameFile);

        while(!archivo.exists()){ //COMPROBANDO QUE EL ARCHIVO EXISTA
            System.out.print("\n***** EL ARCHIVO NO EXISTE *****\nIngresa otro nombre, no olvides agregar la extension: ");
            nameFile = read.nextLine();
            archivo = new File(nameFile);
        }

        System.out.print("\nESCOGE LA MANERA DE ORDENAR:\n1. Ascendente\n2. Descendente\nOpcion: ");
        orden = read.nextInt();
        while(orden <= 0 || orden >= 3){ //COMPROBANDO QUE EL MÉTODO DE ORDENAMIENTO SEA CORRECTO
            System.out.print("\n!!!!! OPCION INVALIDA, ESCOGE UNA QUE NO LO SEA !!!!!\n\n ESCOGE LA MANERA DE ORDENAR:\n1. Ascendente\n2. Descendente\nOpcion:");
            orden = read.nextInt();
        }

        read.close(); //CERRANDO LA ENTRADA

        Radixsort metodoTres = new Radixsort(); //CREANDO OBJETO
        metodoTres.readFileRS(nameFile, orden); //MANDANDO A LLAMAR EL MÉTODO
                
        System.out.println("\n########## Los archivos donde están las iteraciones y donde está el resultado final se encuentran en la carpeta ProjectOne ##########");
    }
}