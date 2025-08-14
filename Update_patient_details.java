package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_patient_details extends JFrame {

    Update_patient_details() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JLabel label = new JLabel("Update Patient Details");
        label.setBounds(200,11,250,20);
        label.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label);

        JLabel label2 = new JLabel("Name");
        label2.setBounds(130,88,100,20);
        label2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(300,85,100,20);
        panel.add(choice);

        try{
            Database c= new Database();
            ResultSet resultSet=c.statement.executeQuery("select* from Patient_info");
            while(resultSet.next()){
                choice.add((resultSet.getString("Name")));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No");
        label3.setBounds(130,130,100,20);
        label3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(300,129,100,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time");
        label4.setBounds(130,175,100,20);
        label4.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label4);

        JTextField textFieldInTime = new JTextField();
        textFieldInTime.setBounds(300,175,100,20);
        panel.add(textFieldInTime);

        JLabel label5 = new JLabel("Amount_Paid");
        label5.setBounds(130,220,150,20);
        label5.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(300,220,100,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending_Amount");
        label6.setBounds(130,270,150,20);
        label6.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(300,270,100,20);
        panel.add(textFieldPending);

        JButton Check= new JButton("Check");
        Check.setBounds(240,320,100,20);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try{
                    Database c = new Database();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room"));
                        textFieldInTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select* from room where room_no = '"+textFieldR.getText()+"'");
                    while(resultSet1.next()){
                        String price = resultSet1.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }

            }
        });

        JButton update= new JButton("Update");
        update.setBounds(130,320,100,20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Database c = new Database();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldInTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update Patient_info set Room = '"+room+"',Time='"+time+"',Deposite='"+amount+"' where name='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Update Successfully");
                    setVisible(false);
                }catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
        JButton back= new JButton("Back");
        back.setBounds(350,320,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(650,400);
        setLocation(400,250);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[]args){
        new Update_patient_details();
    }
}
