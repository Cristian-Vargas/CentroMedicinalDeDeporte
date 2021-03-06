/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controlador.conexionBD;
import Model.Practica;
import Model.Profesional;
import Model.Sede;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "servletAsistencia", urlPatterns = {"/servletAsistencia"})
public class servletAsistencia extends HttpServlet {

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
        
            try {
			conexionBD bd = new conexionBD();
			ArrayList<Sede> listaSede = bd.cargarSede();
			request.setAttribute("listaSede", listaSede);
                        
                        ArrayList<Practica> listaPractica = bd.cargarPractica();
                        request.setAttribute("listaPractica", listaPractica);
                        
                        
                        
                        int tip =1;
                       
                        ArrayList<Profesional> listaProfesional = bd.comboProfesional(tip);
                        request.setAttribute("listaProfesional", listaProfesional);
                        
                        
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/asistencia.jsp");
                            rd.forward(request, response);
                        
                        
                        
		
                } catch (Exception ex) {
			response.sendRedirect("/centroMedicinalDeDeporte/index.jsp");
		}
        
                finally{
            
            }
        
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
