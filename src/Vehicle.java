public class Vehicle implements Comparable<Vehicle> {
    private String mark;
    private String model;
    private ItemCondition condition;
    private double prize;
    private int year;
    private double mileage;
    private double capacity;
    private int count;


    public void setCount(int count){
      this.count=count;
    }

    public int getCount(){return this.count;}

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ItemCondition getCondition() {
        return condition;
    }

    public void setCondition(ItemCondition condition) {
        this.condition = condition;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public Vehicle(String mark, String model, ItemCondition condition, double prize, int year, double mileage, double capacity)
    {
        this.model=model;
        this.mark = mark;
        this.condition=condition;
        this.prize=prize;
        this.year=year;
        this.mileage=mileage;
        this.capacity=capacity;
    }

    public void printVehicle(Vehicle vehicle)
    {
        System.out.println("Marka: "+mark);
        System.out.println("Model: "+model);
//        System.out.println("Stan: "+condition);
//        System.out.println("Cena: "+prize);
//        System.out.println("Rok produkcji: "+year);
//        System.out.println("Przebieg: "+mileage);
//        System.out.println("Pojemność: "+capacity);
        System.out.println("Ilość na magazynie: "+vehicle.getCount());

        System.out.println();
    }

    public Vehicle(String model)
    {
        this.model=model;
    }

    public Vehicle(String model, String mark, int count)
    {
        this.mark=mark;
        this.model=model;
        this.count=count;
    }

    @Override
    public int comprateTo(Vehicle o1, Vehicle o2) {
        return 0;
    }

}
