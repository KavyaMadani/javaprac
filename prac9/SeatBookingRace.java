class SeatBooking {
    int seatsLeft = 5;

    boolean book() {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }

            seatsLeft--;
            return true;
        }
        return false;
    }
}

public class SeatBookingRace {
    public static void main(String[] args) throws InterruptedException {
        SeatBooking booking = new SeatBooking();
        Thread[] threads = new Thread[10];
        int[] success = new int[10];

        for (int i = 0; i < 10; i++) {
            final int index = i;

            threads[i] = new Thread(() -> {
                if (booking.book()) {
                    success[index] = 1;
                    System.out.println(Thread.currentThread().getName() + " booked a seat");
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to book");
                }
            });

            threads[i].start();
        }

        int totalBooked = 0;

        for (Thread thread : threads) {
            thread.join();
        }

        for (int value : success) {
            totalBooked += value;
        }

        System.out.println("Successful Bookings: " + totalBooked);
        System.out.println("Seats Left: " + booking.seatsLeft);
    }
}