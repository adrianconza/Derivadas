package derivadas;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class Derivadas {
	static JFrame ventana = new JFrame();
	static Font fuente = new Font("Arial", Font.PLAIN, 15);
	static String Derivada = "";
	static JTextField resp = new JTextField();
	static JTextField Cderivada = new JTextField();

	public static void main(String[] args) {
		ventana();
		ventana.setVisible(true);
	}

	static void ventana() {
		ventana.setResizable(false);
		ventana.setTitle("DERIVADOR 1.0");
		ventana.setIconImage(new ImageIcon("imagenes/logo.png").getImage());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(659, 362);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);

		JLabel titulo1 = new JLabel("FUNCION A DERIVAR:");
		titulo1.setFont(fuente);
		titulo1.setBounds(12, 68, 157, 16);
		ventana.add(titulo1);

		JLabel titulo2 = new JLabel("DERIVADA:");
		titulo2.setFont(fuente);
		titulo2.setBounds(12, 159, 80, 16);
		ventana.add(titulo2);

		Cderivada.setFont(fuente);
		Cderivada.setBounds(12, 97, 351, 36);
		ventana.add(Cderivada);

		resp.setFont(fuente);
		resp.setBounds(12, 189, 351, 36);
		ventana.add(resp);

		JLabel titulo = new JLabel("DERIVADOR 1.0");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(251, 13, 151, 16);
		ventana.add(titulo);

		JButton btnderivar = new JButton("DERIVAR");
		btnderivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				derivador();
			}
		});
		btnderivar.setFont(fuente);
		btnderivar.setBounds(40, 263, 129, 43);
		ventana.add(btnderivar);

		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cderivada.setText("");
				resp.setText("");
			}
		});
		btnBorrar.setFont(fuente);
		btnBorrar.setBounds(199, 263, 129, 43);
		ventana.add(btnBorrar);

		JButton btnacercade = new JButton("ACERCA DE:");
		btnacercade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercade();
			}
		});
		btnacercade.setFont(fuente);
		btnacercade.setBounds(516, 11, 125, 27);
		ventana.add(btnacercade);
		botones();
	}

	static void botones() {
		JButton btnmas = new JButton("+");
		btnmas.setFont(fuente);
		btnmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar(" + ");
			}
		});
		btnmas.setBounds(405, 68, 50, 50);
		ventana.add(btnmas);

		JButton btnmenos = new JButton("-");
		btnmenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" - ");
			}
		});
		btnmenos.setFont(fuente);
		btnmenos.setBounds(467, 66, 50, 50);
		ventana.add(btnmenos);

		JButton btnpor = new JButton("*");
		btnpor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" * ");
			}
		});
		btnpor.setFont(fuente);
		btnpor.setBounds(529, 66, 50, 50);
		ventana.add(btnpor);

		JButton btndivision = new JButton("/");
		btndivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" / ");
			}
		});
		btndivision.setFont(fuente);
		btndivision.setBounds(591, 66, 50, 50);
		ventana.add(btndivision);

		JButton btnpotencia = new JButton("^");
		btnpotencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" ^ ");
			}
		});
		btnpotencia.setFont(fuente);
		btnpotencia.setBounds(405, 129, 50, 50);
		ventana.add(btnpotencia);

		JButton btnlna = new JButton("ln");
		btnlna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" ln( ) ");
			}
		});
		btnlna.setFont(fuente);
		btnlna.setBounds(467, 129, 50, 50);
		ventana.add(btnlna);

		JButton btnlog = new JButton("lg");
		btnlog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" log( ) ");
			}
		});
		btnlog.setFont(fuente);
		btnlog.setBounds(529, 129, 50, 50);
		ventana.add(btnlog);

		JButton btne = new JButton("e");
		btne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" exp( ) ");
			}
		});
		btne.setFont(fuente);
		btne.setBounds(591, 129, 50, 50);
		ventana.add(btne);

		JButton btnsen = new JButton("sen");
		btnsen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" sin( ) ");
			}
		});
		btnsen.setFont(fuente);
		btnsen.setBounds(415, 195, 65, 50);
		ventana.add(btnsen);

		JButton btncos = new JButton("cos");
		btncos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" cos( ) ");
			}
		});
		btncos.setFont(fuente);
		btncos.setBounds(492, 195, 65, 50);
		ventana.add(btncos);

		JButton btntag = new JButton("tag");
		btntag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" tan( ) ");
			}
		});
		btntag.setFont(fuente);
		btntag.setBounds(569, 195, 65, 50);
		ventana.add(btntag);

		JButton btncsc = new JButton("csc");
		btncsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" cosec( ) ");
			}
		});
		btncsc.setFont(fuente);
		btncsc.setBounds(415, 263, 65, 50);
		ventana.add(btncsc);

		JButton btnsec = new JButton("sec");
		btnsec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" sec( ) ");
			}
		});
		btnsec.setFont(fuente);
		btnsec.setBounds(492, 263, 65, 50);
		ventana.add(btnsec);

		JButton btnctg = new JButton("ctg");
		btnctg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(" cot( ) ");
			}
		});
		btnctg.setFont(fuente);
		btnctg.setBounds(569, 263, 65, 50);
		ventana.add(btnctg);
	}

	static void acercade() {
		Font fuente1 = new Font("Ravie", Font.PLAIN, 20);
		Font fuente2 = new Font("Ravie", Font.PLAIN, 18);
		Font fuente3 = new Font("Ravie", Font.PLAIN, 14);
		JFrame ventayu = new JFrame();
		ventayu.setSize(526, 467);
		ventayu.setLocationRelativeTo(null);
		ventayu.setIconImage(new ImageIcon("imagenes/logo.png").getImage());
		ventayu.setTitle("ACERCA DE");
		ventayu.setLayout(null);
		ventayu.setResizable(false);

		JLabel lbltitulo = new JLabel("DERIVADOR");
		lbltitulo.setFont(fuente1);
		lbltitulo.setBounds(178, 11, 349, 28);
		ventayu.add(lbltitulo);

		JLabel lblVersion = new JLabel("VERSION 1.0");
		lblVersion.setFont(fuente1);
		lblVersion.setBounds(190, 50, 167, 28);
		ventayu.add(lblVersion);

		JLabel logo = new JLabel("");
		logo.setBounds(10, 100, 240, 195);
		ImageIcon imagen = new ImageIcon("imagenes/logo.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
				logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
		logo.setIcon(icono);
		ventayu.add(logo);

		JLabel lblPerteneceA = new JLabel("PERTENECE A:");
		lblPerteneceA.setFont(fuente2);
		lblPerteneceA.setBounds(256, 97, 177, 28);
		ventayu.add(lblPerteneceA);

		JLabel lblAdrianConza = new JLabel("ADRIAN CONZA");
		lblAdrianConza.setFont(fuente3);
		lblAdrianConza.setBounds(266, 129, 155, 28);
		ventayu.add(lblAdrianConza);

		JLabel lblCelular = new JLabel("CELULAR:");
		lblCelular.setFont(fuente2);
		lblCelular.setBounds(256, 182, 177, 28);
		ventayu.add(lblCelular);

		JLabel cel = new JLabel("0999308011");
		cel.setFont(fuente3);
		cel.setBounds(266, 214, 155, 28);
		ventayu.add(cel);

		JLabel lblCorreo = new JLabel("CORREO:");
		lblCorreo.setFont(fuente2);
		lblCorreo.setBounds(256, 270, 177, 28);
		ventayu.add(lblCorreo);

		JLabel lblPacaconzagmailcom = new JLabel("pacaconza94@gmail.com");
		lblPacaconzagmailcom.setFont(fuente3);
		lblPacaconzagmailcom.setBounds(266, 302, 234, 28);
		ventayu.add(lblPacaconzagmailcom);

		JLabel lblCodigoFuente = new JLabel("CODIGO FUENTE:");
		lblCodigoFuente.setFont(fuente2);
		lblCodigoFuente.setBounds(10, 345, 193, 28);
		ventayu.add(lblCodigoFuente);

		JTextField caja1 = new JTextField(
				"");
		caja1.setEditable(false);
		caja1.setFont(new Font("Ravie", Font.PLAIN, 11));
		caja1.setBounds(5, 377, 510, 28);
		ventayu.add(caja1);

		ventayu.setVisible(true);
	}

	static void guardar(String sig) {
		Derivada = Cderivada.getText();
		Derivada += sig;
		Cderivada.setText(Derivada);
	}

	static void derivador() {
		DJep j = new DJep();
		// DJep es la clase encargada de la derivacion en su escencia
		j.addStandardConstants();
		// agrega constantes estandares, pi, e, etc
		j.addStandardFunctions();
		// agrega funciones estandares cos(x), sin(x)
		j.addComplex();
		// por si existe algun numero complejo
		j.setAllowUndeclared(true);
		// permite variables no declarables
		j.setAllowAssignment(true);
		// permite asignaciones
		j.setImplicitMul(true);
		// regla de multiplicacion o para sustraccion y sumas
		j.addStandardDiffRules();
		try {
			// coloca el nodo con una funcion preestablecida
			Node node = j.parse(Cderivada.getText());
			// deriva la funcion con respecto a x
			Node diff = j.differentiate(node, "x");
			// Simplificamos la funcion con respecto a x
			Node simp = j.simplify(diff);
			// Convertimos el valor simplificado en un String
			resp.setText(j.toString(simp));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE SINTAXIS", "ERROR",
					2, new ImageIcon("imagenes/logo.png"));
		}
	}
}