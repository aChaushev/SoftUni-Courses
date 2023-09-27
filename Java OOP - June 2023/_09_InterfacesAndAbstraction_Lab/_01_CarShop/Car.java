package _09_InterfacesAndAbstraction_Lab._01_CarShop;

import java.io.Serializable;

public interface Car extends Serializable {

    int TIERS = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();



}
