/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.gulnat.biblioteca2025;

    import java.time.LocalDate;

/**
 *
 * @author alu23d
 */
public class Prestamo {
    //private String isbn;
    private Libro libroPrest;//assign un objeto se llama libroPrest de tipo Libro - directamente en memoria
    private Usuario usuarioPrest;
    private LocalDate fechaPrest;
    private LocalDate fechaDev;//de devolución

    public Prestamo(Libro libroPrest, Usuario usuarioPrest, LocalDate fechaPrest, LocalDate fechaDev) {
        this.libroPrest = libroPrest;
        this.usuarioPrest = usuarioPrest;
        this.fechaPrest = fechaPrest;
        this.fechaDev = fechaDev;
    }

    public Libro getLibroPrest() {
        return libroPrest;
    }

    public Usuario getUsuarioPrest() {
        return usuarioPrest;
    }

    public LocalDate getFechaPrest() {
        return fechaPrest;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setLibroPrest(Libro libroPrest) {
        this.libroPrest = libroPrest;
    }

    public void setUsuarioPrest(Usuario usuarioPrest) {
        this.usuarioPrest = usuarioPrest;
    }

    public void setFechaPrest(LocalDate fechaPrest) {
        this.fechaPrest = fechaPrest;
    }

    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

    @Override
    public String toString() {
        return libroPrest + "-" + usuarioPrest + "-" +  fechaPrest + "-" +  fechaDev;
    }
    
    
}