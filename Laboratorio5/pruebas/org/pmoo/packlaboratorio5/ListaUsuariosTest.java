package org.pmoo.packlaboratorio5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ListaUsuariosTest extends TestCase
{
	
	private Usuario u1;
	private Usuario u2;
	private Usuario u3;
	//private Usuario auxUser;
	
	private Libro l1;
	private Libro l2;
	private Libro l3;
		
	@Before
	public void setUp()
	{
		u1 = new Usuario("Armando Guerra", 1);
		u2 = new Usuario("Kepa Sarasola", 2); 
		u3 = new Usuario("Lola Mento", 3);
		
		l1=new Libro("Cumbres borrascosas","Emily Bronte",1);
		l2=new Libro("Sentido y sensibilidad","Jane Austen",2);
		l3 = new Libro("El hobbit", "JRR Tolkien",3);
	}
	
	@After
	public void tearDown()
	{
		u1 = null;
		u2 = null;
		u3 = null;
		ListaUsuarios.getListaUsuarios().resetear();
	}
	
	
		
	@Test		
	public void testImprimir()
	{
			
		assertNotNull(ListaUsuarios.getListaUsuarios());		
		
		u1.anadirLibro(l1);
		u3.anadirLibro(l2);
		u3.anadirLibro(l3);
		
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u2);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u3);
			
		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase ListaUsuarios");
		System.out.println("\nLa información de la lista de usuarios debería mostrarse de este modo:\n");
		
		System.out.println("Hay un total de 3 usuarios.");
		System.out.println("ID: 1: Armando Guerra");
		System.out.println("---> Tiene el siguiente título en préstamo:");
		System.out.println("* Cumbres borrascosas, escrito por Emily Bronte.");
		System.out.println("ID: 2: Kepa Sarasola");
		System.out.println("---> No tiene libros en préstamo.");
		System.out.println("ID: 3: Lola Mento");
		System.out.println("---> Tiene los siguientes 2 títulos en préstamo:");
		System.out.println("* Sentido y sensibilidad, escrito por Jane Austen.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");
		
		System.out.println("\nY tu programa lo muestra de este modo:");
		ListaUsuarios.getListaUsuarios().imprimir();
		System.out.println("\n===============================================================");
		
		ListaUsuarios.getListaUsuarios().darDeBajaUsuario(1);
		ListaUsuarios.getListaUsuarios().darDeBajaUsuario(2);
		ListaUsuarios.getListaUsuarios().darDeBajaUsuario(3);
		assertEquals(0,ListaUsuarios.getListaUsuarios().getTamano());	
						
		
	}
		
	@Test
	public void testGetListaUsuarios() {
		assertEquals(0,ListaUsuarios.getListaUsuarios().getTamano());
	}
	
	@Test
	public void testGetTamano() {
		assertEquals(0,ListaUsuarios.getListaUsuarios().getTamano());
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		assertEquals(1,ListaUsuarios.getListaUsuarios().getTamano());
	}
	
	@Test
	public void testBuscarUsuarioPorId() {
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		assertEquals(null,ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(2));
		assertEquals(u1,ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(1));
	}
	
	@Test
	public void testExisteUsuarioConMismoId() {
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		assertFalse(ListaUsuarios.getListaUsuarios().existeUsuarioConMismoId(u2));
		assertTrue(ListaUsuarios.getListaUsuarios().existeUsuarioConMismoId(u1));
	}
	
	@Test
	public void testDarDeAltaUsuario() {
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		assertTrue(ListaUsuarios.getListaUsuarios().existeUsuarioConMismoId(u1));
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		assertTrue(ListaUsuarios.getListaUsuarios().existeUsuarioConMismoId(u1));
	}
	
	@Test
	public void testDarDeBajaUsuario() {
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u2);
		ListaUsuarios.getListaUsuarios().darDeBajaUsuario(3);
		assertEquals(2,ListaUsuarios.getListaUsuarios().getTamano());
		ListaUsuarios.getListaUsuarios().darDeBajaUsuario(2);
		assertEquals(1,ListaUsuarios.getListaUsuarios().getTamano());
	}
	
	@Test
	public void testQuienLoTienePrestado() {
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u2);
		u1.anadirLibro(l1);
		u2.anadirLibro(l2);
		assertEquals(u1,ListaUsuarios.getListaUsuarios().quienLoTienePrestado(l1));
		assertEquals(null,ListaUsuarios.getListaUsuarios().quienLoTienePrestado(l3));
		assertEquals(u2,ListaUsuarios.getListaUsuarios().quienLoTienePrestado(l2));
	}
	
	@Test
	public void testResetear() {
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u2);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u3);
		ListaUsuarios.getListaUsuarios().resetear();
		assertEquals(0,ListaUsuarios.getListaUsuarios().getTamano());
	}
}

