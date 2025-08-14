package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;
    Room(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,490,490);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(109,164,170));
        table.setLayout(null);
        panel.add(table);

        try{
            Database c = new Database();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e){
            e.printStackTrace();

        }
        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(140,15,80,15);
        label2.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(290,15,80,15);
        label3.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(400,15,80,15);
        label4.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(label4);

        JButton back = new JButton("Back");
        back.setBounds(200,450,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(500,500);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
