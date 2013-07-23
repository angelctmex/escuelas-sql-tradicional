package com.zeus.escuelas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zeus.escuelas.db.MySQLConnection;
import com.zeus.escuelas.domain.EscuelaDomain;

public class EscuelasDao extends MySQLConnection{
	
	Connection conexionDB;
	
	public boolean creaNuevoRegistro( EscuelaDomain escuela ){
		
		PreparedStatement pstmt = null;
		
		boolean resultado = false;
		
		final String QUERY = "INSERT INTO ESCUELAS ( NOMBRE_ESCUELA, DIRECCION, TELEFONO, ESPECIALIDAD) VALUES (?,?,?,?)";
		
		try{
			
			/** Invocamos el metodo que crea la conexion a la Base de Datos **/
			conexionDB = obtenConexionConMysql();
			
			/** Preparamos el Insert en la BD **/
			pstmt = conexionDB.prepareStatement(QUERY);
			pstmt.setString(1, escuela.getNombreEscuela());
			pstmt.setString(2, escuela.getDireccion());
			pstmt.setString(3, escuela.getTelefono());
			pstmt.setString(4, escuela.getEspecialidad());
			
			/** Ejecutamos el Insert en la BD **/
			resultado = pstmt.execute();
			
		}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}finally{
			
			/** Cerrando la conexion a la BD **/
			try {
				
				System.out.println("Cerrando la conexion en la BD");
				if( conexionDB != null )conexionDB.close();
				if( pstmt != null )pstmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
		
		
	}
	
	
	public List<EscuelaDomain> obtenTodosLosRegistros(){
		
		List<EscuelaDomain> listaAlumnos = new ArrayList<EscuelaDomain>();
		
		Statement stmt = null;
		ResultSet rs;
		
		final String QUERY = "SELECT * FROM ESCUELAS";
		
		try{
			
			/** Invocamos el metodo que crea la conexion a la Base de Datos **/
			conexionDB = obtenConexionConMysql();
			stmt = conexionDB.createStatement(); 
			
			/** Ejecutamos la consulta en la BD **/
			rs = stmt.executeQuery(QUERY);
			
			/** Recorremos los elementos de la Lista **/
			while(rs.next()){
				
				EscuelaDomain escuela = new EscuelaDomain();
				escuela.setIdEscuela    ( rs.getLong("ID_ESCUELA") );
				escuela.setNombreEscuela( rs.getString("NOMBRE_ESCUELA") );
				escuela.setDireccion    ( rs.getString("DIRECCION") );
				escuela.setTelefono     ( rs.getString("TELEFONO") );
				escuela.setEspecialidad ( rs.getString("ESPECIALIDAD") );
				
				listaAlumnos.add(escuela);
			}
			
		}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}finally{
			
			/** Cerrando la conexion a la BD **/
			try {
				
				System.out.println("Cerrando la conexion en la BD");
				if( conexionDB != null )conexionDB.close();
				if( stmt != null )stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaAlumnos;
		
	}


}
