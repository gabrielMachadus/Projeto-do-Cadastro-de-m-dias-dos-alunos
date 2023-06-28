package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

public class InterfacePessoa extends JFrame {

	private JTextField txtNome;
	private JLabel lblFoto;
	private JButton btnUploadFoto;
	private JFormattedTextField txtDataNascimento;
	private JButton btnUploadCurriculo;
	private JComboBox<String> comboTipo;
	private JLabel lblMensagem;
	private GridBagConstraints c_1;
	private GridBagConstraints c_2;
	private GridBagConstraints c_3;
	private GridBagConstraints c_4;
	private GridBagConstraints c_5;
	private GridBagConstraints c_6;
	private GridBagConstraints c_7;
	private GridBagConstraints c_8;
	private GridBagConstraints c_9;
	private GridBagConstraints c_10;
	private GridBagConstraints c_11;
	private GridBagConstraints c_12;
	private GridBagConstraints c_13;
	private GridBagConstraints c_14;
	private GridBagConstraints c_15;
	private GridBagConstraints c_16;
	private GridBagConstraints c_17;

	public InterfacePessoa() {
		setTitle("Formulário de Pessoa");
		setSize(700, 500);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		// Definição do layout usando o GridBagLayout
		getContentPane().setLayout(new GridBagLayout());

		// Foto
		JLabel lblFotoLabel = new JLabel("Foto:");
		c_3 = new GridBagConstraints();
		c_3.insets = new Insets(0, 0, 5, 5);
		c_3.gridx = 0;
		c_3.gridy = 0;
		c_3.anchor = GridBagConstraints.WEST;
		getContentPane().add(lblFotoLabel, c_3);
		lblFoto = new JLabel();
		String diretorioImagens = System.getProperty("user.dir") + "/src/view/util";
		String nomeImagem = "placeholder.png";
		String caminhoImagem = diretorioImagens + "/" + nomeImagem;
		
		// Verificar se o arquivo de imagem existe
		File imagem = new File(caminhoImagem);
		if (imagem.exists()) {
		    ImageIcon imagemIcone = new ImageIcon(imagem.getPath());
		    Image imagemOriginal = imagemIcone.getImage();
		    Image imagemRedimensionada = imagemOriginal.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		    ImageIcon imagemFinal = new ImageIcon(imagemRedimensionada);
		    lblFoto.setIcon(imagemFinal);
		}

		c_2 = new GridBagConstraints();
		c_2.fill = GridBagConstraints.HORIZONTAL;
		c_2.insets = new Insets(0, 0, 5, 5);
		c_2.gridx = 1;
		c_2.gridy = 0;
		getContentPane().add(lblFoto, c_2);
		btnUploadFoto = new JButton("Upload");
		btnUploadFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png");
				fileChooser.setFileFilter(filter);
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();

					// Verificar se o diretório "arquivos" existe e criar caso não exista
					String diretorio = System.getProperty("user.dir") + "/arquivos/fotos";
					File diretorioArquivos = new File(diretorio);
					if (!diretorioArquivos.exists()) {
						diretorioArquivos.mkdir();
					}
					
					String nomePessoa = "Foto_"+txtNome.getText().trim();
					nomePessoa  = nomePessoa.toLowerCase();
					String caminhoDestino = diretorio + "/" + nomePessoa
							+ selectedFile.getName().substring(selectedFile.getName().lastIndexOf('.'));
					File destino = new File(caminhoDestino);

					try {
						Files.copy(selectedFile.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
						ImageIcon imagemIcone = new ImageIcon(selectedFile.getPath());
						Image imagemOriginal = imagemIcone.getImage();
						Image imagemRedimensionada = imagemOriginal.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
						ImageIcon imagemFinal = new ImageIcon(imagemRedimensionada);
						// Exibir a imagem redimensionada no JLabel
						lblFoto.setIcon(imagemFinal);
						showMessage("Foto enviada: " + selectedFile.getName());
						
					} catch (IOException ex) {
						ex.printStackTrace();
						showMessage("Erro ao enviar foto.");
					}
				}
			}
		});

		c_4 = new GridBagConstraints();
		c_4.insets = new Insets(0, 0, 5, 5);
		c_4.gridx = 0;
		c_4.gridy = 1;
		c_4.anchor = GridBagConstraints.WEST;
		getContentPane().add(btnUploadFoto, c_4);

		// Configuração das propriedades GridBagConstraints
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(4, 4, 5, 5);

		// Nome Completo
		JLabel lblNome = new JLabel("Nome Completo:");

		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(lblNome, c);
		txtNome = new JTextField(20);
		txtNome.setPreferredSize(new Dimension(200, txtNome.getPreferredSize().height)); // Definir largura fixa

		c_1 = new GridBagConstraints();
		c_1.insets = new Insets(0, 0, 5, 5);
		c_1.gridx = 1;
		c_1.gridy = 3;
		c_1.anchor = GridBagConstraints.WEST;
		getContentPane().add(txtNome, c_1);

		// Data de Nascimento
		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");

		c_5 = new GridBagConstraints();
		c_5.insets = new Insets(0, 0, 5, 5);
		c_5.gridx = 0;
		c_5.gridy = 4;
		c_5.anchor = GridBagConstraints.WEST;
		getContentPane().add(lblDataNascimento, c_5);
		txtDataNascimento = new JFormattedTextField(createDateFormatter());
		txtDataNascimento.setPreferredSize(new Dimension(100, txtDataNascimento.getPreferredSize().height)); // Definir
																												// largura
																												// fixa
		txtDataNascimento.setFocusLostBehavior(JFormattedTextField.PERSIST);

		c_6 = new GridBagConstraints();
		c_6.insets = new Insets(0, 0, 5, 5);
		c_6.gridx = 1;
		c_6.gridy = 4;
		c_6.anchor = GridBagConstraints.WEST;
		getContentPane().add(txtDataNascimento, c_6);

		// Currículo
		JLabel lblCurriculo = new JLabel("Currículo:");

		c_7 = new GridBagConstraints();
		c_7.insets = new Insets(0, 0, 5, 5);
		c_7.gridx = 0;
		c_7.gridy = 5;
		c_7.anchor = GridBagConstraints.WEST;
		getContentPane().add(lblCurriculo, c_7);
		String[] tipos = { "Professor", "Aluno", "Coordenador" };
		btnUploadCurriculo = new JButton("Upload");
		btnUploadCurriculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos PDF", "pdf");
		        fileChooser.setFileFilter(filter);
		        int result = fileChooser.showOpenDialog(null);
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            String nomePessoa = txtNome.getText().trim();
		            String diretorio = System.getProperty("user.dir") + "/arquivos/curriculos";
		            File diretorioArquivos = new File(diretorio);
		            if (!diretorioArquivos.exists()) {
		                diretorioArquivos.mkdirs();
		            }

		            String nomeArquivo = "curriculo_" + nomePessoa + ".pdf";
		            String caminhoDestino = diretorio + "/" + nomeArquivo;
		            File destino = new File(caminhoDestino);

		            try {
		                Files.copy(selectedFile.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
		                showMessage("Currículo enviado: " + selectedFile.getName());
		            } catch (IOException ex) {
		                ex.printStackTrace();
		                showMessage("Erro ao enviar currículo.");
		            }
		        }
			}
		});

		c_8 = new GridBagConstraints();
		c_8.insets = new Insets(0, 0, 5, 5);
		c_8.gridx = 1;
		c_8.gridy = 5;
		c_8.anchor = GridBagConstraints.WEST;
		getContentPane().add(btnUploadCurriculo, c_8);

		// Tipo
		JLabel lblTipo = new JLabel("Tipo:");
		c_9 = new GridBagConstraints();
		c_9.insets = new Insets(0, 0, 5, 5);
		c_9.gridx = 0;
		c_9.gridy = 6;
		c_9.anchor = GridBagConstraints.WEST;
		getContentPane().add(lblTipo, c_9);

		// Botões de navegação
		JButton btnNovo = new JButton("Novo");
		JButton btnEditar = new JButton("Editar");
		JButton btnRemover = new JButton("Remover");
		JButton btnPrimeiro = new JButton("|<");
		JButton btnAnterior = new JButton("<");
		JButton btnProximo = new JButton(">");
		JButton btnUltimo = new JButton(">|");
		comboTipo = new JComboBox<>(tipos);

		c_10 = new GridBagConstraints();
		c_10.insets = new Insets(0, 0, 5, 5);
		c_10.gridx = 1;
		c_10.gridy = 6;
		c_10.anchor = GridBagConstraints.WEST;
		getContentPane().add(comboTipo, c_10);

		c_11 = new GridBagConstraints();
		c_11.insets = new Insets(0, 0, 5, 5);
		c_11.gridx = 0;
		c_11.gridy = 8;
		c_11.anchor = GridBagConstraints.WEST;
		getContentPane().add(btnNovo, c_11);

		c_12 = new GridBagConstraints();
		c_12.insets = new Insets(0, 0, 5, 5);
		c_12.gridx = 1;
		c_12.gridy = 8;
		c_12.anchor = GridBagConstraints.WEST;
		getContentPane().add(btnEditar, c_12);

		c_13 = new GridBagConstraints();
		c_13.insets = new Insets(0, 0, 5, 5);
		c_13.gridx = 2;
		c_13.gridy = 8;
		c_13.anchor = GridBagConstraints.WEST;
		getContentPane().add(btnRemover, c_13);

		c_14 = new GridBagConstraints();
		c_14.insets = new Insets(0, 0, 5, 5);
		c_14.gridx = 0;
		c_14.gridy = 9;
		c_14.anchor = GridBagConstraints.WEST;
		getContentPane().add(btnPrimeiro, c_14);

		c_15 = new GridBagConstraints();
		c_15.insets = new Insets(0, 0, 5, 5);
		c_15.gridx = 1;
		c_15.gridy = 9;
		c_15.anchor = GridBagConstraints.WEST;
		getContentPane().add(btnAnterior, c_15);

		c_16 = new GridBagConstraints();
		c_16.insets = new Insets(0, 0, 5, 5);
		c_16.gridx = 2;
		c_16.gridy = 9;
		c_16.anchor = GridBagConstraints.WEST;
		getContentPane().add(btnProximo, c_16);

		c_17 = new GridBagConstraints();
		c_17.insets = new Insets(0, 0, 5, 0);
		c_17.gridx = 4;
		c_17.gridy = 9;
		c_17.anchor = GridBagConstraints.WEST;
		getContentPane().add(btnUltimo, c_17);

		// Mensagem
		lblMensagem = new JLabel();
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 5;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(lblMensagem, c);

		setVisible(true);
	}

	private MaskFormatter createDateFormatter() {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("##/##/####");
			formatter.setPlaceholderCharacter('_');
			formatter.setValidCharacters("0123456789");
			formatter.setAllowsInvalid(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatter;
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InterfacePessoa();
			}
		});
	}
}
