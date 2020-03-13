/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controlador.conexionBD;
import Model.Profesional;
import Model.tipoProfesional;
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
@WebServlet(name = "servletAltaProfesional", urlPatterns = {"/servletAltaProfesional"})
public class servletAltaProfesional extends HttpServlet {

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
                                
                        
                                if (request.getParameter("legajo")==null) {
                                    
                                ArrayList<tipoProfesional> listaTipoProfesional = bd.cargarTipoProfesional();
                                request.setAttribute("listaTipoProfesional", listaTipoProfesional);
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaProfesional.jsp");
				
                                rd.forward(request, response);
                                
			} else {
                            
                            
                                
                                
				int id = Integer.parseInt(request.getParameter("legajo"));

				
				Profesional p = bd.obtenerProfesional(id);

				request.setAttribute("legajo", p.getLegajo());
				request.setAttribute("nombre", p.getNombre());
				request.setAttribute("apellido", p.getApellido());
				request.setAttribute("dni", p.getDni());
				request.setAttribute("telefono", p.getTelefono());
				request.setAttribute("domicilio", p.getDomicilio());
				request.setAttribute("email", p.getEmail());
                                
                                
				ArrayList<tipoProfesional> listaTipoProfesional = bd.cargarTipoProfesional();
                                request.setAttribute("listaTipoProfesional", listaTipoProfesional);
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaProfesional.jsp");
				
                                rd.forward(request, response);
                                
			}
                        
                            

		} catch (Exception ex) {
			response.sendRedirect("/index.jsp");
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
       
        
        
                try {
			int id;
			if (request.getParameter("txtId").equals("")) {
				id = -1;
			
                        } else {
				id = Integer.parseInt(request.getParameter("txtId"));
			}
			
                        String nombre = request.getParameter("txtNombre");
			String apellido = request.getParameter("txtApellido");
                        int dni = Integer.parseInt(request.getParameter("txtDni"));
                        int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
                        String domicilio = request.getParameter("txtDomicilio");
                        String email = request.getParameter("txtEmail");
                        String sexo = request.getParameter("rbtSexo");
                        int tipo = Integer.parseInt(request.getParameter("tipoProfesionalId"));
                        
                        tipoProfesional tp = new tipoProfesional();
                        tp.setIdTipoProfesional(tipo);


			Profesional pr = new Profesional(id,nombre,apellido,tp ,dni,sexo,telefono,domicilio,email);
			Profesional pro = new Profesional(nombre,apellido,tp ,dni,sexo,telefono,domicilio,email);
                       
			conexionBD bd = new conexionBD();

			boolean exito;

			if (id == -1) {
				exito= bd.insertarProfesional(pro);
			} else {
				exito = bd.modificarProfesional(pr);
			}

			if (exito) {
				response.sendRedirect("/centroMedicinalDeDeporte/servletListaProfesionales");
			} else {
				response.sendRedirect("/centroMedicinalDeDeporte/index.jsp");
			}

		} catch (Exception ex) {
			System.out.println(ex);
			response.sendRedirect("/index.jsp");
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
