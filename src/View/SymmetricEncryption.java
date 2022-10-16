package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class SymmetricEncryption extends JFrame {

	private JPanel contentPane;

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
		add(createTabbedPane());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JTabbedPane createTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

		/* create three JPanel, which is content of tabs */
		JPanel panel1 = createPane1();
		JPanel panel2 = createJPanel("content of panel 2");
		JPanel panel3 = createJPanel("content of panel 3");

		/* add three tab with three JPanel */
		tabbedPane.addTab("Tab 1", null, panel1, "click to show panel 1");
		tabbedPane.addTab("Tab 2", null, panel2, "click to show panel 2");
		tabbedPane.addTab("Tab 3", null, panel3, "click to show panel 3");

		return tabbedPane;
	}

	private JPanel createJPanel(String text) {
		JPanel panel = new JPanel(new GridLayout(1, 1));
		JLabel lb = new JLabel(text);
		lb.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lb);
		return panel;
	}

	private JPanel createPane1() {
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(createTextArea(400, 200)));
		return panel;
	}

	private JTextArea createTextArea(int row, int col) {
		JTextArea ta = new JTextArea(row, col);
		ta.setWrapStyleWord(true);
		ta.setLineWrap(true);
		ta.setForeground(Color.BLUE);
		return ta;
	}
}
