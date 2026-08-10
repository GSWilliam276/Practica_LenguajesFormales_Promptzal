/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.promtzal.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 *
 * @author eduar
 */
public class Promptzal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo .pz a analizar:");
        String ruta = scanner.nextLine();

        try {
            String contenido = new String(Files.readAllBytes(Paths.get(ruta)));
            AnalizadorLexico analizador = new AnalizadorLexico(contenido);
            analizador.analizar();
            analizador.mostrarTokensEnConsola();
            GeneradorReporte generador = new GeneradorReporte();
            generador.generarReporteTokens(analizador.getListaTokens(), "reporte_tokens.html");
            generador.generarReporteErrores(analizador.getListaErrores(), "reporte_errores.html");

            System.out.println("\nReportes HTML generados: reporte_tokens.html y reporte_errores.html");
            
            System.out.println("Analisis completado.");
            
        } catch (IOException ex) {
            System.out.println("Error: no se pudo leer el archivo. Verifica la ruta.");
        }
    }
}
