/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.promptzal.modelo;

/**
 *
 * @author eduar
 */
public class Token {
    //Atributos
    private int numero;
    private String lexema;
    private String tipo;
    private int fila;
    private int columna;

    //Constructor
    public Token() {
    }

    //Inicializacion
    public Token(int numero, String lexema, String tipo, int fila, int columna) {
        this.numero = numero;
        this.lexema = lexema;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }

    //Getters y Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getLexema() { return lexema; }
    public void setLexema(String lexema) { this.lexema = lexema; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getFila() { return fila; }
    public void setFila(int fila) { this.fila = fila; }

    public int getColumna() { return columna; }
    public void setColumna(int columna) { this.columna = columna; }

}
