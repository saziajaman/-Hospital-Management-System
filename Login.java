package hospital.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
public class Login extends JFrame implements ActionListener  {
    JTextField textField;
    JPasswordField  jPasswordField;
    JButton b1,b2;
    Login(){
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Times New Roman",Font.BOLD,16));
        namelabel.setForeground(Color.WHITE);
        add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Times New Roman",Font.BOLD,16));
        password.setForeground(Color.WHITE);
        add(password);

        textField = new JTextField();
        textField .setBounds(150,20,150,30);
        textField .setFont(new Font("Times New Roman",Font.PLAIN,15));
        textField .setBackground(new Color(255,255,255));
        add(textField );

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        jPasswordField.setFont(new Font("Times New Roman",Font.PLAIN,15));
        jPasswordField.setBackground(new Color(255,255,255));
        add(jPasswordField );

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("Times New Roman",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("Times New Roman",Font.BOLD,15));
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(109,164,170));
        setSize(700,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try{
                Database c = new Database();
                String user = textField.getText();
                String pass = jPasswordField.getText();

                String q = "select * from login where ID='"+user+"' and password = '"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invaid");
                }

            }catch(Exception E){
                E.printStackTrace();
            }

        }

        else{
            System.exit(10);

        }
    }
    public static void main(String[]args){
        new Login();
    }

}
