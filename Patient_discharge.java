package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_discharge  extends JFrame{

    Patient_discharge (){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,390);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(250,20,150,20);
        label.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(label);

        JLabel label2 = new JLabel("Customer ID:");
        label2.setBounds(130,80,150,20);
        label2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(290,80,150,30);
        panel.add(choice);

        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel label3 = new JLabel("Room No:");
        label3.setBounds(130,130,150,20);
        label3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(290,130,150,20);
        RNo.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(RNo);

        JLabel label4 = new JLabel("IN Time:");
        label4.setBounds(130,180,150,20);
        label4.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label4);

        JLabel INTime  = new JLabel();
        INTime.setBounds(290,180,350,20);
        INTime.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(INTime);

        JLabel label5 = new JLabel("OUT Time:");
        label5.setBounds(130,230,150,20);
        label5.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label5);

        Date date = new Date();

        JLabel OUTTime  = new JLabel(""+date);
        OUTTime.setBounds(290,230,350,20);
        OUTTime.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(OUTTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(130,300,100,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database c = new Database();
                try{
                    c.statement.executeUpdate("delete from Patient_info where number='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room = '"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(260,300,100,30);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database c = new Database();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        RNo.setText(resultSet.getString("room"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(390,300,100,30);
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
        setSize(700,400);
        setLocation(400,250);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[]args){
        new Patient_discharge();
    }
}
