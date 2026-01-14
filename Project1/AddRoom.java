package Project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRoom extends JFrame implements ActionListener {
    JButton addroom,cancel;
    JTextField tfrn,tfprice;
   JComboBox availablecombobox,cleancombobox,bedcombobox;

    AddRoom(){
     setBounds(330,200,940,470);
     getContentPane().setBackground(Color.white);
     setLayout(null);
    
     
     JLabel heading=new JLabel("ADD ROOM");
     heading.setFont(new Font("tohama",Font.BOLD,18));
     heading.setBounds(150,20,200,20);
     add(heading);
      

   JLabel lblrn=new JLabel("Room Number");
     lblrn.setFont(new Font("tohama",Font.PLAIN,16));
    lblrn.setBounds(60,80,120,30);
     add(lblrn);
      
     tfrn=new JTextField();
     tfrn.setBounds(200,80,150,30);
     add(tfrn);
     
     
     JLabel lblavailable=new JLabel("Available");
     lblavailable.setFont(new Font("tohama",Font.PLAIN,16));
    lblavailable.setBounds(60,130,120,30);
     add(lblavailable);
     
     String availableoptions[]={"Available","Occupied"};
     
     availablecombobox=new JComboBox(availableoptions);
     availablecombobox.setBackground(Color.white);
     availablecombobox.setBounds(200,130,150,30);
     add(availablecombobox);
     
     JLabel lblclean=new JLabel("Clean Stauts");
     lblclean.setFont(new Font("tohama",Font.PLAIN,16));
    lblclean.setBounds(60,180,120,30);
     add(lblclean);
     
     String cleanoptions[]={"Cleaned","Dirty"};
     
     cleancombobox=new JComboBox(cleanoptions);
     cleancombobox.setBackground(Color.white);
     cleancombobox.setBounds(200,180,150,30);
     add(cleancombobox);
     
     JLabel lblprice=new JLabel("Price");
     lblprice.setFont(new Font("tohama",Font.PLAIN,16));
    lblprice.setBounds(60,230,120,30);
     add(lblprice);
      
    tfprice=new JTextField();
     tfprice.setBounds(200,230,150,30);
     add(tfprice);
     
     JLabel lbltype=new JLabel("Bed Type");
     lbltype.setFont(new Font("tohama",Font.PLAIN,16));
    lbltype.setBounds(60,280,120,30);
     add(lbltype);
     
     String bedoptions[]={"Single Bed","Double Bed"};
     
      bedcombobox=new JComboBox(bedoptions);
     bedcombobox.setBackground(Color.white);
     bedcombobox.setBounds(200,280,150,30);
     add(bedcombobox);
     
    addroom=new JButton("Add Room");
     addroom.setBounds(80,350,120,30);
     addroom.setForeground(Color.white);
     addroom.setBackground(Color.black);
     addroom.setFont(new Font("serif",Font.BOLD,18));
     addroom.addActionListener(this);
     add(addroom);
     
      cancel=new JButton("Cancel");
     cancel.setBounds(240,350,120,30);
     cancel.setForeground(Color.white);
     cancel.setBackground(Color.black);
     cancel.setFont(new Font("serif",Font.BOLD,18));
     cancel.addActionListener(this);

     add(cancel);
     
     
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
   JLabel image =new JLabel(i1);
    image.setBounds(400,30,500,350);
    add(image);
    
     setVisible(true);
     
     
      }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String  roomNo=tfrn.getText();
        String availablity=(String)availablecombobox.getSelectedItem();
       String clean=(String)cleancombobox.getSelectedItem();
        String price=tfprice.getText();
        String type=(String)bedcombobox.getSelectedItem();
         
        
         
        if(ae.getSource()==addroom){
            
            if (roomNo.equals("") || price.equals("")) {
            JOptionPane.showMessageDialog(this, "All fields are required");
            return;
            }
            try
            {
                Conn c=new Conn();
            
             String query="insert into room values( '"+roomNo+"','"+availablity+"','"+clean+"','"+price+"','"+type+"')";
             c.s.executeUpdate(query); 
             JOptionPane.showMessageDialog(null, "Room Information Added Successfully");
             setVisible(false);
            }
            catch(Exception e){
                
               e.printStackTrace();    
                
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
        
    }
     
     
   
    
    public static void main(String[]args){
        AddRoom r=new AddRoom();
        
    }

}