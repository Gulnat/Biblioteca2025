/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//Esto añadido comentaros
//PRIMER COMMIT EN LA RAMA SEGUNDARIA

package es.educastur.gulnat.biblioteca2025;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author alu23d
 */
public class Biblioteca2025 {
    private ArrayList <Libro> libros;//un clas con tres atributos de arrayList de tipo Libro y se llama libros
    private ArrayList <Usuario> usuarios;
    private ArrayList <Prestamo> prestamos;

    public Biblioteca2025() {//iniciamos new ArrayList 2-cambia nombre del Constructor de GP
        this.libros = new ArrayList(); 
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
    }     
    
    public static void main(String[] args) {
        Biblioteca2025 b= new Biblioteca2025();//cambia en main a GP
        b.cargaDatos();
        
        b.menu();
    }
    
    //<editor-fold defaultstate="collapsed" desc="MENUS">
    
     public void menu() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;//una variable entera para recojer la opción
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tBiblioteca\n");
            System.out.println("\t\t\t\t1 - LIBROS");
            System.out.println("\t\t\t\t2 - USUARIOS");
            System.out.println("\t\t\t\t3 - PRESTAMOS");// +
            System.out.println("\t\t\t\t9 - VOLVER");
            opcion= sc.nextInt();
            switch(opcion) {
                case 1: {
                    menuLibros();
                    break;
                }
                case 2: {
                    menuUsuarios();
                    break;
                }
                case 3: {
                    menuPrestamos();
                    break;
                }
            }
        }while (opcion !=9);
    }

    private void menuLibros() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;//una variable entera para recojer la opción
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tLIBROS\n");
            System.out.println("\t\t\t\t1 - ALTA NUEVO LIBRO");
            System.out.println("\t\t\t\t2 - BAJA LIBRO");
            System.out.println("\t\t\t\t3 - MODIFICACION DATOS LIBRO");
            System.out.println("\t\t\t\t4 - LISTADO DE LIBROS DISPONIBLES");
            System.out.println("\t\t\t\t9 - VOLVER");
            opcion= sc.nextInt();
            switch(opcion) {
                case 1: {
                    nuevoLibro();
                    break;
                }
                case 2: {
                    eliminarLibro();
                    break;
                }
                case 3: {
                    modificarLibros();
                    break;
                }
                case 4: {
                   listaLibros();
                    break;
                }
            }
        }while (opcion !=9);
    }

    private void menuUsuarios() {
       Scanner sc= new Scanner(System.in);
        int opcion=0;//una variable entera para recojer la opción
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tUSUARIOS\n");
            System.out.println("\t\t\t\t1 - ALTA NUEVO/A USUARIO/A");
            System.out.println("\t\t\t\t2 - BAJA USUARIO/A");
            System.out.println("\t\t\t\t3 - LISTADO USUARIOS/AS");
            System.out.println("\t\t\t\t9 - VOLVER");
            opcion= sc.nextInt();
            switch(opcion) {
                case 1: {
                    nuevoUsuario();
                    break;
                }
                case 2: {
                    eliminarUsuario();
                    break;
                }
                case 3: {
                   listaUsuarios();
                    break;
                }
            }
        }while (opcion !=9);
    }  

    private void menuPrestamos() {
       Scanner sc= new Scanner(System.in);
        int opcion=0;//una variable entera para recojer la opción
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tPRESTAMOS\n");
            System.out.println("\t\t\t\t1 - NUEVO PRESTAMO");
            System.out.println("\t\t\t\t2 - DEVOLUCION PRESTAMO");
            System.out.println("\t\t\t\t3 - PRORROGAR PRESTAMO");
            System.out.println("\t\t\t\t4 - LISTADO PRESTAMOS (TODOS)");
            System.out.println("\t\t\t\t9 - VOLVER");
            opcion= sc.nextInt();
            switch(opcion) {
                case 1: {
                    nuevoPrestamo();
                    break;
                }
                case 2: {
                    devolucionPrestamo();
                    break;
                }
                case 3: {
                    prorrogaPrestamo();
                    break;
                }
                case 4: {
                   listaPrestamos();
                    break;
                }
            }
        }while (opcion !=9);
    }
    
//</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="GESTION LIBROS">
    
    private void nuevoLibro() {    //mio
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

    private void eliminarLibro() { //mio
        System.out.println("Identificación del libro:");
        int posLibro= buscaIsbn(solicitaIsbn());
        if (posLibro==-1) {
          System.out.println("El ISBN pertenece a un libro inexistente");                
          }else {
            libros.remove(posLibro);
            }  
    }

    private void modificarLibros() {//tengo cambiar a UNIDADES
        System.out.println("Identificación del libro:");
        int posLibro= buscaIsbn(solicitaIsbn());
        if (posLibro==-1) {
          System.out.println("El ISBN pertenece a un libro inexistente");                
          }else {
            Scanner sc=new Scanner (System.in);
            System.out.println("Insertar el ISBN nuevo de este libro:"); 
            String isbn=sc.next();
            libros.get(posLibro).setIsbn(isbn);
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
    }

    private void eliminarUsuario() {
    }
    
    private void listaUsuarios() {
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTION PRESTAMOS">
    
    private void nuevoPrestamo() {
        System.out.println("Identificación del usuario:"); 
        int posUsuario=buscaDni(solicitaDni());//se llama derecha-->izq, usa el método solicitaDni, se lo manda al método buscaDni
        if (posUsuario==-1){
            System.out.println("No es aún usuario de la biblioteca");
        } else {// si el usuario ESTÁ, se puede hacer el prestamo
            System.out.println("Identificación del libro:");
            int posLibro= buscaIsbn(solicitaIsbn());
            if (posLibro==-1) {
                System.out.println("El ISBN pertenece a un libro inexistente");                
            } else if(libros.get(posLibro).getEjemplares()>0) {// tenemos el usuario y el libro, podemos hacer el prestamo,si tenemos copias del libro
                LocalDate hoy= LocalDate.now();
                prestamos.add(new Prestamo(libros.get(posLibro), usuarios.get(posUsuario), hoy, hoy.plusDays(15)));               
                libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);//que habia - 1
                } else {
                System.out.println("No quedan unidades disponibles del libro");
                }
        }       
    }

    private void devolucionPrestamo() {
        System.out.println("Datos para la prorroga del préstamo:");
        String isbnLibroVolver=solicitaIsbn();
        int posPrestamo =buscaPrestamo(solicitaDni(),isbnLibroVolver);//para buscar el libro no se llama dos vezes SolicitaIsbn()usamos variable isbnLibroVolver
        if (posPrestamo==-1){
            System.out.println("No hay ningun préstamo con estos datos.");
        } else {
            prestamos.get(posPrestamo).setFechaDev(LocalDate.now());
            libros.get(buscaIsbn(isbnLibroVolver)).setEjemplares(libros.get(buscaIsbn(isbnLibroVolver)).getEjemplares()+1);//añadir +1
            }        
    }

    private void prorrogaPrestamo() {
        System.out.println("Datos para la prorroga del préstamo:");
        //String dni= solicitaDni();//diferencia es que variables guardados, si se necesitan para usar en futuro
        //String isbn = solicitaIsbn();
        //int posPrestamo = buscaPrestamo(dni, isbn);//metodos funcionan, pero sin guardar res
        
        int posPrestamo =buscaPrestamo(solicitaDni(),solicitaIsbn());
        if (posPrestamo==-1){
            System.out.println("No hay ningun préstamo con estos datos.");
        } else {
            prestamos.get(posPrestamo).setFechaDev(prestamos.get(posPrestamo).getFechaDev().plusDays(15));     
            }
    }

    private void listaPrestamos() {
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METODOS AUXILIARES">
    
    /**
     * Método para solicitar por teclado el dni del usuario. Pendiente la validación.
     * @return dni (String) del usuario teclado
     */
    public String solicitaDni() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Teclea el dni del usuario:");
        String dni = sc.next();
        return dni;     //devuelve string  
    }
    
    /**
     * Método para solicitar por teclado el isbn del libro. Pendiente la validación.
     * @return isbn (String) del libro teclado
     */
    public String solicitaIsbn() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Teclea el isbn del libro:");
        String isbn = sc.next();
        return isbn;       
    }
    
    /**
     * Método para buscar un dni en la colleción usuarios
     * @param dni dni (String) del usuario a buscar en la colección
     * @return posición (int) del usuario en el ArrayList, -1 si no se encuentra
     */
    public int buscaDni(String dni) {
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)){//si encontramos, pos=i
                pos=i;// devuelve entero=-1 si no está, o posición, si está
                break;
            }           
        }
        return pos;       
    }
    
    /**
     * Método para buscar un libro en la colleción libros
     * @param isbn (String) del libro a buscar en la colección
     * @return posición (int) del libro en el ArrayList, -1 si no se encuentra
     */
    public int buscaIsbn(String isbn) {
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)){//si encontramos, pos=i
                pos=i;
                break;
            }           
        }
        return pos;       
    }
    
    /**
     * Método para buscar un préstamo en la colleción de préstamos
     * @param dni(String) del usuario que realizo el préstamo
     * @param isbn (String) del libro prestado
     * @return posición (int) delpréstamo de ArrayList, valor -1, si no se encuantra un préstamo con estos datos
     */
    public int buscaPrestamo(String dni, String isbn) {
        int pos=-1;
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getUsuarioPrest().getDni().equals(dni)&&prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)){
                pos=i;
                break;
            }           
        }
        return pos;       
    }   
    
    private void cargaDatos() {//leer los archivos de libros/usuarios/prestamos
        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien",3)); 
        libros.add(new Libro("2-22","El Silmarillon","JRR Tolkien",3)); 
        libros.add(new Libro("3-33","El Médico","N. Gordon",4)); 
        libros.add(new Libro("4-44","Chamán","N. Gordon",3)); 
        libros.add(new Libro("5-55","Momo","M. Ende",2)); 
        libros.add(new Libro("6-66","Paraíso inhabitado","A.M.Matute",2)); 
        libros.add(new Libro("7-77","Olvidado Rey Gudú","A.M.Matute",2)); 
        libros.add(new Libro("8-88","El último barco","D.Villar",3)); 
        libros.add(new Libro("9-99","Ojos de agua","D.Villar",2)); 

        usuarios.add(new Usuario("11","Ana","621111111")); 
        usuarios.add(new Usuario("22","David","622222222")); 
        usuarios.add(new Usuario("33","Bea","623333333")); 
        usuarios.add(new Usuario("44","Lucas","624444444")); 
        usuarios.add(new Usuario("55","Carlota","625555555")); 
        usuarios.add(new Usuario("66","Juan","626666666"));
        
        LocalDate hoy= LocalDate.now();
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(8),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(4), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(1), hoy,hoy.plusDays(15)));
    
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
    }

//</editor-fold>


        
 
   
}
