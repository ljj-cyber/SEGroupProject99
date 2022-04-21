package controller;

import model.Baggage;
import model.Flight;
import model.Order;
import model.Passenger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *  Interface for query
 *  @Author ZheLiu
 *  @Version 1.0
 */
public interface QueryUtl {
    public HashMap<Order, Flight> queryByBookNum(String orderNo) throws IOException;
    public boolean checkById(String surName,String idNo) throws IOException;
    public HashMap<Order,Flight> queryByID(String idNo) throws IOException;
    public ArrayList<Passenger> flightSearch(String flightID) throws IOException;
    public boolean loginCheck(String Account,String password) throws IOException;
    public ArrayList<Baggage> checkBaggage(String orderID) throws IOException;
    public int[][] flightChoosed(String flightID) throws IOException;
    public String getFlightId(String orderID) throws IOException;
    public String getMealNameByType(int type) throws IOException;
}
