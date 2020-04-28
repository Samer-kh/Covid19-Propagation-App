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
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;





public class InterfaceTunisie extends JFrame {
	public static void main(String[] args)
	{
		InterfaceTunisie tn=new InterfaceTunisie("maps\\tunisie.png");
		
		
		tn.setExtendedState(tn.MAXIMIZED_BOTH);
		tn.setVisible(true);
		
	}
	public InterfaceTunisie(String MyImage)
	{
	//Creation des boutons represantant les gouvernerats
	JButton Button = new JButton("juste pour marquer");
	
	JButton Button1=new JButton("Tunis");
	JButton Button2=new JButton("Ariana");
	JButton Button3=new JButton("Manouba");
	JButton Button4=new JButton("Ben Arous");
	JButton Button5=new JButton("Bizerte");
	JButton Button6=new JButton("Jandouba");
	JButton Button7=new JButton("Baja");
	JButton Button8=new JButton("Kasrine");
	JButton Button9=new JButton("Zaghouan");
	JButton Button10=new JButton("Kairouan");
	JButton Button11=new JButton("Sidi Bou Zid");
	JButton Button12=new JButton("Sousse");
	JButton Button13=new JButton("Mounastir");
	JButton Button14=new JButton("Mahdia");
	JButton Button15=new JButton("Sfax");
	JButton Button16=new JButton("Gabes");
	JButton Button17=new JButton("Mednine");
	JButton Button18=new JButton("Touzer");
	JButton Button19=new JButton("Kbili");
	JButton Button20=new JButton("Gafsa");
	JButton Button21=new JButton("Nabel");
	JButton Button22=new JButton("Tataouin");
	JButton Button23=new JButton("Kef");
	JButton Button24=new JButton("Sileana");
	
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

	

	
	
	
	Scrolldata.setMaximumSize(new Dimension(0,40));
	sl3.setResizeWeight(0.5);
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
	
	GridLayout gl2=new GridLayout(1,3);
	JLabel nbcas = new JLabel("le nombre des cas est :");
	JLabel nbdeces = new JLabel("le nombre des déces est :");
	JLabel nbgueris = new JLabel("le nombre des guéris est :");
	
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
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tunis.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button2.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\ariana.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button3.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\manouba.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button4.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\ben arous.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button5.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\bizerte.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button6.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\jendouba.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button7.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\beja.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button8.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kassrine.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button9.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\zaghouan.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button10.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kairouan.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button11.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sidi bou zid.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button12.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sousse.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button13.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mounastir.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button14.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mahdia.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button15.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\sfax.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button16.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\gabes.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button17.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\mednine.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button18.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tozeur.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button19.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kebili.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button20.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\gafsa.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button21.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\nabel.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button22.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\tataouine.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button23.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\kef.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	Button24.addActionListener(ae -> 
	{	this.dispose();
	    InterfaceTunisie Tn=new InterfaceTunisie("maps\\siliana.png");
		Tn.setVisible(true);
		Tn.setExtendedState(Tn.MAXIMIZED_BOTH);
		
	});
	
	
	
	
	
		
		
	}}
	


	
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
