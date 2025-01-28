/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.educastur.gulnat.biblioteca2025;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author alu23d
 */
//PruebaEntornos 28/01
public class Biblioteca2025 {

    private ArrayList <Libro> libros;
    private ArrayList <Usuario> usuarios;
    private ArrayList <Prestamo> prestamos;
    private ArrayList <Prestamo> prestamosHist;

    public Biblioteca2025() {
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
        this.prestamosHist = new ArrayList();
    }
    
    public static void main(String[] args) {
       Biblioteca2025 b= new Biblioteca2025();
       b.cargaDatos();
       b.fueraPlazo();
       b.menu();
    }
    
    //<editor-fold defaultstate="collapsed" desc="MENUS">
    public void menu(){
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tBIBLIOTECA\n");
            System.out.println("\t\t\t\t1 - LIBROS");
            System.out.println("\t\t\t\t2 - USUARIOS");
            System.out.println("\t\t\t\t3 - PRESTAMOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    menuLibros();
                    break;
                }    
                case 2:{
                    menuUsuarios();
                    break;
                } 
                case 3:{
                    menuPrestamos();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuLibros() {
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tLIBROS\n");
            System.out.println("\t\t\t\t1 - ALTA NUEVO LIBRO");
            System.out.println("\t\t\t\t2 - BAJA LIBRO");
            System.out.println("\t\t\t\t3 - MODIFICAR LIBRO");
            System.out.println("\t\t\t\t4 - LISTADOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoLibro();
                    break;
                }    
                case 2:{
                    eliminarLibro();
                    break;
                } 
                case 3:{
                    modificarLibros();
                    break;
                } 
                case 4:{
                    listaLibros();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuUsuarios() {
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tUSUARIOS");
            System.out.println("\t\t\t\t1 - ALTA NUEVO/A USUARIO/A");
            System.out.println("\t\t\t\t2 - BAJA USUARIO/A");
            System.out.println("\t\t\t\t3 - LISTADOS USUARIOS/AS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoUsuario();
                    break;
                }    
                case 2:{
                    eliminarUsuario();
                    break;
                }  
                case 3:{
                    listaUsuarios();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuPrestamos() {
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tPRESTAMOS\n");
            System.out.println("\t\t\t\t1 - NUEVO PRESTAMO");
            System.out.println("\t\t\t\t2 - DEVOLUCION PRESTAMO");
            System.out.println("\t\t\t\t3 - PRORROGAR PRESTAMO");
            System.out.println("\t\t\t\t4 - LISTADO GENERAL PRESTAMOS");
            System.out.println("\t\t\t\t5 - LISTADO PRESTAMOS USUARIO");
            System.out.println("\t\t\t\t6 - LISTADO PRESTAMOS LIBRO (USUARIOS QUE LO LEEN)");
            System.out.println("\t\t\t\t7 - LIBRO MÁS LEIDO");
            System.out.println("\t\t\t\t8 - USUARIO MÁS LECTOR");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoPrestamo();
                    break;
                }    
                case 2:{
                    devolucion();
                    break;
                } 
                case 3:{
                    prorroga();
                    break;
                } 
                case 4:{
                    listaPrestamos();
                    break;
                } 
                case 5:{
                    listaPrestamosUsu();
                    break;
                } 
                case 6:{
                    listaPrestamosLibro();
                    break;
                } 
                case 7:{
                    libroMasLeido();
                    break;
                }
                case 8:{
                    usuarioMasLector();
                    break;
                }
            }
        }while (opcion != 9);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTION LIBROS">
    private void nuevoLibro() {
        Scanner sc=new Scanner (System.in);
        System.out.println("Insertar el ISBN del libro nuevo"); 
        String isbn=sc.next();
        sc.nextLine();
        System.out.println("Insertar el titulo del libro nuevo"); 
        String titulo=sc.next();
        sc.nextLine();
        System.out.println("Insertar el autor del libro nuevo"); 
        String autor=sc.next();
        sc.nextLine();
        System.out.println("Insertar el número de ejemplares del libro nuevo"); 
        int ejemplares=sc.nextInt();
        
        libros.add(new Libro(isbn, titulo, autor, ejemplares));
    }

    private void eliminarLibro() {
        System.out.println("Identificación del libro:");
        int posLibro= buscaIsbn(solicitaIsbn());
        if (posLibro==-1) {
          System.out.println("El ISBN pertenece a un libro inexistente");                
          }else {
            libros.remove(posLibro);
            } 
    }

    private void modificarLibros() {
        System.out.println("Identificación del libro:");
        int posLibro= buscaIsbn(solicitaIsbn());
        if (posLibro==-1) {
          System.out.println("El ISBN pertenece a un libro inexistente");                
          }else {
            Scanner sc=new Scanner (System.in);
            System.out.println("Para quitar ejemplares del libro, inserta la cantidad con signo negativo. Para añadirlos, insertala con signo positivo :"); 
            int unidades=sc.nextInt();
            libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()+unidades);            
            } 
    }

    private void listaLibros() {
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTION USUARIOS">
    private void nuevoUsuario() {
        Scanner sc=new Scanner (System.in);
        System.out.println("Insertar el DNI del usuario nuevo"); 
        String dni=sc.next();
        sc.nextLine();
        System.out.println("Insertar el nombre del usuario nuevo"); 
        String nombre=sc.next();
        sc.nextLine();
        System.out.println("Insertar el telefono del usuario nuevo"); 
        String telefono=sc.next();
        sc.nextLine();
        
        usuarios.add(new Usuario(dni, nombre, telefono));
    }

    private void eliminarUsuario() {
        System.out.println("Identificación del usuario:");
        int posUsuario= buscaDni(solicitaDni());
        if (posUsuario==-1) {
          System.out.println("El DNI pertenece a un usuario inexistente");                
          }else {
            usuarios.remove(posUsuario);
            } 
    }

    private void listaUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }       
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTION PRESTAMOS">
    private void nuevoPrestamo() {
        System.out.println("Identificacion del usuario:");
        String dni=solicitaDni();
        int posUsuario = buscaDni(dni);
        
        if (posUsuario==-1){
            System.out.println("No es aun usuario de la biblioteca");
        }else{
            System.out.println("Identificacion del libro:"); 
            String isbn=solicitaIsbn();
            int posLibro=buscaIsbn(isbn);
           
            if (posLibro==-1){
                System.out.println("El ISBN pertenece a un libro inexistente");
            } else if (libros.get(posLibro).getEjemplares()>0){
                if ((buscaPrestamo(dni,isbn))==-1){
                    LocalDate hoy=LocalDate.now();
                    prestamos.add(new Prestamo(libros.get(posLibro),usuarios.get(posUsuario),hoy,hoy.plusDays(15)));
                    libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);
                    }else{
                        System.out.println("Ese usuario ya tiene ese mismo libro en prestamo");
                    }
                }else{
                    System.out.println("No quedan unidades disponibles del libro");
                }
        }
    }
    private void devolucion() {
        System.out.println("Datos para la prorroga del préstamo:");
        String isbnLibro=solicitaIsbn();
        int pos=buscaPrestamo(solicitaDni(),isbnLibro);
        if (pos==-1){
            System.out.println("No hay ningun préstamo con esos datos");
        }else{
            prestamos.get(pos).setFechaDev(LocalDate.now());
            libros.get(buscaIsbn(isbnLibro))
              .setEjemplares(libros.get(buscaIsbn(isbnLibro)).getEjemplares()+1);
            prestamosHist.add(prestamos.get(pos));
            prestamos.remove(pos);
        }
    }
    private void prorroga() {
        System.out.println("Datos para la prorroga del préstamo:");
        
        String dni = solicitaDni();
        String isbn = solicitaIsbn();
        int pos=buscaPrestamo(dni,isbn);
        //int pos=buscaPrestamo(solicitaDni(),solicitaIsbn());
        if (pos==-1){
            System.out.println("No hay ningun préstamo con esos datos");
        }else{
            prestamos.get(pos).setFechaDev(prestamos.get(pos).getFechaDev().plusDays(15));
            prestamos.get(pos).setFechaPrest(LocalDate.now());
        }
    }

    private void listaPrestamos() {
        System.out.println("Listado de prestamos activos");
        for (Prestamo p : prestamos) {
            if (p.getFechaDev().isBefore(LocalDate.now())){
                        System.out.print("Libro fuera de plazo: ");
            }
            System.out.println(p);  
        }
        
        System.out.println("\nListado de prestamos historicos");
        for (Prestamo p : prestamosHist) {
            System.out.println(p);  
        }
    }
    
    private void listaPrestamosUsu(){
        String dni=solicitaDni();
        int pos=buscaDni(dni);
        
        if (pos==-1){
            System.out.println("No tengo a nadie con ese DNI");
        }else{
            System.out.println("Prestamos activos de: "
                    + usuarios.get(pos).getNombre());
            for (Prestamo p : prestamos) {
                if (p.getUsuarioPrest().getDni().equals(dni)){
                    if (p.getFechaDev().isBefore(LocalDate.now())){
                        System.out.print("Libro fuera de plazo: ");
                    }
                    System.out.println(p);  
                }
            }
            System.out.println("\nPrestamos ya devueltos por: "
                    + usuarios.get(pos).getNombre());
            for (Prestamo p : prestamosHist) {
                if (p.getUsuarioPrest().getDni().equals(dni)){
                    System.out.println(p);  
                }
            }
        }
    }
    
    private void listaPrestamosLibro(){
        String isbn=solicitaIsbn();
        int pos=buscaIsbn(isbn);
        if (pos==-1){
             System.out.println("No tengo ningún libro con ese ISBN");
        }else{
            System.out.println("Usuarios/as que lo estan leyendo");
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest().getIsbn().equals(isbn)){
                    System.out.println(p.getUsuarioPrest());
                }
            }
            
            System.out.println("Usuarios/as que ya lo han leido");
            for (Prestamo p : prestamosHist) {
                if (p.getLibroPrest().getIsbn().equals(isbn)){
                    System.out.println(p.getUsuarioPrest());
                }
            }
        }
    }
            
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listados">
    private void libroMasLeido() {
        ArrayList <Integer> contadoresLibros = new ArrayList();// var de tipo normales (int) viven en stack, necesito tipo volvente de Integer (objeto), Double
        int contador;
        for (Libro l : libros) {
            contador=0;
            for (Prestamo p : prestamos) {
                if (l==p.getLibroPrest()) {
                    contador++;
                }
            }
            for (Prestamo p : prestamosHist) {
                if (l==p.getLibroPrest()) {
                    contador++;
                }
            }
            contadoresLibros.add(contador);
        }
        
        /*
        int max=contadoresLibros.get(0);
        for (int i=0; i<libros.size(); i++) {
            if (contadoresLibros.get(i)>max) {// si hay dos libros con el mismo valor, sale solo 1 ; no interesa en posicion porque hay varios
                max = contadoresLibros.get(i);
            }
        } */ 
        
        //código más limpio
        int max=0;
        for (int c: contadoresLibros) {
            if (c>max) {
                max = c;
            }
        } 
        
        System.out.println("El libro/s más leido/s con " + max + "prestamos es/son: ");  
        
        for (int i=0; i<contadoresLibros.size(); i++) {
            if (contadoresLibros.get(i)==max) {
                System.out.println(libros.get(i));// necesito FORE para acceder indice i
            }
        }
    }
    
    
        private void usuarioMasLector() {
         ArrayList <Integer> contadoresUsuarios = new ArrayList();// var de tipo normales (int) viven en stack, necesito tipo volvente de Integer (objeto), Double
        int contador;
        for (Usuario u : usuarios) {
            contador=0;
            for (Prestamo p : prestamos) {
                if (u==p.getUsuarioPrest()) {
                    contador++;
                }
            }
            for (Prestamo p : prestamosHist) {
                if (u==p.getUsuarioPrest()) {
                    contador++;
                }
            }
            contadoresUsuarios.add(contador);
        }
        
        /*
        int max=contadoresLibros.get(0);
        for (int i=0; i<libros.size(); i++) {
            if (contadoresLibros.get(i)>max) {// si hay dos libros con el mismo valor, sale solo 1 ; no interesa en posicion porque hay varios
                max = contadoresLibros.get(i);
            }
        } */ 
        
        //código más limpio
        int max=0;
        for (int c: contadoresUsuarios) {
            if (c>max) {
                max = c;
            }
        } 
        
        System.out.println("El usuario/s más lectores con " + max + "prestamos es/son: ");  
        
        for (int i=0; i<contadoresUsuarios.size(); i++) {
            if (contadoresUsuarios.get(i)==max) {
                System.out.println(usuarios.get(i));// necesito FORE para acceder indice i
            }
        }
    }
    
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="METODOS AUXILIARES">
    /**
     * Método para solicitar por teclado el DNI de un usuario. pdte de validación
     * @return (String) dni del usuario tecleado
     */
    
    public void fueraPlazo(){
        System.out.println("Prestamos fuera de plazo:");
        for (Prestamo p : prestamos) {
            if (p.getFechaDev().isBefore(LocalDate.now())){
                    System.out.println(p);
            }
        }
    }
    
    public String solicitaDni(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el dni del usuario:");
        String dni=sc.next();
        return dni;
    }
    /**
     * Método para solicitar por teclado el ISBN de un libro. pdte de validación
     * @return (String) isbn del libro tecleado
     */
    public String solicitaIsbn(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el isbn del libro:");
        String isbn=sc.next();
        return isbn;
    }
    
    /**
     * Método para buscar un dni en la colección usuarios
     * @param dni (String) del usuario a buscar en la colección
     * @return posición (int) del usuario en el Arraylist, valor -1 si no se encuentra
     */
    public int buscaDni(String dni){
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)){
                pos=i;
                break;
            }
        }
        return pos;       
    }
    
     /**
     * Método para buscar un libro en la colección libros
     * @param isbn (String) del libro a buscar en la colección
     * @return posición (int) del libro el Arraylist, valor -1 si no se encuentra
     */
    public int buscaIsbn(String isbn){
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)){
                pos=i;
                break;
            }
        }
        return pos;       
    }
     /**
     * Método para buscar un préstamo en la colección préstamos
     * @param dni (String) del usuario que realizó el préstamo
     * @param isbn (String) del libro prestado
     * @return posición (int) del préstamo en el Arraylist, 
     *         valor -1 si no se encuentra un préstamo con esos datos
     */
    public int buscaPrestamo(String dni, String isbn){
        int pos=-1;
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getUsuarioPrest().getDni().equals(dni)
                && prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)){   
                pos=i;
                break;
            }
        }
        return pos;       
    }
       
    public void cargaDatos(){
        
        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien",3)); 
        libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien",3)); 
        libros.add(new Libro("1-33","El Medico","N. Gordon",4)); 
        libros.add(new Libro("1-44","Chaman","N. Gordon",3)); 
        libros.add(new Libro("1-55","Momo","M. Ende",2)); 
        libros.add(new Libro("1-66","Paraiso inhabitado","A.M.Matute",2)); 
        libros.add(new Libro("1-77","Olvidado Rey Gudu","A.M.Matute",2)); 
        libros.add(new Libro("1-88","El ultimo barco","D.Villar",3)); 
        libros.add(new Libro("1-99","Ojos de agua","D.Villar",9
        )); 

        usuarios.add(new Usuario("11","Ana","621111111")); 
        usuarios.add(new Usuario("22","David","622222222")); 
        usuarios.add(new Usuario("33","Bea","623333333")); 
        usuarios.add(new Usuario("44","Lucas","624444444")); 
        usuarios.add(new Usuario("55","Carlota","625555555")); 
        usuarios.add(new Usuario("66","Juan","626666666"));
        
        LocalDate hoy= LocalDate.now();
        prestamos.add(new Prestamo(libros.get(3),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(0),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(4), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(1),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(3),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(1), hoy,hoy.plusDays(15)));
        
        prestamos.add(new Prestamo(libros.get(0),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(0),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(2),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(5),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(1),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(2),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(6),usuarios.get(2), hoy.minusDays(20),hoy.minusDays(5)));
        
       
        for (Libro l:libros) {//para comprobar que datos de libros, usuarios y prestamos están
            System.out.println(l);
        }
        System.out.println("");
        for (Usuario u:usuarios) {
            System.out.println(u);
        }
        System.out.println("");
        for (Prestamo p:prestamos) {
            System.out.println(p);
        }
        System.out.println("******");
        System.out.println("");
        for (Prestamo p:prestamosHist) {
            System.out.println(p);
        }
    }
//</editor-fold>
    
}
