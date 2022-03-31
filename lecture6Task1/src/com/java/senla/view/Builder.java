package com.java.senla.view;

import com.java.senla.controller.lodger.*;
import com.java.senla.controller.room.*;
import com.java.senla.controller.service.*;

public class Builder {
    private final Menu rootMenu = new Menu("Root menu");
    private final Menu lodgerMenu = new Menu("Lodger menu");
    private final Menu roomMenu = new Menu("Room menu");
    private final Menu serviceMenu = new Menu("Service menu");

    public Builder() {
    }

    private Menu buildMenu() {
//room menu
        roomMenu.addMenuItem(new MenuItem("Add room ", new AddRoom(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Show room details ", new ShowDetailsOfRoom(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Sort empty rooms by price ", new SortingEmpRoomOnPrice(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Sort empty rooms by stars", new SortingEmpRoomOnStars(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Sort empty rooms by capacity ", new SortingEmpRoomOnCapacity(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Update price room ", new UpdatePriceRoom(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Update status room ", new UpdateStatusRoom(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Sort rooms by price ", new SortingRoomOnPrice(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Sort rooms by stars", new SortingRoomOnStars(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Sort rooms by capacity", new SortingRoomOnCapacity(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Total number rooms ", new CountEmptyRooms(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Empty room on date", new EmptyRoomOnDate(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Import rooms ", new ImportRooms(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Export rooms", new ExportRooms(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Back to root menu", rootMenu));
//service menu
        serviceMenu.addMenuItem(new MenuItem("Add service ", new AddService(), serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Change price service ", new ChangeServicePrice(), serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Sorted service by price ", new SortedServiceByPrice(), serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Import services ", new ImportServices(), serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Export services ", new ExportServices(), serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Back to root menu ", rootMenu));
//lodger menu
        lodgerMenu.addMenuItem(new MenuItem("Add Lodger ", new AddLodger(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Check in room lodger ", new CheckInRoom(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Check out room lodger ", new CheckOutRoom(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Sorting lodger by Name ", new SortedLodgersByName(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Sorting lodger by date check out ", new SortedLodgersByDate(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Total count lodger ", new TotalNumberOfLodgers(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Bill room ", new BillLodger(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("add service to lodger ", new ServicesLodger(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Last lodgers room ", new ShowLastLodgersRoom(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Sorting lodgers services by price", new SortedLodgerByService(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Import lodgers ", new ImportLodgers(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Export lodgers", new ExportLodgers(), lodgerMenu));
        lodgerMenu.addMenuItem(new MenuItem("Back to root menu", rootMenu));

        rootMenu.addMenuItem(new MenuItem("Room menu", roomMenu));
        rootMenu.addMenuItem(new MenuItem("Service menu", serviceMenu));
        rootMenu.addMenuItem(new MenuItem("Lodger menu", lodgerMenu));
        return rootMenu;
    }

    public Menu getRootMenu() {
        return buildMenu();
    }
}

