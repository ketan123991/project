
package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateCheck extends JFrame implements ActionListener{
    Choice customer;
    JTextField txtname,txtrn,txtcheckingtime,txtamount,txtpending;
    JButton check,back,update;
    UpdateCheck(){
        setBounds(300,200,900,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

            JLabel txt=new JLabel("Update Status");
            txt.setBounds(90,20,200,30);
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
            rn.setBounds(30,120,100,20);
            add(rn);
              txtrn=new JTextField();
            txtrn.setBounds(200,120,150,25);
            add(txtrn);
            JLabel name=new JLabel("Name");
            name.setBounds(30,160,100,20);
            add(name); 
            txtname=new JTextField();
            txtname.setBounds(200,160,150,25);
            add(txtname);
           JLabel  checkingtime=new JLabel(" Checking Time");
            checkingtime.setBounds(30,200,100,20);
            add(checkingtime); 
            txtcheckingtime=new JTextField();
            txtcheckingtime.setBounds(200,200,150,25);
            add(txtcheckingtime);
            JLabel  amount=new JLabel("Paid Amount");
            amount.setBounds(30,240,100,20);
            add(amount); 
            txtamount=new JTextField();
            txtamount.setBounds(200,240,150,25);
            add(txtamount);
            JLabel pending=new JLabel("Pending Amount");
            pending.setBounds(30,280,100,20);
            add(pending); 
            txtpending=new JTextField();
            txtpending.setBounds(200,280,150,25);
            add(txtpending);
            
            check=new JButton("Check");
            check.setBackground(Color.black);
            check.setForeground(Color.white);
            check.setBounds(30,340,100,30);
            check.addActionListener(this);
            add(check);
            update=new JButton("Update");
            update.setBackground(Color.black);
            update.setForeground(Color.white);
            update.setBounds(150,340,100,30);
             update.addActionListener(this);
            add(update);
           back=new JButton("Back");
            back.setBackground(Color.black);
            back.setForeground(Color.white);
            back.setBounds(270,340,100,30);
             back.addActionListener(this);
            add(back);
             
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        
        JLabel image= new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
            
            

        setVisible(true);
}
    public static void main(String []args){
    new UpdateCheck();
    
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
                   txtname.setText(rs.getString("Name"));
                     txtamount.setText(rs.getString("Deposit"));
                       txtcheckingtime.setText(rs.getString("Time"));
                     
                 }
                  ResultSet rs1=c.s.executeQuery("select * from room where RoomNumber='"+txtrn.getText()+"'");
                  while(rs1.next()){
                  String amount=rs1.getString("Price");
                  int remaingingAmount=Integer.parseInt(amount)-Integer.parseInt(txtamount.getText());
                 txtpending.setText(" "+remaingingAmount);
                  }
                 
            }
            catch(Exception w){
            w.printStackTrace();
            }
        }
        
        
        else if(e.getSource()==update){
          
   
            String number=customer.getSelectedItem();
            String name=txtname.getText();
         String rn=txtrn.getText();
         String checkingtime=txtcheckingtime.getText();
         String amount=txtamount.getText();
        
         try{ 
         Conn c=new Conn();
         c.s.executeUpdate("update customer set RoomNumber='"+rn+"',Name='"+name+"',Time='"+checkingtime+"',Deposit='"+amount+"'where Number='"+number+"'");
         JOptionPane.showMessageDialog(null, "Information added Successfully");
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
