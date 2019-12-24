package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FrmStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtBrojStudenata;
	JList lstStudent = new JList();
	DefaultListModel dlm = new DefaultListModel();
	int brojac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStudent frame = new FrmStudent();
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
	public FrmStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Evidencija studenata");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlZapad = new JPanel();
		contentPane.add(pnlZapad, BorderLayout.WEST);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStudent dlgStudent = new DlgStudent();
				dlgStudent.setVisible(true);
				if (dlgStudent.isOk) {
					dlm.addElement("Broj indeksa: " + dlgStudent.getCbxSmer().getSelectedItem() + " "
							+ dlgStudent.getTxtBrojIndeksa().getText() + " / "
							+ dlgStudent.getCbxGodina().getSelectedItem() + ", Prezime: "
							+ dlgStudent.getTxtPrezime().getText() + " Ime: " + dlgStudent.getTxtIme().getText());
					brojac++;
					txtBrojStudenata.setText(Integer.toString(brojac));
				}
			}
		});

		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lstStudent.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan red!", "Greška",
							JOptionPane.ERROR_MESSAGE);
				} else {
					DlgStudent dlgModifikacija = new DlgStudent();
					String[] split = dlm.getElementAt(lstStudent.getSelectedIndex()).toString().split(" ");
					int index = lstStudent.getSelectedIndex();
					dlgModifikacija.getTxtIme().setText(split[9]);
					dlgModifikacija.getTxtPrezime().setText(split[7]);
					dlgModifikacija.getTxtBrojIndeksa().setText(split[3]);
					dlgModifikacija.getCbxSmer().setSelectedItem(split[2]);
					dlgModifikacija.getCbxGodina().setSelectedItem(split[5]);
					dlgModifikacija.setVisible(true);

					if (dlgModifikacija.isOk) {
						dlm.removeElementAt(lstStudent.getSelectedIndex());
						dlm.add(index,
								"Broj indeksa: " + dlgModifikacija.getCbxSmer().getSelectedItem() + " "
										+ dlgModifikacija.getTxtBrojIndeksa().getText() + " / "
										+ dlgModifikacija.getCbxGodina().getSelectedItem() + ", Prezime: "
										+ dlgModifikacija.getTxtPrezime().getText() + " Ime: "
										+ dlgModifikacija.getTxtIme().getText());
					}
				}
			}
		});
		GroupLayout gl_pnlZapad = new GroupLayout(pnlZapad);
		gl_pnlZapad.setHorizontalGroup(gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup().addGap(5)
						.addGroup(gl_pnlZapad.createParallelGroup(Alignment.LEADING)
								.addComponent(btnModifikuj, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addGroup(gl_pnlZapad.createSequentialGroup()
										.addComponent(btnDodaj, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
										.addContainerGap()))));
		gl_pnlZapad.setVerticalGroup(gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup().addGap(5).addComponent(btnDodaj)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnModifikuj).addContainerGap(184,
								Short.MAX_VALUE)));
		pnlZapad.setLayout(gl_pnlZapad);

		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);

		JScrollPane scrlStudent = new JScrollPane();
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup().addContainerGap()
						.addComponent(scrlStudent, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(11, Short.MAX_VALUE)));
		gl_pnlCentar.setVerticalGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup().addContainerGap()
						.addComponent(scrlStudent, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(30, Short.MAX_VALUE)));

		lstStudent.setModel(dlm);
		scrlStudent.setViewportView(lstStudent);
		pnlCentar.setLayout(gl_pnlCentar);

		JPanel pnlIstok = new JPanel();
		contentPane.add(pnlIstok, BorderLayout.EAST);

		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!dlm.isEmpty()) {
					dlm.remove(dlm.size() - 1);
					brojac--;
					txtBrojStudenata.setText(Integer.toString(brojac));
				} else
					JOptionPane.showMessageDialog(pnlCentar, "Lista je prazna!", "Greška", JOptionPane.ERROR_MESSAGE);
			}
		});
		pnlIstok.add(btnUkloni);

		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);

		JLabel lblBrojStudenata = new JLabel("Broj studenata:");

		txtBrojStudenata = new JTextField();
		txtBrojStudenata.setEditable(false);
		txtBrojStudenata.setColumns(10);
		GroupLayout gl_pnlJug = new GroupLayout(pnlJug);
		gl_pnlJug
				.setHorizontalGroup(gl_pnlJug.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlJug.createSequentialGroup().addGap(162).addComponent(lblBrojStudenata)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtBrojStudenata, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(154, Short.MAX_VALUE)));
		gl_pnlJug
				.setVerticalGroup(gl_pnlJug.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_pnlJug.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_pnlJug.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtBrojStudenata, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBrojStudenata))));
		pnlJug.setLayout(gl_pnlJug);

		JLabel lblEvidencijaStudenata = new JLabel("Evidencija studenata");
		lblEvidencijaStudenata.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEvidencijaStudenata.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEvidencijaStudenata, BorderLayout.NORTH);
	}
}
