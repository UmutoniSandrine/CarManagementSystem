/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataBaseDao.CarDatabaseDao;
import DataBaseDao.OwnerDao;
import Domain.Owner;
import Domain.PassengerCar;
import Domain.Truck;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bitwayiki
 */
@ManagedBean
@SessionScoped
public class CarModel {



    private PassengerCar pc;
    private Truck t;
    private List<PassengerCar> PassengerCars;
    private List<Truck> trucks;

    private Map<Integer, String> map;

    public CarModel() {
        this.pc = new PassengerCar();
        this.t = new Truck();
        this.PassengerCars = CarDatabaseDao.findAllPassengerCars();
        this.trucks=CarDatabaseDao.findAllTrucks();
        map = new HashMap<>();
        for (Owner w : OwnerDao.findAll()) {
            map.put(w.getId(), w.getName());
        }
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }
    
    

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public List<PassengerCar> getPassengerCars() {
        return PassengerCars;
    }

    public void setPassengerCars(List<PassengerCar> PassengerCars) {
        this.PassengerCars = PassengerCars;
    }

    public PassengerCar getPc() {
        return pc;
    }

    public void setPc(PassengerCar pc) {
        this.pc = pc;
    }

    public Truck getT() {
        return t;
    }

    public void setT(Truck t) {
        this.t = t;
    }

    public String registerTruck() {
        CarDatabaseDao.createCar(t);
        t= new Truck();
        trucks= CarDatabaseDao.findAllTrucks();
        return "Truck.xhtml?faces-redirect=true";
    }

    public String registerPassengerCar() {
        CarDatabaseDao.createCar(pc);
        pc = new PassengerCar();
        PassengerCars = CarDatabaseDao.findAllPassengerCars();
        return "PassengerCar.xhtml?faces-redirect=true";
    }

}
