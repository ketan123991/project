
package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame  implements ActionListener{
    JButton back;
    JTable table;
    JComboBox bedtype;
SearchRoom(){    
    setBounds(300,200,800,600);
    setLayout(null);
     getContentPane().setBackground(Color.white);
       
       
      JLabel txt=new JLabel("Search for Room");
      txt.setFont(new Font("Tahoma",Font.PLAIN,20));
      txt.setBounds(200,30,200,30);
      add(txt);
      
       JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(50,80,100,20);
        add(lblbed);
        String options[]={"Single Bed","Double Bed"};
        bedtype =new JComboBox(options);
        bedtype.setBounds(160,80,100,20);
        add(bedtype);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,150,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(120,150,100,20);
        add(l2);
        JLabel l3=new JLabel("Status");
        l3.setBounds(230,150,100,20);
        add(l3);
        JLabel l4=new JLabel("Price");
        l4.setBounds(320,150,100,20);
        add(l4);
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(420,150,100,20);
        add(l5);
        table =new JTable();
        table.setBounds(0,200,500,300);
        add(table);
     
        try{
            
             String bed=(String) bedtype.getSelectedItem();
             Conn c=new Conn();
            String query="select * from room where TypeofBed='"+bed+"'";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

           
        }
        catch(Exception e){
        e.printStackTrace();
            
        }
        
        back=new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(100,250,100,20);
        back.addActionListener(this);
        add(back);
        
        
        
       setVisible(true);
    
}

public static void main(String[]args){
    new SearchRoom();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
        
        
    }
}
