package student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class DlgStudent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private JLabel lblIme;
	private JTextField txtIme;
	private JLabel lblPrezime;
	private JTextField txtPrezime;
	private JTextField txtBrojIndeksa;
	JComboBox cbxSmer = new JComboBox();
	protected JComboBox cbxGodina = new JComboBox();
	boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStudent dialog = new DlgStudent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStudent() {
		setModal(true);
		setResizable(false);
		setTitle("Unos/modifikacija studenta");
		setBounds(100, 100, 266, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIme = new JTextField();
		txtIme.setColumns(10);
		lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPrezime = new JTextField();
		txtPrezime.setColumns(10);

		cbxSmer.addItem("IM");
		cbxSmer.addItem("IT");
		cbxSmer.addItem("MH");
		cbxSmer.addItem("II");

		txtBrojIndeksa = new JTextField();
		txtBrojIndeksa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtBrojIndeksa.setColumns(10);

		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));

		cbxGodina.addItem("2013");
		cbxGodina.addItem("2014");
		cbxGodina.addItem("2015");
		cbxGodina.addItem("2016");

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
								.createSequentialGroup().addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup().addGap(18)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(txtPrezime, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtIme, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblIme, GroupLayout.PREFERRED_SIZE, 39,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPrezime, GroupLayout.PREFERRED_SIZE, 55,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addComponent(cbxSmer, GroupLayout.PREFERRED_SIZE, 54,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtBrojIndeksa, GroupLayout.PREFERRED_SIZE, 65,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(label, GroupLayout.PREFERRED_SIZE, 15,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(cbxGodina,
														GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(34, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblIme)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblPrezime)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtPrezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbxSmer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBrojIndeksa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxGodina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
						.addContainerGap(71, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.setIcon(null);
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtIme.getText().trim().isEmpty() || txtPrezime.getText().trim().isEmpty()
								|| txtBrojIndeksa.getText().trim().isEmpty()) {
							isOk = false;
							setVisible(true);
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!", "Greška",
									JOptionPane.ERROR_MESSAGE);
						} else {
							isOk = true;
							dispose();
						}

					}
				});
				btnPotvrdi.setActionCommand("OK");
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				btnOdustani = new JButton("Odustani");
				btnOdustani.setIcon(null);
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnOdustani.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
					gl_buttonPane.createParallelGroup(Alignment.LEADING).addGroup(gl_buttonPane.createSequentialGroup()
							.addGap(31).addComponent(btnPotvrdi).addGap(44).addComponent(btnOdustani).addGap(43)));
			gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(5)
							.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE).addComponent(btnOdustani)
									.addComponent(btnPotvrdi))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JTextField getTxtIme() {
		return txtIme;
	}

	public void setTxtIme(JTextField txtIme) {
		this.txtIme = txtIme;
	}

	public JTextField getTxtPrezime() {
		return txtPrezime;
	}

	public void setTxtPrezime(JTextField txtPrezime) {
		this.txtPrezime = txtPrezime;
	}

	public JTextField getTxtBrojIndeksa() {
		return txtBrojIndeksa;
	}

	public void setTxtBrojIndeksa(JTextField txtBrojIndeksa) {
		this.txtBrojIndeksa = txtBrojIndeksa;
	}

	public JComboBox getCbxSmer() {
		return cbxSmer;
	}

	public void setCbxSmer(JComboBox cbxSmer) {
		this.cbxSmer = cbxSmer;
	}

	public JComboBox getCbxGodina() {
		return cbxGodina;
	}

	public void setCbxGodina(JComboBox cbxGodina) {
		this.cbxGodina = cbxGodina;
	}
}
