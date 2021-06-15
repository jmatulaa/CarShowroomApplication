public class Main{
    public static void main(String[] args) {
        CarShowroom carShowroom = new CarShowroom("Lala", 16);
        CarShowroom carShowroom2 = new CarShowroom("Lalahb", 30);

        Vehicle vehicle = new Vehicle("BMW", "M3", ItemCondition.NEW, 1, 1998, 0, 1.3);
        Vehicle vehicle11 = new Vehicle("BMW", "Mbg3", ItemCondition.NEW, 1, 1998, 0, 1.3);
       Vehicle vehicle22 = new Vehicle("BMW", "M3", ItemCondition.NEW, 1, 1998, 0, 1.3);
        Vehicle vehicle4 = new Vehicle("Audi", "A3", ItemCondition.NEW, 3, 1998, 0, 1.3);
       Vehicle vehicle5 = new Vehicle("Zom", "k", ItemCondition.NEW, 4, 1998, 0, 1.3);
        Vehicle vehicle3 = new Vehicle("Skoda", "Fabia", ItemCondition.USED, 13, 1998, 0, 1.3);
        Vehicle vehicle2 = new Vehicle("Skoda", "Fabia", ItemCondition.NEW, 1, 1998, 0, 1.3);
        Vehicle vehicle24 = new Vehicle("Skoda", "Fabia", ItemCondition.NEW, 1, 1998, 0, 1.3);



        carShowroom2.addVehicle(vehicle, carShowroom2);
        carShowroom2.addVehicle(vehicle11, carShowroom2);
        carShowroom2.addVehicle(vehicle4, carShowroom2);
       carShowroom2.addVehicle(vehicle5, carShowroom2);
       carShowroom2.addVehicle(vehicle2, carShowroom2);
       carShowroom2.addVehicle(vehicle22, carShowroom2);
        carShowroom2.addVehicle(vehicle3, carShowroom2);
        carShowroom2.addVehicle(vehicle24, carShowroom2);
        carShowroom2.summary();

        System.out.println();
        System.out.println( carShowroom2.getMax2());

        //carShowroom2.removeVehicle(vehicle11, carShowroom2);
       // carShowroom2.print();

        //carShowroom2.removeAllVehicle(vehicle22);

//        System.out.println("--");
//        carShowroom2.summary();
      //  System.out.println(carShowroom2.getMax());

      // carShowroom.search("BMW");
       //carShowroom.searchPartial("bm");
//       System.out.println("NEW:");
//       System.out.println(carShowroom2.countByCondition(ItemCondition.NEW));
//       System.out.println("USED:");
//       System.out.println(carShowroom2.countByCondition(ItemCondition.USED));
//       System.out.println("DEMAGED:");
//       System.out.println(carShowroom2.countByCondition(ItemCondition.DEMAGED));

        //carShowroom2.summary();
       // carShowroom2.sortByName();
    }
}
