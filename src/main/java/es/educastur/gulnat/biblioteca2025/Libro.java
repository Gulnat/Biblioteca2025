/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.gulnat.biblioteca2025;
/**
 * @author alu23d
 */
public class Libro {
    private String isbn;//atributos son siempre privados, minisculos
    private String titulo;
    private String autor;
    private String genero;
    private int ejemplares;

    public Libro(String isbn, String titulo, String autor, String genero, int ejemplares) {//o sin aportar autor/genero , un constructor 
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ejemplares = ejemplares;
    }
     
 //Libro l=new Libro("1111111","El lazar...","","",3);

    public String getIsbn() {//con método puede acceder los atributos privados
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setIsbn(String isbn) {//no vuelve nada, modifica/cambia
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    @Override
    public String toString() {
        return isbn + "-" + titulo + "-" +  autor + "-" +  genero + "-" +  ejemplares ;
    }
 
    
    
    
}
