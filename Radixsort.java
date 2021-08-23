package Ordenamiento.RadixsortArchivos;

import java.io.*;
import java.util.*;

public class Radixsort {
    static List<String> listaUnidades = new LinkedList<>();
    static List<String> listaDecenas = new LinkedList<>();
    static List<String> listaCentenas = new LinkedList<>();
    static List<String> listaMiles  = new LinkedList<>();
    static List<String> numeros = new LinkedList<>();
    
    public void readFileRS(String nombreArchivo, int dir){ //LECTURA DEL ARCHIVO
        File archivo = new File(nombreArchivo); //OBJETO ARCHIVO CON EL NOMBRE IDICADO
        String elemento;

        try{
            BufferedReader entrada = new BufferedReader(new FileReader(archivo)); //BUFFERED: LEER LINEAS COMPLETAS DEL ARCHIVO, FILEREADER NO LEE LINEAS COMPLETAS, FILE READER TIENE LA INFOMRACION NECESARIA SOBRE EL ARCHIVO QUE SE VA A LEER(RUTA)
            String lectura = entrada.readLine(); //LEER LINEAS COMPLETAS, LEE SOLO LA PRIMER LINEA 1234,134566
            while(lectura != null){ //COMPROBANDO QUE LA LINEA NO ESTÉ VACIA
                for (int i = 0; i <= lectura.length()-1 && i+4 <= lectura.length(); i++){ 
                    if(!lectura.substring(i, i+4).contains(",") && !lectura.substring(i, i+4).contains(" ")){ //OBTENIENDO LOS NÚMEROS
                        elemento = lectura.substring(i, i+4); //PASANDO EL NÚMERO LEIDO A UNA VARIABLE
                        numeros.add(elemento); //SE AGREGA LA VARIABLE A UNA LISTA (LISTA CON EL ORDEN ORIGINAL)
                    }
                }
                lectura = entrada.readLine(); //LEE LA SIGUIENTE LINEA
            }
            entrada.close(); //SE CIERRA EL FLUJO DE ENTRADA
        }catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }catch (IOException ex){
            ex.printStackTrace(System.out);
        }

        //DEPENDIENDO DEL ORDEN ESCOGIDO POR EL USUARIO SE EJECUTARA UN MÉTODO
        if(dir == 1){
            ordenAscendente();
        }else{
            ordenDescendente();
        }
    }

    private void ordenAscendente(){
        //CREANDO OBJETOS 
        File fiCero = new File("FileZero.txt");
        File fiUno = new File("FileOne.txt");
        File fiDos = new File("FileTwo.txt");
        File fiTres = new File("FileThree.txt");
        File fiCuatro = new File("FileFour.txt");
        File fiCinco = new File("FileFive.txt");
        File fiSeis = new File("FileSix.txt");
        File fiSiete = new File("FileSeven.txt");
        File fiOcho = new File("FileEight.txt");
        File fiNueve = new File("FileNine.txt");

        //COMPROBANDO LA EXISTENCIA DE LOS ARCHIVOS
            comprobandoArchivo(fiCero, "FileZero.txt");
            comprobandoArchivo(fiUno, "FileOne.txt");
            comprobandoArchivo(fiDos, "FileTwo.txt");
            comprobandoArchivo(fiTres, "FileThree.txt");
            comprobandoArchivo(fiCuatro, "FileFour.txt");
            comprobandoArchivo(fiCinco, "FileFive.txt");
            comprobandoArchivo(fiSeis, "FileSix.txt");
            comprobandoArchivo(fiSiete, "FileSeven.txt");
            comprobandoArchivo(fiOcho, "FileEight.txt");
            comprobandoArchivo(fiNueve, "FileNine.txt");
            
        //ASIGNANDO UBICACION POR UNIDADES, DEL ARCHIVO ORIGINAL A LOS AUXILIARES
            unidades("FileZero.txt", 0); //EL SEGUNDO NÚMERO CORRESPONDE AL NÚMERO QUE SE BUSCARÁ EN LA POSICIÓN DE LAS UNIDADES
            unidades("FileOne.txt", 1);
            unidades("FileTwo.txt", 2);
            unidades("FileThree.txt", 3);
            unidades("FileFour.txt", 4);
            unidades("FileFive.txt", 5);
            unidades("FileSix.txt", 6);
            unidades("FileSeven.txt", 7);
            unidades("FileEight.txt", 8);
            unidades("FileNine.txt", 9);
            backToOriginal("numeros.txt", 1); //REGRESANDO LOS ELEMENTOS AL ARCHIVO ORIGINAL ORDENADOS POR UNIDADES
            //EL SEGUNDO NÚMERO DEL MÉTODO 'BACKTOORIGINAL' SOLO SIRVE PARA LA IMPRESIÓN EN EL ARCHIVO ORIGINAL 

        //ASIGNANDO UBICACION POR DECENAS, DEL ARCHIVO ORIGINAL A LOS AUXILIARES
            decenas("FileZero.txt", 0); //EL SEGUNDO NÚMERO CORRESPONDE AL NÚMERO QUE SE BUSCARÁ EN LA POSICIÓN DE LAS DECENAS
            decenas("FileOne.txt", 1);
            decenas("FileTwo.txt", 2);
            decenas("FileThree.txt", 3);
            decenas("FileFour.txt", 4);
            decenas("FileFive.txt", 5);
            decenas("FileSix.txt", 6);
            decenas("FileSeven.txt", 7);
            decenas("FileEight.txt", 8);
            decenas("FileNine.txt", 9);
            backToOriginal("numeros.txt", 2); //REGRESANDO LOS ELEMENTOS AL ARCHIVO ORIGINAL ORDENADOS POR DECENAS
            //EL SEGUNDO NÚMERO DEL MÉTODO 'BACKTOORIGINAL' SOLO SIRVE PARA LA IMPRESIÓN EN EL ARCHIVO ORIGINAL

        //ASIGNANDO UBICACION POR CENTENAS, DEL ARCHIVO ORIGINAL A LOS AUXILIARES
            centenas("FileZero.txt", 0); //EL SEGUNDO NÚMERO CORRESPONDE AL NÚMERO QUE SE BUSCARÁ EN LA POSICIÓN DE LAS CENTENAS
            centenas("FileOne.txt", 1);
            centenas("FileTwo.txt", 2);
            centenas("FileThree.txt", 3);
            centenas("FileFour.txt", 4);
            centenas("FileFive.txt", 5);
            centenas("FileSix.txt", 6);
            centenas("FileSeven.txt", 7);
            centenas("FileEight.txt", 8);
            centenas("FileNine.txt", 9);
            backToOriginal("numeros.txt", 3); //REGRESANDO LOS ELEMENTOS AL ARCHIVO ORIGINAL ORDENADOS POR CENTENAS
            //EL SEGUNDO NÚMERO DEL MÉTODO 'BACKTOORIGINAL' SOLO SIRVE PARA LA IMPRESIÓN EN EL ARCHIVO ORIGINAL

        //ASIGNANDO UBICACION POR MILES, DEL ARCHIVO ORIGINAL A LOS AUXILIARES
            miles("FileZero.txt", 0); //EL SEGUNDO NÚMERO CORRESPONDE AL NÚMERO QUE SE BUSCARÁ EN LA POSICIÓN DE LOS MILES
            miles("FileOne.txt", 1);
            miles("FileTwo.txt", 2);
            miles("FileThree.txt", 3);
            miles("FileFour.txt", 4);
            miles("FileFive.txt", 5);
            miles("FileSix.txt", 6);
            miles("FileSeven.txt", 7);
            miles("FileEight.txt", 8);
            miles("FileNine.txt", 9);
            backToOriginal("numeros.txt", 4); //REGRESANDO LOS ELEMENTOS AL ARCHIVO ORIGINAL ORDENADOS POR MILES
            //EL SEGUNDO NÚMERO DEL MÉTODO 'BACKTOORIGINAL' SOLO SIRVE PARA LA IMPRESIÓN EN EL ARCHIVO ORIGINAL
        
        System.out.println("\nLAS CLAVES HAN SIDO ORDENADAS Y SE ENCUENTRAN EN EL ARCHIVO: numeros.txt");

        //ELIMINANDO LOS DATOS QUE TIENE CADA LISTA
        listaUnidades.clear(); 
        listaDecenas.clear();
        listaCentenas.clear();
        listaMiles.clear();
    }

    private void ordenDescendente(){
        //CREANDO OBJETOS
        File fiCero = new File("FileZero.txt");
        File fiUno = new File("FileOne.txt");
        File fiDos = new File("FileTwo.txt");
        File fiTres = new File("FileThree.txt");
        File fiCuatro = new File("FileFour.txt");
        File fiCinco = new File("FileFive.txt");
        File fiSeis = new File("FileSix.txt");
        File fiSiete = new File("FileSeven.txt");
        File fiOcho = new File("FileEight.txt");
        File fiNueve = new File("FileNine.txt");

        //COMPROBANDO LA EXISTENCIA DE LOS ARCHIVOS
            comprobandoArchivo(fiCero, "FileZero.txt");
            comprobandoArchivo(fiUno, "FileOne.txt");
            comprobandoArchivo(fiDos, "FileTwo.txt");
            comprobandoArchivo(fiTres, "FileThree.txt");
            comprobandoArchivo(fiCuatro, "FileFour.txt");
            comprobandoArchivo(fiCinco, "FileFive.txt");
            comprobandoArchivo(fiSeis, "FileSix.txt");
            comprobandoArchivo(fiSiete, "FileSeven.txt");
            comprobandoArchivo(fiOcho, "FileEight.txt");
            comprobandoArchivo(fiNueve, "FileNine.txt");    

         //ASIGNANDO UBICACION POR UNIDADES, DEL ARCHIVO ORIGINAL A LOS AUXILIARES
            unidades("FileNine.txt", 9); //EL SEGUNDO NÚMERO CORRESPONDE AL NÚMERO QUE SE BUSCARÁ EN LA POSICIÓN DE LAS UNIDADES
            unidades("FileEight.txt", 8);    
            unidades("FileSeven.txt", 7);    
            unidades("FileSix.txt", 6);
            unidades("FileFive.txt", 5);
            unidades("FileFour.txt", 4);
            unidades("FileThree.txt", 3);
            unidades("FileTwo.txt", 2);
            unidades("FileOne.txt", 1);
            unidades("FileZero.txt", 0);   
            backToOriginal("numeros.txt", 1); //REGRESANDO LOS ELEMENTOS AL ARCHIVO ORIGINAL ORDENADOS POR MILES
            //EL SEGUNDO NÚMERO DEL MÉTODO 'BACKTOORIGINAL' SOLO SIRVE PARA LA IMPRESIÓN EN EL ARCHIVO ORIGINAL
        
        //ASIGNANDO UBICACION POR DECENAS, DEL ARCHIVO ORIGINAL A LOS AUXILIARES
            decenas("FileNine.txt", 9); //EL SEGUNDO NÚMERO CORRESPONDE AL NÚMERO QUE SE BUSCARÁ EN LA POSICIÓN DE LAS DECENAS
            decenas("FileEight.txt", 8);    
            decenas("FileSeven.txt", 7);    
            decenas("FileSix.txt", 6);
            decenas("FileFive.txt", 5);
            decenas("FileFour.txt", 4);
            decenas("FileThree.txt", 3);
            decenas("FileTwo.txt", 2);
            decenas("FileOne.txt", 1);
            decenas("FileZero.txt", 0);
            backToOriginal("numeros.txt", 2); //REGRESANDO LOS ELEMENTOS AL ARCHIVO ORIGINAL ORDENADOS POR MILES
            //EL SEGUNDO NÚMERO DEL MÉTODO 'BACKTOORIGINAL' SOLO SIRVE PARA LA IMPRESIÓN EN EL ARCHIVO ORIGINAL

        //ASIGNANDO UBICACION POR CENTENAS, DEL ARCHIVO ORIGINAL A LOS AUXILIARES
            centenas("FileNine.txt", 9); //EL SEGUNDO NÚMERO CORRESPONDE AL NÚMERO QUE SE BUSCARÁ EN LA POSICIÓN DE LAS CENTENAS
            centenas("FileEight.txt", 8);    
            centenas("FileSeven.txt", 7);    
            centenas("FileSix.txt", 6);
            centenas("FileFive.txt", 5);
            centenas("FileFour.txt", 4);
            centenas("FileThree.txt", 3);
            centenas("FileTwo.txt", 2);
            centenas("FileOne.txt", 1);
            centenas("FileZero.txt", 0);
            backToOriginal("numeros.txt", 3); //REGRESANDO LOS ELEMENTOS AL ARCHIVO ORIGINAL ORDENADOS POR MILES
            //EL SEGUNDO NÚMERO DEL MÉTODO 'BACKTOORIGINAL' SOLO SIRVE PARA LA IMPRESIÓN EN EL ARCHIVO ORIGINAL
            
        //ASIGNANDO UBICACION POR MILES, DEL ARCHIVO ORIGINAL A LOS AUXILIARES
            miles("FileNine.txt", 9); //EL SEGUNDO NÚMERO CORRESPONDE AL NÚMERO QUE SE BUSCARÁ EN LA POSICIÓN DE LOS MILES
            miles("FileEight.txt", 8);    
            miles("FileSeven.txt", 7);    
            miles("FileSix.txt", 6);
            miles("FileFive.txt", 5);
            miles("FileFour.txt", 4);
            miles("FileThree.txt", 3);
            miles("FileTwo.txt", 2);
            miles("FileOne.txt", 1);
            miles("FileZero.txt", 0);
            backToOriginal("numeros.txt", 4); //REGRESANDO LOS ELEMENTOS AL ARCHIVO ORIGINAL ORDENADOS POR MILES
            //EL SEGUNDO NÚMERO DEL MÉTODO 'BACKTOORIGINAL' SOLO SIRVE PARA LA IMPRESIÓN EN EL ARCHIVO ORIGINAL
    }

    private void comprobandoArchivo(File nombre, String nombreArchivo){
        if(nombre.exists()){ //SI EL ARCHIVO AUXILIAR EXISTE ...
            cleanFile(nombre); //SE BORRA LO QUE HAYA EN EL 
        }else{ //SI NO EXISTE, SE CREA
            File archivoCreado = new File(nombreArchivo);
            try{
                PrintWriter read = new PrintWriter(archivoCreado);
                read.close();
                System.out.println("Se ha creado el archivo: " + nombreArchivo);
            }catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    private void backToOriginal(String nombreArchivo, int n){
        File archivo = new File(nombreArchivo);

        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true)); 
            salida.println("\n\nITERACIÓN #" + n); 
            if(n == 1){ //'n' FUNCIONA PARA SABER QUE LISTA SE IMPRIMIRA AL ARCHIVO ORIGINAL, EN ESTE CASO ES PARA UNIDADES
                salida.println(listaUnidades); 
            }else if(n == 2){ //PARA DECENAS
                salida.println(listaDecenas);
            }else if(n == 3){ //PARA CENTENAS
                salida.println(listaCentenas);
            }else{ //PARA EL ORDEN FINAL
                salida.println("********** ELEMENTOS ORDENADOS **********\n" + listaMiles);
            }
            salida.close(); //SE CIERRA LA ESCRITURA
            System.out.println("Se ha escrito nueva información sobre: " + nombreArchivo);
        }catch (FileNotFoundException ex) { 
            ex.printStackTrace(System.out);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
        }    
    }

    private List<String> unidades(String nombreArchivo, int digito){ //FUNCIÓN PARA LA LISTA DE LOS NÚMEROS ORDENADOS POR UNIDADES
        File archivo = new File(nombreArchivo);
        
        primeraImpresion(archivo, digito, 1); //SE IMPRIME ALGO SOBRE EL ARCHIVO RESPECTO A LAS UNIDADES Y CON EL DÍGITO QUE SE BUSCA

        // -> POSIBLE MEJORA, EVITAR IR POSICIÓN POR POSICIÓN PARA BUSCAR LOS NÚMEROS COMPLETOS

        for (int i = 0; i < numeros.size(); i++) {
            String elementoAgregar = numeros.get(i);  //GUARDANDO EL ELEMENTO DE LA LISTA ORIGINAL 
            if(Integer.parseInt(elementoAgregar.substring(3, 4)) == digito){ //AL SER UN 'STRING' SE OBTIENE EL NÚMERO CORRESPONDIENTE A LAS UNIDADES Y SE CONVIERTE A ENTERO
                try{
                    listaUnidades.add(elementoAgregar); //SE AGREGA EL ELEMENTO A LA LISTA DE UNIDADES
                    PrintWriter salida = new PrintWriter(new FileWriter(archivo, true)); //PARA ESCRIBIR SIN PERDER LOS DATOS EN EL ARCHIVO
                    salida.print(numeros.get(i) + " , "); //SE IMPRIME EL ELEMENTO SOBRE EL ARCHIVO
                    salida.close();
                }catch (FileNotFoundException ex) { 
                    ex.printStackTrace(System.out);
                }catch (IOException ex) { 
                    ex.printStackTrace(System.out);
                }
            }   
        }
        
        ultimaImpresion(archivo);  //SALTOS DE LINEA PARA SEPARAR LAS ITERACIONES

        return listaUnidades;
    }

    private List<String> decenas(String nombreArchivo, int digito){ //FUNCIÓN PARA LA LISTA DE LOS NÚMEROS ORDENADOS POR DECENAS
        File archivo = new File(nombreArchivo);
        
        primeraImpresion(archivo, digito, 2); //SE IMPRIME ALGO SOBRE EL ARCHIVO RESPECTO A LAS DECENAS Y CON EL DÍGITO QUE SE BUSCA

        for (int i = 0; i < listaUnidades.size(); i++) {
            String elementoAgregar = listaUnidades.get(i); //GUARDANDO EL ELEMENTO DE LA LISTA DE UNIDADES
            if(Integer.parseInt(elementoAgregar.substring(2, 3)) == digito){ //AL SER UN 'STRING' SE OBTIENE EL NÚMERO CORRESPONDIENTE A LAS DECENAS Y SE CONVIERTE A ENTERO
                try{
                    listaDecenas.add(elementoAgregar); //SE AGREGA EL ELEMENTO A LA LISTA DE DECENAS
                    PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));  //PARA ESCRIBIR SIN PERDER LOS DATOS EN EL ARCHIVO
                    salida.print(listaUnidades.get(i) + " , "); //SE IMPRIME EL ELEMENTO SOBRE EL ARCHIVO
                    salida.close();
                }catch (FileNotFoundException ex) { 
                    ex.printStackTrace(System.out);
                } catch (IOException ex) { 
                    ex.printStackTrace(System.out);
                }
            }   
        }

        ultimaImpresion(archivo);  //SALTOS DE LINEA PARA SEPARAR LAS ITERACIONES

        return listaDecenas;
    }

    private List<String> centenas(String nombreArchivo, int digito){ //FUNCIÓN PARA LA LISTA DE LOS NÚMEROS ORDENADOS POR DECENAS
        File archivo = new File(nombreArchivo);
        
        primeraImpresion(archivo, digito, 3); //SE IMPRIME ALGO SOBRE EL ARCHIVO RESPECTO A LAS CENTENAS Y CON EL DÍGITO QUE SE BUSCA
        
        for (int i = 0; i < listaDecenas.size(); i++) {
            String elementoAgregar = listaDecenas.get(i);  //GUARDANDO EL ELEMENTO DE LA LISTA DE DECENAS
            if(Integer.parseInt(elementoAgregar.substring(1, 2)) == digito){ //AL SER UN 'STRING' SE OBTIENE EL NÚMERO CORRESPONDIENTE A LAS CENTENAS Y SE CONVIERTE A ENTERO
                try{
                    listaCentenas.add(elementoAgregar); //SE AGREGA EL ELEMENTO A LA LISTA DE CENTENAS
                    PrintWriter salida = new PrintWriter(new FileWriter(archivo, true)); //PARA ESCRIBIR SIN PERDER LOS DATOS EN EL ARCHIVO
                    salida.print(listaDecenas.get(i) + " , "); //SE IMPRIME EL ELEMENTO SOBRE EL ARCHIVO
                    salida.close();
                }catch (FileNotFoundException ex) { 
                    ex.printStackTrace(System.out);
                } catch (IOException ex) { //Catch de FileWriter
                    ex.printStackTrace(System.out);
                }
            }   
        }
        ultimaImpresion(archivo);  //SALTOS DE LINEA PARA SEPARAR LAS ITERACIONES

        return listaCentenas;
    }

    private List<String> miles(String nombreArchivo, int digito){ //FUNCIÓN PARA LA LISTA DE LOS NÚMEROS ORDENADOS POR MILES
        File archivo = new File(nombreArchivo);
        
        primeraImpresion(archivo, digito, 4); //SE IMPRIME ALGO SOBRE EL ARCHIVO RESPECTO A LOS MILES Y CON EL DÍGITO QUE SE BUSCA

        for (int i = 0; i < listaCentenas.size(); i++) {
            String elementoAgregar = listaCentenas.get(i); //GUARDANDO EL ELEMENTO DE LA LISTA DE CENTENAS
            if(Integer.parseInt(elementoAgregar.substring(0, 1)) == digito){ //AL SER UN 'STRING' SE OBTIENE EL NÚMERO CORRESPONDIENTE A LAS MILES Y SE CONVIERTE A ENTERO
                try{
                    listaMiles.add(elementoAgregar); //SE AGREGA EL ELEMENTO A LA LISTA DE MILES
                    PrintWriter salida = new PrintWriter(new FileWriter(archivo, true)); //PARA ESCRIBIR SIN PERDER LOS DATOS EN EL ARCHIVO
                    salida.print(listaCentenas.get(i) + " , "); //SE IMPRIME EL ELEMENTO SOBRE EL ARCHIVO
                    salida.close();
                }catch (FileNotFoundException ex) { 
                    ex.printStackTrace(System.out);
                } catch (IOException ex) { 
                    ex.printStackTrace(System.out);
                }
            }   
        }

        ultimaImpresion(archivo); //SALTOS DE LINEA PARA SEPARAR LAS ITERACIONES

        return listaMiles;
    }

    private void primeraImpresion(File archivo, int digito, int i){ //IMPRESION SOBRE CADA ARCHIVO PARA VER LAS ITERACIONES
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            
            if(i == 1){ //SI SE ORDENA POR UNIDADES...
                salida.println("------- NUMERO " + digito + " EN LAS UNIDADES -------");
            }else if(i == 2){ //POR DECENAS ...
                salida.println("------- NUMERO " + digito + " EN LAS DECENAS -------");
            }else if(i == 3){ //POR CENTENAS ...
                salida.println("------- NUMERO " + digito + " EN LAS CENTENAS -------");
            }else{ //POR MILES ...
                salida.println("------- NUMERO " + digito + " EN LOS MILES -------");
            }
            
            salida.close();
        }catch (FileNotFoundException ex) { 
            ex.printStackTrace(System.out);
        } catch (IOException ex) { //Catch de FileWriter
            ex.printStackTrace(System.out);
        }
    }

    private void ultimaImpresion(File archivo){ //SALTOS DE LINEA PARA SEPARAR CADA ITERACIÓN
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println("\n\n");
            salida.close();
        }catch (FileNotFoundException ex) { 
            ex.printStackTrace(System.out);
        } catch (IOException ex) { //Catch de FileWriter
            ex.printStackTrace(System.out);
        }
    }
    
    private void cleanFile(File nombreArchivo){ //ELIMINAR TODO LO QUE EXISTA EN EL ARCHIVO
        try{
            PrintWriter archivo = new PrintWriter(nombreArchivo); //SE ELIMINARÁ TODO LO QUE EXISTA EN EL ARCHIVO
            archivo.println(""); 
            archivo.close();
        }catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
}