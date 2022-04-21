package view;

import controller.ChoiceController;
import controller.DataManage;
import controller.QueryController;
import controller.JudgeController;
import model.Meal;
import model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is for selecting the foundation meal
 * @Author Tianze Li
 * @version 1.0
 */
public class menuSelectMeal {
    private JFrame frame0;//当前页面容器
    private JPanel panel0;
    private JButton buttonBack;
    private JButton buttonNext;
    private JPanel panelBot;
    private JPanel panelTop;
    private JLabel label2;
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JComboBox comboBoxMeal;
    private JCheckBox checkBoxExtra;
    private ChoiceController choiceController = new ChoiceController();
    private QueryController queryController = new QueryController();
    private JudgeController judgeController = new JudgeController();

    public menuSelectMeal(String orderId) {
        //生成页面区域
        frame0 = new JFrame("menuSelectMeal");
        ImageIcon img1 = new ImageIcon("img/meal1.png");
        img1.setImage(img1.getImage().getScaledInstance(250,150, Image.SCALE_DEFAULT));
        ImageIcon img2 = new ImageIcon("img/meal2.png");
        img2.setImage(img2.getImage().getScaledInstance(250,150, Image.SCALE_DEFAULT));
        ImageIcon img3 = new ImageIcon("img/meal3.png");
        img3.setImage(img3.getImage().getScaledInstance(250,150, Image.SCALE_DEFAULT));
        ImageIcon img4 = new ImageIcon("img/meal4.png");
        img4.setImage(img4.getImage().getScaledInstance(250,150, Image.SCALE_DEFAULT));
        label1.setIcon(img1);
        label2.setIcon(img2);
        label3.setIcon(img3);
        label4.setIcon(img4);
        frame0.setContentPane(panel0);
        frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame0.pack();
        frame0.setVisible(true);
        frame0.setSize(800,600);

        //监听事件区域
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("back");


                //跳转回座位选择界面
                new menuSelectSeat(orderId);
                frame0.dispose();
            }
        });
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("next");
                //提取、存储相关数据
                try {
                    choiceController.basicMealChoose(orderId, queryController.getMealNameByType(comboBoxMeal.getSelectedIndex()));
//                    //此段代码为必选餐是否真正写入Meal类里，已经测试成功，可以删除----------------
////                    DataManage instance = DataManage.getInstance();
////                    ArrayList<Order> orderArrayList = instance.getOrders();
////                    ArrayList<Meal> mealArrayList = instance.getMeals();
////                    for (Order temp:orderArrayList){
////                        if (temp.getOrderNo().equals(orderId)){
////                            for (Meal temp1:mealArrayList){
////                                if (temp1.getMealNo().equals(temp.getMealNo())){
////                                    System.out.println(temp1.getBasicMeal());
////                                }
////                            }
////                        }
////                    }
////                    //---------------------------------------------------------------------
                    if (checkBoxExtra.isSelected()){
                        new menuSelectExtraMeal(orderId);
                    }
                    else if (!checkBoxExtra.isSelected() && !judgeController.isExtraSeat(orderId)){
                        new menuShowInfo(orderId);
                    }
                    else if (!checkBoxExtra.isSelected() && judgeController.isExtraSeat(orderId)){
                        new menuAddCreditCard(orderId);
                    }
                    frame0.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    //测试用
    public static void main(String[] args) {
       new menuSelectMeal("8201465425955");
    }
}
