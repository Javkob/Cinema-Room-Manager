
public class Cinema {

    public static void main(String[] args) {
        CinemaHall cinemaHall = new CinemaHall(UserInput.readRows(),UserInput.readColumns());
        while (true) {
            switch (UserInput.menu()) {
                case 0:
                    return;
                case 1:
                    cinemaHall.displayCinemaHall();
                    break;
                case 2:
                    do{
                        cinemaHall.checkTicketIsSold(UserInput.readRowSeat(), UserInput.readColumnSeat());
                    } while(cinemaHall.isSold());
                    break;
                case 3:
                    cinemaHall.calcAndDisplayStatistics();
                    break;
            }
        }
    }
}