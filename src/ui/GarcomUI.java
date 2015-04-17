package ui;

import classe.Garcom;
import repositorio.GarcomRepo;
import util.Console;

public class GarcomUI 
{	
	public static void menu( GarcomRepo garcom )
	{
		System.out.println( "-------------\nMenu Gar�om\n" );
		System.out.println( "1- Adicionar Gar�om" );
		System.out.println( "2- Listar Gar�ons" );
		System.out.println( "0- Voltar" );
		
		int option = Console.scanInt( "\nEscolha uma op��o: " );
				
		switch( option )
		{
			case 1: add( garcom ); break;
			case 2: list( garcom ); break;
			case 0: main.menu(); break;
		}
	}
	
	public static void add( GarcomRepo garcom )
	{
		System.out.println( "-------------\n\tNovo Gar�om\n" );
		
		String name = Console.scanString( "Nome: " );
		String cpf = Console.scanString( "CPF: " );
		double salary = Console.scanDouble( "Sal�rio: " );
		
		garcom.addGarcom( new Garcom( name, cpf, salary ) );
			
		System.out.println( "\nGar�om adicionado com sucesso!" );
		
		menu( garcom );
	}
	
	public static void list( GarcomRepo garcom )
	{
		System.out.println( "-------------\nListagem de Gar�ons\n" );
		
		for( Garcom g: garcom.getAll() )
		{
			System.out.println( g.toString() );
		}
		
		System.out.println( "\nFim de gar�ons." );
		
		menu( garcom );
	}
}