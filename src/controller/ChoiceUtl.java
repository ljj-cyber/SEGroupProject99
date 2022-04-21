package controller;

import model.Flight;
import model.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *  Interface for choice
 *  @Author ZheLiu
 *  @Version 1.0
 */
public interface ChoiceUtl {
    public void seatChoose(String orderNo, String seat, int type) throws IOException;
    public void basicMealChoose(String orderNo, String basicMeal) throws IOException;
    public void extraMealChoose(String orderNo, ArrayList<String> extraMeal ) throws IOException;
    public void pay(String orderNo,String creditNo) throws IOException;
    public void defaultPayment(String orderNo) throws IOException;
    public void defaultSeat(String orderNo) throws IOException;
    public void defaultMeal(String orderNo) throws IOException;

}
