/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sopadeletras;

import java.util.Arrays;
import java.util.Scanner;

public class SopaDeLetras {
    static String[] Palabras = new String[0]; //Se mantiene en memoria
    static String Usuario;
    public static void main(String[] args) {
        MenuBienvenida();
    }

    static void MenuBienvenida() {
        Scanner leer = new Scanner(System.in);
        int num;

        System.out.println("______________________________________");
        System.out.println("Autor: Angel Emanuel Rodriguez Corado");
        System.out.println("Carnet: 202404856");
        System.out.println("Seccion: E");
        System.out.println("______________________________________");

        System.out.print("Ingrese un nombre de usuario: ");
        Usuario = leer.nextLine();
        System.out.println("\n---------------------------------------");
        System.out.println("Bienvenid@: " + Usuario);
        System.out.println("Elige el numero según lo que desees:");
        System.out.println("[1] Nueva Partida");
        System.out.println("[2] Historial de Partidas");
        System.out.println("[3] Puntuacion mas alta");
        System.out.println("[4] Salir");
        System.out.print("Ingrese su eleccion: ");

        num = leer.nextInt();
        leer.nextLine(); // Limpiar buffer después de leer un número

        switch (num) {
            case 1 -> MenuNuevaPartida();
            case 2 -> MenuHistorial();
            case 3 -> MenuPuntuacion();
            case 4 -> System.out.println("Saliendo del programa...");
            default -> System.out.println("Opción invalida, intenta nuevamente.");
        }
    }

    static void MenuNuevaPartida() {
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
                    System.out.print("Ingrese el nmero de palabras que desees: ");
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
                    System.out.println("Saliendo al menú principal...");
                    MenuBienvenida();
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }

        } while (menu != 4);
    }

    static void MenuHistorial() {
        System.out.println("Historial de partidas aún no implementado.");
    }
    
    static void MenuPuntuacion() {
        System.out.println("Puntuación más alta aún no implementada.");
    }

    static String[] IngresoDePalabras(int NumeroDePalabras) {
        String[] palabras = new String[NumeroDePalabras];
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese palabras de 5 a 10 letras:");
        System.err.println("--UNICAMENTE SE ACEPTAN MAYUSCULAS--");

        for (int i = 0; i < NumeroDePalabras; i++) {
            String palabra;
            do {
                System.out.print("Palabra [" + (i + 1) + "]: ");
                palabra = leer.next();
                if (palabra.length() < 5 || palabra.length() > 10) {
                    System.out.println("AaanfeasdaLa palabra debe tener entre 5 y 10 letras. Intente de nuevo.");
                }
            } while (palabra.length() < 5 || palabra.length() > 10);

            palabras[i] = palabra;
        }

        return palabras;
    }

    static void ModificarPalabras() {
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
                
                // 🔹 Validar que la nueva palabra tenga entre 5 y 10 letras
                if (nuevaPalabra.length() < 5 || nuevaPalabra.length() > 10) {
                    System.out.println("Error: La palabra debe tener entre 5 y 10 letras.");
                    return;
                }

                Palabras[i] = nuevaPalabra;
                encontrada = true;
                System.out.println("Palabra modificada con éxito.");
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Error: La palabra no fue encontrada.");
        }
    }
   
    static void EliminarPalabras() {
        Scanner leer = new Scanner(System.in);

        if (Palabras.length == 0) {
            System.out.println("No hay palabras para eliminar.");
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
            System.out.println("Error: La palabra no fue encontrada.");
        }
    }

static void IniciarPartida() {
    char[][] tablero = new char[14][14];

    if (Palabras == null || Palabras.length == 0) {
        System.out.println("No hay palabras agregadas.");
        System.out.println("Por favor ingrese sus palabras en el siguiente menú.");
        MenuNuevaPartida();
        return;
    }

    System.out.println("  ____________________________");
    System.out.println(" /     Tablero de Juego      /");
    System.out.println("/____________________________/");

    // Tablero en blanco
    for (int f = 0; f < 14; f++) {
        for (int c = 0; c < 14; c++) {
            tablero[f][c] = ' '; // Ahora sí hay celdas vacías
        }
    }

    // Ingresar las palabras en el tablero 
    for (String palabra : Palabras) {
        boolean colocada = false;

        while (!colocada) { 
            int fila = (int) (Math.random() * 14);
            int columna = (int) (Math.random() * 14);
            int direccion = (int) (Math.random() * 2); // 0 = Horizontal, 1 = Vertical

            // Ajustar posición si la palabra se sale del tablero
            if (direccion == 0 && columna + palabra.length() > 14) {
                columna = 14 - palabra.length();
            } else if (direccion == 1 && fila + palabra.length() > 14) {
                fila = 14 - palabra.length();
            }

            // Verificar
            boolean hayColision = false;
            if (direccion == 0) { // Horizontal
                for (int i = 0; i < palabra.length(); i++) {
                    if (tablero[fila][columna + i] != ' ') { 
                        hayColision = true;
                        break;
                    }
                }
            } else { // Vertical
                for (int i = 0; i < palabra.length(); i++) {
                    if (tablero[fila + i][columna] != ' ') { 
                        hayColision = true;
                        break;
                    }
                }
            }

            // Colocar palabra
            if (!hayColision) {
                for (int i = 0; i < palabra.length(); i++) {
                    if (direccion == 0) { 
                        tablero[fila][columna + i] = palabra.charAt(i);
                    } else { 
                        tablero[fila + i][columna] = palabra.charAt(i);
                    }
                }
                colocada = true; // Marcar como colocada
            }
        }
    }

    // Letras aleatorias en espacios vacios
    for (int f = 0; f < 14; f++) {
        for (int c = 0; c < 14; c++) {
            if (tablero[f][c] == ' ') { 
                tablero[f][c] = (char) (Math.random() * 26 + 65);
            }
        }
    }

    // Imprimir el tablero
    for (int f = 0; f < 14; f++) {
        for (int c = 0; c < 14; c++) {
            System.out.print(" | " + tablero[f][c]);
        }
        System.out.println(" |");
    }
    
    
    
}





    
}
