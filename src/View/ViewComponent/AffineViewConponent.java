package View.ViewComponent;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import Logic.SymmetricEncryptionLogic;

public class AffineViewConponent extends JFrame{
	private JTextField textField;
	public AffineViewConponent(SymmetricEncryptionLogic logic, JPanel contentPane) {
		affine(logic, contentPane);
	}
	
	public JPanel affine(SymmetricEncryptionLogic logic, JPanel contentPane) {
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
