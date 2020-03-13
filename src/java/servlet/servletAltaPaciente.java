/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controlador.conexionBD;
import Model.Paciente;
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
@WebServlet( urlPatterns = {"/servletAltaPaciente"})
public class servletAltaPaciente extends HttpServlet {

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

			if (request.getParameter("idPaciente")==null) {
				response.sendRedirect("/centroMedicinalDeDeporte/altaPaciente.jsp");
			} else {
				int id = Integer.parseInt(request.getParameter("idPaciente"));

				conexionBD bd = new conexionBD();
				Paciente p = bd.obtenerPaciente(id);

				request.setAttribute("idPaciente", p.getIdPaciente());
				request.setAttribute("nombre", p.getNombre());
				request.setAttribute("apellido", p.getApellido());
				request.setAttribute("dni", p.getDni());
				request.setAttribute("telefono", p.getDni());
				request.setAttribute("domicilio", p.getDomicilio());
				request.setAttribute("email", p.getEmail());
                                

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaPaciente.jsp");
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


			Paciente p = new Paciente(nombre,apellido,dni,sexo,telefono,domicilio,email);
                        Paciente pa = new Paciente(id,nombre,apellido,dni,sexo,telefono,domicilio,email);
			conexionBD bd = new conexionBD();

			boolean exito;

			if (id == -1) {
				exito= bd.insertarPaciente(p);
			} else {
				exito = bd.modificarPaciente(pa);
			}

			if (exito) {
				response.sendRedirect("/centroMedicinalDeDeporte/servletListaPaciente");
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
