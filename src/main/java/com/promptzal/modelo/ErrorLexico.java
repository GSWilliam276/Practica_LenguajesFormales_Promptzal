/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.promptzal.modelo;

/**
 *
 * @author eduar
 */
public class ErrorLexico {
    //Atributos
    private String lexema;
    private String descripcion;
    private int fila;
    private int columna;
    
    //Constructor
    public ErrorLexico() {
    }

    //Inicializacion
    public ErrorLexico(String lexema, String descripcion, int fila, int columna) {
        this.lexema = lexema;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }

    //Getters y Setters
    public String getLexema() { return lexema; }
    public void setLexema(String lexema) { this.lexema = lexema; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getFila() { return fila; }
    public void setFila(int fila) { this.fila = fila; }

    public int getColumna() { return columna; }
    public void setColumna(int columna) { this.columna = columna; }
}
