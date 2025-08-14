package hospital.management.system;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {


    Department(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JTable table = new JTable();
        table.setBounds(30,100,600,300);
        table.setFont(new Font("Times New Roman",Font.PLAIN,16));
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        try{
            Database c = new Database();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setBounds(145,60,105,20);
        label1.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone no");
        label2.setBounds(431,60,150,20);
        label2.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label2);

        JButton back = new JButton("Back");
        back.setBounds(340,400,100,20);
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
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }
    public static void main(String[]args){
        new Department();

    }
}
