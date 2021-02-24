import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Login {

JPanel panel;
JFrame jf;
JLabel label1,label2;
JButton login;
JTextField textfield1,textfield2,textfield3;
JPasswordField passwordfield;

public Login() {
initComponents();
handlingEvents();
}

public void initComponents() {
jf=new javax.swing.JFrame();
jf.setTitle("Login");
jf.setLayout(null);
jf.setSize(800,500);
jf.show();
jf.setVisible(true);

JScrollPane scrollBar=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
jf.add(scrollBar);

label1=new javax.swing.JLabel("User Login");
label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
label1.setBounds(400,20,500,40);
jf.add(label1);

label1=new javax.swing.JLabel("Username");
label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
label1.setBounds(200,80,150,40);
jf.add(label1);

textfield1=new javax.swing.JTextField();
textfield1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
textfield1.setBounds(400,80,150,30);
jf.add(textfield1);

label1=new javax.swing.JLabel("Password");
label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
label1.setBounds(200,200,100,40);
jf.add(label1);

passwordfield=new javax.swing.JPasswordField();
passwordfield.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
passwordfield.setBounds(400,200,150,30);
jf.add(passwordfield);

login=new javax.swing.JButton("Login");
login.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
login.setBounds(250,280,100,30);
jf.add(login);

}

public void handlingEvents() {
login.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent event) {
String un = textfield1.getText();
String ui = passwordfield.getText();
boolean valid = false;
String username="";
String uid="";
try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection c = DriverManager.getConnection("jdbc:odbc:user","","");
Statement st = c.createStatement();
st.execute("SELECT Name,Password FROM user_details WHERE Name='"+un+"' AND Password='"+ui+"'");
ResultSet rs = st.getResultSet();
while(rs.next())
{
if(rs != null) {
valid = true;
username = rs.getString(1);
uid = rs.getString(2);
}
else
valid = false;
}
if(valid == true)
{
JOptionPane.showMessageDialog(null,"Authenticated User");
textfield1.setText("");
passwordfield.setText("");
}
else {
JOptionPane.showMessageDialog(null,"Not Authenticated User");
}
c.close();
st.close();

}
catch (Exception e) {
System.out.println(e);
}

}
});

}

public static void main(String args[]) {
Login log = new Login();
}
}
