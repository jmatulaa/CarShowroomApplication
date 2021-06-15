import java.util.*;

public class CarShowroom {
    private String salon;
    private int max;
    private List<Vehicle> vehicleList = new ArrayList<>();
    private Map<Vehicle, Integer> vehicleMap = new HashMap<>();

    public CarShowroom(String salon, int max) {
        this.salon = salon;
        this.max = max;
    }

    //DONE
    public void addVehicle(Vehicle vehicle, CarShowroom carShowroom)
    {
        if(vehicleList.size()<carShowroom.getMax()) {
            if (equals(vehicle)) {
                vehicleList.add(vehicle);
            } else {
                vehicleList.add(vehicle);
                vehicleMap.put(vehicle, 1);
            }
        } else System.err.println("Sorry, we don't have enough space");
    }

    public boolean equals(Vehicle v)
    {
        for(Vehicle vehicle: vehicleList)
        {
            if(v.getModel().equals(vehicle.getModel()) && v.getMark().equals(vehicle.getMark()))
            {
                vehicleMap.put(vehicle, vehicleMap.get(vehicle)+1);
                return true;
            }
        }
        return false;
    }

    //DONE
    public void removeVehicle(Vehicle vehicle, CarShowroom carShowroom)
    {
        summary();
        if(vehicle.getCount()==0) {
            vehicleList.remove(vehicle);
            vehicleMap.remove(vehicle);
        }
        else{
        System.out.println("wchodze2");
            vehicleList.remove(vehicle);
            vehicleMap.put(vehicle, vehicle.getCount()-1);
        }
        summary();
    }

    //DONE
    public boolean removeAllVehicle(Vehicle vehicle)
    {
       for(Vehicle v : vehicleList)
       {
           if(vehicle.equals(v)){
               vehicleList.remove(v);
               vehicleMap.remove(v);
           }
       }
       return true;
    }

    public int getMax(){ return max;}


    public int getMax2(){

         Vehicle e =Collections.max(vehicleList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                if(v1.getCount()==v2.getCount())
                    return 0;
                else if (v1.getCount()<v2.getCount())
                    return -1;
                else if (v1.getCount()>v2.getCount())
                    return 1;
                return 0;
            }
        });

        return e.getCount();
    }

    //DONE
    public void summary()
    {
        for(Vehicle vehicle: vehicleList) {
            for (Map.Entry<Vehicle, Integer> e : vehicleMap.entrySet()) {
                if(vehicle.getMark()==e.getKey().getMark() && vehicle.getModel()==e.getKey().getModel()) {
                    vehicle.setCount(e.getValue());
                }
            }
        }
    }

    public void print()
    {
        for(Vehicle vehicle: vehicleList) {
            vehicle.printVehicle(vehicle);
        }
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

        if(!true1) System.out.println("We haven't got this vehicle");
    }

    //DONE
    public int countByCondition(ItemCondition itemCondition)
    {
        System.out.println("here");
        int count=0;
        for(Vehicle vehicle: vehicleList)
        {
            if(vehicle.getCondition()==itemCondition)
            {
                count++;
            }
        }
        return count;
    }

    //DONE
    public void sortByName(){

        Collections.sort(vehicleList, (v1,v2)->{
            return v1.getMark().compareTo(v2.getMark());
        });

          /*another way:
         Collections.sort(vehicleList, new Comparator<Vehicle>() {
             @Override
             public int compare(Vehicle v1, Vehicle v2) {
                 return v1.getMark().compareTo(v2.getMark());
             }
         });
        */
        print();
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
        print();
    }

    //DONE
    public void sortByCount() {
        Collections.sort(vehicleList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                if(v1.getCount()<v2.getCount()) return 1;
                if(v1.getCount()>v2.getCount()) return -1;
                else return 0;
            }
        });
        print();
    }

}
