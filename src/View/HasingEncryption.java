package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Logic.HasingEncryptionLogic;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class HasingEncryption extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HasingEncryption frame = new HasingEncryption();
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
	public HasingEncryption() {
		setTitle("SymmetricEncryption");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
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
		getContentPane().add(createTabbedPane());
//		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JTabbedPane createTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));

		/* create three JPanel, which is content of tabs */
		JPanel panel1 = createPane1();
		JPanel panel2 = createPane2();

		/* add three tab with three JPanel */
		tabbedPane.addTab("MD5", null, panel1, "click to show panel 1");
		tabbedPane.addTab("SHA256", null, panel2, "click to show panel 2");

		return tabbedPane;
	}

	private JPanel createJPanel(String text) {
		JPanel panel = new JPanel(new GridLayout(1, 1));
		JLabel lb = new JLabel(text);
		lb.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lb);
		return panel;
	}

	private String MD5(String md5) {
		HasingEncryptionLogic logic = new HasingEncryptionLogic();
		return logic.MD5(md5);
	}

	private JPanel createPane1() {
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

		JLabel lblNewLabel = new JLabel("MD5 Hasing Generator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 11, 391, 45);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Use this generator to create an MD5 hash of a string: ");
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
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(62, 388, 1028, 129);
		JButton btnNewButton_1 = new JButton("Generation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String md5Text = MD5(textArea.getText());
				textArea_1.setText(md5Text);
			}
		});
		btnNewButton_1.setBounds(52, 242, 139, 38);
		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("Output");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(52, 339, 139, 38);
		panel_1.add(lblNewLabel_2);

		panel_1.add(textArea_1);
		panel.setLayout(gl_panel);
		return panel;
	}
	
	private JPanel createPane2() {
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

		JLabel lblNewLabel = new JLabel("SHA256 Hasing Generator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 11, 391, 45);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Use this generator to create an SHA256 hash of a string: ");
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
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(62, 388, 1028, 129);
		JButton btnNewButton_1 = new JButton("Generation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String md5Text = MD5(textArea.getText());
				textArea_1.setText(md5Text);
			}
		});
		btnNewButton_1.setBounds(52, 242, 139, 38);
		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("Output");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(52, 339, 139, 38);
		panel_1.add(lblNewLabel_2);

		panel_1.add(textArea_1);
		panel.setLayout(gl_panel);
		return panel;
	}
}
