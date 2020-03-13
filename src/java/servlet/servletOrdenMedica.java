/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controlador.conexionBD;
import Model.Disciplina;
import Model.OrdenMedica;
import Model.Paciente;
import Model.Profesional;
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
@WebServlet(name = "servletOrdenMedica", urlPatterns = {"/servletOrdenMedica"})
public class servletOrdenMedica extends HttpServlet {

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
			

                            int id = Integer.parseInt(request.getParameter("idPaciente"));

				
				Paciente p = bd.obtenerPaciente(id);

				request.setAttribute("idPaciente", p.getIdPaciente());
				request.setAttribute("nombre", p.toString());
				request.setAttribute("dni", p.getDni());
				
                                
                                ArrayList<Profesional> listaProfesional = bd.comboProfesional(1);
                                request.setAttribute("listaProfesional", listaProfesional);
                                
				ArrayList<Disciplina> listaDisciplina = bd.cargarDisciplina();
                                request.setAttribute("listaDisciplina", listaDisciplina);

                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ordenMedica.jsp");
                                rd.forward(request, response);

                        
		
        } catch (Exception ex) {
			response.sendRedirect("");
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
        
                    int idPaciente = Integer.parseInt(request.getParameter("txtNroPaciente"));
                    int legajo = Integer.parseInt(request.getParameter("ProfesionalId"));
                    int disciplina = Integer.parseInt(request.getParameter("listaDisciplinaid"));
                    int cantSes = Integer.parseInt(request.getParameter("txtCantidadSesiones"));
                    int minXses = Integer.parseInt(request.getParameter("txtMinutosXSesionMensual"));
                    String diagnostico = request.getParameter("txtDiagnostico");
        
        Paciente p = new Paciente();
        p.setIdPaciente(idPaciente);
        
        Profesional pr = new Profesional();
        pr.setLegajo(legajo);
        
        Disciplina d = new Disciplina();
        d.setIdDisciplina(disciplina);
        
        OrdenMedica om = new OrdenMedica(p,pr,d,cantSes,minXses,diagnostico);
        conexionBD bd = new conexionBD();
        bd.insertarOrdenMedica(om);
        
        
        response.sendRedirect("/centroMedicinalDeDeporte/servletListaOrdenMedica");
        
        
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
