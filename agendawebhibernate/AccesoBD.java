/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendawebhibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Mañanas
 */
public class AccesoBD {
    private static SessionFactory sessionFactory;
    public static void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			System.out.println(e.getMessage());
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
    public static void insertarContacto(Contacto c){
	Session s=sessionFactory.openSession();
	s.beginTransaction();
	s.save(c);
	s.getTransaction().commit();
    }
    public static List<Contacto> listarContactos() {
	//List<Contacto> lista_contactos=new List();
	Session s=sessionFactory.openSession();
        String hql="FROM Contacto";
        Query consulta=s.createQuery(hql);
        List<Contacto> resultados=(List<Contacto>) consulta.list();
        for (Contacto lista : resultados) 
        {
            System.out.println("Nombre: "+lista.getNombre()+"\t"+"Email: "+lista.getEmail()+"\t"+"Telefono: "+lista.getTelefono());	
	} 
        return resultados;   
    }
    public static List<Contacto> listarPorNombre(String contacto_buscado) {
	//ArrayList<Contacto> lista_contactos_por_nombre=new ArrayList();
	Session s=sessionFactory.openSession();
        String hql="FROM Contacto WHERE nombre=:nombre";
        Query consulta=s.createQuery(hql);
        consulta.setParameter("nombre",contacto_buscado);
        List<Contacto> resultados=(List<Contacto>) consulta.list();
        for (Contacto lista : resultados) {
        	System.out.println("Nombre: "+lista.getNombre()+"\t"+"Email: "+lista.getEmail()+"\t"+"Telefono: "+lista.getTelefono());	
		} 
        return resultados;  
	}

    static void borrarContacto(int id) {
       //ArrayList<Contacto> lista_contactos=new ArrayList();
	Session s=sessionFactory.openSession();
        String hql="DELETE FROM Contacto WHERE id=:id_contacto";
        Query consulta=s.createQuery(hql);
        consulta.setParameter("id_contacto",id);
        int result = consulta.executeUpdate();
        //List<Contacto> resultados=(List<Contacto>) consulta.list();
        /*for (Contacto lista : resultados) {
        	System.out.println("Nombre: "+lista.getNombre()+"\t"+"Email: "+lista.getEmail()+"\t"+"Telefono: "+lista.getTelefono());	
		} */
         
	}
}
