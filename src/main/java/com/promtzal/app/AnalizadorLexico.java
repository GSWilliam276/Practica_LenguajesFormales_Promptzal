/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.promtzal.app;

import com.promptzal.modelo.Token;
import com.promptzal.modelo.ErrorLexico;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author eduar
 */
public class AnalizadorLexico {
    //Atributos
    private String texto;
    private int posicion;
    private int fila;
    private int columna;
    private int contadorTokens;

    private List<Token> listaTokens;
    private List<ErrorLexico> listaErrores;

    //Listas de palabras conocidas, para clasificar contra ellas
    private static final String[] PALABRAS_RESERVADAS = {"AGENTE", "contexto", "variable", "EJECUTAR", "EXPORTAR"};
    private static final String[] COMANDOS_IA = {"PREGUNTAR", "GENERAR", "RESUMIR", "ANALIZAR", "TRADUCIR", "CLASIFICAR", "EXTRAER", "CARGAR"};
    private static final String[] CONECTORES_PALABRA = {"SOBRE", "DESDE", "EN", "COMO"};

    //Constructor
    public AnalizadorLexico(String texto) {
        this.texto = texto;
        this.posicion = 0;
        this.fila = 1;
        this.columna = 1;
        this.contadorTokens = 0;
        this.listaTokens = new ArrayList<>();
        this.listaErrores = new ArrayList<>();
    }
    
    private char espiar() {
        //Mira el caracter en la posicion siguiente
        if (posicion + 1 < texto.length()) {
            return texto.charAt(posicion + 1);
        }
        return '\0'; //Caracter nulo, indica que no hay siguiente caracter
    }
    
    private void avanzar() {
        //Mueve el puntero una posicion hacia adelante, actualiza fila/columna 
        //correctamente segun lo que se acaba de dejar atras
        if (texto.charAt(posicion) == '\n') {
            fila++;
            columna = 1;
        } else {
            columna++;
        }
        posicion++;
    }
    
    private void leerPalabra() {
        int filaInicio = fila;
        int columnaInicio = columna;
        StringBuilder palabra = new StringBuilder();

        //Mientras el caracter actual sea letra, digito o guion bajo, se sigue acumulando
        while (posicion < texto.length() && esCaracterDePalabra(texto.charAt(posicion))) {
            palabra.append(texto.charAt(posicion));
            avanzar();
        }

        String lexema = palabra.toString();
        String tipo = clasificarPalabra(lexema);

        contadorTokens++;
        Token token = new Token(contadorTokens, lexema, tipo, filaInicio, columnaInicio);
        listaTokens.add(token);
    }

    //Determina si un caracter puede formar parte de una palabra (identificador,
    //palabra reservada, comando o conector)
    private boolean esCaracterDePalabra(char c) {
        return Character.isLetterOrDigit(c) || c == '_';
    }

    private String clasificarPalabra(String palabra) {
        //Respeta el orden de prioridad
        if (contiene(PALABRAS_RESERVADAS, palabra)) {
            return "PALABRA_RESERVADA";
        }
        if (contiene(COMANDOS_IA, palabra)) {
            return "COMANDO_IA";
        }
        if (contiene(CONECTORES_PALABRA, palabra)) {
            return "CONECTOR";
        }
        return "IDENTIFICADOR";
    }

    private boolean contiene(String[] arreglo, String valor) {
        //Recorre el arreglo comparando uno por uno
        for (String s : arreglo) {
            if (s.equals(valor)) {
                return true;
            }
        }
        return false;
    }
}
