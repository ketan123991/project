package Project1;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;


public class AddCustomer extends JFrame  implements ActionListener{
    
    JComboBox idcombobox;
     JTextField txtnumber,txtname,txtcountry,txtdeposit;
     JRadioButton rbmale,rbfemale;
     Choice croom;
      JLabel checkingtime;
      JButton add,back;
    AddCustomer(){
        getContentPane().setBackground(Color.white);
        setBounds(350,200,800,550);
        setLayout(null);
   
        
        
        JLabel txt=new JLabel("NEW CUSTOMER FROM");
        txt.setBounds(100,20,300,30);
        txt.setFont(new Font("raleway",Font.PLAIN,20));
        add(txt);
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(35,80,300,30);
        lblid.setFont(new Font("raleway",Font.PLAIN,20));
        add(lblid);
        
        String options[]={"Aadhar Card","Password","Driving License","Voter-id Card","Ration Card"};
         idcombobox=new JComboBox(options);
        idcombobox.setBounds(200,80,150,25);
        idcombobox.setBackground(Color.white);
        add(idcombobox);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(35,120,150,30);
        lblnumber.setFont(new Font("raleway",Font.PLAIN,20));
        add(lblnumber);
        
       txtnumber=new JTextField();
       txtnumber.setBounds(200,120,150,30);
       add(txtnumber);
       
       JLabel lblname=new JLabel("Name");
        lblname.setBounds(35,160,150,30);
        lblname.setFont(new Font("raleway",Font.PLAIN,20));
        add(lblname);
        
       txtname=new JTextField();
       txtname.setBounds(200,160,150,30);
       add(txtname);
       JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(35,200,150,30);
        lblgender.setFont(new Font("raleway",Font.PLAIN,20));
        add(lblgender);
        rbmale=new JRadioButton("Male");
         rbmale.setBounds(200,200,75,30);
          rbmale.setBackground(Color.white);
          add(rbmale);
           rbfemale=new JRadioButton("Female");
         rbfemale.setBounds(275,200,90,30);
          rbfemale.setBackground(Color.white);
          add(rbfemale);
          ButtonGroup bg=new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);
          JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(35,240,150,30);
        lblcountry.setFont(new Font("raleway",Font.PLAIN,20));
        add(lblcountry);
        
       txtcountry=new JTextField();
       txtcountry.setBounds(200,240,150,30);
       add(txtcountry);
         JLabel lblroom=new JLabel("Room Number ");
        lblroom.setBounds(35,280,150,30);
        lblroom.setFont(new Font("raleway",Font.PLAIN,20));
        add(lblroom);
       croom=new Choice();
       try{
           Conn c=new Conn();
            String query="select * from room where available='available'";
           ResultSet rs= c.s.executeQuery(query);
           while(rs.next()){
               croom.add(rs.getString("RoomNumber"));
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       croom.setBounds(200,280,150,30);
       add(croom);
           JLabel lbltime=new JLabel("Checking Time ");
        lbltime.setBounds(35,320,150,30);
        lbltime.setFont(new Font("raleway",Font.PLAIN,20));
        add(lbltime);
        Date date=new Date();
         checkingtime =new JLabel(""+date);
        checkingtime.setBounds(200,320,150,30);
       checkingtime.setFont(new Font("raleway",Font.PLAIN,16));
        add(checkingtime);
        
        JLabel lbldeposit=new JLabel("Deposit ");
        lbldeposit.setBounds(35,360,150,30);
        lbldeposit.setFont(new Font("raleway",Font.PLAIN,20));
        add(lbldeposit);
        txtdeposit=new JTextField();
       txtdeposit.setBounds(200,360,150,30);
       add(txtdeposit);
        add=new JButton("Add ");
        add.setBounds(40,430,120,30);
         add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setFont(new Font("serif",Font.BOLD,18));
       add.addActionListener(this);
        add(add);
     
      back=new JButton("Back");
     back.setBounds(220,430,120,30);
     back.setForeground(Color.white);
     back.setBackground(Color.black);
     back.setFont(new Font("serif",Font.BOLD,18));
     back.addActionListener(this);

     add(back);
     
     
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth1.png"));
    Image i2=i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
   JLabel image =new JLabel(i3);
    image.setBounds(400,50,300,400);
    add(image);
         setVisible(true);
}
    public void actionPerformed(ActionEvent ae) {

    if (ae.getSource() == add) {

        String country = txtcountry.getText();
        String id = (String) idcombobox.getSelectedItem();
        String roomnumber = croom.getSelectedItem();
        String name = txtname.getText();
        String number = txtnumber.getText();
        String deposit = txtdeposit.getText();
        String time = checkingtime.getText();

        if (number.equals("") || name.equals("") || country.equals("") || deposit.equals("")) {
            JOptionPane.showMessageDialog(this, "All fields are required");
            return;
        }

        String gender = null;
        if (rbmale.isSelected()) gender = "Male";
        else if (rbfemale.isSelected()) gender = "Female";
        else {
            
            JOptionPane.showMessageDialog(this, "Please select gender");
            return;
        }

        try {
            Conn c = new Conn();

            String query ="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+roomnumber+"','"+time+"','"+deposit+"')";
            String query1="update room set available='occupied' where RoomNumber='"+roomnumber+"'";
            c.s.executeUpdate(query);
            c.s.executeUpdate(query1);

            JOptionPane.showMessageDialog(this, "Customer Added Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    } else if (ae.getSource() == back) {
        setVisible(false);
    }
}

    
    public static void main(String[]args){
        new AddCustomer();
    }
}