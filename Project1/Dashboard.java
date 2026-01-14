package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener {
   JMenuItem addroom,addemploye,adddrive,reception;
     Dashboard(){
     setVisible(true);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
      Image i2=i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(0,0,1550,1000);
      add(image);
      
      
        JLabel txt=new JLabel("THE TAJ GROUP WELCOME YOU");
        txt.setBounds(400,80,1000,50);
        txt.setFont(new Font("Tahoma",Font.PLAIN,46));
        txt.setForeground(Color.white);
        image.add(txt);
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel=new JMenu("Hotel Management");
        hotel.setForeground(Color.red);
        mb.add(hotel);
        JMenuItem reception=new JMenuItem("RECEPTION");
       reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
         addemploye=new JMenuItem("ADD EMPLOYEE");
        addemploye.addActionListener(this);
        admin.add(addemploye);
        
         addroom=new JMenuItem("ADD ROOM");
        addroom.addActionListener(this);
        admin.add(addroom);
        
          adddrive=new JMenuItem("ADD DRIVE");
          adddrive.addActionListener(this);
        admin.add(adddrive);
        
         
     }
     @Override
    public void actionPerformed(ActionEvent e) {
         
        if(e.getSource()==addroom)
        {
            new AddRoom();
              
        }
        else if(e.getSource()==addemploye){
            new AddEmployee();
            
        }
        else if(e.getSource()==adddrive){
            new AddDriver();
        }
        else if(e.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
        
           
    }
     
    public static void main(String[]args){
        Dashboard d=new Dashboard();
          d.setSize(1550,1000);
          d.setLayout(null);
         
          d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    
}
