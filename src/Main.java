public class Main{
    public static void main(String[] args) {
        CarShowroom carShowroom = new CarShowroom("Lala", 12);

        Vehicle vehicle = new Vehicle("BMW", "M3", ItemCondition.NEW, 1, 1998, 0, 1.3);
        Vehicle vehicle4 = new Vehicle("Audi", "A3", ItemCondition.NEW, 3, 1998, 0, 1.3);
        Vehicle vehicle5 = new Vehicle("Zom", "k", ItemCondition.NEW, 4, 1998, 0, 1.3);
        Vehicle vehicle3 = new Vehicle("Skoda", "4", ItemCondition.USED, 13, 1998, 0, 1.3);
        Vehicle vehicle1 = new Vehicle("Maluch", "la", ItemCondition.NEW, 2, 1998, 0, 1.3);
        Vehicle vehicle2 = new Vehicle("Skoda", "Fabia", ItemCondition.NEW, 1, 1998, 0, 1.3);


        carShowroom.addVehicle(vehicle);
        carShowroom.addVehicle(vehicle3);
        carShowroom.addVehicle(vehicle1);
        carShowroom.addVehicle(vehicle1);
        carShowroom.addVehicle(vehicle2);
        carShowroom.addVehicle(vehicle4);
        carShowroom.addVehicle(vehicle5);
      //  carShowroom.addVehicle(vehicle1);
       // carShowroom.addVehicle(vehicle2);
        //carShowroom.print();
      //carShowroom.search("BMW");
      //carShowroom.searchPartial("bm");
        System.out.println("NEW:");
        System.out.println(carShowroom.countByCondition(ItemCondition.NEW));
        System.out.println("USED:");
        System.out.println(carShowroom.countByCondition(ItemCondition.USED));
        System.out.println("DEMAGED:");
        System.out.println(carShowroom.countByCondition(ItemCondition.DEMAGED));
        //carShowroom.search("BMW");
        System.out.println("-----");
       // carShowroom.sortByName();
        carShowroom.sortByPrize();
    }
}
