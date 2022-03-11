package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize =  list.getCount();
        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(listSize + 1, list.getCount());

    }

    @Test
    public void testHasCity(){
        City city = new City("Calgary", "AB");
        list.addCity(city);
        assertEquals(true, list.hasCity(city));
    }

    @Test
    void testDelete(){
        City city = new City("Calgary", "AB");
        list.addCity(city);
        list.delete(city);
        assertEquals(false, list.hasCity(city));

    }

    @Test
    void testDeleteException(){
        City city = new City("Regina", "SK");
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city);
        });
    }

    @Test
    void testCount(){
        assertEquals(1, list.countCities());
    }


}
