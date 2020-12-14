import java.util.Arrays;

public class CinemaHall {

    private final String SEAT_SIGN = "S";
    private final String CHOSEN_SEAT = "B";
    private int rowsWithNum;
    private int columnsWithNum;
    private String[][] hall;
    private boolean isSold = false;
    private int purchasedTickets = 0;
    private int currentIncome = 0;
    private int totalIncome = 0;

    public CinemaHall(int rows, int columns) {
        this.rowsWithNum = rows + 1;
        this.columnsWithNum = columns + 1;
        this.hall = new String[rowsWithNum][columnsWithNum];
        createSeats();
        calcTotalIncome();
    }

    void createSeats() {
        for (int i = 0; i < hall.length; i++) {
            for (int j = 0; j < hall[i].length; j++) {
                if (i == 0) {
                    hall[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    hall[i][j] = String.valueOf(i);
                } else {
                    hall[i][j] = SEAT_SIGN;
                }
            }
        }
    }

    void displayCinemaHall() {
        System.out.println("\nCinema: ");
        for (String[] element : hall) {
            System.out.println(
                    Arrays.toString(element)
                            .replace("0", " ")
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", ""));
        }
    }

    public void checkTicketIsSold(int row, int column) {
        System.out.print("\n");
        try {
            if (seatIsSold(row, column)) {
                System.out.println("That ticket has already been purchased");
                isSold = true;
            } else {
                buyTicket(row, column);
                purchasedTickets++;
                isSold = false;
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
            isSold = true;
        }
    }

    public boolean isSold() {
        return isSold;
    }

    public void buyTicket(int row, int column) {
        markSeat(row, column);
        currentIncome += getPrice(row);
        printTicketPrice(row);
    }

    void calcAndDisplayStatistics() {
        double percentageOfSoldTickets = (((double) purchasedTickets / (double) getTotalNumberOfSeats()) * 100);
        System.out.printf("\nNumber of purchased tickets: %d\n" +
                        "Percentage: %.2f%%\n" +
                        "Current income: $%d\n" +
                        "Total income: $%d\n",
                purchasedTickets, percentageOfSoldTickets, currentIncome, totalIncome);

    }

    void printTicketPrice(int row) {
        System.out.println("Ticket price: $" + getPrice(row));
    }

    int getPrice(int row) {
        return getRows() * getColumns() <= 60 ? 10 : row <= getRows() / 2 ? 10 : 8;
    }

    void markSeat(int row, int column) {
        hall[row][column] = CHOSEN_SEAT;
    }

    boolean seatIsSold(int row, int column) {
        if (hall[row][column] == CHOSEN_SEAT) {
            return true;
        } else {
            return false;
        }
    }

    void calcTotalIncome() {
        for (int i = 1; i <= getRows(); i++) {
            for (int j = 1; j <= getColumns(); j++) {
                totalIncome += getPrice(i);
            }
        }
    }

    int getTotalNumberOfSeats() {
        return getRows() * getColumns();
    }

    int getRows() {
        return rowsWithNum - 1;
    }

    int getColumns() {
        return columnsWithNum - 1;
    }

}
