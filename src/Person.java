

import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//���࣬��������
public class Person {
	public static String keyword = "������Ϣ";

	public static File[] searchFile(File folder, final String keyWord) {// �ݹ���Ұ����ؼ��ֵ��ļ�

		File[] subFolders = folder.listFiles(new FileFilter() {// �����ڲ����������ļ�
			@Override
			public boolean accept(File pathname) {// ʵ��FileFilter���accept����
				int countFiles = 0;
				int countFolders = 0;
				if (pathname.isFile())// ������ļ�
					countFiles++;
				else
					// �����Ŀ¼
					countFolders++;
				if (pathname.isDirectory()
						|| (pathname.isFile() && pathname.getName().toLowerCase().contains(keyWord.toLowerCase())))// Ŀ¼���ļ������ؼ���
					return true;
				return false;
			}
		});

		ArrayList<File> result = new ArrayList<File>();// ����һ������
		for (int i = 0; i < subFolders.length; i++) {// ѭ����ʾ�ļ��л��ļ�
			if (subFolders[i].isFile()) {// ������ļ����ļ���ӵ�����б���
				result.add(subFolders[i]);
			} else {// ������ļ��У���ݹ���ñ�������Ȼ������е��ļ��ӵ�����б���
				File[] foldResult = searchFile(subFolders[i], keyWord);
				for (int j = 0; j < foldResult.length; j++) {// ѭ����ʾ�ļ�
					result.add(foldResult[j]);// �ļ����浽������
				}
			}
		}

		File files[] = new File[result.size()];// �����ļ����飬����Ϊ���ϵĳ���
		result.toArray(files);// �������黯
		return files;
	}
	// ���캯����

	public static void main(String[] args) {
		new begindemo("ҽ�����ı���ϵͳ");
		File folder = new File("D:/����");// Ĭ��Ŀ¼

		if (!folder.exists()) {// ����ļ��в�����
			System.out.println("Ŀ¼�����ڣ�" + folder.getAbsolutePath());
			return;
		}
		File[] result = Person.searchFile(folder, keyword);// ���÷�������ļ�����

		for (int i = 0; i < result.length; i++) {// ѭ����ʾ�ļ�
			File file = result[i];

			File file1 = new File(file.getAbsolutePath());

		}
	}
}

class begindemo extends JFrame {
	// ��¼���û���������
	private final String userName = "����";
	private final String password = "123456";
	// ������Ļ�Ŀ�ߣ����򴰿ڵĿ��
	private int windowWidth;
	private int windowHeight;
	private int screenSizeWidth;
	private int screenSizeHeight;
	static int countFiles = 0;// ����ͳ���ļ������ı���
	static int countFolders = 0;// ����ͳ���ļ��еı���

	public begindemo(String title) {
		super(title); // ���ñ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �����ܹرմ���
		this.setSize(600, 400); // ���ô��ڵĴ�С
		this.setLayout(null); // ���ó���Ĭ�ϲ��ָ�ʽΪ�գ��Ա��ں����Լ��򵥵����ò���
		this.setResizable(false); // ���ò�������
		init(); // ִ�г�ʼ�����������û��������������뵽����У�
		this.setVisible(true); // ʹ����ɼ�
	}

	public void init() {
		// ����Ļ�Ŀ�ȸ߶ȣ����򴰿ڵĿ�ȸ߶ȸ�ֵ
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		screenSizeWidth = (int) dimension.getWidth();
		screenSizeHeight = (int) dimension.getHeight();
		windowWidth = this.getWidth();
		windowHeight = this.getHeight();
		// ���ó��򴰿ڵ�λ��Ϊ��Ļ��������
		this.setLocation(screenSizeWidth / 2 - windowWidth / 2, screenSizeHeight / 2 - windowHeight / 2);

		// ��������������ı�ǩ
		JLabel username_label = new JLabel("���֤��");
		JLabel password_label = new JLabel("����");
		JLabel log = new JLabel("��ӭ����ҽ������ϵͳ��");

		// �����������������������
		final JTextField user_field = new JTextField();
		final JPasswordField password_field = new JPasswordField();

		// ������¼��ť
		JButton login_btn = new JButton("��¼");

		// ���ø�����ǩ�������Ĵ�С��λ��
		log.setBounds(150, -20, 500, 200);
		log.setFont(new Font("�����п�", Font.BOLD, 28));
		username_label.setBounds(100, 140, 100, 30);
		password_label.setBounds(100, 220, 100, 30);
		user_field.setBounds(200, 140, 300, 30);
		password_field.setBounds(200, 220, 300, 30);
		login_btn.setBounds(250, 300, 100, 50);

		this.add(username_label);
		this.add(password_label);
		this.add(user_field);
		this.add(password_field);
		this.add(login_btn);
		this.add(log);

		// ��¼��ť�ļ�����
		login_btn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			// ����ť������ʱ�Զ������������
			public void actionPerformed(ActionEvent event) {

				// ����û��������붼����ȷ�ģ���ô�����Ի�����ʾ��¼�ɹ������ҿ�����һ������ܣ���ҳ��
				if ((user_field.getText().equals(userName) || user_field.getText().equals("210010198808083324"))
						&& password_field.getText().equals(password)) {
					new People();
					File folder = new File("D:/ҽ��");
					// Ĭ��Ŀ¼
					if (!folder.exists()) {// ����ļ��в�����
						System.out.println("Ŀ¼�����ڣ�" + folder.getAbsolutePath());
						return;
					}
					File[] result = Person.searchFile(folder, Person.keyword);// ���÷�������ļ�����
					for (int i = 0; i < result.length; i++) {// ѭ����ʾ�ļ�
						File file = result[i];
						File file1 = new File(file.getAbsolutePath());
						// JOptionPane.showMessageDialog(null, "��¼�ɹ�", "login",
						// JOptionPane.INFORMATION_MESSAGE);

					}

				}

			}

			public String txt2String(File file1) {
				StringBuilder result = new StringBuilder();
				try {
					BufferedReader br = new BufferedReader(new FileReader(file1));// ����һ��BufferedReader������ȡ�ļ�
					String s = null;
					while ((s = br.readLine()) != null) {// ʹ��readLine������һ�ζ�һ��
						result.append(System.lineSeparator() + s);
					}
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result.toString();
			}
		});
	}
}
