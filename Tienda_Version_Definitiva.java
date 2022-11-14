package Examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Tienda_Version_Definitiva {
	public static void main(String args[]) {
	
		Scanner sc= new Scanner(System.in);
		
		ArrayList<Digimon> digimon = new ArrayList();
		ArrayList<Digimon> digimon_ventas = new ArrayList();
		ArrayList<Cliente> cliente = new ArrayList();
		ArrayList<Integer> numeros = new ArrayList();
		ArrayList<Integer> cantidadd = new ArrayList();

		
		OrdenarPorPrecio ordenarprecio = new OrdenarPorPrecio();
		OrdenarPorNombre ordenarnombre = new OrdenarPorNombre();
		OrdenarPorID OrdenarPorID = new OrdenarPorID();

		
		digimon.add( new Digimon(0, "Androide",0,5, 0, 80) );
		digimon.add( new Digimon(0, "Pikachu",0,10, 0, 25) );
		digimon.add( new Digimon(0, "Mercadona",0,8, 0, 65) );

		int respuesta =89238;
		
		do {
		
			System.out.println(" --------------------------------------------------------------------");
			System.out.println("|                             Bienvenido                             |");
			System.out.println("|--------------------------------------------------------------------|");
			System.out.println("|      1) Mostrar artículos.                                         |");
			System.out.println("|      2) Venta a cliente.                                           |");
			System.out.println("|      3) Compra a proveedor.                                        |");
			System.out.println("|      4) Gestiona artículos.                                        |");
			System.out.println("|      5) Criterios de ordenación.                                   |");
			System.out.println("|      6) Mostrar Clientes.                                          |");
			System.out.println("|      7) Mostrar Historico.                                         |");
			System.out.println("|      0) Salir                                                      |");
			System.out.println("----------------------------------------------------------------------");
			System.out.print(">> ");
		
			respuesta = sc.nextInt();
			sc.nextLine();
			
			switch(respuesta) {
			case 1:
				
		        for(int i = 0; i < digimon.size(); i++) {
		            System.out.println(digimon.get(i));
		        }
				
				break;
			case 2:
				
				String nombre_cliente;
				
				Double Precio_Total = (double) 0;
				int cantidad = 0;
				int r;
				
				System.out.println("Inserte su nombre: ");
				nombre_cliente = sc.next();
				try {
					do {
						System.out.println("ID: ");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.println("Cantidad: ");
						cantidad = sc.nextInt();
						sc.nextLine();
						if(digimon.get(id).vender(cantidad)==true) {
							Precio_Total = (digimon.get(id).getPrecio_venta()+Precio_Total)*cantidad;
							cantidadd.add(cantidad);
							numeros.add(id);
						}	
						
						System.out.println("Inserte algun numero positivo si quiere seguir con la compra, si no inserte un numero negativo");
						
						r = sc.nextInt();
						sc.nextLine();
						
					}while(r>0);
				}catch(IndexOutOfBoundsException ex) {
					System.out.println("Lo siento has elegido un producto que no existe.");
				}
					
					System.out.println("Precio Total: "+Precio_Total+" , ¿Esta seguro de querer realizar la compra?, si es así inserte 1, si no es así inserte cualquier otro numero");
					int r1 = sc.nextInt();
					sc.nextLine();
					if(r1==1) {
						System.out.println("Compra Realizada Con Exito");
						cliente.add( new Cliente(nombre_cliente, Precio_Total) );
				        for(int i = 0; i < numeros.size(); i++) {
							digimon_ventas.add(digimon.get(i));
							digimon_ventas.get(i).setStock(cantidadd.get(i));
				        }
					}
					else {
						System.out.println("Compra Cancelada");
					}
					
				break;
			case 3:
				
				Double Precio_Total_Compra = (double) 0;
				int cantidad_compra = 0;
				int respuesta_compra;
				try {
					do {
						
						System.out.println("ID: ");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.println("Cantidad: ");
						cantidad_compra = sc.nextInt();
						sc.nextLine();
						digimon.get(id).comprar(cantidad_compra);
							
						
						System.out.println("Inserte algun numero positivo si quiere seguir con la compra, si no inserte un numero negativo");
						respuesta_compra = sc.nextInt();
						sc.nextLine();
						
					}while(respuesta_compra>0);
				}catch(IndexOutOfBoundsException ex) {
					System.out.println("Lo siento has elegido un producto que no existe.");
				}
				break;
			case 4:
				
				int respuesta_caso4=99;
				
				do {
				
					System.out.println(" --------------------------------------------------------------------");
					System.out.println("|                             Bienvenido                             |");
					System.out.println("|--------------------------------------------------------------------|");
					System.out.println("|      1) Añadir artículo.                                           |");
					System.out.println("|      2) Eliminar artículo.                                         |");
					System.out.println("|      3) Editar artículo.                                           |");                      
					System.out.println("|      0) Salir                                                      |");
					System.out.println("----------------------------------------------------------------------");
					System.out.print(">> ");
				
					respuesta_caso4 = sc.nextInt();
					sc.nextLine();
					
					switch(respuesta_caso4) {
					
					case 1:
						
						System.out.println("Dime el nombre");
						String nombre = sc.next();
						
						System.out.println("Dime el Precio de compra");
						int Precio_Compra_Anadir = sc.nextInt();
						sc.nextLine();

						System.out.println("Dime el Stock");
						int Stock_Anadir = sc.nextInt();
						sc.nextLine();

						digimon.add(new Digimon(0,nombre,0,Precio_Compra_Anadir,0,Stock_Anadir));
												
						break;
					case 2:
						
						System.out.println("Dime el ID");
						int id_eliminar = sc.nextInt();
						sc.nextLine();
						digimon.remove(id_eliminar);
						
						break;
					case 3:
						
						System.out.println("Dime el ID");
						int id_modificar = sc.nextInt();
						sc.nextLine();
						System.out.println(digimon.get(id_modificar));
						
						System.out.println("Nombre: ");
						digimon.get(id_modificar).setNombre(sc.next());
						System.out.println("Precio de compra: ");
						digimon.get(id_modificar).setPrecio_compra(sc.nextInt());
						sc.nextLine();
						System.out.println("Stock: ");
						digimon.get(id_modificar).setStock(sc.nextInt());
						sc.nextLine();
												
						digimon.get(id_modificar).setPrecio_venta((digimon.get(id_modificar).getPrecio_compra()+0.5)+(digimon.get(id_modificar).getPrecio_compra()*21/100));

						break;
					default:
						break;
					}
					
				}while(respuesta_caso4!=0);
					
				break;
			case 5:
				int answer;
				System.out.println(" --------------------------------------------------------------------");
				System.out.println("|                             Bienvenido                             |");
				System.out.println("|--------------------------------------------------------------------|");
				System.out.println("|      1) Ordenar por defecto.                                       |");
				System.out.println("|      2) Ordenar por ID.                                            |");
				System.out.println("|      3) Ordenar por nombre.                                        |");
				System.out.println("|      4) Ordenar por precio.                                        |");
				System.out.println("|      0) Salir                                                      |");
				System.out.println("----------------------------------------------------------------------");
				do {
					answer = sc.nextInt();
					sc.nextLine();
					if(answer==1) {
						Collections.sort(digimon);
						
						Iterator<Digimon> it = digimon.iterator();
						while(it.hasNext()) {
							System.out.println(it.next());
						}
					}
					else if(answer==2) {
						Collections.sort(digimon, OrdenarPorID);
						
						Iterator<Digimon> it = digimon.iterator();
						while(it.hasNext()) {
							System.out.println(it.next());
						}
					}
					else if(answer==3){
						Collections.sort(digimon, ordenarnombre);
	
						Iterator<Digimon> it = digimon.iterator();
						while(it.hasNext()) {
							System.out.println(it.next());
						}
					}
					else if(answer==4) {
						Collections.sort(digimon, ordenarprecio);
	
						Iterator<Digimon> it = digimon.iterator();
						while(it.hasNext()) {
							System.out.println(it.next());
						}
					}
				}while(answer!=0);
				break;
			case 6:
				
		        for(int i = 0; i < cliente.size(); i++) {
		            System.out.println(cliente.get(i));
		        }
				
				break;
				
			case 7:
				
		        for(int i = 0; i < digimon_ventas.size(); i++) {
		            System.out.println(digimon_ventas.get(i));
		        }
				
				break;
			default:
				break;
			}
			
		}while(respuesta!=0);
		
	}
}
