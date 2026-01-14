
package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class PickUp extends JFrame  implements ActionListener{
    JButton back;
    JTable table;
    JComboBox bedtype;
PickUp(){    
    setBounds(300,200,1050,600);
    setLayout(null);
     getContentPane().setBackground(Color.white);
       
       
      JLabel txt=new JLabel("Search for Room");
      txt.setFont(new Font("Tahoma",Font.PLAIN,20));
      txt.setBounds(400,30,200,30);
      add(txt);
      
       JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        String options[]={"Single Bed","Double Bed"};
        bedtype =new JComboBox(options);
        bedtype.setBounds(160,100,100,20);
        add(bedtype);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        add(l2);
        JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
        JLabel l4=new JLabel("Price");
        l4.setBounds(320,10,100,20);
        add(l4);
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(420,10,100,20);
        add(l5);
        table =new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        try{
            Conn c=new Conn();
            String query="select * from room";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

           
        }
        catch(Exception e){
        e.printStackTrace();
            
        }
        
        back=new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        add(back);
        
        
        
       setVisible(true);
    
}

public static void main(String[]args){
    new PickUp();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
        
        
    }
}
