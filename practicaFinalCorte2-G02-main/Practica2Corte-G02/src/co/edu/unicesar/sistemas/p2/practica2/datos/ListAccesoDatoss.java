/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicesar.sistemas.p2.practica2.datos;

import co.edu.unicesar.sistemas.p2.practica2.dominio.Publicacion;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jairo
 * Implementar metodos utilizando colecciones de datos, clase List y ArrayList
 */
public class ListAccesoDatoss implements IAccesoDatos {
    
      List<Publicacion> publi = new ArrayList();


    @Override
    public void insertarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
       // implemntar 
       this.publi.add(p);

    }

    @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionAccesoDatos {
        
        //Implementar    
        return this.publi;
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
       //implementar
        if(this.publi==null)
           throw new ExcepcionAccesoDatos("No hay publicaciones registradas"); 
        if(p==null)
           throw new ExcepcionAccesoDatos("Parametro no permitido para la busqueda"); 
        if(p.getIsbn()==null)
            throw new ExcepcionAccesoDatos("Isbn de busqueda, no registrado"); 
        
           Publicacion encontrado = null;
           for ( Publicacion e : this.publi) {
            if (e.getIsbn().equals(p.getIsbn())) {
                encontrado = e;
                break;
            }
          }
         return encontrado;
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        
        //implementar
         if(this.publi==null)
           throw new ExcepcionAccesoDatos("No hay publicaciones registradas"); 
        if(p==null)
           throw new ExcepcionAccesoDatos("Parametro no permitido para la busqueda"); 
        if(p.getIsbn()==null)
          throw new ExcepcionAccesoDatos("Isbn de busqueda, no registrado"); 
        Publicacion eliminado = null;
        Iterator<Publicacion> it = this.publi.iterator();
        while (it.hasNext()) {
            Publicacion e = it.next();
            if (e.getIsbn().equals(p.getIsbn())) {
                it.remove();
                eliminado = e;
                break;
            }
        }
       return eliminado;
  
    }
    
}
