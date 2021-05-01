package co.edu.unicesar.sistemas.p2.practica2.vista;

import co.edu.unicesar.sistemas.p2.practica2.datos.ListAccesoDatoss;
import co.edu.unicesar.sistemas.p2.practica2.dominio.*;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import co.edu.unicesar.sistemas.p2.practica2.negocio.RegistroPublicacion;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VistaConsola {
    private String[] titulos = {"1. Insertar Publicacion",
                                "2. Leer Publicaciones",
                                "3. Buscar Publicacion",
                                "4.Eliminar Publicacion",
                                "0. Salir del Aplicativo"};
    private int opcion;
    private Scanner lector;
    private RegistroPublicacion registro;

    public VistaConsola() {
        this.lector = new Scanner(System.in);
        this.registro = new RegistroPublicacion();
        
    }
    
    public void ejecutarMenu(){
        
        do{
            this.imprimirMenu();
            this.leerOpcion();
            this.evaluarOpcion();
            
        }while(this.opcion!=0);
    }
    
    public void imprimirMenu(){
        System.out.println(" MENU DE APLICACION \n\n");
        for(String t: this.titulos){
            System.out.println(t);
        }
    }
    
    public void leerOpcion(){
        boolean excepcion = true;
        do{
            try{
                System.out.print("\nSeleccione su opcion: ");   
                this.opcion = this.lector.nextInt();
                excepcion=false;
            
            }catch(java.util.InputMismatchException ime){
                System.out.println("La opcion debe ser valor entero, registre nuevamente");
                excepcion=true;
                this.lector.nextLine();
            }    
        }while(excepcion);
        
    }
    
    public void evaluarOpcion(){
        
        switch(this.opcion){
            case 1: this.vistaInsertar();
                    break;
            case 2: this.vistaConsultar();
                    break;
            case 3: this.vistaBuscar();
                    break;
            case 4: this.vistaEliminar();
                    break;
            case 0: System.out.println("La aplicacion a finalizado");
                    break;
            default: System.out.println("Opcion no valida");
            
        }
    }
    
    public void vistaInsertar() {
        
        System.out.println(this.titulos[this.opcion-1]);
       
        try {
            Publicacion a = new Libro(13, 3, "123", "Soledad", "Gabriel", 2012, 100000);
            registro.adicionarPublicacion(a);
            Publicacion b = new AudioLibro(90, 50, "MP3", "132", "Llanto", "Jesus", 2014, 30000);
            registro.adicionarPublicacion(b);
            System.out.println("Registros completados");
            
        } catch (ExcepcionAccesoDatos ex) {
            System.out.println("No se pudo registrar");
        }
        
    }
    
    public void vistaConsultar(){
        
        System.out.println("--------------------------------------------------");
        System.out.println(this.titulos[this.opcion-1]);
         // escribir metodo consultar
        try {
            for(Publicacion e: this.registro.consultarPublicaciones())
            {
                System.out.println(e);
            System.out.println("--------------------------------------------------");
            }
        } catch (ExcepcionAccesoDatos ex) {
            System.out.println("No hay valores registrados");
        }
    }
    
    public void vistaBuscar(){
        
        System.out.println("--------------------------------------------------");
        System.out.println(this.titulos[this.opcion-1]);
        Publicacion a = new Libro("123");
        try {
            System.out.println(this.registro.buscarPublicacion(a));
            System.out.println("--------------------------------------------------");
        } catch (ExcepcionAccesoDatos ex) {
            System.out.println("No se encontro");
        }
    }
    
    public void vistaEliminar(){
        
        System.out.println("--------------------------------------------------");
        System.out.println(this.titulos[this.opcion-1]);
         // escribir metodo eliminar
        Publicacion b = new Libro("123");   
        try {
            System.out.println(this.registro.eliminarPublicacion(b));
            System.out.println("**Registro eliminado**");
            System.out.println("--------------------------------------------------");
        } catch (ExcepcionAccesoDatos ex) {
            System.out.println("No se encontro el elemento");
        }
    }
    
}
