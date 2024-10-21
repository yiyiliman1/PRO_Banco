package main;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String nombre;
		String fecha;
		String cuenta;		
		String log = "";				
		
		System.out.println("Buenos días");
		System.out.println("Bienvenido a RABOBANK");
		System.out.print("Introduzca su nombre: ");
		nombre = entrada.nextLine();
		System.out.print("Introduzca fecha de nacimiento (dd/mm/aaaa): ");
		fecha = entrada.nextLine();
		System.out.print("Introduzca su número cuenta (IBAN): ");
		cuenta = entrada.nextLine();
		
		int totalretiro = 0;
		int totalingreso = 0;
		int sino = 0;
		int opcion = 0;	
		int divisa = 0;
		double saldo = 0;		
		double ingresar = 0;				
		double retirar = 0;
		
		//divisas
		double dolar = 0.95;
		double libra = 1.15;
		double yuan = 0.13;				
		
		while (opcion >= 0) {
				sino = 0;
				divisa = 0;
				System.out.print("RABOBANK || Qué operación desea realizar? || Su saldo actual: " + saldo + "€\n" + "\n"
						+ "-(1): Ver los datos de la cuenta\n"
						+ "-(2): Ingresar\n"
						+ "-(3): Retirar\n"
						+ "-(4): Ver su saldo en otras monedas internacionales\n"
						+ "-(5): Ver la cantidad de ingresos realizados\n"
						+ "-(6): Ver la cantidad de gastos realizados\n"
						+ "-(7): Salir del sistemas\n"
						+">> ");
				opcion = entrada.nextInt();										
				if (opcion < 0) {
					System.out.println("Error, selecciones una opción correcta\n");
					/*Si la opcion indicada es inferior*/
					opcion = 0;
				} else {
					switch (opcion) {
					case 1:
						System.out.println("Tus datos de la cuenta son los siguientes: \n" + "Nombre de Usuario: " + nombre + "\n" + "Fecha de nacimiento: " + fecha + "\n" + "Número de cuenta: " + cuenta + "\n" + "Saldo actual: " + saldo + "€\n");			
						break;						
					case 2:						
							System.out.print("Cuánto dinero desea ingresar?: ");
							ingresar = entrada.nextDouble();	
							
							if (ingresar < 0) {
								/*si el dinero ingresado es negativo*/
								System.out.println("Error, no es posible realizar esta operación\n");							
							} else {
								System.out.println("Has ingresado: " + ingresar + "€\n");
								saldo = ingresar + saldo;
								log += "+" + ingresar;
								totalingreso++;
								/*cada ingreso se va sumando a la variable totalingreso que tiene un valor de 0*/
								
							}
						break;						
					case 3:					
						System.out.print("Cuánto dinero desea retirar?: ");
						retirar = entrada.nextDouble();
						if (retirar < 0) {
							System.out.println("Error, no es posible realizar esta operación\n");
							/*si el dinero retirado es negativo*/
						} else {
							System.out.println("Retiraste: " + -retirar + "€");
							System.out.println("Tienes en la cuenta: " + (saldo-retirar) + "€\n");
							saldo = saldo - retirar;
							log += "+" + -retirar;
							totalretiro++;							
						} if (retirar > saldo) {
							System.out.println("Seguro que quiere realizar esta operación?\nSu saldo en la cuenta se quedaría en negativo\n");
							/*si el dinero que se quiera retirar es mayor que el saldo de la cuenta*/
							while (sino >= 0) {
								System.out.print("Elige una operación:\n"
										+ "-(1): Si\n"
										+ "-(2): No\n"
										+ "-(3): Atrás\n"
										+">> ");
								sino = entrada.nextInt();
								if (sino < 0) {
									sino = 0;
									System.out.println("Error, no es posible realizar esta operación\n");	
									/*Si la opcion indicada es inferior*/
								} else {	
									switch (sino) {
									case 1:
										System.out.println("Retiraste: " + -retirar + "€");
										System.out.println("Tienes en la cuenta: " + (saldo-retirar) + "€\n");
										saldo = saldo - retirar;
										log += "+" + -retirar;
										totalretiro++;
										sino = -2;
										/*para que no se repita en el bucle*/										
										break;
									case 2: 
										System.out.println("No se realizó la operación\n");
										sino = -2;
										break;
									case 3:
										System.out.println("Has selecionado Atrás\n");	
										sino = -2;
										break;
									default :
										System.out.println("Error, selecciones una opción correcta\n");
									} 								
								}
							}
						}
						break; 												
					case 4: 
						System.out.print("Elige una operación:\n"
								+ "-(1): Ver su saldo en $\n"
								+ "-(2): Ver tu saldo en £\n"
								+ "-(3): Ver tu saldo en ¥\n"
								+ "-(4): Atrás\n"
								+">> ");
						divisa = entrada.nextInt();	
						if (divisa < 0) {
							System.out.println("Error, no es posible realizar esta operación\n");
						} else {																
								switch (divisa) {								
								case 1:										
									System.out.println("Tu saldo en $(Dolar): " + (saldo*dolar) + "$" + "\n");
									break;
								case 2:									
									System.out.println("Tu saldo en £(Libra): " + (saldo*libra) + "£" + "\n");
									break;
								case 3:									
									System.out.println("Tu saldo en ¥(Yuan): " + (saldo*yuan) + "¥" + "\n");
									break;
								case 4:
									System.out.println("Has selecionado Atrás\n");
									break;
								default :
									System.out.println("Error, selecciones una opción correcta\n");
								}
							}
						break;
					case 5:
						System.out.println("Has ingresado un total de: " + totalingreso + " vez/veces \n");
						break;						
					case 6:
						System.out.println("Has retirado un total de: " + totalretiro + " vez/veces \n");
						break;						
					case 7:
						System.out.println("Has selecionado salir del sistema");
						opcion = -2;	
						break;
					default :
						System.out.println("Error, selecciones una opción correcta\n");
					}																						
				}
		}
	}

}
