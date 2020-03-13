/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Model.Disciplina;
import Model.Inscripcion;
import Model.OrdenMedica;
import Model.Paciente;
import Model.Practica;
import Model.Profesional;
import Model.ProfesionalXDisciplina;
import Model.Sede;
import Model.Usuario;
import Model.tipoProfesional;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dell
 */
public class conexionBD {
    
    private Connection con;

    
    private void abrirConexion()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con= DriverManager.getConnection("jdbc:sqlserver://DELL-PC:1433;databaseName=CentroDeMedicinaDeDeporte","sa","cristian123");
       
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar.");
        }
    
    }
    
    private void cerrarConexion()
    {
        try {
            if(!con.isClosed() && con!= null)
            {
                con.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cerrar la conexion.");
        }
    }
    
    //----------------------------USUARIO
    public String obtenerUsuario(Usuario u)
    {
        String user = "";
                try {
            
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from Usuario where nombreUsuario = '"+ u.getUsuario() +"' and clave='"+u.getClave()+"'");
            while(lector.next())
            {
                String usuario = lector.getString("nombreUsuario");
                String clave = lector.getString("clave");
                
                Usuario us = new Usuario (usuario,clave); 
                
                user= us.getUsuario();
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
    return user;
    
    } 
    
    
    //-------------------PACIENTE
    
    public boolean insertarPaciente(Paciente p)
    {
            int filasAfectadas=0;
        try {
            abrirConexion();
            String sql = "insert into Paciente values (?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, p.getNombre());
            st.setString(2, p.getApellido());
            st.setInt(3, p.getDni());
            st.setInt(4, p.getTelefono());
            st.setString(5, p.getEmail());
            st.setString(6, p.getDomicilio());
            st.setString(7, p.getSexo());

             
            filasAfectadas = st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }
            
            if (filasAfectadas > 0) {
			return true;
		} else {
			return false;
	}
    
    }
    
    
    public boolean modificarPaciente(Paciente p)
    {
           int filasAfectadas=0;
        try {
            abrirConexion();
            String sql = "update Paciente\n" +
                            "set nombre= ?,\n" +
                            "	apellido=?,\n" +
                            "	dni=?,\n" +
                            "	telefono=?,\n" +
                            "	email=?,\n" +
                            "	direccion=?,\n" +
                            "	sexo=?\n" +
                            "where idPaciente = ?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, p.getNombre());
            st.setString(2, p.getApellido());
            st.setInt(3, p.getDni());
            st.setInt(4, p.getTelefono());
            st.setString(5, p.getEmail());
            st.setString(6, p.getDomicilio());
            st.setString(7, p.getSexo());
            st.setInt(8, p.getIdPaciente());
             
            filasAfectadas = st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }
            
            if (filasAfectadas > 0) {
			return true;
		} else {
			return false;
	}
    
    }
    
    
    
    public Paciente obtenerPaciente(int id)
    {
        Paciente pa = null;
                
        try {
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from Paciente where idPaciente = " + id );
            while(lector.next())
            {
                  int idPaciente = lector.getInt("idPaciente");
                  String nombre= lector.getString("nombre");
                  String apellido = lector.getString("apellido");
                  int dni= lector.getInt("dni");
                  String sexo=lector.getString("sexo");
                  int telefono=lector.getInt("telefono");
                  String domicilio=lector.getString("direccion");
                  String email=lector.getString("email");
                
                  pa= new Paciente(idPaciente,nombre,apellido,dni,sexo,telefono,domicilio,email);
                
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
        return pa;
    
    }
    
    
      public boolean eliminarPaciente(int id)
    {
            int resultado = 0;
        
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("delete from paciente where idPaciente = " + id);
            
            resultado = st.executeUpdate();
            st.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{cerrarConexion();}
        
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
	}
    
    
    public ArrayList<Paciente> obtenerTodosPacientes()
    {
        ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
                
        try {
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from paciente");
            while(lector.next())
            {
                  int idPaciente = lector.getInt("idPaciente");
                  String nombre= lector.getString("nombre");
                  String apellido = lector.getString("apellido");
                  int dni= lector.getInt("dni");
                  String sexo=lector.getString("sexo");
                  int telefono=lector.getInt("telefono");
                  String domicilio=lector.getString("direccion");
                  String email=lector.getString("email");
                
                  Paciente p = new Paciente(idPaciente,nombre,apellido,dni,sexo,telefono,domicilio,email);
                  
                  listaPaciente.add(p);
                
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
        return listaPaciente;
    
    }
    
    //------------------------------- Tipo PROFESIONAL
    
    public ArrayList<tipoProfesional> cargarTipoProfesional()
    {
        ArrayList<tipoProfesional> listaTipoProfesional= new ArrayList<tipoProfesional>();
        try {
            
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from TipoProfesional");
            while(lector.next())
            {
                int id = lector.getInt("idTipoProfesional");
                String tipo = lector.getString("tipo");
                
                
                tipoProfesional tipProf = new tipoProfesional(id,tipo);
                listaTipoProfesional.add(tipProf);
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
    return listaTipoProfesional;
    
    }
    //------------------------------- PROFESIONAL
     public boolean insertarProfesional(Profesional p)
    {
            int filasAfectadas=0;
            try {
            abrirConexion();
            String sql = "insert into Profesional values (?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, p.getNombre());
            st.setString(2, p.getApellido());
            st.setInt(3, p.getDni());
            st.setInt(4, p.getTipo().getIdTipoProfesional());
            st.setInt(5, p.getTelefono());
            st.setString(6, p.getEmail());
            st.setString(7, p.getDomicilio());
            st.setString(8, p.getSexo());

            filasAfectadas= st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }
            if (filasAfectadas > 0) {
			return true;
		} else {
			return false;
	}
    
    }
     
     
     public boolean modificarProfesional(Profesional p)
    {
            int filasAfectadas=0;
            try {
            abrirConexion();
            String sql = "update profesional\n" +
                        "set	nombre =?,\n" +
                        "	apellido =?,\n" +
                        "	dni=?,\n" +
                        "	idTipo=?,\n" +
                        "	telefono=?,\n" +
                        "	email=?,\n" +
                        "	direccion=?,\n" +
                        "	sexo=?\n" +
                        "where idLegajo =?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, p.getNombre());
            st.setString(2, p.getApellido());
            st.setInt(3, p.getDni());
            st.setInt(4, p.getTipo().getIdTipoProfesional());
            st.setInt(5, p.getTelefono());
            st.setString(6, p.getEmail());
            st.setString(7, p.getDomicilio());
            st.setString(8, p.getSexo());
            st.setInt(9, p.getLegajo());

            filasAfectadas= st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }
            if (filasAfectadas > 0) {
			return true;
		} else {
			return false;
	}
    
    }
     
     
     public boolean eliminarProfesional(int id)
    {
            int resultado = 0;
        
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("delete from Profesional where idLegajo = ?");
            st.setInt(1, id);
            resultado = st.executeUpdate();
            st.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{cerrarConexion();}
        
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
	}
     
     public ArrayList<Profesional> comboProfesional(int tip)
    {
        ArrayList<Profesional> listaProfesional= new ArrayList<Profesional>();
        try {
            
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from Profesional where idTipo= " + tip);
            while(lector.next())
            {
                int legajo = lector.getInt("idLegajo");
                String nombre= lector.getString("nombre");
                String apellido= lector.getString("apellido");
                int dni = lector.getInt("dni");
                int tipo = lector.getInt("idTipo");
                int telefono = lector.getInt("telefono");
                String email = lector.getString("email");
                String direccion= lector.getString("direccion");
                String sexo = lector.getString("sexo");
                
                tipoProfesional tp = new tipoProfesional();
                tp.setIdTipoProfesional(tipo);
                
                Profesional p = new Profesional(legajo,nombre,apellido,tp,dni,sexo,telefono,direccion,email);
                listaProfesional.add(p);

            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
    return listaProfesional;
    
    }
     
     
     public ArrayList<Profesional> obtenerTodosProfesionales()
    {
        ArrayList<Profesional> listaProfesionales = new ArrayList<Profesional>();
                
        try {
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select p.* , tp.tipo from profesional p join TipoProfesional tp on p.idTipo=tp.idTipoProfesional");
            while(lector.next())
            {
                  int legajo = lector.getInt("idLegajo");
                  String nombre= lector.getString("nombre");
                  String apellido = lector.getString("apellido");
                  int dni= lector.getInt("dni");
                  int tipo  = lector.getInt("idTipo");
                  int telefono=lector.getInt("telefono");
                  String email=lector.getString("email");
                  String domicilio=lector.getString("direccion");
                  String sexo=lector.getString("sexo");
                  String tipoProfesional = lector.getString("tipo");
                  
                  tipoProfesional tp = new tipoProfesional(tipo,tipoProfesional);
                  
                
                  Profesional pr=new Profesional(legajo,nombre,apellido,tp,dni,sexo,telefono,domicilio,email);
                  
                  listaProfesionales.add(pr);
                
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
        return listaProfesionales;
    
    }
     
     public Profesional obtenerProfesional(int id)
    {
        Profesional p = null;
                
        try {
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from Profesional where idLegajo = " + id );
            while(lector.next())
            {
                   int legajo = lector.getInt("idLegajo");
                  String nombre= lector.getString("nombre");
                  String apellido = lector.getString("apellido");
                  int dni= lector.getInt("dni");
                  int tipo  = lector.getInt("idTipo");
                  int telefono=lector.getInt("telefono");
                  String email=lector.getString("email");
                  String domicilio=lector.getString("direccion");
                  String sexo=lector.getString("sexo");
                  
                  tipoProfesional tp = new tipoProfesional();
                  tp.setIdTipoProfesional(tipo);
                
                  p = new Profesional(legajo,nombre,apellido,tp,dni,sexo,telefono,domicilio,email);
                
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
        return p;
    
    }
     
     //---------------DISCIPLINA
     public ArrayList<Disciplina> cargarDisciplina()
    {
        ArrayList<Disciplina> listaDisciplina= new ArrayList<Disciplina>();
        try {
            
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from Disciplina");
            while(lector.next())
            {
                int id = lector.getInt("idDisciplina");              
                String tipo = lector.getString("tipo");
                String descripcion = lector.getString("descripcion");

                Disciplina d = new Disciplina(id,tipo,descripcion);
                listaDisciplina.add(d);
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
    return listaDisciplina;
    
    }
     
     //--------------ORDEN MEDICA
     
     public void insertarOrdenMedica(OrdenMedica om)
    {
    
        try {
            abrirConexion();
            String sql = "insert into OrdenMedica values (?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, om.getPaciente().getIdPaciente());
            st.setInt(2, om.getProfesional().getLegajo());
            st.setInt(3, om.getDisciplina().getIdDisciplina());
            st.setInt(4, om.getCantidadSesiones());
            st.setInt(5, om.getMinXSesion());
            st.setString(6, om.getDiagnostico());
            

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }
    
    }
     
     public ArrayList<OrdenMedica> obtenerOrdenesMedicas()
    {
        ArrayList<OrdenMedica> listaOrdenesMedicas = new ArrayList<OrdenMedica>();
                
        try {
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select om.* , P.nombre 'nombreP', P.apellido 'apellidoP' , pr.nombre 'nombrePR', pr.apellido 'apellidoPR', d.tipo \n" +
                                                    "from OrdenMedica om join Paciente p ON om.idPaciente = p.idPaciente\n" +
                                                    "join Profesional pr on om.idLegajo= pr.idLegajo \n" +
                                                    "join Disciplina d on d.idDisciplina = om.idDisciplina");
            while(lector.next())
            {
                  int idOrdenMedica = lector.getInt("idOrdenMedica");
                  int idPaciente = lector.getInt("idOrdenMedica");
                  int idLegajo = lector.getInt("idOrdenMedica");
                  int idDisciplina = lector.getInt("idDisciplina");
                  int cantidadSesiones = lector.getInt("cantidadSesiones");
                  int minXses = lector.getInt("minutoXSesionMensual");
                  String diagnostico = lector.getString("diagnostico");
                  String nombreP = lector.getString("nombreP");
                  String apellidoP = lector.getString("apellidoP");
                  String nombrePR = lector.getString("nombrePR");
                  String apellidoPR = lector.getString("apellidoPR");
                  String tipo = lector.getString("tipo");
                  
                  Paciente p = new Paciente();
                  p.setIdPaciente(idPaciente);
                  p.setNombre(nombreP);
                  p.setApellido(apellidoP);
                  
                  Profesional pr = new Profesional();
                  pr.setLegajo(idLegajo);
                  pr.setNombre(nombrePR);
                  pr.setApellido(apellidoPR);
                  
                  Disciplina d = new Disciplina();
                  d.setIdDisciplina(idDisciplina);
                  d.setDisciplina(tipo);
                  
                  OrdenMedica om = new OrdenMedica(idOrdenMedica,p,pr,d,cantidadSesiones,minXses,diagnostico);
                  
                  listaOrdenesMedicas.add(om);
                  
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
        return listaOrdenesMedicas;
    
    }
     
     
     
     public OrdenMedica obtenerOrdenMedica(int id)
    {
        OrdenMedica om = null;
                
        try {
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select om.* , P.nombre 'nombreP', P.apellido 'apellidoP' , pr.nombre 'nombrePR', pr.apellido 'apellidoPR', d.tipo \n" +
                                                    "from OrdenMedica om join Paciente p ON om.idPaciente = p.idPaciente\n" +
                                                    "join Profesional pr on om.idLegajo= pr.idLegajo \n" +
                                                    "join Disciplina d on d.idDisciplina = om.idDisciplina where om.idOrdenMedica = " + id);
            while(lector.next())
            {
                  int idOrdenMedica = lector.getInt("idOrdenMedica");
                  int idPaciente = lector.getInt("idPaciente");
                  int idLegajo = lector.getInt("idLegajo");
                  int idDisciplina = lector.getInt("idDisciplina");
                  int cantidadSesiones = lector.getInt("cantidadSesiones");
                  int minXses = lector.getInt("minutoXSesionMensual");
                  String diagnostico = lector.getString("diagnostico");
                  String nombreP = lector.getString("nombreP");
                  String apellidoP = lector.getString("apellidoP");
                  String nombrePR = lector.getString("nombrePR");
                  String apellidoPR = lector.getString("apellidoPR");
                  String tipo = lector.getString("tipo");
                  
                  Paciente p = new Paciente();
                  p.setIdPaciente(idPaciente);
                  p.setNombre(nombreP);
                  p.setApellido(apellidoP);
                  
                  Profesional pr = new Profesional();
                  pr.setLegajo(idLegajo);
                  pr.setNombre(nombrePR);
                  pr.setApellido(apellidoPR);
                  
                  Disciplina d = new Disciplina();
                  d.setIdDisciplina(idDisciplina);
                  d.setDisciplina(tipo);
                  
                   om = new OrdenMedica(idOrdenMedica,p,pr,d,cantidadSesiones,minXses,diagnostico);
                  
                  
                  
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
        return om;
    
    }
     
     //-------------------------Inscripcion
     
     public boolean insertarInscripcion(Inscripcion i )
    {
            int filasAfectadas=0;
        try {
            abrirConexion();
            String sql = "insert into Inscripcion values ( (?) ,convert(date,GETDATE()))";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, i.getOrdenMedica().getIdOrdenMedica());

            filasAfectadas= st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }
        
        if (filasAfectadas > 0) {
			return true;
		} else {
			return false;
	}
    
    }
     
      public ArrayList<Inscripcion> obtenerInscripciones()
    {
        ArrayList<Inscripcion> listaInscripciones = new ArrayList<Inscripcion>();
                
        try {
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select i.idInscripcion,i.fechaAlta, om.idOrdenMedica,P.nombre 'nombreP', P.apellido 'apellidoP' , pr.nombre 'nombrePR', pr.apellido 'apellidoPR', d.tipo\n" +
"from Inscripcion i join OrdenMedica om on i.idOrdenMedica = om.idOrdenMedica join Paciente p ON om.idPaciente = p.idPaciente\n" +
"                                                    join Profesional pr on om.idLegajo= pr.idLegajo\n" +
"                                                    join Disciplina d on d.idDisciplina = om.idDisciplina");
            while(lector.next())
            {
                  int idInscripcion = lector.getInt("idInscripcion");
                  String fecha = lector.getString("fechaAlta");
                  int idOrdenMedica = lector.getInt("idOrdenMedica");
                  String nombreP = lector.getString("nombreP");
                  String apellidoP = lector.getString("apellidoP");
                  String nombrePR = lector.getString("nombrePR");
                  String apellidoPR = lector.getString("apellidoPR");
                  String tipo = lector.getString("tipo");
                  
                  Paciente p = new Paciente();
                  p.setNombre(nombreP);
                  p.setApellido(apellidoP);
                  
                  Disciplina d = new Disciplina();
                  d.setDisciplina(tipo);
                  
                  tipoProfesional tp = new tipoProfesional();
                  tp.setTipoProfesional(tipo);
                  
                  Profesional pr = new Profesional();
                  pr.setNombre(nombrePR);
                  pr.setApellido(apellidoPR);
                  
                  
                  OrdenMedica om = new OrdenMedica();
                  om.setProfesional(pr);
                  om.setPaciente(p);
                  om.setIdOrdenMedica(idOrdenMedica);
                  om.setDisciplina(d);
                  
                  Inscripcion i = new Inscripcion(idInscripcion,om,fecha);

                  listaInscripciones.add(i);
                
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
        return listaInscripciones;
    
    }
     
     //-------------------------PRACTICA
     
     public ArrayList<Practica> cargarPractica()
    {
        ArrayList<Practica> listaPractica= new ArrayList<Practica>();
        try {
            
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from Practica");
            while(lector.next())
            {
                int id = lector.getInt("idPractica");              
                String tipo = lector.getString("horario");
                int descripcion = Integer.parseInt(lector.getString("duracion"));

                Practica p = new Practica(id,tipo,descripcion);
                listaPractica.add(p);
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
    return listaPractica;
    
    }
     
     
   //-----------------------SEDES
      public ArrayList<Sede> cargarSede()
    {
        ArrayList<Sede> listaSede= new ArrayList<Sede>();
        try {
            
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from Sede");
            while(lector.next())
            {
                int id = lector.getInt("idSede");              
                String nombre = lector.getString("nombre");
                String direccion = lector.getString("direccion");
                int telefono = Integer.parseInt(lector.getString("telefono"));

                Sede s = new Sede(id,nombre,direccion,telefono);
                listaSede.add(s);
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
    return listaSede;
    
    }
    
      
     //--------------- REPORTES
      
      
     public ArrayList<OrdenMedica> pacientesXDisciplina(int id)
    {
        ArrayList<OrdenMedica> pacientesXDisciplina= new ArrayList<OrdenMedica>();
        try {
            
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from pacientesXDisciplina("+ id + ")");
            while(lector.next())
            {
                int idPaciente = lector.getInt("idPaciente");
                  String nombre= lector.getString("nombre");
                  String apellido = lector.getString("apellido");
                  int dni= lector.getInt("dni");
                  String sexo=lector.getString("sexo");
                  int telefono=lector.getInt("telefono");
                  String domicilio=lector.getString("direccion");
                  String email=lector.getString("email");
                  String disciplina = lector.getString("Disciplina");
                
                  Paciente p = new Paciente(idPaciente,nombre,apellido,dni,sexo,telefono,domicilio,email);
                  Disciplina d = new Disciplina(); 
                  d.setDisciplina(disciplina);
                  
                  OrdenMedica om = new OrdenMedica();
                  om.setPaciente(p);
                  om.setDisciplina(d);
                  
                  pacientesXDisciplina.add(om);
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
    return pacientesXDisciplina;
      
      
    }
      
     
     
     
     
     
     public ArrayList<OrdenMedica> cantidadOrdenesXmedico()
    {
        ArrayList<OrdenMedica> lista= new ArrayList<OrdenMedica>();
        try {
            
            abrirConexion();
            Statement comando = con.createStatement();
            ResultSet lector = comando.executeQuery("select * from cantidadOrdenesXProfesional");
            while(lector.next())
            {
                  int legajo = lector.getInt("Legajo");
                  String nombre= lector.getString("Profesional");
                  int cantidadInscripciones= lector.getInt("Cant_Inscripciones");
                  
                  Profesional p = new Profesional();
                  p.setLegajo(legajo);
                  p.setNombre(nombre);
                  
                  OrdenMedica om = new OrdenMedica();
                  om.setProfesional(p);
                  om.setCantidadSesiones(cantidadInscripciones);
                  
                  lista.add(om);
    
            }
            lector.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        cerrarConexion();}
    return lista;
      
      
    }
      
     
}
