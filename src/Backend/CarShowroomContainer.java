package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarShowroomContainer {

    private Map<CarShowroom, Integer> carShowroomContainerMap = new HashMap<>();

    public CarShowroomContainer(){};

    public void addCenter(CarShowroom carShowroom, int max)
    {
        carShowroomContainerMap.put(carShowroom, max);
    }

    public void removeCenter(String name)
    {
        carShowroomContainerMap.remove(name);
    }

    public List<CarShowroom> getCarShowroomContainerList(){
       List<CarShowroom> carShowroomList = new ArrayList<>();
        this.carShowroomContainerMap.forEach((k,v)->carShowroomList.add(k));
        return carShowroomList;
        }

    public void summary()
    {
        for(Map.Entry<CarShowroom, Integer> carShowroom : carShowroomContainerMap.entrySet())
        {
            System.out.println("Name of salon: "+carShowroom.getKey().getNameOfSalon());
            System.out.println("Capacity "+carShowroom.getValue());
        }
    }

    public String getName()
    {
        for(Map.Entry<CarShowroom, Integer> carShowroom : carShowroomContainerMap.entrySet())
        {
            return  carShowroom.getKey().getNameOfSalon();
        }
        return "";
    }
    public String getCapacity()
    {
        for(Map.Entry<CarShowroom, Integer> carShowroom : carShowroomContainerMap.entrySet())
        {
            //return  carShowroom.getValue().
        }
        return "";
    }

    public int countOfCarSchoroom(){
        return carShowroomContainerMap.size();
    }



}
