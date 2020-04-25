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
		InterfaceTunisie tn=new InterfaceTunisie();
		tn.setExtendedState(tn.MAXIMIZED_BOTH);
		tn.setVisible(true);
		
	}
	public InterfaceTunisie()
	{
	
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
	
	
	setSize(400,400);
	JPanel Panel1=new JPanel();
	JPanel Panel2=new JPanel();
	JPanel Panel3=new JPanel();
	JPanel Panel4=new JPanel();
	JPanel Panel5=new JPanel();
	JPanel Panel6=new JPanel();
	JPanel Panel7=new JPanel();
	
	
	

	JTextArea area=new JTextArea();
	Panel2.add(area);
	Panel2.setLayout(new FlowLayout());
	JScrollPane ScrollD=new JScrollPane(Panel1);
	JScrollPane Scrolldata=new JScrollPane(Panel3);
	JSplitPane sl3=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,Panel2,Panel4);
	JSplitPane sl2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sl3,Scrolldata);
	
	JSplitPane sl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ScrollD , sl2);

	
	// ImageIcon icon = createImageIcon("images/Cat.gif");
    // SizeDisplayer sd1 = new SizeDisplayer("left", icon);
    // sd1.setMinimumSize(new Dimension(30,30));
	
	
	
	Scrolldata.setMaximumSize(new Dimension(0,40));
	sl3.setResizeWeight(0.75);
	sl2.setResizeWeight(0.95);
	ScrollD.setPreferredSize(new Dimension(250,0));
	//Scrolldata.setPreferredSize(new Dimension(0,150));
	//sl3.setPreferredSize(new Dimension(200,0));

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
	
	BufferedImage myPicture=null;
	
	try {
	    myPicture = ImageIO.read(new File("C:\\maps\\tunisie.jpg"));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	ImageIcon image = new ImageIcon(myPicture);
	JLabel imageLabel= new JLabel(image);
	JScrollPane ImageScroll=new JScrollPane(imageLabel);
	Panel2.add(ImageScroll);
	
	Button1.addActionListener(ae -> 
	{BufferedImage myPictur=null;
		try {
		    myPictur = ImageIO.read(new File("C:\\maps\\tunis.jpg"));
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		ImageIcon image1 = new ImageIcon(myPictur);
		JLabel imageLabel1= new JLabel(image1);
		JScrollPane ImageScroll1=new JScrollPane(imageLabel1);
		Panel2.remove(ImageScroll); 
		Panel2.repaint(); 
		Panel2.add(ImageScroll1);
	});
		
		
	}
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
