package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame  implements ActionListener{
    JButton newcustomer, rooms,department,logout,update,roomstatus;
    Reception(){
        setBounds(350,200,800,570);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newcustomer=new JButton("New Customer From");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
         rooms=new JButton("Room");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
         rooms.addActionListener(this);
        add(rooms);
        department=new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
         department.addActionListener(this);
        add(department);
        JButton allemployee=new JButton("All Employee");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        add(allemployee);
        JButton customer=new JButton("Customer Info");
        customer.setBounds(10,190,200,30);
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        add(customer);
        JButton managerInfo=new JButton("Manage Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        add(managerInfo);
        JButton checkout=new JButton("Check Out");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);
        update=new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        roomstatus=new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        add(roomstatus);
        JButton pickup=new JButton("Pickup");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);
        JButton roomsearch=new JButton("Room Search");
        roomsearch.setBounds(10,430,200,30);
        roomsearch.setBackground(Color.BLACK);
        roomsearch.setForeground(Color.WHITE);
        add(roomsearch);
       logout=new JButton("Log Out");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        setVisible(true);
        
    }
    public static void main(String[]args){
    new Reception();    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newcustomer){
            new AddCustomer();
        }
        else if(e.getSource()==rooms){
            setVisible(false);
        new Room();
        }
        else if(e.getSource()==department){
            setVisible(false);
            new Department();
        }
         else if(e.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        }
         else if(e.getSource()==roomstatus){
            setVisible(false);
            new UpdateRoom();
        }
         
    }
}
