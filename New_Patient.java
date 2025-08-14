package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class New_Patient extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber,textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton b1,b2;

    New_Patient(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(10,5,848,548);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JLabel labelName = new JLabel("New Patient Info");
        labelName.setBounds(330,10,260,53);
        labelName.setFont(new Font("Times New Roman",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelID = new JLabel("New Patient ID:");
        labelID.setBounds(180,76,230,16);
        labelID.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"NID card","Driving License"});
        comboBox.setBounds(300,76,200,20);
        comboBox.setBackground(new Color(110,50,60));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(comboBox);

        JLabel  labelNumber = new JLabel("Number:");
        labelNumber.setBounds(200,111,230,16);
        labelNumber.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(300,111,200,20);
        panel.add(textFieldNumber);

        JLabel  labelNamee = new JLabel("Name:");
        labelNamee.setBounds(200,151,230,16);
        labelNamee.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(labelNamee);

        textName = new JTextField();
        textName.setBounds(300,151,200,20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(200,175,260,53);
        labelGender.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Times New Roman",Font.BOLD,16));
        r1.setBounds(300,194,200,14);
        r1.setBackground(new Color(109,165,170));
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Times New Roman",Font.BOLD,16));
        r2.setBounds(500,194,200,14);
        r2.setBackground(new Color(109,165,170));
        panel.add(r2);

        JLabel  labelDisease = new JLabel("Disease:");
        labelDisease.setBounds(200,230,230,16);
        labelDisease.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(300,230,200,20);
        panel.add(textFieldDisease);

        JLabel  labelRoom = new JLabel("Room:");
        labelRoom.setBounds(200,270,90,16);
        labelRoom.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(labelRoom);

        c1 = new Choice();
        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select* from Room");
            while(resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }
        }catch(Exception e){
            e.printStackTrace();

        }

        c1.setBounds(300,270,200,20);
        c1.setFont(new Font("Times New Roman",Font.BOLD,14));
        c1.setBackground(new Color(109,165,170));
        panel.add(c1);

        JLabel  labelDate = new JLabel("Time:");
        labelDate.setBounds(200,310,230,16);
        labelDate.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(300,310,300,14);
        date.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(date);

        JLabel  labelDeposite = new JLabel("Deposite:");
        labelDeposite.setBounds(200,350,230,16);
        labelDeposite.setFont(new Font("Times New Roman",Font.BOLD,16));
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(300,350,200,20);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(300,400,140,20);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(500,400,140,20);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            Database c = new Database();
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN="Male";
            }
            else if (r2.isSelected()){
                radioBTN="Female";
            }

            String s1 = (String)comboBox.getSelectedItem();
            String s2 = (String)textFieldNumber.getText();
            String s3 = (String)textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try{
                String q = "insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update room set Availability = 'Occupied' where room_no="+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }
            catch (Exception E){
                E.printStackTrace();

            }
        }else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new New_Patient();
    }
}
