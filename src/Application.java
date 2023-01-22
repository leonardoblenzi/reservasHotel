import Model.Entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws ParseException {

    Scanner sc = new Scanner(System.in);
    Locale.setDefault(Locale.US);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Room number: ");
    int room_n = sc.nextInt();
    System.out.print("Check-in date (dd/mm/yyyy): ");
    Date checkIn = sdf.parse(sc.next());
    System.out.print("Check-out date(dd/mm/yyyy): ");
    Date checkOut = sdf.parse(sc.next());

    //se checkout não for depois de checkin vai dar erro
    if(!checkOut.after(checkIn)){
        System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
    //se estiver ok instancia o objeto
    else{
        Reservation reservation = new Reservation(room_n, checkIn, checkOut);
        System.out.println("Reservation: " + reservation);


        //fazendo update do aluguel
        System.out.println("Enter data to update the reservation: ");

        System.out.print("Check-in date (dd/mm/yyyy): ");
        checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date(dd/mm/yyyy): ");
        checkOut = sdf.parse(sc.next());

        //armazenando resultado do update em var error
        String error = reservation.updateDates(checkIn, checkOut);
        //se erro for diferente de nulo significa que veio alguma string com erro
        if(error != null){
            System.out.println("Error in reservation: " + error);
        }
        else{
            System.out.println("Reservation: " + reservation);
        }
    }


    }
}