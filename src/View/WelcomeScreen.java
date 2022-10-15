package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Model.RoundedBorder;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class WelcomeScreen extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WelcomeScreen dialog = new WelcomeScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WelcomeScreen() {
		getContentPane().setBackground(SystemColor.scrollbar);
		setTitle("HashCodeTool");
		setBounds(100, 100, 538, 346);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to HashCode Tool. Please select option: ");
		lblNewLabel.setForeground(UIManager.getColor("CheckBox.foreground"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(99, 11, 413, 40);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Symmetric Encryption");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBorder(new RoundedBorder(15)); //10 is the radius
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(142, 61, 235, 33);
		getContentPane().add(btnNewButton);
	}
}
