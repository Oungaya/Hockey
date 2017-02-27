import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;

import ejbHockey.Gardien;
import ejbHockey.Match;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppletHockey {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("Confirmer");
	private JTable table_zone_tir;
	private JTable table_zone_arret;
	private JTextField nameField;
	private JTextField passwordField;
	private String token ="";
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JComboBox liste_gardien = new JComboBox();
	private JComboBox liste_match = new JComboBox();
	private Object[] title_tir = {" ", "1", "2", "3","4","5","6"};
	private Object[] title_arret = {" ", "A", "B", "C","D","E","F","G","H","I"};
	private JScrollPane scrollPane = new JScrollPane();
	private JScrollPane scrollPane_1 = new JScrollPane();
	private JLabel lbl_pourcentage = new JLabel("");
	private JLabel lbl_lancer = new JLabel("");
	private JLabel lbl_arret = new JLabel("");


	private void showMatchs(){
		
		try{
			//call matchs
			System.out.println("token depuis l'applet : " + token);
			URL url=new URL("http://localhost:8080/ProjectHockeyWeb/MatchServlet?token=" + token);
			// Connexion à la servlet
			HttpURLConnection connexion = (HttpURLConnection)url.openConnection();
			connexion.setDoOutput(true);
			// Récupération du flux d’entrée
			ObjectInputStream fluxentree = new ObjectInputStream(connexion.getInputStream());
			ArrayList<Match> listMatchs = (ArrayList<Match>)fluxentree.readObject();
			//init liste and fill it
			this.liste_match.removeAllItems();
			for(int i=0; i< listMatchs.size();i++){
				this.liste_match.addItem(listMatchs.get(i));
			}
		
			
		}catch(Exception e){
			
		}
	}
	private void showGardiens(){
			
		try{
			//call gardiens
			URL url=new URL("http://localhost:8080/ProjectHockeyWeb/GardienServlet?token=" + token);
			// Connexion à la servlet
			HttpURLConnection connexion = (HttpURLConnection)url.openConnection();
			connexion.setDoOutput(true);
			
			// Récupération du flux d’entrée
			ObjectInputStream fluxentree = new ObjectInputStream(connexion.getInputStream());
			ArrayList<Gardien> listGardiens = (ArrayList<Gardien>)fluxentree.readObject();
			//init liste and fill it
			for(int i=0; i< listGardiens.size();i++){
				this.liste_gardien.addItem(listGardiens.get(i));
			}
		}catch(Exception e){
			
		}
	}
	private void set_totaux(Object[][] data)
	{
		int totalLancer,totalArret;
		float totalPourcentage;
		totalLancer = totalArret=0;
		totalPourcentage = 0;
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(1);
		//get total lancer
		for(int i=1; i < 7; i++)
		{
			totalLancer += (int)data[0][i];
			totalArret += (int)data[1][i];
		}
		totalPourcentage = (float)totalArret/totalLancer *100;
		this.lbl_lancer.setText(Integer.toString(totalLancer));
		this.lbl_arret.setText(Integer.toString(totalArret));
		this.lbl_pourcentage.setText(f.format(totalPourcentage));
	}
	private void set_zone_tir(int idGardien, int idMatch)
	{
		try {
			URL url = new URL("http://localhost:8080/ProjectHockeyWeb/StatsServletZoneTir?token=" + token);
			String urlParameters  = "idGardien="+ idGardien + "&idMatch=" + idMatch;
			byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
			
			// Connexion à la servlet
			HttpURLConnection connexion = (HttpURLConnection)url.openConnection();
			connexion.setDoOutput(true);
			connexion.setRequestMethod("POST");
			try( DataOutputStream wr = new DataOutputStream( connexion.getOutputStream())) {
				   wr.write( postData );
			}
			
			// Récupération du flux d’entrée
			ObjectInputStream fluxentree = new ObjectInputStream(connexion.getInputStream());
			Object[][] data_zone_tir = (Object[][])fluxentree.readObject();
			table_zone_tir = new JTable(data_zone_tir,title_tir);
			
			scrollPane_1.setViewportView(table_zone_tir);
			fluxentree.close();
			set_totaux(data_zone_tir);
			
		}catch(Exception eee){
			
		}
	}
	private void set_zone_arret(int idGardien, int idMatch)
	{
		try{
			System.out.println("set_zone_arret");
			URL url = new URL("http://localhost:8080/ProjectHockeyWeb/StatsServletZoneArret?token=" + token);
			String urlParameters  = "idGardien="+ idGardien + "&idMatch=" + idMatch;
			byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
			
			// Connexion à la servlet
			HttpURLConnection connexion = (HttpURLConnection)url.openConnection();
			connexion.setDoOutput(true);
			connexion.setRequestMethod("POST");
			try( DataOutputStream wr = new DataOutputStream( connexion.getOutputStream())) {
				   wr.write( postData );
			}
			
			// Récupération du flux d’entrée
			ObjectInputStream fluxentree = new ObjectInputStream(connexion.getInputStream());
			Object[][] data_zone_arret = (Object[][])fluxentree.readObject();
			
			table_zone_arret = new JTable(data_zone_arret,title_arret);
			scrollPane.setViewportView(table_zone_arret);
			fluxentree.close();
			
		}catch(Exception eee){
			
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppletHockey window = new AppletHockey();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppletHockey() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 935, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JList list = new JList();
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		Object[][] data_tir = {
			      {"Lancer", "0", "0","0","0","0","0"},
			      {"Arret", "0", "0","0","0","0","0"},
			      {"%", "0", "0","0","0","0","0"}
			    };
	
		
		Object[][] data_arret = {
			      {"Lancer", "0", "0","0","0","0","0","0","0","0"},
			      {"Arret", "0", "0","0","0","0","0","0","0","0"},
			      {"%", "0", "0","0","0","0","0","0","0","0"}
			    };
	
		
		
		
		//this.getContentPane().add(new JScrollPane(table_zone_arret));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 816, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(list)
							.addGap(282)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(list))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(63)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel_2.setLayout(null);
		
		JButton btnDconnexion = new JButton("D\u00E9connexion");
	
	
		btnDconnexion.setBounds(0, 11, 120, 23);
		panel_2.add(btnDconnexion);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(10, 11, 59, 14);
		panel_1.add(lblUsername);
		
		nameField = new JTextField();
		nameField.setBounds(75, 8, 114, 20);
		panel_1.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(250, 11, 59, 14);
		panel_1.add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(319, 8, 108, 20);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnValider = new JButton("valider");
		

		btnValider.setBounds(470, 7, 68, 23);
		panel_1.add(btnValider);
		panel.setLayout(null);
		
		
		scrollPane.setBounds(64, 250, 616, 80);
		panel.add(scrollPane);
		
		table_zone_arret = new JTable(data_arret,title_arret);
		scrollPane.setViewportView(table_zone_arret);
		
		JLabel lblParZoneDarrt = new JLabel("Par zone d'arr\u00EAt :");
		lblParZoneDarrt.setBounds(64, 237, 616, 14);
		panel.add(lblParZoneDarrt);
		
		
		scrollPane_1.setBounds(64, 121, 616, 80);
		panel.add(scrollPane_1);
		
		table_zone_tir = new JTable(data_tir,title_tir);
		scrollPane_1.setViewportView(table_zone_tir);
		
		
		JLabel lblParZoneDe = new JLabel("Par zone de tir :");
		lblParZoneDe.setBounds(64, 99, 616, 14);
		panel.add(lblParZoneDe);
		
		JLabel lblNewLabel_3 = new JLabel("Lancers :");
		lblNewLabel_3.setBounds(64, 74, 66, 14);
		panel.add(lblNewLabel_3);
		
		
		lbl_lancer.setBounds(140, 74, 84, 14);
		panel.add(lbl_lancer);
		
		JLabel lblNewLabel_5 = new JLabel("Arr\u00EAts :");
		lblNewLabel_5.setBounds(299, 74, 46, 14);
		panel.add(lblNewLabel_5);
		
		
		lbl_arret.setBounds(339, 74, 84, 14);
		panel.add(lbl_arret);
		
		JLabel lblNewLabel_7 = new JLabel("Pourcentage d'arr\u00EAt :");
		lblNewLabel_7.setBounds(479, 74, 128, 14);
		panel.add(lblNewLabel_7);
		
		lbl_pourcentage.setBounds(617, 74, 63, 14);
		panel.add(lbl_pourcentage);
		
		JLabel lblNewLabel_2 = new JLabel("Match");
		lblNewLabel_2.setBounds(64, 11, 29, 14);
		panel.add(lblNewLabel_2);
		
		liste_match.setBounds(114, 8, 293, 20);
		panel.add(liste_match);
		
		JLabel lblNewLabel_1 = new JLabel("Gardien");
		lblNewLabel_1.setBounds(64, 49, 37, 14);
		panel.add(lblNewLabel_1);
		
		
		liste_gardien.setBounds(113, 43, 294, 20);
		panel.add(liste_gardien);
		
		btnNewButton.setBounds(688, 8, 118, 55);
		panel.add(btnNewButton);
		groupLayout.setHonorsVisibility(false);
		frame.getContentPane().setLayout(groupLayout);
		
		//invisible
		panel.setVisible(false);
		panel_2.setVisible(false);
	
	
		
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
			
					String name = nameField.getText();
					String password = passwordField.getText();	
					
					URL url=new URL("http://localhost:8080/ProjectHockeyWeb/LoginExecuteServlet");
					String urlParameters  = "name="+ name + "&password=" + password+"&applet=true";
					byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
					
					// Connexion à la servlet
					HttpURLConnection connexion = (HttpURLConnection)url.openConnection();
					connexion.setDoOutput(true);
					connexion.setRequestMethod("POST");
					try( DataOutputStream wr = new DataOutputStream( connexion.getOutputStream())) {
						   wr.write( postData );
					}
					
					// Récupération du flux d’entrée
					ObjectInputStream fluxentree = new ObjectInputStream(connexion.getInputStream());
					
					//génération du token
					token = (String)fluxentree.readObject();
					System.out.println("token reçu dans l'applet : " + token);

					
					if (!token.isEmpty())
					{
						panel.setVisible(true);
						panel_2.setVisible(true);
						panel_1.setVisible(false);
						
						showGardiens();
						showMatchs();
						
						
					}else{
						System.out.println("credentials invalids");
					}
				
				}catch(Exception ex){
					
				}
			}
		});
		
		btnDconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					URL url=new URL("http://localhost:8080/ProjectHockeyWeb/LogoutExecuteServlet?token=" + token);

					// Connexion à la servlet
					HttpURLConnection connexion = (HttpURLConnection)url.openConnection();
					connexion.getInputStream();
					
					panel.setVisible(false);
					panel_2.setVisible(false);
					panel_1.setVisible(true);
					
				}catch(Exception ex){
					
				}
			}
		});
		//click confirm
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gardien gardien = (Gardien)liste_gardien.getSelectedItem();
				int idGardien = gardien.getId();
				
				Match match = (Match)liste_match.getSelectedItem();
				int idMatch = match.getId();
				set_zone_tir(idGardien, idMatch);
				set_zone_arret(idGardien, idMatch);
				
			}
		});
		
	}
	
}
