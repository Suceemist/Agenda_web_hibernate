/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendawebhibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mañanas
 */
@WebServlet(name = "ServletAgenda", urlPatterns = {"/ServletAgenda"})
public class ServletAgenda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String accion=request.getParameter("accion");
       try {
            AccesoBD.setUp();
	} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
        if(accion.equals("vercontactos")){
            List<Contacto> lista_contactos=AccesoBD.listarContactos();
            request.setAttribute("contactos", lista_contactos);
            request.getRequestDispatcher("vercontactos.jsp").forward(request, response);
        }else if (accion.equals("insertar")){
            String nombre=request.getParameter("nombre");
            String email=request.getParameter("email");
            String telefono=request.getParameter("telefono");
            Contacto c=new Contacto(nombre, email,telefono);
            AccesoBD.insertarContacto(c);
            request.getRequestDispatcher("index.jsp").forward(request, response);  
        }else if (accion.equals("buscar")){
            String nombre_buscado=request.getParameter("nombre_buscado");
            List<Contacto> lista_contactos_nombre=AccesoBD.listarPorNombre(nombre_buscado);
            request.setAttribute("contactos", lista_contactos_nombre);
            request.getRequestDispatcher("vercontactos.jsp").forward(request, response);
        
        }else if (accion.equals("borrar")){
            String id_libro=request.getParameter("id");
            int id=Integer.parseInt(id_libro);
            AccesoBD.borrarContacto(id);
            //String situacion=request.getParameter("situacion");
            List<Contacto> lista_contactos=AccesoBD.listarContactos();
            request.setAttribute("contactos", lista_contactos);
            request.getRequestDispatcher("vercontactos.jsp").forward(request, response);
    }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }
