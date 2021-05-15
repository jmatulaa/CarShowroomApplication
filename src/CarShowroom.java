import java.util.*;

public class CarShowroom {
    private String salon;
    private int max=10;
    private List<Vehicle> vehicleList = new ArrayList<>();
    //private Map<Vehicle, Integer> vehicleMap = new HashMap<Vehicle, Integer>();

    private int count = 0;

    public CarShowroom(){};
    public CarShowroom(String salon, int max) {
        this.salon = salon;
        this.max = max;
    }
    public void addVehicle(Vehicle vehicle)
    {
        vehicleList.add(vehicle);

    }


    public int getMax(){return max;}

   public int getCount(Vehicle vehicle)
    {
       return  1;
    }

    //DONE
    public void print()
    {
        for(Vehicle vehicle: vehicleList)
        {
            vehicle.printVehicle(vehicle);
        }
    }


    public void removeVehicle(Vehicle vehicle)
    {

    }

    //DONE
    public void search(String marka)
    {
        boolean true1=false;
        for(Vehicle vehicle : vehicleList) {
            String m = vehicle.getMark();
            if (m == marka) {
                vehicle.printVehicle(vehicle);
                true1 = true;
            }
        }

        if(true1==false) System.out.println("We haven't got this vehicle");

    }

    //DONE
    public void searchPartial(String part)
    {
        boolean true1 = false;
        for(Vehicle vehicle : vehicleList) {
            String part2 = vehicle.getModel().toLowerCase();
            String part3 = vehicle.getMark().toLowerCase();
            if (part2.contains(part.toLowerCase()) || part3.contains(part.toLowerCase())) {
                vehicle.printVehicle(vehicle);
                true1=true;
            }
        }

        if(true1==false) System.out.println("We haven't got this vehicle");
    }

    //DONE
    public int countByCondition(ItemCondition itemCondition)
    {
        int count=0;
        for(Vehicle vehicle: vehicleList)
        {
            if(vehicle.getCondition()==itemCondition)
            {
                //vehicle.printVehicle(vehicle);
                count++;
            }
        }
        return count;
    }

    //DONE
    public void sortByName(){

         Collections.sort(vehicleList, new Comparator<Vehicle>() {
             @Override
             public int compare(Vehicle v1, Vehicle v2) {
                 return v1.getMark().compareTo(v2.getMark());
             }
         });

        /*
        another way:
        Collections.sort(vehicleList, (v1,v2)->{
            return v1.getMark().compareTo(v2.getMark());
        });
         */

         for(Vehicle vehicle: vehicleList)
         {
             vehicle.printVehicle(vehicle);
         }

    }

    //DONE
    public void sortByPrize() {
        Collections.sort(vehicleList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                if(v1.getPrize()<v2.getPrize()) return -1;
                if(v1.getPrize()>v2.getPrize()) return 1;
                else return 0;
            }
        });
        for(Vehicle vehicle: vehicleList)
        {
            vehicle.printVehicle(vehicle);
        }
    }
    



}
