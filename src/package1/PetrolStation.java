package package1;

public class PetrolStation {

    private volatile double amount;
    private double carTankCapacity = Main.CAR_TANK_CAPACITY;

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public double doRefuel(String carName) {
        try {
            System.out.println(carName + " refueling");
            Thread.sleep((long) ((Math.random() * 8) + 3) * 1000);

//            // для проверки, печать времени ожидания
//            long sleepTime = (long) ((Math.random() * 8) + 3) * 1000;
//            System.out.println("sleepTime: " + sleepTime/1000 + " s");
//            Thread.sleep(sleepTime) ;

//            // заправка 3 секунды - для проверки, программа работает быстрее
//            Thread.sleep(3000);
            if (amount >= carTankCapacity) {
                amount -= carTankCapacity;
                System.out.println(carName + " refueled, l " + amount + " left");
            } else {
                System.out.println(carName + " is not refueled, l " + amount + " left");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }
}
