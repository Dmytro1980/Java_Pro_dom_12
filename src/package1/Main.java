package package1;

import java.util.concurrent.Semaphore;

public class Main {

    public static final int NUM_OF_REQUESTS = 3;        // количество одновременных заправок
    public static final int NUM_OF_REFUELINGS = 11;     // количество автомобилей
    public static final double CAR_TANK_CAPACITY = 10;  // ёмкость бака машины
    public static final double AMOUNT = 100;            // количество топлива на заправке, будет передано в PetrolStation


    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(NUM_OF_REQUESTS);
        PetrolStation station = new PetrolStation(AMOUNT);

        for (int i = 0; i < NUM_OF_REFUELINGS; i++) {
            new Thread(new Refueling(station, semaphore, "Car " + i)).start();
        }
    }
}
