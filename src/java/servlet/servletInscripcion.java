/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controlador.conexionBD;
import Model.Inscripcion;
import Model.OrdenMedica;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "servletInscripcion", urlPatterns = {"/servletInscripcion"})
public class servletInscripcion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        
       
        
                        conexionBD bd = new conexionBD();
			
                        int id = Integer.parseInt(request.getParameter("idOrdenMedica"));
                        
                            OrdenMedica om = bd.obtenerOrdenMedica(id);
                        
                                request.setAttribute("idOrdenMedica", om.getIdOrdenMedica());
				request.setAttribute("nombre", om.getPaciente().toString());
				request.setAttribute("disciplina", om.getDisciplina().getDisciplina());
                                
        
        
         RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaInscripcion.jsp");
            rd.forward(request, response);
        
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
        
        
        int nroOrden = Integer.parseInt(request.getParameter("txtNroOrden"));   
        
        OrdenMedica om = new OrdenMedica();
        om.setIdOrdenMedica(nroOrden);
        
        Inscripcion i = new Inscripcion();
        i.setOrdenMedica(om);
        
        conexionBD bd = new conexionBD();
        boolean exito = bd.insertarInscripcion(i);
        
        if (exito) {
				response.sendRedirect("/centroMedicinalDeDeporte/servletListaInscripciones");
			} else {
				response.sendRedirect("/centroMedicinalDeDeporte/index.jsp");
			}
        
        
        
        
        
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
