package ui;

import repositorio.PedidoRepo;
import util.Console;

public class PedidosUI
{
	public static void menu( PedidoRepo pedido )
	{
		System.out.println( "-------------\nMenu Pedidos\n" );
		System.out.println( "1- Adicionar Pedido" );
		System.out.println( "0- Voltar" );
		
		int option = Console.scanInt( "\nEscolha uma op��o: " );
				
		switch( option )
		{
			case 1: add( pedido ); break;
			case 0: main.menu(); break;
		}
	}
	
	public static void add( PedidoRepo pedido )
	{
		System.out.println( "N�o implementado ainda." );
		menu( pedido );
	}
}