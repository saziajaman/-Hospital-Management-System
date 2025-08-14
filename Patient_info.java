package hospital.management.system;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class Patient_info  extends JFrame{

    Patient_info (){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,700,150);
        table.setFont(new Font("Times New Roman",Font.PLAIN,16));
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        try{
            Database c = new Database();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setBounds(10,11,105,20);
        label1.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(90,11,150,20);
        label2.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(190,15,80,15);
        label3.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(260,15,80,15);
        label4.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(350,15,80,15);
        label5.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label5);

        JLabel label6 = new JLabel("Room");
        label6.setBounds(440,15,80,15);
        label6.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(520,15,80,15);
        label7.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label7);

        JLabel label8 = new JLabel("Deposite");
        label8.setBounds(600,15,80,15);
        label8.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label8);


        JButton b1 = new JButton("Back");
        b1.setBounds(400,200,100,20);
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
        new Patient_info();
    }
}
