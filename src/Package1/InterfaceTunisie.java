package Package1;




import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;





public class InterfaceTunisie extends JFrame {
	public static void main(String[] args)
	{
		InterfaceTunisie tn=new InterfaceTunisie("maps\\tunisie.png",true,"tunisie");
		
		
		tn.setExtendedState(tn.MAXIMIZED_BOTH);
		tn.setVisible(true);
		
	}
	
	
	public InterfaceTunisie(String MyImage,boolean ok, String nom_gouvernerat)
	{
	//Creation des boutons represantant les gouvernerats
	JButton Button = new JButton("juste pour marquer");
	
	JButton Button1=new JButton("Ariana");
	JButton Button2=new JButton("Bizerte");
	JButton Button3=new JButton("Ben Arous");
	JButton Button4=new JButton("Beja");
	JButton Button5=new JButton("Gab�s");
	JButton Button6=new JButton("Gafsa");
	JButton Button7=new JButton("Jendouba");
	JButton Button8=new JButton("Kassrine");
	JButton Button9=new JButton("Kairouan");
	JButton Button10=new JButton("K�bili");
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
	
	setSize(400,400);
	JPanel Panel1=new JPanel();
	JPanel Panel2=new JPanel();
	JPanel Panel3=new JPanel();
	JPanel Panel4=new JPanel();
	JPanel Panel5=new JPanel();
	JPanel Panel6=new JPanel();
	JPanel Panel7=new JPanel();
	
	
	
	//splitting the page
	
	
	JTextArea area=new JTextArea();
	Panel2.add(area);
	Panel2.setLayout(new FlowLayout());
	JScrollPane ScrollD=new JScrollPane(Panel1);
	JScrollPane Scrolldata=new JScrollPane(Panel3);
	JSplitPane sl3=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,Panel2,Panel4);
	JSplitPane sl2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sl3,Scrolldata);
	
	JSplitPane sl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ScrollD , sl2);
	
	
	//remplissage du Panel 4
	if (ok==true)
	{
	Panel4.setLayout(new FlowLayout());
	JLabel Titre = new JLabel("<html><font size='6' color=blue>Titre du Description<br><br></html>");
	JLabel Description= new JLabel("<html><strong>Lorem ipsum dolor sit amet, consectetur adipiscing elit,<br> sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea <br> commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit <br> esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, <br> sunt in culpa qui officia deserunt mollit anim id est laborum<br><br></strong></html>\r\n");
	//JLabel Description_Cal =new JLabel("<html><font size='6' color=blue>Titre du date<br><br><br><br></html>");
	Description.setHorizontalAlignment(JLabel.CENTER);
	Titre.setFont(new Font("ComicSansMs",Font.BOLD,25));
	Description.setFont(new Font("ComicSansMs",Font.PLAIN,16));
	
	selectd Calendrier = new selectd();
	Panel4.add(Titre);
	Panel4.add(Description);
	//Panel4.add(Description_Cal);
	Panel4.add(Calendrier);
	}
	
	// mettre les ratios se chaque panel 
	
	Scrolldata.setMaximumSize(new Dimension(0,40));
	sl3.setResizeWeight(0.46);
	sl2.setResizeWeight(0.95);
	sl.setResizeWeight(0.2);
	//ScrollD.setPreferredSize(new Dimension(200,0));
	//ScrollD.setMaximumSize(new Dimension(200,0));
	add(sl);
	
	
	show();
	
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
	
	

	
	if (nom_gouvernerat=="ariana")
		
	{
		creer_gouv(Panel4,"Ariana")	;
	}
	
	if (nom_gouvernerat=="bizerte")
		
	{
		creer_gouv(Panel4,"Bizerte")	;
	}

	if (nom_gouvernerat=="beja")
		
	{
		creer_gouv(Panel4,"Beja")	;
	}
	

	if (nom_gouvernerat=="benarous")
		
	{
		creer_gouv(Panel4,"Ben Arous")	;	
	}

	if (nom_gouvernerat=="gabes")
		
	{
		creer_gouv(Panel4,"Gabes")	;
	
	}
	

	if (nom_gouvernerat=="gafsa")
		
	{
		creer_gouv(Panel4,"Gafsa")	;
	}
	

	if (nom_gouvernerat=="jendouba")
	{	
	
		creer_gouv(Panel4,"Jendouba")	;
	}

	if (nom_gouvernerat=="kairouan")
		
	{
		creer_gouv(Panel4,"Kairouan")	;		
	}

	if (nom_gouvernerat=="kassrine")
		
	{
		creer_gouv(Panel4,"Kassrine")	;
	}
	

	if (nom_gouvernerat=="kbili")
		
	{
		creer_gouv(Panel4,"Kebili")	;
	}

	if (nom_gouvernerat=="kef")
		
	{
		creer_gouv(Panel4,"Kef")	;
	}

	if (nom_gouvernerat=="mahdia")
		
	{
		creer_gouv(Panel4,"Mahdia")	;
	}

	if (nom_gouvernerat=="manouba")
		
	{
		creer_gouv(Panel4,"Manouba")	;
	}

	if (nom_gouvernerat=="mednine")
		
	{
		creer_gouv(Panel4,"Mednine")	;
	}

	if (nom_gouvernerat=="mounastir")
		
	{
		creer_gouv(Panel4,"Mounastir")	;
	}

	if (nom_gouvernerat=="nabel")
		
	{
		creer_gouv(Panel4,"Nabel")	;
	}

	if (nom_gouvernerat=="sfax")
		
	{
		creer_gouv(Panel4,"Sfax")	;
	}

	if (nom_gouvernerat=="sidi bouzid")
		
	{
		creer_gouv(Panel4,"Sidi Bou Zid")	;
	}

	if (nom_gouvernerat=="siliana")
		
	{
		creer_gouv(Panel4,"Siliana")	;
	}

	if (nom_gouvernerat=="sousse")
		
	{
		creer_gouv(Panel4,"Sousse")	;
	}

	if (nom_gouvernerat=="tataouin")
		
	{
		creer_gouv(Panel4,"Tataouin")	;
	}

	if (nom_gouvernerat=="tozeur")
		
	{
		creer_gouv(Panel4,"Tozeur")	;
	}

	if (nom_gouvernerat=="tunis")
		
	{
		creer_gouv(Panel4,"Tunis")	;
	}

	if (nom_gouvernerat=="zaghouan")
		
	{
		creer_gouv(Panel4,"Zaghouan")	;
	}
	
	
	
	
	//ajout des labels contenant le nbr totals des cas 
				GridLayout gl2=new GridLayout(1,4);
				
				
				JLabel nbcas = new JLabel("le nombre des cas est : 1500 ");
				JLabel nbdeces = new JLabel("le nombre des d�ces est : 1500 ");
				JLabel nbgueris = new JLabel("le nombre des gu�ris est : 1500  ");
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
	
	
	
	//ajout d'un bouton qui permet le retour a l'acceuil
	
	
	if(ok==false)
	{
					BorderLayout FL = new BorderLayout();
				JPanel PanelInter=new JPanel();
				JButton acceuil=new JButton("retour � l'acceuil");
				//acceuil.setPreferredSize(new Dimension(10,10));
				PanelInter.setLayout(new BorderLayout());
				//acceuil.setPreferredSize(new Dimension(50,50));
				//acceuil.setMaximumSize(new Dimension(50,50));
				acceuil.setSize(120, 100);
				Panel2.setLayout(FL);
				PanelInter.add(acceuil);
				Panel2.add(PanelInter,BorderLayout.SOUTH);
				acceuil.addActionListener(ae -> 
				{	this.dispose();
				    InterfaceTunisie Tn=new InterfaceTunisie("maps\\Tunisie.png",true,"Tunisie");
					Tn.setVisible(true);
					Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
					
				});
	
	
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
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\ariana.png",false,"ariana");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button2.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\bizerte.png",false,"bizerte");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button3.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\ben arous.png",false,"benarous");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button4.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\beja.png",false,"beja");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button5.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\gabes.png",false,"gabes");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button6.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\gafsa.png",false,"gafsa");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button7.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\jendouba.png",false,"jendouba");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button8.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kassrine.png",false,"kassrine");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
	});
	Button9.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kairouan.png",false,"kairouan");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button10.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kebili.png",false,"kbili");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button11.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kef.png",false,"kef");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button12.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mahdia.png",false,"mahdia");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button13.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\manouba.png",false,"manouba");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button14.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mednine.png",false,"mednine");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button15.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mounastir.png",false,"mounastir");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button16.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\nabel.png",false,"nabel");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button17.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sfax.png",false,"sfax");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button18.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sidi bou zid.png",false,"sidibouzid");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button19.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\siliana.png",false,"siliana");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button20.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sousse.png",false,"sousse");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button21.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tunis.png",false,"tunis");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button22.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tataouine.png",false,"tataouin");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button23.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tozeur.png",false,"tozeur");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	
		
	
	Button24.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\siliana.png",false,"siliana");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	}
	
public void creer_gouv(JPanel Panel,String nom)
		{
			GridLayout GP=new GridLayout(5,1);
			JLabel Titre = new JLabel("<html><b>Gouvernerat :"+ nom +"</b><br><br></html>");
			Titre.setHorizontalAlignment(JLabel.CENTER);
			Titre.setFont(new Font("ComicSansMs",Font.BOLD,30));	
			//Panel.setBackground(new Color(140,200,226));
			String[] col_name= {"nombre total de cas confirm�s","nombre total de cas gu�ris","nombre total des d�c�s"};
			Object[][] row= { {"<html><font size='6' color=blue > Cas confirm�s</html>","<html><font size='6' color=green> Cas gu�ris </html>","<html><font size='6' color=red> D�c�s </html>"},{10,25,30}};
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
			selectd Calendrier = new selectd();
			
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
	
 class selectd extends JPanel implements ActionListener{
	
	public JComboBox<String> mars;//liste de selection des mois 
	public JComboBox<Integer> jours;//liste de selection des jours 
	public JComboBox<Integer> annee;//liste de selection des ann�es 
	public JButton afficher ;
	public String m; //le mois s�l�ction� par l'utilisateur
	public int j;//le jour s�l�ctionn� par l'utilisateur
	public int a;// l'ann�e s�l�ctionn� par l'utilisateur
	
	public selectd()
	{
		super();
		 
		Object[] elt2 = new Object[] {01,02,03,04,05,06,07, 8 , 9, 10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,29,30,31};
		 jours= new JComboBox(elt2);
		jours.setBounds(300, 20, 70, 35);
		this.add(jours);
		Object[] elt1= new Object[] {"mars","avril","mai","juin"};
		 mars=new JComboBox(elt1);
		mars.setBounds(300, 20, 70, 35);
		this.add(mars);
		Object[] elt3  =new Object[] {2020,2021};
		 annee= new JComboBox(elt3);
		annee.setBounds(300, 20, 70, 35);
		this.add(annee);
		afficher=new JButton("afficher");
		afficher.setBounds(400, 20, 70, 35);
		this.add(afficher);
		this.afficher.addActionListener(this);
		this.mars.addActionListener(this);//action sp�cifique � la JComboBox mars pour la r�cuperation du mois s�l�ctionn�
		this.jours.addActionListener(this);//action sp�cifique � la JComboBox jours pour la r�cuperation du jour s�l�ctionn�
		this.annee.addActionListener(this);//action sp�cifique � la JComboBox annee pour la r�cuperation de l'ann�e s�l�ctionn�
	}

	//@Override
	/*public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.mars)
		   m= (String) this.mars.getSelectedItem();
		else if (e.getSource()==this.jours)
		 j=(int)this.jours.getSelectedItem();
		else if (e.getSource()==this.annee)
		 a=(int)this.annee.getSelectedItem();
		else if (e.getSource()==this.afficher)
		{
			String m=this.toString();
			LocalDate d=LocalDate.parse(m);// modefier le type du m en un LocalDate
			LocalDate[] tab= datesdonnees();
			if(tab.contains(d)) //si la date est trouvee on affiche la fenetre avec les donn�es du date d 
				InterfaceTunisie T = new InterfaceTunisie(d);
			else 
			{
				JLabel l=new JLabel("la date choisie est erron�e !!");//sinon il ronvoie un msg d'erreur
				this.add(l);
			}	
				
		}
	}

	@Override
	public String toString() {
		return (""+a+"-"+m+"-"+""+j );
	}*/
	
	

}


	
/*
class ImagePanel extends JPanel{
private BufferedImage image;
public ImagePanel() {
image = ImageIO.read(new File(monFichierImage));
}
protected void paintComponent(Graphics g) {
super.paintComponent(g);
g.drawImage(image, 0, 0, null);
}
}*/
