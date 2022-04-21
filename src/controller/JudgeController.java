package controller;



import model.Order;
import model.Passenger;

import java.io.IOException;
import java.util.ArrayList;

/**
 *  The class stores the tool methods of judge.
 *  @Author Jingkun Yue
 *  @Version 1.0
 */
public class JudgeController implements JudgeUtl{
    public boolean isExtraSeat(String orderNo) throws IOException {
        DataManage instance = DataManage.getInstance();
        ArrayList<Order> orderArrayList = instance.getOrders();
        for (Order temp:orderArrayList){
            if (temp.getOrderNo().equals(orderNo)){
                if (temp.getSeat()!=null){
                    int row = Integer.parseInt(temp.getSeat().substring(0,2));
                    if (row>3){
                        return false;
                    }
                    else if (1<=row && row<=3){
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean isCorrectID(String orderNo, String inputIDNo) throws IOException{
        DataManage instance = DataManage.getInstance();
        ArrayList<Order> orderArrayList = instance.getOrders();
        for (Order temp:orderArrayList){
            if (temp.getOrderNo().equals(orderNo)){
                if (temp.getPassenger_IDNo().equals(inputIDNo)){
                    return true;
                }
            }
        }
        return false;
    }

}
