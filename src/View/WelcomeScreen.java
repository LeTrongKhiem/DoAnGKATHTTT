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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(80, 11, 413, 40);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Symmetric Encryption");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SymmetricEncryption symmetricEncryption = new SymmetricEncryption();
				symmetricEncryption.setVisible(true);
			}
		});
		btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(Color.MAGENTA);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(UIManager.getColor("control"));
		    }
		});
		JButton btnNewButton1 = new JButton("Asymmetric Encryption");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("2");
			}
		});
		btnNewButton1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnNewButton1.setBackground(Color.MAGENTA);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton1.setBackground(UIManager.getColor("control"));
		    }
		});
		JButton btnNewButton2 = new JButton("Hasing");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HasingEncryption hasingEncryption = new HasingEncryption();
				hasingEncryption.setVisible(true);
			}
		});
		btnNewButton2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnNewButton2.setBackground(Color.MAGENTA);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton2.setBackground(UIManager.getColor("control"));
		    }
		});
		btnNewButton.setBorder(new RoundedBorder(15));
		btnNewButton1.setBorder(new RoundedBorder(15));
		btnNewButton2.setBorder(new RoundedBorder(15));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton1.setBackground(Color.LIGHT_GRAY);
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton2.setBackground(Color.LIGHT_GRAY);
		btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(110, 62, 299, 49);
		btnNewButton1.setBounds(110, 127, 299, 49);
		btnNewButton2.setBounds(110, 199, 299, 49);
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton1);
		getContentPane().add(btnNewButton2);
	}
}
