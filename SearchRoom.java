package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    Choice choice;
    JTable table;
    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,250,20);
        For.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(For);

        JLabel status = new JLabel("Status:");
        status.setBounds(170,55,80,20);
        status.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(250,55,150,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,120,700,300);
        table.setFont(new Font("Times New Roman",Font.PLAIN,20));
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        try{
            Database c= new Database();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Roomno = new JLabel("Room no");
        Roomno.setBounds(60,90,80,20);
        Roomno.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(Roomno);

        JLabel available = new JLabel("Availability");
        available.setBounds(240,90,180,20);
        available.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(410,90,80,20);
        price.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(price);

        JLabel bed = new JLabel("Bed type");
        bed.setBounds(550,90,80,20);
        bed.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(bed);


        JButton Search = new JButton("Search");
        Search.setBounds(200,450,120,20);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.WHITE);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select* from room where Availability='"+choice.getSelectedItem()+"'";
                try{
                    Database c= new Database();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });



        JButton back = new JButton("Back");
        back.setBounds(450,450,120,20);
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
        setSize(700,500);
        setLocation(450,250);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
