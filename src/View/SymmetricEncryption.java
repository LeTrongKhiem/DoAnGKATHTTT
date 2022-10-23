package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import Logic.SymmetricEncryptionLogic;
import javax.swing.JTextField;

public class SymmetricEncryption extends JFrame {

	private SymmetricEncryptionLogic logic;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SymmetricEncryption frame = new SymmetricEncryption();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SymmetricEncryption() {
		setTitle("SymmetricEncryption");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 930, 555);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(223, 105, 10, 10);
//		contentPane.add(panel_1);
//
//		JPanel panel = new JPanel();
//		panel.setBounds(238, 10, 468, 200);
//		contentPane.add(panel);
//		add(createTabbedPane());
		logic = new SymmetricEncryptionLogic();
		getContentPane().add(createTabbedPane());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JTabbedPane createTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));

		/* create three JPanel, which is content of tabs */
		JPanel panel1 = dichChuyen();
		JPanel panel2 = thayThe();
		JPanel panel3 = createJPanel("content of panel 3");
		JPanel panel4 = createJPanel("4");
		JPanel panel5 = createJPanel("5");

		/* add three tab with three JPanel */
		tabbedPane.addTab("MA HOA DICH CHUYEN", null, panel1, "click to show panel 1");
		tabbedPane.addTab("MA HOA THAY THE", null, panel2, "click to show panel 2");
		tabbedPane.addTab("AFFINE", null, panel3, "click to show panel 3");
		tabbedPane.addTab("VINEGERE", null, panel4, "click to show panel 2");
		tabbedPane.addTab("HILL", null, panel5, "click to show panel 3");

		return tabbedPane;
	}

	private JPanel createJPanel(String text) {
		JPanel panel = new JPanel(new GridLayout(1, 1));
		JLabel lb = new JLabel(text);
		lb.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lb);
		return panel;
	}

	private JPanel dichChuyen() {
		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1182, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ceasar Hasing Generator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 11, 391, 45);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Use this generator to create an Ceasar hash of a string: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 55, 391, 45);
		panel_1.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(62, 111, 1028, 109);
		panel_1.add(textArea);

		JButton btnNewButton = new JButton("Import File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null); // replace null with your swing container
				File file = null;
				if (returnVal == JFileChooser.APPROVE_OPTION)
					file = chooser.getSelectedFile();

				BufferedReader in = null;
				try {
					in = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				String line;
				try {
					line = in.readLine();
					while (line != null) {
						textArea.append(line + "\n");
						line = in.readLine();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(938, 70, 152, 30);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panel_1.add(btnNewButton);
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinner.setBounds(234, 231, 92, 45);
		panel_1.add(spinner);

		JLabel lblNewLabel_3 = new JLabel("Shift");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(85, 231, 139, 45);
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(62, 434, 1028, 129);
		JButton btnNewButton_1 = new JButton("Encode");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int shift = (Integer) spinner.getValue();
					String ceasarEncode = logic.CeasarEncode(textArea.getText(), shift);
					textArea_1.setText(ceasarEncode);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(52, 326, 139, 38);
		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("Output");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(52, 385, 139, 38);
		panel_1.add(lblNewLabel_2);

		panel_1.add(textArea_1);

		JButton btnNewButton_1_1 = new JButton("Decode");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int shift = (Integer) spinner.getValue();
					String ceasarEncode = logic.CeasarDecode(textArea.getText(), shift);
					textArea_1.setText(ceasarEncode);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBounds(234, 326, 139, 38);
		panel_1.add(btnNewButton_1_1);

		panel_1.add(lblNewLabel_3);
		panel.setLayout(gl_panel);
		return panel;
	}

	private JPanel thayThe() {
		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1182, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Substitution Cipher Hasing Generator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 11, 391, 45);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Use this generator to create an Substitution Cipher hash of a string: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 55, 391, 45);
		panel_1.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(62, 111, 1028, 109);
		panel_1.add(textArea);

		JButton btnNewButton = new JButton("Import File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null); // replace null with your swing container
				File file = null;
				if (returnVal == JFileChooser.APPROVE_OPTION)
					file = chooser.getSelectedFile();

				BufferedReader in = null;
				try {
					in = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				String line;
				try {
					line = in.readLine();
					while (line != null) {
						textArea.append(line + "\n");
						line = in.readLine();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(938, 70, 152, 30);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JButton btnNewButton_2 = new JButton("Random Key");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(logic.randomKey());
			}
		});
		panel_1.add(btnNewButton);
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinner.setBounds(690, 231, 74, 45);
		JLabel lblNewLabel_3 = new JLabel("Key");
		JLabel lblNewLabel_3_1 = new JLabel("Shift");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(85, 231, 139, 45);
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(62, 434, 1028, 129);
		JButton btnNewButton_1 = new JButton("Encode");
		JLabel lblNewLabel_2 = new JLabel("Output");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(52, 385, 139, 38);
		panel_1.add(lblNewLabel_2);

		panel_1.add(textArea_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					int shift = (Integer) spinner.getValue();
//					String encodeString = logic.subtitutionEnCode(textArea.getText(), shift, textField.getText());
//					textArea_1.setText(encodeString);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(52, 326, 139, 38);
		panel_1.add(btnNewButton_1);

		

		JButton btnNewButton_1_1 = new JButton("Decode");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int shift = (Integer) spinner.getValue();
//					String encodeString = logic.subtitutionDecode(textArea.getText(), shift, textField.getText());
//					textArea_1.setText(encodeString);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBounds(234, 326, 139, 38);
		panel_1.add(btnNewButton_1_1);

		panel_1.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(147, 236, 284, 38);
		panel_1.add(textField);
		textField.setColumns(10);

		btnNewButton_2.setBounds(441, 239, 139, 32);
		panel_1.add(btnNewButton_2);

		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(622, 231, 139, 45);
		panel_1.add(lblNewLabel_3_1);

		panel_1.add(spinner);
		panel.setLayout(gl_panel);
		return panel;
	}
}
