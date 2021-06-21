package Backend;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Application extends JFrame {

    public Application()
    {
        super("CarShowroom!");
        this.setSize(new Dimension(1000,800));
        int width= Toolkit.getDefaultToolkit().getScreenSize().width;
        int height= Toolkit.getDefaultToolkit().getScreenSize().height;
//        this.setSize(width, height);
        int widthFrame= this.getSize().width;
        int heightFrame= this.getSize().height;
        this.setLocation((width-widthFrame)/2, (height-heightFrame)/2);

        initComponents();
        Data();
        prepareData();
        listeners();

        this.setDefaultCloseOperation(3);
    }

        JPanel panel = new JPanel();

        JPanel panelSalon = new JPanel();
        JLabel label = new JLabel("Add salon");
        JTextField nameOfSalon = new JTextField("Name of salon", 10);
        JTextField maxCapacity = new JTextField("Capacity", 8);
        JButton buttonAddSalon = new JButton("add");
        JButton buttonShowVehicle = new JButton("show Vehicle");

        JPanel panelTable = new JPanel();
        JTable salonTableContainer;
        TableModel salonContainerModel;
        String[] salonContainerColumnName = {"Name of carshowroom", "Capacity"};
        JScrollPane salonContainerScroll;

        JTable salonTable;
        TableModel salonModel;
        String[] salonColumnName = {"Mark", "Model", "Condition", "Prize", "Year", "Mileage"};
        JScrollPane salonScroll;

        JPanel panelVehicle = new JPanel();
        JLabel labelV = new JLabel("Add Vehicle");
        JTextField mark = new JTextField("Mark", 10);
        JTextField model = new JTextField("Model", 10);
        JTextField condition = new JTextField("Condition", 10);
        JTextField prize = new JTextField("Prize", 4);
        JTextField year = new JTextField("Year", 4);
        JTextField milleage = new JTextField("Milleage", 6);
        JButton buttonAddVehicle = new JButton("add");

        JButton buttonRemoveVehicle = new JButton("remove");
        JButton buttonSortName = new JButton("sort by Name");
        JButton buttonSortPrize = new JButton("sort by Prize");


    public void initComponents()
    {
        panel.add(panelSalon);

        panelSalon.add(label);
        panelSalon.add(nameOfSalon);
        panelSalon.add(maxCapacity);
        panelSalon.add(buttonAddSalon);
        panelSalon.add(buttonShowVehicle);

        panel.add(buttonSortName);
        panel.add(buttonSortPrize);

        panel.add(panelTable);

        panel.add(panelVehicle);

        panelVehicle.add(labelV);
        panelVehicle.add(mark);
        panelVehicle.add(model);
        panelVehicle.add(condition);
        panelVehicle.add(prize);
        panelVehicle.add(year);
        panelVehicle.add(milleage);
        panelVehicle.add(buttonAddVehicle);
        panelVehicle.add(buttonRemoveVehicle);


        this.getContentPane().add(panel);
    }

    CarShowroomContainer carShowroomContainer = new CarShowroomContainer();
    Vehicle vehicle;

    public void Data()
    {
        CarShowroom carShowroom = new CarShowroom("Volvo", 16);
        CarShowroom carShowroom2 = new CarShowroom("Suzuki", 30);
        CarShowroom carShowroom3 = new CarShowroom("Toyota", 30);

        carShowroomContainer.addCenter(carShowroom, 30);
        carShowroomContainer.addCenter(carShowroom2, 100);
        carShowroomContainer.addCenter(carShowroom3, 40);

        Vehicle vehicle = new Vehicle("BMW", "M3", ItemCondition.NEW, 1, 2018, 0, 1.3);
        Vehicle vehicle11 = new Vehicle("BMW", "Mbg3", ItemCondition.USED, 1, 2000, 122000, 2.0);
        Vehicle vehicle22 = new Vehicle("BMW", "M3", ItemCondition.DEMAGED, 1, 1998, 160000, 1.3);
        Vehicle vehicle4 = new Vehicle("Audi", "A3", ItemCondition.NEW, 3, 1998, 0, 1.3);
        Vehicle vehicle5 = new Vehicle("Zom", "k", ItemCondition.NEW, 4, 1998, 0, 3.1);
        Vehicle vehicle3 = new Vehicle("Skoda", "Fabia", ItemCondition.USED, 13, 1998, 0, 1.3);
        Vehicle vehicle2 = new Vehicle("Skoda", "Fabia", ItemCondition.NEW, 1, 1998, 0, 1.3);
        Vehicle vehicle24 = new Vehicle("Skoda", "Fabia", ItemCondition.NEW, 1, 1998, 0, 1.3);

        carShowroom.addVehicle(vehicle, carShowroom);
        carShowroom.addVehicle(vehicle11, carShowroom);
        carShowroom.addVehicle(vehicle22, carShowroom);
        carShowroom.addVehicle(vehicle4, carShowroom);

        carShowroom2.addVehicle(vehicle5, carShowroom2);
        carShowroom2.addVehicle(vehicle3, carShowroom2);

        carShowroom3.addVehicle(vehicle2, carShowroom3);
        carShowroom3.addVehicle(vehicle24, carShowroom3);

    }
    public void prepareData()
    {
        salonContainerModel = new AbstractTableModel(){

            public String getColumnName(int column){
                return salonContainerColumnName[column];
            }

            @Override
            public int getRowCount() {
                return carShowroomContainer.countOfCarSchoroom();
            }

            @Override
            public int getColumnCount() {
                return salonContainerColumnName.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                if(columnIndex==0)
                {
                   return carShowroomContainer.getCarShowroomContainerList().get(rowIndex).getNameOfSalon();
                }
                else if(columnIndex==1)
                {
                    return carShowroomContainer.getCarShowroomContainerList().get(rowIndex).getMax();
                }
                return "";
            }
        };

        salonTableContainer = new JTable(salonContainerModel);
        salonContainerScroll = new JScrollPane(salonTableContainer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        salonContainerScroll.getViewport().add(salonTableContainer);
        panelTable.add(salonContainerScroll);
        panelTable.updateUI();


        salonModel = new AbstractTableModel() {

            public String getColumnName(int column){ return salonColumnName[column];}

            @Override
            public int getRowCount() {
                return carShowroomContainer.getCarShowroomContainerList().size();
            }

            @Override
            public int getColumnCount() {
                return salonColumnName.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return "";
            }
        };

        salonTable = new JTable(salonModel);
        salonScroll = new JScrollPane(salonTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        salonScroll.getViewport().add(salonTable);
        panelTable.add(salonScroll);
        panelTable.updateUI();


    }
    public void listeners()
    {
        focusListener(nameOfSalon);
        focusListener(maxCapacity);
        focusListener(mark);
        focusListener(model);
        focusListener(condition);
        focusListener(prize);
        focusListener(year);
        focusListener(milleage);

        buttonAddSalon.setActionCommand("add");
        buttonAddSalon.addActionListener(new JScrollPaneListener());

        buttonShowVehicle.setActionCommand("show Vehicle");
        buttonShowVehicle.addActionListener(new JScrollPaneListener());

        buttonAddVehicle.setActionCommand("add Vehicle");
        buttonAddVehicle.addActionListener(new JScrollPaneListener());

        buttonRemoveVehicle.setActionCommand("remove Vehicle");
        buttonRemoveVehicle.addActionListener(new JScrollPaneListener());

        buttonSortName.setActionCommand("sort Name");
        buttonSortName.addActionListener(new JScrollPaneListener());

        buttonSortPrize.setActionCommand("sort Prize");
        buttonSortPrize.addActionListener(new JScrollPaneListener());
    }

    public class JScrollPaneListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            String button = e.getActionCommand();

            int indexSalon = salonTableContainer.getSelectedRow();
            int indexVehicle = salonTable.getSelectedRow();

            if(button.equals("add"))
            {
                String nameSalon = nameOfSalon.getText();
                int capacity =Integer.parseInt(maxCapacity.getText());

                CarShowroom carShowroom4= new CarShowroom(nameSalon, capacity);
                carShowroomContainer.addCenter(carShowroom4, capacity);

                salonContainerModel = new AbstractTableModel(){

                    public String getColumnName(int column){
                        return salonContainerColumnName[column];
                    }

                    @Override
                    public int getRowCount() {
                        return carShowroomContainer.countOfCarSchoroom();
                    }

                    @Override
                    public int getColumnCount() {
                        return salonContainerColumnName.length;
                    }

                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        if(columnIndex==0)
                        {
                            return carShowroomContainer.getCarShowroomContainerList().get(rowIndex).getNameOfSalon();
                        }
                        else if(columnIndex==1)
                        {
                            return carShowroomContainer.getCarShowroomContainerList().get(rowIndex).getMax();
                        }
                        return "";
                    }
                };
                salonTableContainer = new JTable(salonContainerModel);
                salonContainerScroll.getViewport().add(salonTableContainer);
            }
            else if(button.equals("show Vehicle"))
            {
                CarShowroom vehicles = carShowroomContainer.getCarShowroomContainerList().get(indexSalon);

                salonModel = new AbstractTableModel() {
                    @Override
                    public String getColumnName(int column) {
                        return salonColumnName[column];
                    }

                    @Override
                    public int getRowCount() {
                        return vehicles.getVehicleList().size();
                    }

                    @Override
                    public int getColumnCount() {
                        return salonColumnName.length;
                    }

                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        if(columnIndex==0)
                        return vehicles.getVehicleList().get(rowIndex).getMark();
                        if(columnIndex==1)
                            return vehicles.getVehicleList().get(rowIndex).getModel();
                        if(columnIndex==2)
                            return vehicles.getVehicleList().get(rowIndex).getCondition();
                        if(columnIndex==3)
                            return vehicles.getVehicleList().get(rowIndex).getPrize();
                        if(columnIndex==4)
                            return vehicles.getVehicleList().get(rowIndex).getYear();
                        if(columnIndex==5)
                            return vehicles.getVehicleList().get(rowIndex).getMileage();
                        else return "error";
                    }
                };

                salonTable = new JTable(salonModel);
                salonScroll.getViewport().add(salonTable);
            }
            else if (button.equals("add Vehicle"))
            {
                Vehicle vehicle = new Vehicle(mark.getText(), model.getText(), Double.parseDouble(prize.getText()), Integer.parseInt(year.getText()), Double.parseDouble(milleage.getText()));
                CarShowroom vehicles= carShowroomContainer.getCarShowroomContainerList().get(indexSalon);
                carShowroomContainer.getCarShowroomContainerList().get(indexSalon).addVehicle(vehicle, vehicles);
                salonTable = new JTable(salonModel);
                salonScroll.getViewport().add(salonTable);
            }
            else if(button.equals("remove Vehicle"))
            {
                vehicle  = carShowroomContainer.getCarShowroomContainerList().get(indexSalon).getVehicleList().get(indexVehicle);
                carShowroomContainer.getCarShowroomContainerList().get(indexSalon).removeVehicle(vehicle);
                salonTable = new JTable(salonModel);
                salonScroll.getViewport().add(salonTable);
            }
            else if (button.equals("sort Name"))
            {
                carShowroomContainer.getCarShowroomContainerList().get(indexSalon).sortByName();
                salonTable = new JTable(salonModel);
                salonScroll.getViewport().add(salonTable);
            }
            else if (button.equals("sort Prize"))
            {
                carShowroomContainer.getCarShowroomContainerList().get(indexSalon).sortByPrize();
                salonTable = new JTable(salonModel);
                salonScroll.getViewport().add(salonTable);
            }
        }
    }

    public void focusListener(JTextField textField)
    {
        String caption = textField.getText();

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                    if(textField.getText().equals(""))
                        textField.setText(caption);
                }
        });
    }
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
}
