package Package1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class selectd extends JPanel implements ActionListener{
	
	public JComboBox<String> mars;//liste de selection des mois 
	public JComboBox<Integer> jours;//liste de selection des jours 
	public JComboBox<Integer> annee;//liste de selection des années 
	public JButton afficher ;
	public String m; //le mois sélèctioné par l'utilisateur
	public int j;//le jour sélèctionné par l'utilisateur
	public int a;// l'année sélèctionné par l'utilisateur
	
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
		this.mars.addActionListener(this);//action spécifique à la JComboBox mars pour la récuperation du mois sélèctionné
		this.jours.addActionListener(this);//action spécifique à la JComboBox jours pour la récuperation du jour sélèctionné
		this.annee.addActionListener(this);//action spécifique à la JComboBox annee pour la récuperation de l'année sélèctionné
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
			if(tab.contains(d)) //si la date est trouvee on affiche la fenetre avec les données du date d 
				InterfaceTunisie T = new InterfaceTunisie(d);
			else 
			{
				JLabel l=new JLabel("la date choisie est erronée !!");//sinon il ronvoie un msg d'erreur
				this.add(l);
			}	
				
		}
	}

	@Override
	public String toString() {
		return (""+a+"-"+m+"-"+""+j );
	}
	
	

}
