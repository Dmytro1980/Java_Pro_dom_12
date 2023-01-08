package package1;

import java.util.concurrent.Semaphore;

public class Refueling implements Runnable{

    PetrolStation station;
    Semaphore semaphore;
    String carName;

    public Refueling(PetrolStation station, Semaphore semaphore, String carName) {
        this.station = station;
        this.semaphore = semaphore;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.printf("%s at the station\n", carName);
            synchronized (station){
                station.doRefuel(carName);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        semaphore.release();
    }
}
