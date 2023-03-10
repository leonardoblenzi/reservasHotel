package Model.Entities;

import Model.Exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        if(!checkOut.after(checkIn)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
    //calculando diferença entre datas
    public long duration(){
        //pegando a diferença em milissegundos
        long dif = checkOut.getTime() - checkIn.getTime();
        //passando milissegungos para dias
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut){
        //se entrar no bloco de erro vai ser lançada uma exceção de argumento invalido
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Error in reservation: Reservations dates for update must be future dates");
        }
        if(!checkOut.after(checkIn)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;



    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Room: ");
        sb.append(roomNumber);
        sb.append(", check-in: ");
        sb.append(sdf.format(checkIn));
        sb.append(", check-out: ");
        sb.append(sdf.format(checkOut));
        sb.append(", ");
        sb.append(duration());
        sb.append(" nights");
        return sb.toString();
    }

}
