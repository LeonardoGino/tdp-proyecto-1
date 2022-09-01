package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entities.Student;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private Student studentData;

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;

	private JLabel LabelLU;
	private JLabel LabelNombre;
	private JLabel LabelApellido;
	private JLabel LabelEmail;
	private JLabel LabelGitHub;

	private JTextField txtLU;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtGitHubURL;

	public SimplePresentationScreen(Student studentData) {

		this.studentData = studentData;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(600, 265));
		setResizable(false);
		setContentPane(contentPane);

		init();

	}

	private void init() {
		// Tabbed Pane to student personal data

		// Informacion del alumno
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 216);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation,
				"Muestra la información declarada por el alumno");

		LabelLU = new JLabel("LU");

		LabelNombre = new JLabel("Nombre");

		LabelApellido = new JLabel("Apellido");

		LabelEmail = new JLabel("Email");

		LabelGitHub = new JLabel("GitHub URL");

		txtLU = new JTextField();
		txtLU.setColumns(10);
		txtLU.setText(Integer.toString(studentData.getId()));

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setText(studentData.getLastName());

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setText(studentData.getFirstName());

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setText(studentData.getMail());

		txtGitHubURL = new JTextField();
		txtGitHubURL.setColumns(10);
		txtGitHubURL.setText(studentData.getGithubURL());

		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup().addContainerGap().addGroup(gl_tabInformation
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelLU, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtLU, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelApellido, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtApellido, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelNombre, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelGitHub, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtGitHubURL, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelEmail, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_tabInformation
				.setVerticalGroup(
						gl_tabInformation.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_tabInformation.createSequentialGroup().addGap(15)
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelLU).addComponent(txtLU, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(10)
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelApellido)
												.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_tabInformation.createSequentialGroup().addGap(10)
														.addComponent(LabelNombre))
												.addGroup(gl_tabInformation.createSequentialGroup().addGap(10)
														.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelEmail)
												.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(10)
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelGitHub).addComponent(txtGitHubURL,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGap(10)));

		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);

		// Foto del alumno
		JLabel image = new JLabel("");
		image.setBounds(450, 40, 120, 150);
		image.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon profileIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gino.jpg"))
				.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
		image.setIcon(profileIcon);
		contentPane.add(image, BorderLayout.CENTER);

		// fecha y hora en la que la ventana se lanzó a ejecución
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		JLabel dateLabel = new JLabel(
				"Esta ventana fue generada el " + date.format(now) + " a las " + time.format(now));
		dateLabel.setBounds(15, 240, 420, 13);
		contentPane.add(dateLabel, BorderLayout.SOUTH);

	}
}
