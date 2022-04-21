package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.excepetions.DomainException;

public class program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		try {
			//Reservation
			System.out.print("Room number: ");
			int number = sc.nextInt();
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());		
			
			//Caso ocorra um erro na instanciação da classe (Ex. chekout antes do checkin),
			//o construtor da classe Reservation vai gerar uma exceção e o programa vai parar.
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);		
		
			//Update Reservation
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());			
						
			reservation.updateDates(checkIn, checkOut);		
			
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid Date Format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
			//o método get.Message retorna uma String inclusa no metodo UpdateDates da Classe Reservation
		}
		catch (RuntimeException e){ // capturar qualquer outro erro ocorrido no programa
			System.out.println("Unexpected error!!");			
		}
		
		sc.close();
	}

}
