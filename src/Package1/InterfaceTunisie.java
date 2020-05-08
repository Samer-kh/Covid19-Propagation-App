package Package1;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import chedly.Gestion_Donnée;





public class InterfaceTunisie extends JFrame {
	public static void main(String[] args) 
	{
		
		try {
		InterfaceTunisie tn=new InterfaceTunisie("maps\\tunisie.png",false,0,0,0);
		
		
		tn.setExtendedState(tn.MAXIMIZED_BOTH);
		tn.setVisible(true);
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
	// constructeur de l'interface tunisie contenant les infos générales (acceuil )
	
	
	public InterfaceTunisie(String MyImage,boolean ok,int cas,int gueris,int deces) throws Exception
	{
	//Creation des boutons represantant les gouvernerats
		// les boutons qui vont occuper la partie gauche de l'ecran
				JButton Button = new JButton("juste pour marquer");
				
				JButton Button1=new JButton("Ariana");
				JButton Button2=new JButton("Bizerte");
				JButton Button3=new JButton("Ben Arous");
				JButton Button4=new JButton("Beja");
				JButton Button5=new JButton("Gabés");
				JButton Button6=new JButton("Gafsa");
				JButton Button7=new JButton("Jendouba");
				JButton Button8=new JButton("Kassrine");
				JButton Button9=new JButton("Kairouan");
				JButton Button10=new JButton("Kébili");
				JButton Button11=new JButton("Kef");
				JButton Button12=new JButton("Mehdia");
				JButton Button13=new JButton("Manouba");
				JButton Button14=new JButton("Mednine");
				JButton Button15=new JButton("Monastir");
				JButton Button16=new JButton("Nabeul");
				JButton Button17=new JButton("Sfax");
				JButton Button18=new JButton("Sidi Bou Zid");
				JButton Button19=new JButton("Siliana");
				JButton Button20=new JButton("Sousse");
				JButton Button21=new JButton("Tunis");
				JButton Button22=new JButton("Tataouin");
				JButton Button23=new JButton("Tozeur");
				JButton Button24=new JButton("Zaghouan");
				
	//creation des parties du page
	// préparation de la subdivision de la page 
				
				
				setSize(400,400);
				JPanel Panel1=new JPanel();
				JPanel Panel2=new JPanel();
				JPanel Panel3=new JPanel();
				JPanel Panel4=new JPanel();
				JPanel Panel5=new JPanel();
				JPanel Panel6=new JPanel();
				JPanel Panel7=new JPanel();
	
	
	
	//splitting the page
	// affectation des Panels a des parties du page
	
				JTextArea area=new JTextArea();
				Panel2.add(area);
				Panel2.setLayout(new FlowLayout());
				JScrollPane ScrollD=new JScrollPane(Panel1);
				JScrollPane Scrolldata=new JScrollPane(Panel3);
				JSplitPane sl3=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,Panel2,Panel4);
				JSplitPane sl2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sl3,Scrolldata);
				
				JSplitPane sl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ScrollD , sl2);
	
	
	//remplissage du Panel 4
	//ce remplisage est celui de l'acceuil			
				
				
				Panel4.setLayout(new FlowLayout());
				JLabel Titre = new JLabel("<html><font size='6' color=blue>Titre du Description<br><br></html>");
				JLabel Description= new JLabel("<html><strong>Lorem ipsum dolor sit amet, consectetur adipiscing elit,<br> sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea <br> commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit <br> esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, <br> sunt in culpa qui officia deserunt mollit anim id est laborum<br><br></strong></html>\r\n");
				//JLabel Description_Cal =new JLabel("<html><font size='6' color=blue>Titre du date<br><br><br><br></html>");
				Description.setHorizontalAlignment(JLabel.CENTER);
				Titre.setFont(new Font("ComicSansMs",Font.BOLD,25));
				Description.setFont(new Font("ComicSansMs",Font.PLAIN,16));
				/*Properties p = new Properties();
				p.put("text.today", "Today");
				p.put("text.month", "Month");
				p.put("text.year", "Year");
				UtilDateModel model = new UtilDateModel();
				JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
				JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
				 JLabel LabelDes=new JLabel("<html><b>Choisir la date afin de visualiser ses informations : <br></b></html>");
				 LabelDes.setFont(new Font("ComicSansMs",Font.PLAIN,16));
				 JButton BoutonSubmit=new JButton("Submit");
				 BoutonSubmit.addActionListener(ae -> 
				 {	Date selectedDate = (Date) datePicker.getModel().getValue();
				    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				    String reportDate = df.format(selectedDate);
				    LocalDate ldate=LocalDate.parse(reportDate);
					try {
					 int tableau[]=Gestion_Donnée.lecturetunisie (ldate);
					 int nbCas=tableau[0];
					 int nbG=tableau[1];
					 int nbD=tableau[2];
					 this.dispose();
					 InterfaceTunisie tn=new InterfaceTunisie("maps\\tunisie.png",false,nbCas,nbG,nbD);
					 tn.setVisible(true);
					 tn.setExtendedState(tn.MAXIMIZED_BOTH);
						}
					catch ( Exception e)
					{e.printStackTrace();}
					
						 
						 
				 });*/
				selectd Calendrier = new selectd(this);
				Panel4.add(Titre);
				Panel4.add(Description);
				//Panel4.add(Description_Cal);
				//Panel4.add(LabelDes);
				Panel4.add(Calendrier);
				//Panel4.add(datePicker);
				//Panel4.add(BoutonSubmit);
	
	// mettre les ratios se chaque panel 
		//mise en forme de l'interface général
	
				Scrolldata.setMaximumSize(new Dimension(0,40));
				sl3.setResizeWeight(0.46);
				sl2.setResizeWeight(0.95);
				sl.setResizeWeight(0.2);
				//ScrollD.setPreferredSize(new Dimension(200,0));
				//ScrollD.setMaximumSize(new Dimension(200,0));
				add(sl);
				show();
				
				//ajout des boutons au panel 
	
				GridLayout gl= new GridLayout(24,1);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Panel1.setLayout(gl);
				Panel1.add(Button1);
				Panel1.add(Button2);
				Panel1.add(Button3);
				Panel1.add(Button4);
				Panel1.add(Button5);
				Panel1.add(Button6);
				Panel1.add(Button7);
				Panel1.add(Button8);
				Panel1.add(Button9);
				Panel1.add(Button10);
				Panel1.add(Button11);
				Panel1.add(Button12);
				Panel1.add(Button13);
				Panel1.add(Button14);
				Panel1.add(Button15);
				Panel1.add(Button16);
				Panel1.add(Button17);
				Panel1.add(Button18);
				Panel1.add(Button19);
				Panel1.add(Button20);
				Panel1.add(Button21);
				Panel1.add(Button22);
				Panel1.add(Button23);
				Panel1.add(Button24);
				
	
	//ajout des labels contenant le nbr totals des cas 
	//lecture des GestionDonnées 
	//mise en forme des Labels 
	
				GridLayout gl2=new GridLayout(1,4);
				if (ok==false)
						{
					
				int TableauDonnées[]=Gestion_Donnée.lecturetunisie ();
					
				int CaseCas=TableauDonnées[0];
				int CaseGueris=TableauDonnées[1];
				int CaseDéces=TableauDonnées[2];
					
					
				JLabel nbcas = new JLabel("le nombre des cas est :" + CaseCas);
				JLabel nbdeces = new JLabel("le nombre des déces est :" + CaseGueris);
				JLabel nbgueris = new JLabel("le nombre des guéris est :" + CaseDéces);
					
				nbcas.setFont(new java.awt.Font("Dialog", 1, 18));
				nbgueris.setFont(new java.awt.Font("Dialog", 1, 18));
				nbdeces.setFont(new java.awt.Font("Dialog", 1, 18));
				
				Font font = new Font("Serif", Font.ITALIC, 24);
				nbcas.setFont(font);
				nbgueris.setFont(font);
				nbdeces.setFont(font);
				nbcas.setForeground(Color.blue);
				nbgueris.setForeground(Color.green);
				nbdeces.setForeground(Color.red);
				Panel3.setLayout(gl2);
				Panel3.add(nbcas,BorderLayout.CENTER);
				Panel3.add(nbdeces);
				Panel3.add(nbgueris);}
						
				else
				{
					JLabel nbcas = new JLabel("le nombre des cas est :" + cas);
					JLabel nbdeces = new JLabel("le nombre des déces est :" + gueris);
					JLabel nbgueris = new JLabel("le nombre des guéris est :" + deces);
					nbcas.setFont(new java.awt.Font("Dialog", 1, 18));
					nbgueris.setFont(new java.awt.Font("Dialog", 1, 18));
					nbdeces.setFont(new java.awt.Font("Dialog", 1, 18));
					
					Font font = new Font("Serif", Font.ITALIC, 24);
					nbcas.setFont(font);
					nbgueris.setFont(font);
					nbdeces.setFont(font);
					nbcas.setForeground(Color.blue);
					nbgueris.setForeground(Color.green);
					nbdeces.setForeground(Color.red);
					Panel3.setLayout(gl2);
					Panel3.add(nbcas,BorderLayout.CENTER);
					Panel3.add(nbdeces);
					Panel3.add(nbgueris);
				}
				
				
	
	
	//importation des cartes
	
					BufferedImage myPicture=null;
					
					try {
					    myPicture = ImageIO.read(new File(MyImage));
					} catch (IOException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					
					ImageIcon image = new ImageIcon(myPicture);
					JLabel imageLabel= new JLabel(image);
					//imageLabel.setPreferredSize(new Dimension(600,600));
					
					JScrollPane ImageScroll=new JScrollPane(imageLabel);
					
					Panel2.add(ImageScroll);
	
	Button1.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\ariana.png",true,"Ariana",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button2.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\bizerte.png",true,"Bizerte",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button3.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\ben arous.png",true,"BenArous",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button4.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\beja.png",true,"Beja",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button5.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\gabes.png",true,"Gabes",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button6.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\gafsa.png",true,"Gafsa",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button7.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\jendouba.png",true,"Jendouba",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button8.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kassrine.png",true,"Kasserine",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	});
	Button9.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kairouan.png",true,"Kairouan",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button10.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kebili.png",true,"Kebili",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button11.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kef.png",true,"Kef",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button12.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mahdia.png",true,"Mahdia",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button13.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\manouba.png",true,"Manouba",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button14.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mednine.png",true,"Medenine",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button15.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mounastir.png",true,"Monastir",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button16.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\nabel.png",true,"Nabeul",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button17.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sfax.png",true,"Sfax",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button18.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sidi bou zid.png",true,"SidiBouZid",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button19.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\siliana.png",true,"Siliana",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button20.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sousse.png",true,"Sousse",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button21.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tunis.png",true,"Tunis",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button22.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tataouine.png",true,"Tataouine",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button23.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tozeur.png",true,"Tozeur",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	
		
	
	Button24.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\zaghouan.png",true,"Zaghouan",null);
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	}
	
	
	//creation du Panel Gouvernerat qui sera remplit dans l'interface contenant les infos
	//sur les gouvernerats
	
public void creer_gouv(JPanel Panel,String nom,LocalDate date) 
		{	try {
			GridLayout GP=new GridLayout(5,1);
			if (date==null)
			{
			int tableauD[]=Gestion_Donnée.lecturedonnées(nom);
			int nbCasG=tableauD[0];
			int nbGuerisG=tableauD[0];
			int nbDecesG=tableauD[2];
			
			
			JLabel Titre = new JLabel("<html><b>Gouvernerat :"+ nom +"</b><br><br></html>");
			Titre.setHorizontalAlignment(JLabel.CENTER);
			Titre.setFont(new Font("ComicSansMs",Font.BOLD,30));	
			//Panel.setBackground(new Color(140,200,226));
			String[] col_name= {"nombre total de cas confirmés","nombre total de cas guéris","nombre total des décès"};
			Object[][] row= { {"<html><font size='6' color=blue > Cas confirmés</html>","<html><font size='6' color=green> Cas guéris </html>","<html><font size='6' color=red> Décés </html>"},{nbCasG,nbGuerisG,nbDecesG}};
			JTable tab=new JTable(row,col_name);
			JScrollPane scrollpane = new JScrollPane(tab);
			Titre.setForeground(new Color(20,148,20));
			//tab.setPreferredSize(new Dimension(0,250));
			//tab.setBackground(new Color(140,200,226));
			//col_name.setBackground(new Color(140,200,226));
			tab.setMaximumSize(new Dimension(0,50));
			tab.setRowHeight(55);
			//tab.getColumn(0).setWidth(100);
			tab.setBackground(new Color(224,224,224));
			tab.setFont(new Font("ComicSansMs",Font.BOLD,26));
			//tab.setBorder(BorderFactory.createLineBorder(Color.red)); 
			selectd Calendrier = new selectd(nom,"maps//"+nom+".png",this);
			
			JScrollPane Scroll_Calender=new JScrollPane(Calendrier);
			JLabel Ligne = new JLabel("<html><b>Choissir une date si vous voulez connaitre le nombre des cas :</b> </html> ");
			Ligne.setFont(new Font("ComicSansMs",Font.BOLD,22));
			Ligne.setForeground(Color.blue);
			Ligne.setBackground(new Color(140,200,226));
			tab.setLayout(new FlowLayout());
			Panel.setLayout(GP);
			Panel.add(Titre);
			Panel.add(scrollpane);
			Panel.add(Ligne);
			Panel.add(Calendrier);
			}
			else 
			{
				int tableauD[]=Gestion_Donnée.lecturedonnées(nom,date);
				int nbCasG=tableauD[0];
				int nbGuerisG=tableauD[1];
				int nbDecesG=tableauD[2];
				
				
				JLabel Titre = new JLabel("<html><b>Gouvernerat :"+ nom +"</b><br><br></html>");
				Titre.setHorizontalAlignment(JLabel.CENTER);
				Titre.setFont(new Font("ComicSansMs",Font.BOLD,30));	
				//Panel.setBackground(new Color(140,200,226));
				String[] col_name= {"nombre total de cas confirmés","nombre total de cas guéris","nombre total des décès"};
				Object[][] row= { {"<html><font size='6' color=blue > Cas confirmés</html>","<html><font size='6' color=green> Cas guéris </html>","<html><font size='6' color=red> Décés </html>"},{nbCasG,nbGuerisG,nbDecesG}};
				JTable tab=new JTable(row,col_name);
				JScrollPane scrollpane = new JScrollPane(tab);
				Titre.setForeground(new Color(20,148,20));
				//tab.setPreferredSize(new Dimension(0,250));
				//tab.setBackground(new Color(140,200,226));
				//col_name.setBackground(new Color(140,200,226));
				tab.setMaximumSize(new Dimension(0,50));
				tab.setRowHeight(55);
				//tab.getColumn(0).setWidth(100);
				tab.setBackground(new Color(224,224,224));
				tab.setFont(new Font("ComicSansMs",Font.BOLD,26));
				//tab.setBorder(BorderFactory.createLineBorder(Color.red));
				selectd Calendrier = new selectd(nom,"maps//"+nom+".png",this);
				
				JScrollPane Scroll_Calender=new JScrollPane(Calendrier);
				JLabel Ligne = new JLabel("<html><b>Choissir une date si vous voulez connaitre le nombre des cas :</b> </html> ");
				Ligne.setFont(new Font("ComicSansMs",Font.BOLD,22));
				Ligne.setForeground(Color.blue);
				Ligne.setBackground(new Color(140,200,226));
				tab.setLayout(new FlowLayout());
				Panel.setLayout(GP);
				Panel.add(Titre);
				Panel.add(scrollpane);
				Panel.add(Ligne);
				Panel.add(Calendrier);
			}
		
		}
		catch(Exception e)
		{e.printStackTrace();}
	
}



// constructeur de l'interface tunisie qui contient les information des gouvernerats

public InterfaceTunisie(String MyImage, boolean ok,String nom_gouvernerat ,LocalDate date) {
//Creation des boutons represantant les gouvernerats
	// les boutons qui vont occuper la partie gauche de l'ecran
		
			JButton Button = new JButton("juste pour marquer");
			
			JButton Button1=new JButton("Ariana");
			JButton Button2=new JButton("Bizerte");
			JButton Button3=new JButton("Ben Arous");
			JButton Button4=new JButton("Beja");
			JButton Button5=new JButton("Gabés");
			JButton Button6=new JButton("Gafsa");
			JButton Button7=new JButton("Jendouba");
			JButton Button8=new JButton("Kassrine");
			JButton Button9=new JButton("Kairouan");
			JButton Button10=new JButton("Kébili");
			JButton Button11=new JButton("Kef");
			JButton Button12=new JButton("Mehdia");
			JButton Button13=new JButton("Manouba");
			JButton Button14=new JButton("Mednine");
			JButton Button15=new JButton("Monastir");
			JButton Button16=new JButton("Nabeul");
			JButton Button17=new JButton("Sfax");
			JButton Button18=new JButton("Sidi Bou Zid");
			JButton Button19=new JButton("Siliana");
			JButton Button20=new JButton("Sousse");
			JButton Button21=new JButton("Tunis");
			JButton Button22=new JButton("Tataouin");
			JButton Button23=new JButton("Tozeur");
			JButton Button24=new JButton("Zaghouan");
			
//creation des parties du page
// préparation de la subdivision de la page 
			
			
			setSize(400,400);
			JPanel Panel1=new JPanel();
			JPanel Panel2=new JPanel();
			JPanel Panel3=new JPanel();
			JPanel Panel4=new JPanel();
			JPanel Panel5=new JPanel();
			JPanel Panel6=new JPanel();
			JPanel Panel7=new JPanel();



//splitting the page
// affectation des Panels a des parties du page

			JTextArea area=new JTextArea();
			Panel2.add(area);
			Panel2.setLayout(new FlowLayout());
			JScrollPane ScrollD=new JScrollPane(Panel1);
			JScrollPane Scrolldata=new JScrollPane(Panel3);
			JSplitPane sl3=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,Panel2,Panel4);
			JSplitPane sl2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sl3,Scrolldata);
			
			JSplitPane sl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ScrollD , sl2);


		
		
// mettre les ratios se chaque panel 
	//mise en forme de l'interface général

			Scrolldata.setMaximumSize(new Dimension(0,40));
			sl3.setResizeWeight(0.46);
			sl2.setResizeWeight(0.95);
			sl.setResizeWeight(0.2);
			//ScrollD.setPreferredSize(new Dimension(200,0));
			//ScrollD.setMaximumSize(new Dimension(200,0));
			add(sl);
			show();
			
			//ajout des boutons au panel 

			GridLayout gl= new GridLayout(24,1);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Panel1.setLayout(gl);
			Panel1.add(Button1);
			Panel1.add(Button2);
			Panel1.add(Button3);
			Panel1.add(Button4);
			Panel1.add(Button5);
			Panel1.add(Button6);
			Panel1.add(Button7);
			Panel1.add(Button8);
			Panel1.add(Button9);
			Panel1.add(Button10);
			Panel1.add(Button11);
			Panel1.add(Button12);
			Panel1.add(Button13);
			Panel1.add(Button14);
			Panel1.add(Button15);
			Panel1.add(Button16);
			Panel1.add(Button17);
			Panel1.add(Button18);
			Panel1.add(Button19);
			Panel1.add(Button20);
			Panel1.add(Button21);
			Panel1.add(Button22);
			Panel1.add(Button23);
			Panel1.add(Button24);
			
//creation des labels donnant les informations et leur mise en page

// chaque label suivant le gouvernerat




if (nom_gouvernerat=="Ariana")
	
{
	creer_gouv(Panel4,"Ariana",date)	;
}

if (nom_gouvernerat=="Bizerte")
	
{
	creer_gouv(Panel4,"Bizerte",date)	;
}

if (nom_gouvernerat=="Beja")
	
{
	creer_gouv(Panel4,"Beja",date)	;
}


if (nom_gouvernerat=="BenArous")
	
{
	creer_gouv(Panel4,"BenArous",date)	;	
}

if (nom_gouvernerat=="Gabes")
	
{
	creer_gouv(Panel4,"Gabes",date)	;

}


if (nom_gouvernerat=="Gafsa")
	
{
	creer_gouv(Panel4,"Gafsa",date)	;
}


if (nom_gouvernerat=="Jendouba")
{	

	creer_gouv(Panel4,"Jendouba",date)	;
}

if (nom_gouvernerat=="Kairouan")
	
{
	creer_gouv(Panel4,"Kairouan",date)	;		
}

if (nom_gouvernerat=="kasserine")
	
{
	creer_gouv(Panel4,"Kasserine",date)	;
}


if (nom_gouvernerat=="kebili")
	
{
	creer_gouv(Panel4,"Kebili",date)	;
}

if (nom_gouvernerat=="kef")
	
{
	creer_gouv(Panel4,"Kef",date)	;
}

if (nom_gouvernerat=="Mahdia")
	
{
	creer_gouv(Panel4,"Mahdia",date)	;
}

if (nom_gouvernerat=="Manouba")
	
{
	creer_gouv(Panel4,"Manouba",date)	;
}

if (nom_gouvernerat=="Medenine")
	
{
	creer_gouv(Panel4,"Medenine",date)	;
}

if (nom_gouvernerat=="Monastir")
	
{
	creer_gouv(Panel4,"Monastir",date)	;
}

if (nom_gouvernerat=="Nabeul")
	
{
	creer_gouv(Panel4,"Nabeul",date)	;
}

if (nom_gouvernerat=="Sfax")
	
{
	creer_gouv(Panel4,"Sfax",date)	;
}

if (nom_gouvernerat=="SidiBouZid")
	
{
	creer_gouv(Panel4,"SidiBouZid",date)	;
}

if (nom_gouvernerat=="Siliana")
	
{
	creer_gouv(Panel4,"Siliana",date)	;
}

if (nom_gouvernerat=="Sousse")
	
{
	creer_gouv(Panel4,"Sousse",date)	;
}

if (nom_gouvernerat=="Tataouin")
	
{
	creer_gouv(Panel4,"Tataouin",date)	;
}

if (nom_gouvernerat=="Tozeur")
	
{
	creer_gouv(Panel4,"Tozeur",date)	;
}

if (nom_gouvernerat=="Tunis")
	
{
	creer_gouv(Panel4,"Tunis",date)	;
}

if (nom_gouvernerat=="Zaghouan")
	
{
	creer_gouv(Panel4,"Zaghouan",date)	;
}




//ajout des labels contenant le nbr totals des cas 
//lecture des GestionDonnées 
//mise en forme des Labels 
	try {
			GridLayout gl2=new GridLayout(1,4);
			int TableauDonnées[]=Gestion_Donnée.lecturetunisie ();
			int CaseCas=TableauDonnées[0];
			int CaseGueris=TableauDonnées[1];
			int CaseDéces=TableauDonnées[2];
			
			JLabel nbcas = new JLabel("le nombre des cas est :" + CaseCas);
			JLabel nbdeces = new JLabel("le nombre des déces est :" + CaseGueris);
			JLabel nbgueris = new JLabel("le nombre des guéris est :" + CaseDéces);
			nbcas.setFont(new java.awt.Font("Dialog", 1, 18));
			nbgueris.setFont(new java.awt.Font("Dialog", 1, 18));
			nbdeces.setFont(new java.awt.Font("Dialog", 1, 18));
			
			Font font = new Font("Serif", Font.ITALIC, 24);
			nbcas.setFont(font);
			nbgueris.setFont(font);
			nbdeces.setFont(font);
			nbcas.setForeground(Color.blue);
			nbgueris.setForeground(Color.green);
			nbdeces.setForeground(Color.red);
			Panel3.setLayout(gl2);
			Panel3.add(nbcas,BorderLayout.CENTER);
			Panel3.add(nbdeces);
			Panel3.add(nbgueris);
	}
	catch(Exception e)
	{}


//ajout d'un bouton qui permet le retour a l'acceuil



				BorderLayout FL = new BorderLayout();
			JPanel PanelInter=new JPanel();
			JButton acceuil=new JButton("retour à l'acceuil");
			//acceuil.setPreferredSize(new Dimension(10,10));
			PanelInter.setLayout(new BorderLayout());
			//acceuil.setPreferredSize(new Dimension(50,50));
			//acceuil.setMaximumSize(new Dimension(50,50));
			acceuil.setSize(120, 100);
			Panel2.setLayout(FL);
			PanelInter.add(acceuil);
			Panel2.add(PanelInter,BorderLayout.SOUTH);
			
			acceuil.addActionListener(ae -> 
			{	try {
				this.dispose();
			    InterfaceTunisie Tn=new InterfaceTunisie("maps\\Tunisie.png",false,0,0,0);
				Tn.setVisible(true);
				Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
			}
			catch(Exception e)
			{}
			});




//importation des cartes

BufferedImage myPicture=null;

try {
    myPicture = ImageIO.read(new File(MyImage));
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

ImageIcon image = new ImageIcon(myPicture);
JLabel imageLabel= new JLabel(image);
//imageLabel.setPreferredSize(new Dimension(600,600));

JScrollPane ImageScroll=new JScrollPane(imageLabel);

Panel2.add(ImageScroll);

Button1.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\ariana.png",true,"Ariana",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button2.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\bizerte.png",true,"Bizerte",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button3.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\benarous.png",true,"BenArous",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button4.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\beja.png",true,"Beja",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button5.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\gabes.png",true,"Gabes",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button6.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\gafsa.png",true,"Gafsa",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button7.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\jendouba.png",true,"Jendouba",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button8.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kasserine.png",true,"Kasserine",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
});
Button9.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kairouan.png",true,"Kairouan",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button10.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kebili.png",true,"Kebili",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button11.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kef.png",true,"Kef",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button12.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mahdia.png",true,"Mahdia",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button13.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\manouba.png",true,"Manouba",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button14.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\medenine.png",true,"Medenine",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button15.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\monastir.png",true,"Monastir",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button16.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\nabeul.png",true,"Nabeul",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button17.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sfax.png",true,"Sfax",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button18.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sidibouzid.png",true,"SidiBouZid",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button19.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\siliana.png",true,"Siliana",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button20.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sousse.png",true,"Sousse",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button21.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tunis.png",true,"Tunis",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button22.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tataouine.png",true,"Tataouin",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});

Button23.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tozeur.png",true,"Tozeur",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});


	

Button24.addActionListener(ae -> 
{	this.dispose();
    InterfaceTunisie Tn=new InterfaceTunisie("maps\\zaghouan.png",true,"Zaghouan",null);
	Tn.setVisible(true);
	Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	
});


}


}

	
 class selectd extends JPanel implements ActionListener{
	
	public JComboBox<String> mars;//liste de selection des mois 
	public JComboBox<Integer> jours;//liste de selection des jours 
	public JComboBox<Integer> annee;//liste de selection des années 
	public JButton afficher ;
	public String m; //le mois sélèctioné par l'utilisateur
	public int j;//le jour sélèctionné par l'utilisateur
	public int a;// l'année sélèctionné par l'utilisateur
	
	public selectd(String Gouv,String Map,JFrame Frame)
	{
		super();
		 
		Object[] elt2 = new Object[] {"01","02","03","04","05","06","07","08" , "09", "10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","29","30","31"};
		 jours= new JComboBox(elt2);
		jours.setBounds(300, 20, 70, 35);
		this.add(jours);
		Object[] elt1= new Object[] {"03","04","05","06"};
		 mars=new JComboBox(elt1);
		mars.setBounds(300, 20, 70, 35);
		this.add(mars);
		Object[] elt3  =new Object[] {"2020","2021"};
		 annee= new JComboBox(elt3);
		annee.setBounds(300, 20, 70, 35);
		this.add(annee);
		afficher=new JButton("afficher");
		afficher.setBounds(400, 20, 70, 35);
		afficher.addActionListener(ae->
		{	
			String ans=annee.getSelectedItem().toString();
			
			String mois=mars.getSelectedItem().toString();
			String jour=jours.getSelectedItem().toString();
			
			String TabInter[]= {ans,mois,jour};
			String resultat=String.join("-",TabInter);
			LocalDate Date=null;
			Date=LocalDate.parse(resultat);
			Frame.dispose();
			InterfaceTunisie tn=new InterfaceTunisie(Map,true,Gouv,Date);
			tn.setExtendedState(tn.MAXIMIZED_BOTH);
			tn.setVisible(true);
			
			

			
			
				
		});
		
		this.add(afficher);}
		
	
	public selectd(JFrame Frame)
	{
		super();
		 
		Object[] elt2 = new Object[] {"01","02","03","04","05","06","07", "08" , "09", "10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","29","30","31"};
		 jours= new JComboBox(elt2);
		jours.setBounds(300, 20, 70, 35);
		this.add(jours);
		Object[] elt1= new Object[] {"03","04","05","06"};
		 mars=new JComboBox(elt1);
		mars.setBounds(300, 20, 70, 35);
		this.add(mars);
		Object[] elt3  =new Object[] {"2020","2021"};
		 annee= new JComboBox(elt3);
		annee.setBounds(300, 20, 70, 35);
		this.add(annee);
		afficher=new JButton("afficher");
		afficher.setBounds(400, 20, 70, 35);
		
		afficher.addActionListener(ae->
		{
			String ans=annee.getSelectedItem().toString();
			String mois=mars.getSelectedItem().toString();
			String jour=jours.getSelectedItem().toString();
			int jourInt=Integer.parseInt(jour);
			if ((0<=jourInt)&&(jourInt<=9))
			{
				jour="0" + jour;
				
			}
			String TabInter[]= {ans,mois,jour};
			String resultat=String.join("-",TabInter);
			LocalDate Date=LocalDate.parse(resultat);
			try {
			int tabDon[]=Gestion_Donnée.lecturetunisie (Date);
			int NbCas=tabDon[0];
			int NbGueris=tabDon[1]; 
			int NbDeces=tabDon[2];
			
			Frame.dispose();
			InterfaceTunisie tn=new InterfaceTunisie("maps\\tunisie.png",true,NbCas,NbGueris,NbDeces);
			tn.setExtendedState(tn.MAXIMIZED_BOTH);
			tn.setVisible(true);
			}
			catch(Exception e)
			{}
			

			
			
				
		});
		
		this.add(afficher);
		
	}
	}
