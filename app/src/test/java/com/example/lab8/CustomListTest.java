package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        list.addCity(new City("Edmonton", "Alberta"));
        return list;
    }



    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        CustomList cityList = MockCityList();
        assertTrue(cityList.hasCity((City) cityList.getCities().get(0)));
        City city = new City("Yellowknife", "Northwest Territories");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    public void testDelete() {
        CustomList cityList = MockCityList();
        cityList.delete((City) cityList.getCities().get(0));
        Assert.assertEquals(0, cityList.getCities().size());
    }

    @Test
    public void testCountCities() {
        CustomList cityList = MockCityList();
        Assert.assertEquals(1, cityList.countCities());
    }

}
