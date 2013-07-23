package com.zeus.escuelas.test;

import java.util.List;

import com.zeus.escuelas.dao.EscuelasDao;
import com.zeus.escuelas.domain.EscuelaDomain;

public class EscuelasDAOTest {
	
	static EscuelasDao escuelaDao;
	
	public static void main(String[] args) {
		
		System.out.println("Iniciando Funcion...");
		
		escuelaDao = new EscuelasDao();
		
		insertaNuevoRegistro();
		ejecutaPruebaListarTodos();
		
	}
	
	/** Funcion que lista todos los elementos de la Tabla Escuelas **/
	public static void insertaNuevoRegistro(){
		
		System.out.println("Ejecutando Funcion ==> Insertar nuevo elemento...");
		
		EscuelaDomain escuela = new EscuelaDomain();
		
		escuela.setDireccion("CALLE DE LA ALEGRIA # 29");
		escuela.setEspecialidad("FISICO-QUIMICO");
		escuela.setNombreEscuela("UPIBI");
		escuela.setTelefono("565811");
		
		escuelaDao.creaNuevoRegistro(escuela);
		
	}
	
	/** Funcion que lista todos los elementos de la Tabla Escuelas **/
	public static void ejecutaPruebaListarTodos(){
		
		System.out.println("Ejecutando Funcion ==> Listar Todos los elementos...");
		
		List<EscuelaDomain> list = escuelaDao.obtenTodosLosRegistros();
		
		for( EscuelaDomain escuela: list ){
			System.out.println( escuela.toString() );
		}
		
	}

}
