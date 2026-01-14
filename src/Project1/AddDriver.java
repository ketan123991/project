package Project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddDriver extends JFrame implements ActionListener {
    JButton adddriver,cancel;
    JTextField tfname,tfage,tfcarcompany,tfmodel,tflocation;
   JComboBox agecombobox,availablecombobox;

    AddDriver(){
     setBounds(300,200,980,570);
     getContentPane().setBackground(Color.white);
     setLayout(null);
    
     
     JLabel heading=new JLabel("ADD DRIVER");
     heading.setFont(new Font("tohama",Font.BOLD,18));
     heading.setBounds(150,20,200,20);
     add(heading);
      

   JLabel lblname=new JLabel("Name");
     lblname.setFont(new Font("tohama",Font.PLAIN,16));
    lblname.setBounds(60,80,120,30);
     add(lblname);
      
     tfname=new JTextField();
     tfname.setBounds(200,80,150,30);
     add(tfname);
     
     
     JLabel lblage=new JLabel("Age");
     lblage.setFont(new Font("tohama",Font.PLAIN,16));
    lblage.setBounds(60,130,120,30);
     add(lblage);
     
     tfage=new JTextField();
     tfage.setBounds(200,130,150,30);
     add(tfage);
     
    JLabel lblgender=new JLabel("Gender");
     lblgender.setFont(new Font("tohama",Font.PLAIN,16));
    lblgender.setBounds(60,180,120,30);
     add(lblgender);
     String cleanoptions[]={"Male","Female"};
     
     agecombobox=new JComboBox(cleanoptions);
     agecombobox.setBackground(Color.white);
     agecombobox.setBounds(200,180,150,30);
     add(agecombobox);
     
     
     JLabel lblcare=new JLabel("Car Company");
     lblcare.setFont(new Font("tohama",Font.PLAIN,16));
    lblcare.setBounds(60,230,120,30);
     add(lblcare);
      
    tfcarcompany=new JTextField();
     tfcarcompany.setBounds(200,230,150,30);
     add(tfcarcompany);
     
     JLabel lbltype=new JLabel("Car Model");
     lbltype.setFont(new Font("tohama",Font.PLAIN,16));
    lbltype.setBounds(60,280,120,30);
     add(lbltype);
     tfmodel=new JTextField();
     tfmodel.setBounds(200,280,150,30);
     add(tfmodel);
     
     
      JLabel lblavailable=new JLabel("Availablity");
     lblavailable.setFont(new Font("tohama",Font.PLAIN,16));
    lblavailable.setBounds(60,330,120,30);
     add(lblavailable);
    String availableoptions[]={"Available","Busy"};
     
     availablecombobox=new JComboBox(availableoptions);
     availablecombobox.setBackground(Color.white);
    availablecombobox.setBounds(200,330,150,30);
     add(availablecombobox);
     
      JLabel lblLocation=new JLabel("Location");
     lblLocation.setFont(new Font("tohama",Font.PLAIN,16));
    lblLocation.setBounds(60,380,120,30);
     add(lblLocation);
     tflocation=new JTextField();
     tflocation.setBounds(200,380,150,30);
     add(tflocation);
     
    adddriver=new JButton("Add Driver");
     adddriver.setBounds(70,430,130,30);
     adddriver.setForeground(Color.white);
     adddriver.setBackground(Color.black);
     adddriver.setFont(new Font("serif",Font.BOLD,18));
     adddriver.addActionListener(this);
     add(adddriver);
     
      cancel=new JButton("Cancel");
     cancel.setBounds(240,430,120,30);
     cancel.setForeground(Color.white);
     cancel.setBackground(Color.black);
     cancel.setFont(new Font("serif",Font.BOLD,18));
     cancel.addActionListener(this);

     add(cancel);
     
     
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
    Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
   JLabel image =new JLabel(i3);
    image.setBounds(400,30,500,500);
    add(image);
    
     setVisible(true);
     
     
      }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String  Name=tfname.getText();
        String  Age=tfage.getText();
        String availablity=(String)availablecombobox.getSelectedItem();
        String  Company=tfcarcompany.getText();
        String  Model=tfmodel.getText();
        String Gender=(String)agecombobox.getSelectedItem();
        String Location=tflocation.getText();
         if (Name.equals("") || Age.equals("") || Company.equals("") || Model.equals("") || Location.equals("")) {
            JOptionPane.showMessageDialog(this, "All fields are required");
            return;
        }
      
         
        if(ae.getSource()==adddriver){
            
            try
            {
                Conn c=new Conn();
            
             String query="insert into driver values( '"+Name+"','"+Age+"','"+Gender+"','"+Company+"','"+Model+"','"+availablity+"','"+Location+"')";
             c.s.executeUpdate(query); 
             JOptionPane.showMessageDialog(null, "new Driver Added Successfully");
             setVisible(false);
            }
            catch(Exception e){
                
               e.printStackTrace();    
                
            }
        }
        else{
            setVisible(false);
        }
        
    }
     
     
   
    
    public static void main(String[]args){
        AddDriver r=new AddDriver();
        
    }

}