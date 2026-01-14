
package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Department extends JFrame  implements ActionListener{
    JButton back;
    JTable table;
Department(){    
    setBounds(400,200,700,480);
    setLayout(null);
     getContentPane().setBackground(Color.white);
       
 
        JLabel l1=new JLabel("Department");
        l1.setBounds(170,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Budget");
        l2.setBounds(420,10,100,20);
        add(l2);
      
        table =new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        try{
            Conn c=new Conn();
            String query="select * from department";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

           
        }
        catch(Exception e){
        e.printStackTrace();
            
        }
        
        back=new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(280,400,120,30);
        back.addActionListener(this);
        add(back);
        
        
        
       setVisible(true);
    
}

public static void main(String[]args){
    new Department();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
        
        
    }
}
