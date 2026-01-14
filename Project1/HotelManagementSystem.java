package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener {
    
   
    
    HotelManagementSystem(){
        
      
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
    JLabel image=new JLabel(i1);
    image.setBounds(0,0,1366,565);
      add(image);
      
      
      JLabel txt=new JLabel("Hotel Management System");
      txt.setBounds(20,430,1000,90);
      txt.setForeground(Color.WHITE);
      txt.setFont(new Font("serif",Font.PLAIN,50));
      image.add(txt);
      
      JButton next=new JButton("NEXT");
      next.setBounds(1150,450,130,50);
      next.setBackground(Color.white);
      next.setForeground(Color.magenta);
      next.setFont(new Font("serif",Font.PLAIN,24));
      next.addActionListener(this);
      image.add(next);
    
      /*
   
    while(true){
        txt.setVisible(false);
        try{
            Thread.sleep(500);
        }
          catch(Exception e){
              e.printStackTrace();   
    }
            txt.setVisible(true);
   
         try{
            Thread.sleep(500);
        }
          catch(Exception e){
              e.printStackTrace();   
    }
      }*/
    
    
 }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
          Login l= new Login();
        
}
    
    
    
    
    
   

    public static void main(String[] args) {
        
        HotelManagementSystem s=new HotelManagementSystem();
       s.setSize(1366,565);
        s.setVisible(true);
       s.setLocation(100,100);
       s.setLayout(null);
       s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

    
