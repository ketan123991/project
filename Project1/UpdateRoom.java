
package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateRoom extends JFrame implements ActionListener{
    Choice customer;
    JTextField txtavailability,txtrn,txtclean;
    JButton check,back,update;
    UpdateRoom(){
        setBounds(300,200,900,470);
        setLayout(null);
        getContentPane().setBackground(Color.white);

            JLabel txt=new JLabel("Update Room Status");
            txt.setBounds(30,20,250,30);
            txt.setForeground(Color.blue);
            txt.setFont(new Font("tahoma",Font.PLAIN,20));
            add(txt);
            JLabel lblid=new JLabel("Customer Id");
            lblid.setBounds(30,80,100,20);
            add(lblid);
            customer=new Choice();
            customer.setBounds(200,80,150,25);
            add(customer);
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from customer");
                
                while(rs.next()){
                    customer.add(rs.getString("Number"));
            }
            }
            catch(Exception q){
                q.printStackTrace();
                    }       
             
            JLabel rn=new JLabel("Room Number");
            rn.setBounds(30,130,100,20);
            add(rn);
              txtrn=new JTextField();
            txtrn.setBounds(200,130,150,25);
            add(txtrn);
            JLabel availability=new JLabel("Availability");
            availability.setBounds(30,180,100,20);
            add(availability); 
            txtavailability=new JTextField();
            txtavailability.setBounds(200,180,150,25);
            add(txtavailability);
           JLabel  clean=new JLabel("Cleaning Status");
            clean.setBounds(30,230,100,20);
            add(clean); 
            txtclean=new JTextField();
            txtclean.setBounds(200,230,150,25);
            add(txtclean);
         
            check=new JButton("Check");
            check.setBackground(Color.black);
            check.setForeground(Color.white);
            check.setBounds(30,300,100,30);
            check.addActionListener(this);
            add(check);
            update=new JButton("Update");
            update.setBackground(Color.black);
            update.setForeground(Color.white);
            update.setBounds(150,300,100,30);
             update.addActionListener(this);
            add(update);
           back=new JButton("Back");
            back.setBackground(Color.black);
            back.setForeground(Color.white);
            back.setBounds(270,300,100,30);
             back.addActionListener(this);
            add(back);
             
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
       Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
        
        JLabel image= new JLabel(i3);
        image.setBounds(380,50,500,300);
        add(image);
            
            

        setVisible(true);
}
    public static void main(String []args){
    new UpdateRoom();
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            String id=customer.getSelectedItem();
          
            try{
                Conn c=new Conn();
                 String query="select * from customer where Number='"+id+"'";
                 ResultSet rs=c.s.executeQuery(query);
                 while(rs.next()){
                 txtrn.setText(rs.getString("RoomNumber"));
                  
                     
                 }
                  ResultSet rs1=c.s.executeQuery("select * from room where RoomNumber='"+txtrn.getText()+"'");
                  while(rs1.next()){
                      txtavailability.setText(rs1.getString("available"));
                        txtclean.setText(rs1.getString("clean"));
               
                  }
                 
            }
            catch(Exception w){
            w.printStackTrace();
            }
        }
        
        
        else if(e.getSource()==update){
          
   

            String clean=txtclean.getText();
         String rn=txtrn.getText();
         String availability=txtavailability.getText();
        
        
         try{ 
         Conn c=new Conn();
         c.s.executeUpdate("update room set available='"+availability+"',clean='"+clean+"'where RoomNumber='"+rn+"'");
         JOptionPane.showMessageDialog(null, "Update Successfully");
         setVisible(false);
         }
        catch(Exception q){
            q.printStackTrace();
        }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
}
