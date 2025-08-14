package hospital.management.system;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class Employee_info  extends JFrame{

    Employee_info (){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,700,200);
        table.setFont(new Font("Times New Roman",Font.PLAIN,16));
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        try{
            Database c = new Database();
            String q = "select * from emp_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(20,11,105,20);
        label1.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(120,11,50,20);
        label2.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone_Number");
        label3.setBounds(210,15,170,15);
        label3.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label3);

        JLabel label4 = new JLabel("Email");
        label4.setBounds(410,15,160,15);
        label4.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label4);

        JLabel label5 = new JLabel("Salary");
        label5.setBounds(500,15,80,15);
        label5.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label5);

        JLabel label6 = new JLabel("NID_no");
        label6.setBounds(590,15,80,15);
        label6.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label6);

        JButton b1 = new JButton("Back");
        b1.setBounds(220,250,100,20);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[]args){
        new Employee_info();
    }
}
