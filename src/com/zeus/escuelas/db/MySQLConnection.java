package com.zeus.escuelas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	protected Connection obtenConexionConMysql(){
		
		Connection conexion = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
            System.out.println("Conectando a la base...");
            
            /** Obteniendo la conexion a la BD **/
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/escuelas", "root", "ver9batim"
                    );
            
            System.out.println("Conexion a BD establecida");
            
		}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
            } catch(Exception e) {
            System.out.println("Se produjo un error inesperado: "+e.getMessage());
        }
		
		return conexion;
	}
}
