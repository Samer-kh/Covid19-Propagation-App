package Principale;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class LogIn extends JFrame implements ActionListener {
	String administrateur="admin";
	String adminPassword="administrateur";
	JButton SeConnecter;
	JTextField nomAdmin;
	JPasswordField motDePasse;
	
	public LogIn() 
	{    nomAdmin=new JTextField();
    nomAdmin.setPreferredSize(new Dimension(200,20));
    motDePasse=new JPasswordField();
    motDePasse.setPreferredSize(new Dimension(200,20));
    SeConnecter=new JButton("Se connecter");
		this.setSize(400,200);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	    this.setResizable(true);  
	    this.setTitle("Se connecter"); 
	    JPanel panel=new JPanel();    
	    JLabel userName = new JLabel("Nom de l'administrateur :");
	    JLabel password = new JLabel("Mot De Passe :");
	   /* nomAdmin.setBounds(150,80,50,100);
	    userName.setBounds(20,80,50,50);
	    password.setBounds(20,100,50,50);
	    motDePasse.setBounds(150,100,50,50);
	    SeConnecter.setBounds(180,180,50,50);*/
	    panel.add(userName);
	    panel.add(nomAdmin);
	    panel.add(password);
	    panel.add(motDePasse);
	    panel.add(SeConnecter);
	    this.setLayout(null);   
	    SeConnecter.addActionListener(this); 
	    this.setContentPane(panel);
	}
	public void connexionValide() {Fenetre fen = new Fenetre();}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//if(nomAdmin.getSelectedText()!=" " &&  motDePasse.getSelectedText()!=" ")
		 if(!nomAdmin.getText().equals(administrateur))
		  { JOptionPane d = new JOptionPane();
		  d.showMessageDialog( new JFrame() , "nom administrateur invalide",
		        "Warning",JOptionPane.WARNING_MESSAGE);}
	      else
	    	  if(! motDePasse.getText().equals(adminPassword) )
	    	  { JOptionPane d = new JOptionPane();
			  d.showMessageDialog( new JFrame() , "Mot De Passe Invalide",
			        "Warning",JOptionPane.WARNING_MESSAGE);}
	    	  else 
	    		  connexionValide();
	}
}