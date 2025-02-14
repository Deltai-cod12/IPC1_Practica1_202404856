/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sopadeletras;

import java.util.Arrays;
import java.util.Scanner;

public class SopaDeLetras {
    //En esta parte se almacenan los datos como lo son las Palabras, El Usuario, Puntuaciones, etc.
    static String[] Palabras = new String[0]; 
    static String[] Usuario = new String[100];
    static int[] Puntuaciones = new int[100];
    static int[] PalabrasEncontradas = new int[100];
    static int[] Fallos = new int[100];
    static int[] PuntuacionesAltas = new int[100];
    
    static int ContadorDeJugadores = 0;
    
    
    public static void main(String[] args) {
        MenuBienvenida();
    }

    static void MenuBienvenida() {
        Scanner leer = new Scanner(System.in);
        int num;
        //Aqui mostramos el menu principal
        System.out.println("______________________________________");
        System.out.println("Autor: Angel Emanuel Rodriguez Corado");
        System.out.println("Carnet: 202404856");
        System.out.println("Seccion: E");
        System.out.println("______________________________________");
        

        System.out.print("---------------SOPA DE LETRAS--------------");
        System.out.println("\n---------------------------------------");
        System.out.println("Elige el numero según lo que desees:");
        System.out.println("[1] Nueva Partida");
        System.out.println("[2] Historial de Partidas");
        System.out.println("[3] Puntuacion mas alta");
        System.out.println("[4] Salir");
        System.out.print("Ingrese su eleccion: ");

        num = leer.nextInt();
        leer.nextLine();

        switch (num) {
            case 1 -> MenuNuevaPartida();
            case 2 -> MenuHistorial();
            case 3 -> MenuPuntuacion();
            case 4 -> System.exit(0);
            default -> System.out.println("Opcion invalida, intenta nuevamente.");
        }
    }

    static void MenuNuevaPartida() {
        //Aqui mostramos el menu de la partida, donde podra agregar, modificar, eliminar o iniciar la partida.
        Scanner leer = new Scanner(System.in);
        byte menu;

        do {
            System.out.println("--------------------------------------------------");
            System.out.println("""
                               Ingrese el numero correspondiente a lo que desee
                               [1] Agregar palabras
                               [2] Modificar palabras
                               [3] Eliminar palabra
                               [4] Iniciar Partida
                               [5] Salir
                               
                               """);
            System.out.print("Ingrese su eleccion: ");
            menu = leer.nextByte();

            switch (menu) {
                case 1:
                    System.out.println("-------------------------------------------------");
                    System.out.print("Ingrese el numero de palabras que desees: ");
                    int NumeroDePalabras = leer.nextInt();
                    Palabras = IngresoDePalabras(NumeroDePalabras); //Guardar variable global

                    if (Palabras.length != 0) {
                        System.out.println("Palabras ingresadas:");
                        for (int i = 0; i < Palabras.length; i++) {
                            System.out.println("[" + i + "] " + Palabras[i]);
                        }
                    }
                    break;

                case 2:
                    ModificarPalabras();
                    break;

                case 3:
                    EliminarPalabras();
                    break;
                
                case 4:  
                    IniciarPartida();
                    break;
                case 5:
                    System.out.println("Saliendo al menu principal...");
                    MenuBienvenida();
                    break;

                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }

        } while (menu != 4);
    }

    static void MenuHistorial() {
        //En este menu se muestran todas las partidas de los distintos Usuarios, se muestran datos como su puntuacion, aciertos y fallos.
        System.out.println("HISTORIAL DE PARTIDAS");
        System.out.println("Se mostraran los datos de los Usuarios ingresados");
        for (int i = 0; i < ContadorDeJugadores; i++) {
        System.out.println("Jugador #" + (i + 1));
        System.out.println("Usuario: " + Usuario[i]);
        System.out.println("Puntuaciones: " + Puntuaciones[i]);
        System.out.println("Aciertos: " + PalabrasEncontradas[i]);
        System.out.println("Fallos: " + Fallos[i]);
        System.out.println("--------------------------------------");
    }
    }
    
    static void MenuPuntuacion() {
    //En esta parte se muestra la posicion de mayor a menor de cada Usuario dependiendo su punteo.
    System.out.println("A continuación se muestra el punteo de los jugadores (de mayor a menor):");
    
    if (ContadorDeJugadores == 0) {
        System.out.println("No se han registrado partidas aun.");
        return;
    }
    
    int[] indices = new int[ContadorDeJugadores];
    for (int i = 0; i < ContadorDeJugadores; i++) {
        indices[i] = i;
    }
    
    for (int i = 0; i < ContadorDeJugadores - 1; i++) {
        for (int j = i + 1; j < ContadorDeJugadores; j++) {
            if (Puntuaciones[indices[i]] < Puntuaciones[indices[j]]) {
                int temp = indices[i];
                indices[i] = indices[j];
                indices[j] = temp;
            }
        }
    }
    
    System.out.println("Posicion de jugadores:");
    for (int i = 0; i < ContadorDeJugadores; i++) {
        int index = indices[i];
        System.out.println("-------------------------------------------");
        System.out.println("Posición " + (i + 1) + ": " + Usuario[index] 
                + " - Puntuación: " + Puntuaciones[index]
                + " - Aciertos: " + PalabrasEncontradas[index]
                + " - Fallos: " + Fallos[index]);
    }
}

    static String[] IngresoDePalabras(int NumeroDePalabras) {
        
        //En esta parte le damos instrucciones al Usuario para que pueda ingresar las palabras.
        
        String[] palabras = new String[NumeroDePalabras];
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese palabras de 5 a 10 letras:");
        
        for (int i = 0; i < NumeroDePalabras; i++) {
            String palabra;
            do {
                System.out.print("Palabra [" + (i + 1) + "]: ");
                palabra = leer.next();
                if (palabra.length() < 5 || palabra.length() > 10) {
                    System.out.println("La palabra debe tener entre 5 y 10 letras. Intente de nuevo.");
                }
            } while (palabra.length() < 5 || palabra.length() > 10);

            palabras[i] = palabra;
        }

        return palabras;
    }

    static void ModificarPalabras() {
        
        //En este menu le damos la opcion al Usuario de poder modificar una palabra que haya agregado anteriormente.
        
        Scanner leer = new Scanner(System.in);

        if (Palabras.length == 0) {
            System.out.println("No hay palabras para modificar.");
            return;
        }

        System.out.println("Tus palabras son: " + Arrays.toString(Palabras));
        System.out.print("Ingrese la palabra que desea modificar: ");
        String palabraAntigua = leer.nextLine();

        boolean encontrada = false;
        for (int i = 0; i < Palabras.length; i++) {
            if (Palabras[i].equalsIgnoreCase(palabraAntigua)) {
                System.out.print("Ingrese la nueva palabra: ");
                String nuevaPalabra = leer.nextLine();
                
                if (nuevaPalabra.length() < 5 || nuevaPalabra.length() > 10) {
                    System.out.println("--La palabra debe tener entre 5 y 10 letras--");
                    return;
                }

                Palabras[i] = nuevaPalabra;
                encontrada = true;
                System.out.println("--Palabra modificada con exito--");
                break;
            }
        }

        if (!encontrada) {
            System.out.println("--La palabra no fue encontrada--");
        }
    }
   
    static void EliminarPalabras() {
        
        //En este apartado le damos la opcion al Usuario de poder eliminar una palabra que haya ingresado anteriormente
        
        Scanner leer = new Scanner(System.in);

        if (Palabras.length == 0) {
            System.out.println("--No hay palabras para eliminar--");
            return;
        }

        System.out.println("Tus palabras son: " + Arrays.toString(Palabras));
        System.out.print("Ingrese la palabra que desea eliminar: ");
        String palabraAEliminar = leer.nextLine();

        boolean encontrada = false;
        int nuevaLongitud = Palabras.length - 1;
        String[] nuevoArreglo = new String[nuevaLongitud];
        int j = 0;

        for (int i = 0; i < Palabras.length; i++) {
            if (Palabras[i].equalsIgnoreCase(palabraAEliminar)) {
                encontrada = true;
            } else {
                if (j < nuevaLongitud) {
                    nuevoArreglo[j] = Palabras[i];
                    j++;
                }
            }
        }

        if (encontrada) {
            Palabras = nuevoArreglo;
            System.out.println("Palabra eliminada correctamente.");
        } else {
            System.out.println("--La palabra no fue encontrada--");
        }
    }


    static void IniciarPartida() {
        
    //En este apartado se genera la partida y el tablero de juego
        
    char[][] tablero = new char[14][14];
    boolean[][] palabrasEncontradas = new boolean[14][14];
    int intentosFallidos = 0;
    int palabrasRestantes = Palabras.length;
    int puntos = 25;
    int Aciertos = 0;
    Scanner leer = new Scanner(System.in);
    
    System.out.println("Ingrese su nombre de usuario: ");
    String NombreUsuario = leer.nextLine();
    System.out.println("Buena suerte" + NombreUsuario);

    if (Palabras == null || Palabras.length == 0) {
        System.out.println("No hay palabras agregadas.");
        System.out.println("Por favor ingrese sus palabras en el siguiente menu.");
        MenuNuevaPartida();
        return;
    }

    // Iniciamos el tablero con espacios vacios
    for (int f = 0; f < 14; f++) {
        for (int c = 0; c < 14; c++) {
            tablero[f][c] = ' ';
        }
    }

    // Colocamoslas palabras ingresadas por el Usuario en el tablero aleatoriamente (Convertimos las letras de las palabras en mayusculas
    for (String palabra : Palabras) {
        palabra = palabra.toUpperCase();
        boolean colocada = false;
        while (!colocada) {
            int fila = (int) (Math.random() * 14);
            int columna = (int) (Math.random() * 14);
            int direccion = (int) (Math.random() * 2);
            
            // Ajustamos la posición si la palabra se sale del tablero de juego
            if (direccion == 0 && columna + palabra.length() > 14) {
                columna = 14 - palabra.length();
            } else if (direccion == 1 && fila + palabra.length() > 14) {
                fila = 14 - palabra.length();
            }
            
            //Posicion horizontal del tablero
            boolean hayColision = false;
            if (direccion == 0) { 
                for (int i = 0; i < palabra.length(); i++) {
                    if (tablero[fila][columna + i] != ' ') {
                        hayColision = true;
                        break;
                    }
                }
                
            //Posicion vertical del tablero    
            } else { 
                for (int i = 0; i < palabra.length(); i++) {
                    if (tablero[fila + i][columna] != ' ') {
                        hayColision = true;
                        break;
                    }
                }
            }

            if (!hayColision) {
                if (direccion == 0) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila][columna + i] = palabra.charAt(i);
                    }
                } else {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila + i][columna] = palabra.charAt(i);
                    }
                }
                colocada = true;
            }
        }
    }

    // Rellenar espacios vacíos con letras aleatorias
    for (int f = 0; f < 14; f++) {
        for (int c = 0; c < 14; c++) {
            if (tablero[f][c] == ' ') {
                tablero[f][c] = (char) (Math.random() * 26 + 65);
            }
        }
    }
    
    while (intentosFallidos < 4 && palabrasRestantes > 0) {
        // Mostrar el tablero
        System.out.println("  ____________________________");
        System.out.println(" /     Tablero de Juego      /");
        System.out.println("/____________________________/");
        for (int f = 0; f < 14; f++) {
            for (int c = 0; c < 14; c++) {
                if (palabrasEncontradas[f][c]) {
                    System.out.print(" | #");
                } else {
                    System.out.print(" | " + tablero[f][c]);
                }
            }
            System.out.println(" |");
        }
        System.out.println("\nTe faltan " + palabrasRestantes + " palabras de " + Palabras.length);
        System.out.println("Puntos actuales: " + puntos);
        
        
        System.out.print("\nIngrese una palabra: ");
        String palabraUsuario = leer.next().toUpperCase();

        boolean palabraEncontrada = false;
        
        // Buscar la palabra horizontalmente
        for (int f = 0; f < 14; f++) {
            for (int c = 0; c <= 14 - palabraUsuario.length(); c++) {
                StringBuilder palabraTablero = new StringBuilder();
                for (int i = 0; i < palabraUsuario.length(); i++) {
                    palabraTablero.append(tablero[f][c + i]);
                }
                if (palabraTablero.toString().equals(palabraUsuario)) {
                    palabraEncontrada = true;
                    
                    puntos += palabraUsuario.length();
                    
                    for (int i = 0; i < palabraUsuario.length(); i++) {
                        palabrasEncontradas[f][c + i] = true;
                        tablero[f][c + i] = '#';
                    }
                    palabrasRestantes--;
                    Aciertos++;
                }
            }
        }
        
        // Buscar la palabra verticalmente
        for (int f = 0; f <= 14 - palabraUsuario.length(); f++) {
            for (int c = 0; c < 14; c++) {
                StringBuilder palabraTablero = new StringBuilder();
                for (int i = 0; i < palabraUsuario.length(); i++) {
                    palabraTablero.append(tablero[f + i][c]);
                }
                if (palabraTablero.toString().equals(palabraUsuario)) {
                    palabraEncontrada = true;
                    
                    puntos += palabraUsuario.length();
                    
                    for (int i = 0; i < palabraUsuario.length(); i++) {
                        palabrasEncontradas[f + i][c] = true;
                        tablero[f + i][c] = '#';
                    }
                    palabrasRestantes--;
                    Aciertos++;
                }
            }
        }

        if (palabraEncontrada) {
            System.out.println("Muy bien, Has encontrado la palabra: " + palabraUsuario);
        } else {
            intentosFallidos++;
            puntos -=5;
            System.out.println("Incorrecto. Te quedan " + (4 - intentosFallidos) + " intentos.");
        }
    }

    if (palabrasRestantes == 0) {
        System.out.println("--ENCONTRASTE TODAS LAS PALABRAS--");
    } else {
        System.out.println("--GAME OVER-- Inténtalo de nuevo");
    }
    Usuario[ContadorDeJugadores] = NombreUsuario;
    Puntuaciones[ContadorDeJugadores] = puntos;
    PalabrasEncontradas[ContadorDeJugadores] = Aciertos;
    Fallos[ContadorDeJugadores] = intentosFallidos;
    ContadorDeJugadores++;
    
    MenuNuevaPartida();
    
    }  
}