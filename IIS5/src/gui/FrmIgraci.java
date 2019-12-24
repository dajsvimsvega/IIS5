package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class FrmIgraci extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	JList listIgraci = new JList();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JTextField txtIgrac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIgraci frame = new FrmIgraci();
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
	public FrmIgraci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 395);
		setResizable(false);
		setTitle("Frame Igraci");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnIspisi = new JButton("Ispi\u0161i");
		btnIspisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test Button");
			}
		});
		pnlSouth.add(btnIspisi);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblAleksandarKolarov = new JLabel("Aleksandar Kolarov");
		
		JLabel lblNemanjaMatic = new JLabel("Nemanja Matic");
		
		JLabel lblDusanTadic = new JLabel("Dusan Tadic");
		
		JToggleButton tglbtnKolarov = new JToggleButton("Kolarov");
		tglbtnKolarov.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnKolarov.isSelected()) {
					dlm.addElement(lblAleksandarKolarov.getText());
					// obavezno java awt
					lblAleksandarKolarov.setForeground(Color.BLUE);
					lblDusanTadic.setForeground(Color.RED);
					lblNemanjaMatic.setForeground(Color.RED);
				}
			}
		});
		
		JToggleButton tglbtnMatic = new JToggleButton("Matic");
		tglbtnMatic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnMatic.isSelected()) {
					dlm.addElement(lblNemanjaMatic.getText());
					lblAleksandarKolarov.setForeground(Color.RED);
					lblDusanTadic.setForeground(Color.RED);
					lblNemanjaMatic.setForeground(Color.BLUE);
				}
			}
		});
		
		JToggleButton tglbtnTadic = new JToggleButton("Tadic");
		tglbtnTadic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnTadic.isSelected()) {
					dlm.addElement(lblDusanTadic.getText());
					lblAleksandarKolarov.setForeground(Color.RED);
					lblDusanTadic.setForeground(Color.BLUE);
					lblNemanjaMatic.setForeground(Color.RED);
				}
			}
		});
		
		// dodavanje tgl-btn-a u ButtonGroup
		btnGroup.add(tglbtnKolarov);
		btnGroup.add(tglbtnMatic);
		btnGroup.add(tglbtnTadic);
		
		JScrollPane scrlPaneIgraci = new JScrollPane();
		
		JLabel lblUnesiIgraca = new JLabel("Unesi igraca:");
		
		txtIgrac = new JTextField();
		txtIgrac.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					dlm.addElement(txtIgrac.getText()); 
				}
			}
		});
		txtIgrac.setColumns(10);
		
		JLabel lblOdaberiIgraca = new JLabel("Odaberi igraca:");
		
		JComboBox cbxIgraci = new JComboBox();
		
		cbxIgraci.addItem("Luka Jovic");
		cbxIgraci.addItem("Dusan Vlahovic");
		cbxIgraci.addItem("Nemanja Gudelj");
		
		JButton btnDodajIgraca = new JButton("Dodaj igraca");
		btnDodajIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement((String) cbxIgraci.getSelectedItem());
			}
		});
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listIgraci.isSelectionEmpty()) {
					dlm.removeElement(listIgraci.getSelectedValue());
				} else {
					JOptionPane.showMessageDialog(null,
							"Niste selektovali nijednog igraca!");
				}
			}
		});
		
		JButton btnDijalog = new JButton("Dijalog");
		btnDijalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgIgrac dlg = new DlgIgrac();
				dlg.setVisible(true);
				if(dlg.isOk) {
					dlm.addElement(dlg.getTxtIme().getText() + " " + dlg.getTxtPrezime().getText());
				}
			}
		});
		
		JButton btnModifikacijaDijalog = new JButton("Modifikacija dijalog");
		btnModifikacijaDijalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listIgraci.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Niste selektovali nijednog igraca!");
				} else {
					DlgIgrac dlgModifikacija = new DlgIgrac();
					String[] split = dlm.getElementAt(listIgraci.getSelectedIndex()).toString().split(" ");
					int index = listIgraci.getSelectedIndex();
					dlgModifikacija.getTxtIme().setText(split[0]);
					dlgModifikacija.getTxtPrezime().setText(split[1]);
					dlgModifikacija.setVisible(true);
					if(dlgModifikacija.isOk) {
						dlm.removeElementAt(index);
						dlm.add(index, dlgModifikacija.getTxtIme().getText() + " " + dlgModifikacija.getTxtPrezime().getText());
					}
				}
			}
		});
		
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblUnesiIgraca, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tglbtnTadic, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tglbtnMatic, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tglbtnKolarov, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIgrac))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDodajIgraca)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addComponent(lblOdaberiIgraca, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(cbxIgraci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblAleksandarKolarov, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(lblNemanjaMatic, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDusanTadic, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrlPaneIgraci, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(32, Short.MAX_VALUE))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(103)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDijalog, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModifikacijaDijalog))
							.addGap(208))))
				.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
					.addContainerGap(556, Short.MAX_VALUE)
					.addComponent(btnUkloni)
					.addGap(73))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnKolarov)
								.addComponent(lblAleksandarKolarov))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnMatic)
								.addComponent(lblNemanjaMatic))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnTadic)
								.addComponent(lblDusanTadic))
							.addGap(16))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addComponent(scrlPaneIgraci, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnUkloni)
					.addGap(16)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnesiIgraca)
						.addComponent(txtIgrac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDijalog, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOdaberiIgraca)
						.addComponent(cbxIgraci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModifikacijaDijalog))
					.addGap(26)
					.addComponent(btnDodajIgraca)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		
		// povezivanje modela i liste
		listIgraci.setModel(dlm);
		
		scrlPaneIgraci.setViewportView(listIgraci);
		pnlCenter.setLayout(gl_pnlCenter);
	}
}
