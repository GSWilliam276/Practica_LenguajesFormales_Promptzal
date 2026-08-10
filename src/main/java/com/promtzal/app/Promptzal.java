/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.promtzal.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import com.promptzal.vista.Colores;
/**
 *
 * @author eduar
 */
public class Promptzal {

    public static void main(String[] args) {
        mostrarBienvenida();

        Scanner scanner = new Scanner(System.in);
        System.out.println(Colores.AZUL + "Ingrese la ruta del archivo .pz a analizar:" + Colores.RESET);
        String ruta = scanner.nextLine();

        try {
            String contenido = new String(Files.readAllBytes(Paths.get(ruta)));
            AnalizadorLexico analizador = new AnalizadorLexico(contenido);
            analizador.analizar();
            analizador.mostrarTokensEnConsola();

            GeneradorReporte generador = new GeneradorReporte();
            generador.generarReporteTokens(analizador.getListaTokens(), "reporte_tokens.html");
            generador.generarReporteErrores(analizador.getListaErrores(), "reporte_errores.html");

            System.out.println(Colores.VERDE + "\nReportes HTML generados: reporte_tokens.html y reporte_errores.html" + Colores.RESET);

        } catch (IOException ex) {
            System.out.println(Colores.ROJO + "Error: no se pudo leer el archivo. Verifica la ruta." + Colores.RESET);
        }
    }
    
        private static void mostrarBienvenida(){
            System.out.println(Colores.NARANJA + Colores.NEGRITA);
            System.out.println("    _");
            System.out.println("  ~(o)>");
            System.out.println("  / ) \\        ===================");
            System.out.println(" ( (   )            PROMPTZAL");
            System.out.println("  \\ \\_/        ===================");          
            System.out.println("   ) )");
            System.out.println("  ( (");
            System.out.println("   ) )");
            System.out.println("  ( (");
            System.out.println("   \\ \\");
            System.out.println("    \\ \\");
            System.out.println("     `~'");
            System.out.println(Colores.RESET);
            System.out.println(Colores.AZUL + "Bienvenid@ a PromptZal - Analizador Lexico" + Colores.RESET);
        }            
}
