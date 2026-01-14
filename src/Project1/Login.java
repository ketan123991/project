 package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField txtuser;
     JPasswordField txtpass;
    JButton login,cancel;
    Login(){
        getContentPane().setBackground(Color.white);
       setSize(600,300);
     
       setLocation(500,200);
       setLayout(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
       JLabel uname=new JLabel("User Name");
       uname.setBounds(40,20,100,30);
       uname.setForeground(Color.BLUE);
       uname.setFont(new Font("serif",Font.PLAIN,20));
       add(uname);
     
     JLabel pass=new JLabel("Password");
       pass.setBounds(40,70,100,30);
      pass.setForeground(Color.BLUE);
       pass.setFont(new Font("serif",Font.PLAIN,20));
       add(pass);
       
       txtuser=new JTextField();
      txtuser.setBounds(170,20,150,30);
      add(txtuser);
      
       txtpass=new JPasswordField();
      txtpass.setBounds(170,70,150,30);
      add(txtpass);
      
      login=new JButton("Login");
      login.setBounds(40,150,120,30);
      login.setBackground(Color.BLACK);
      login.setForeground(Color.WHITE);
      login.addActionListener(this);
      add(login);
       
      
      cancel=new JButton("Cancel");
      cancel.setBounds(200,150,120,30);
      cancel.setBackground(Color.BLACK);
      cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
      add(cancel);
      
      ImageIcon i1=new ImageIcon("C:/Users/lenovo/Downloads/HotelManagementSystem1/src/icons/second.jpg");
      Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(350,10,200,200);
      add(image);
        setVisible(true);
       
    
    }
 @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            String user=txtuser.getText();
            String pass=txtpass.getText();
            try{
                Conn c=new Conn();
                String query="select * from login where username ='"+user+"'and password ='"+pass+"'";
               ResultSet rs= c.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   Dashboard d=new Dashboard();
                     d.setExtendedState(JFrame.MAXIMIZED_BOTH);
               }
               else{
                   JOptionPane.showMessageDialog(null,"invalid username and password");
                   
               }
            }
            catch(Exception ae){
                ae.printStackTrace();
            }
            
        }
        else if(e.getSource()==cancel){
            setVisible(false);
            
        }
        
        
    }

  
    
 public static void main(String[]args){
      Login l=new Login();
     
    }

}
