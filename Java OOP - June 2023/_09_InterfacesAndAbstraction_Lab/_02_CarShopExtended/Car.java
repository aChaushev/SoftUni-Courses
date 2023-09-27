package _09_InterfacesAndAbstraction_Lab._02_CarShopExtended;

import java.io.Serializable;

public interface Car extends Serializable {

    int TIERS = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String getCountryProduced();



}
