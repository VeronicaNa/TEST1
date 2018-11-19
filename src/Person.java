

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

//主类，程序的入口
public class Person {
	public static String keyword = "基本信息";

	public static File[] searchFile(File folder, final String keyWord) {// 递归查找包含关键字的文件

		File[] subFolders = folder.listFiles(new FileFilter() {// 运用内部匿名类获得文件
			@Override
			public boolean accept(File pathname) {// 实现FileFilter类的accept方法
				int countFiles = 0;
				int countFolders = 0;
				if (pathname.isFile())// 如果是文件
					countFiles++;
				else
					// 如果是目录
					countFolders++;
				if (pathname.isDirectory()
						|| (pathname.isFile() && pathname.getName().toLowerCase().contains(keyWord.toLowerCase())))// 目录或文件包含关键字
					return true;
				return false;
			}
		});

		ArrayList<File> result = new ArrayList<File>();// 声明一个集合
		for (int i = 0; i < subFolders.length; i++) {// 循环显示文件夹或文件
			if (subFolders[i].isFile()) {// 如果是文件则将文件添加到结果列表中
				result.add(subFolders[i]);
			} else {// 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
				File[] foldResult = searchFile(subFolders[i], keyWord);
				for (int j = 0; j < foldResult.length; j++) {// 循环显示文件
					result.add(foldResult[j]);// 文件保存到集合中
				}
			}
		}

		File files[] = new File[result.size()];// 声明文件数组，长度为集合的长度
		result.toArray(files);// 集合数组化
		return files;
	}
	// 构造函数，

	public static void main(String[] args) {
		new begindemo("医保中心报销系统");
		File folder = new File("D:/张三");// 默认目录

		if (!folder.exists()) {// 如果文件夹不存在
			System.out.println("目录不存在：" + folder.getAbsolutePath());
			return;
		}
		File[] result = Person.searchFile(folder, keyword);// 调用方法获得文件数组

		for (int i = 0; i < result.length; i++) {// 循环显示文件
			File file = result[i];

			File file1 = new File(file.getAbsolutePath());

		}
	}
}

class begindemo extends JFrame {
	// 登录的用户名和密码
	private final String userName = "张三";
	private final String password = "123456";
	// 声明屏幕的宽高，程序窗口的宽高
	private int windowWidth;
	private int windowHeight;
	private int screenSizeWidth;
	private int screenSizeHeight;
	static int countFiles = 0;// 声明统计文件个数的变量
	static int countFolders = 0;// 声明统计文件夹的变量

	public begindemo(String title) {
		super(title); // 设置标题
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置能关闭窗口
		this.setSize(600, 400); // 设置窗口的大小
		this.setLayout(null); // 设置程序默认布局格式为空，以便于后期自己简单的设置布局
		this.setResizable(false); // 设置不可缩放
		init(); // 执行初始化函数（将用户名密码等组件加入到面板中）
		this.setVisible(true); // 使程序可见
	}

	public void init() {
		// 给屏幕的宽度高度，程序窗口的宽度高度赋值
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		screenSizeWidth = (int) dimension.getWidth();
		screenSizeHeight = (int) dimension.getHeight();
		windowWidth = this.getWidth();
		windowHeight = this.getHeight();
		// 设置程序窗口的位置为屏幕的正中央
		this.setLocation(screenSizeWidth / 2 - windowWidth / 2, screenSizeHeight / 2 - windowHeight / 2);

		// 声明姓名，密码的标签
		JLabel username_label = new JLabel("身份证号");
		JLabel password_label = new JLabel("密码");
		JLabel log = new JLabel("欢迎来到医保中心系统！");

		// 声明姓名输入框和密码输入框
		final JTextField user_field = new JTextField();
		final JPasswordField password_field = new JPasswordField();

		// 声明登录按钮
		JButton login_btn = new JButton("登录");

		// 设置各个标签和输入框的大小和位置
		log.setBounds(150, -20, 500, 200);
		log.setFont(new Font("华文行楷", Font.BOLD, 28));
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

		// 登录按钮的监听器
		login_btn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			// 当按钮被单击时自动调动这个方法
			public void actionPerformed(ActionEvent event) {

				// 如果用户名和密码都是正确的，那么弹出对话框显示登录成功，并且开启另一个主框架（主页）
				if ((user_field.getText().equals(userName) || user_field.getText().equals("210010198808083324"))
						&& password_field.getText().equals(password)) {
					new People();
					File folder = new File("D:/医保");
					// 默认目录
					if (!folder.exists()) {// 如果文件夹不存在
						System.out.println("目录不存在：" + folder.getAbsolutePath());
						return;
					}
					File[] result = Person.searchFile(folder, Person.keyword);// 调用方法获得文件数组
					for (int i = 0; i < result.length; i++) {// 循环显示文件
						File file = result[i];
						File file1 = new File(file.getAbsolutePath());
						// JOptionPane.showMessageDialog(null, "登录成功", "login",
						// JOptionPane.INFORMATION_MESSAGE);

					}

				}

			}

			public String txt2String(File file1) {
				StringBuilder result = new StringBuilder();
				try {
					BufferedReader br = new BufferedReader(new FileReader(file1));// 构造一个BufferedReader类来读取文件
					String s = null;
					while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
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
