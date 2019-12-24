package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgIgrac extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIme;
	private JTextField txtPrezime;
	public boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgIgrac dialog = new DlgIgrac();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgIgrac() {
		setBounds(100, 100, 450, 228);
		setTitle("Unos/Modifikacija igraca");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblImeIgraca = new JLabel("Ime igraca:");
		txtIme = new JTextField();
		txtIme.setColumns(10);
		JLabel lblPrezimeIgraca = new JLabel("Prezime igraca:");
		txtPrezime = new JTextField();
		txtPrezime.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(177)
							.addComponent(lblImeIgraca))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(161)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblPrezimeIgraca))
								.addComponent(txtIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPrezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(177, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImeIgraca)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPrezimeIgraca)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPrezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(121, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtIme.getText().trim().isEmpty() ||
								txtPrezime.getText().trim().isEmpty()) {
							isOk = false;
							setVisible(true);
							getToolkit().beep();
							JOptionPane.showMessageDialog(null,
									"Sva polja moraju biti popunjena!");
						} else {
							isOk = true;
							dispose();
						}
					}
				});
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnOdustani.setActionCommand("Cancel");
				buttonPane.add(btnOdustani);
			}
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

}
