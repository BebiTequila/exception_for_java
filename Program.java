package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in  date:");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out  date:");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Error, the checkout date must be after check in  date.");
		}
		else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter to update the reservatio data: ");
			
			System.out.println("Checkin Date: ");
			checkin = sdf.parse(sc.next());
			System.out.println("Checkout Date: ");
			checkout = sdf.parse(sc.next());
			
			
			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)) {
				
				System.out.println("Error in reservation: reservation dates for uptade must be future dates. ");
				
			}
			else if (!checkin.after(checkin)) {
				System.out.println("Error in reservation: reservation dates for uptade must be future dates.");
			}
			else {
				reservation.updateDates(checkin, checkout);
			}
				
			
		}
		
		sc.close();
	}

}
