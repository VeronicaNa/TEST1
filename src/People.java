


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.io.*;

public class People {
	   
	   public static void main(String[] args) {
			new People();
	   }
	   public People(){
		new MainFrame().setVisible(true);
	   }
	   public String person[][]=new String[100][7];   //储存个人信息
	   public String drug[][]=new String[100][5];     //储存药品信息
	   int count=0;                                   //药品数量
	   int cou=0;                                     //人数
	   class MainFrame extends JFrame implements ActionListener{
		   JButton button1,button2,button3,button4;
	       JPanel jp=new JPanel();
	       JLabel label;
		   public MainFrame() {
			    super("主界面");
			    jp.setLayout(null);
	    		add(jp);
	    		label=new JLabel("医疗报销管理系统");
	    		label.setFont(new Font("华文行楷", Font.PLAIN, 28));
	    		label.setForeground(Color.black);
	    		label.setBounds(180, 50, 250, 30);
	    		jp.add(label);
	    		setVisible(true);
	    		setResizable(false); 
	    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(300, 300, 600, 400);
				
				button1=new JButton("中心报销");
				button2=new JButton("报销查询");
				button3=new JButton("人员信息");
				button4=new JButton("医疗项目");
				
				button1.setBounds(120, 120, 110, 40);
	    	    button2.setBounds(330, 120, 110, 40);
	    	    button3.setBounds(120, 200, 110, 40);
	    	    button4.setBounds(330, 200, 110, 40);
	    	    
	    	    jp.add(button1);
	    	    jp.add(button2);
	    	    jp.add(button3);
	    	    jp.add(button4);
	    	    
	    	    button1.addActionListener(this);
	    	    button2.addActionListener(this);
	    	    button3.addActionListener(this);
	    	    button4.addActionListener(this);
		   }
	    	    
	    	    public void actionPerformed(ActionEvent e){
	        		if(e.getSource()==button1){             
	        			new Reimbursement().setVisible(true);
	        		}
	        		else if(e.getSource()==button2){
	        			new SearchR().setVisible(true);
	        		}
	        		else if(e.getSource()==button3){
	        			new PInfo().setVisible(true);
	        		}
	        		else if(e.getSource()==button4){
	        			new DInfo().setVisible(true);
	        		}
	    	    }
			   
	   }
	   
	   class PInfo extends JFrame implements ActionListener{
		   JButton button1,button2,button3,button4,button5;
		   JPanel jp=new JPanel();
	    	JLabel label;
	    	public PInfo(){
	    		super("人员信息管理");
	    		jp.setLayout(null);
	    		add(jp);

	    		setVisible(true);
	    		setResizable(false);
	    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		setBounds(350,250,400,300);
	    		
	    		button1=new JButton("增加人员");
	    		button2=new JButton("删除人员信息");
	    		button3=new JButton("修改人员信息");
	    		button4=new JButton("人员查询");
	    		button5=new JButton("返回");
	    		
	    		button1.setBounds(50,60,115,38);
	    	    button2.setBounds(50,130,115,38);
	    	    button3.setBounds(220,60,115,38);
	    	    button4.setBounds(220,130,115,38);
	    	    button5.setBounds(160,220,60,30);
	    	    
	    	    jp.add(button1);
	    	    jp.add(button2);
	    	    jp.add(button3);
	    	    jp.add(button4);
	    	    jp.add(button5);
	    	    
	    	    button1.addActionListener(this);
	    	    button2.addActionListener(this);
	    	    button3.addActionListener(this);
	    	    button4.addActionListener(this);
	    	    button5.addActionListener(this);
	    	}
	    	    
	    	    public void actionPerformed(ActionEvent e){
	        		if(e.getSource()==button1){             
	        			new AddPerson().setVisible(true);
	        		}
	        		else if(e.getSource()==button2){
	        			new DeletePerson().setVisible(true);
	        		}
	        		else if(e.getSource()==button3){
	        			new RevisePerson().setVisible(true);
	        		}
	        		else if(e.getSource()==button4){
	        			new SearchPerson().setVisible(true);
	        		}
	        		else if(e.getSource()==button5){
	        			dispose();
	        		}
	    	    }
	   }                                                       //人员信息界面结束
	   
	   //实现增加人员对象的窗口
	   class AddPerson extends JFrame implements ActionListener{ 
		    JLabel label1 = new JLabel("添加基本信息",JLabel.CENTER);
		    JLabel labID=new JLabel("ID：",JLabel.CENTER);
		    JLabel labName=new JLabel("姓名：",JLabel.CENTER);
		    JLabel labsex = new JLabel("性别：",JLabel.CENTER);
		    JLabel labcatagory=new JLabel("医疗人员类别：",JLabel.CENTER);
		    JLabel labprompt=new JLabel("（填写在职职工、退休人员或其它）",JLabel.CENTER);
		    JLabel labinstitution=new JLabel("定点医疗机构：",JLabel.CENTER);

		    JTextField txtID=new JTextField(20);
		    JTextField txtName=new JTextField(20);
		    JTextField txtSex=new JTextField(18);		    
            JTextField txtCatagory=new JTextField(20);
		    JTextField txtInstitution=new JTextField(20);

		    JButton btnAdd=new JButton("添加");
		    JButton btnCancel=new JButton("返回");
		    JButton btnReset = new JButton("重置");
		    JPanel jpl=new JPanel();
		    File file=new File("D://医保","人员.txt");  //打开文件
		    
			public AddPerson(){
				super("添加人员信息");
				this.setResizable(false);
				this.setSize(510,400);
				this.setVisible(true);
				this.setLocation(300,300);
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.add(jpl);
				jpl.setLayout(null);
				btnAdd.addActionListener(this);
				btnReset.addActionListener(this);
				btnCancel.addActionListener(this);
				
				jpl.setBackground(Color.pink);
				label1.setBounds(100,20,300,20);
				label1.setFont(new Font("华文行楷", Font.PLAIN, 20));
				jpl.add(label1);
				labID.setBounds(100,50,70,20);
				jpl.add(labID);
				txtID.setBounds(190,50,140,20);
				jpl.add(txtID);
				labName.setBounds(100,90,70,20);
				jpl.add(labName);
				txtName.setBounds(190,90,140,20);
				jpl.add(txtName);
				labsex.setBounds(100,130,60,20);
				jpl.add(labsex);
				txtSex.setBounds(190,130,140,20);
				jpl.add(txtSex);
			    labcatagory.setBounds(100,170,100,20);
				jpl.add(labcatagory);
				txtCatagory.setBounds(190,170,140,20);
				jpl.add(txtCatagory);
				labprompt.setBounds(100,190,250,20);
				jpl.add(labprompt);
				labinstitution.setBounds(100,220,100,20);
				jpl.add(labinstitution);
				txtInstitution.setBounds(190,220,140,20);
				jpl.add(txtInstitution);
				btnReset.setBounds(80,320,90,20);
				btnAdd.setBounds(200,320,90,20);
				btnCancel.setBounds(320,320,90,20);
				jpl.add(btnReset);
				jpl.add(btnAdd);
				jpl.add(btnCancel);

				try{
					file.createNewFile();
				}
				catch(Exception e){}
			}
				
			public void actionPerformed(ActionEvent ee){
		    	if(ee.getSource()==btnReset){        //重置
		    		   txtID.setText(null);
		    		   txtName.setText(null);
		    		   txtSex.setText(null);
		    		   txtCatagory.setText(null);
		    		   txtInstitution.setText(null);
		    	}
		    	
		    	if(ee.getSource()==btnCancel){     //返回
		    		dispose();
		    	}
		    	
		    	if(ee.getSource()==btnAdd){
	    			boolean bool=false;
	    			for(int i=0;i<cou;i++){
	    				String temp=txtID.getText();
	    				if(temp.equals(person[i][0])){     //判断ID是否已存在
	    					bool=true;
	    					break;
	    				}
	    			}
	    			if(bool){                                   //若ID已经存在 错误提示
	    				JOptionPane.showMessageDialog(null, "ID重复，请重新输入", "错误提示", JOptionPane.INFORMATION_MESSAGE);
	    				txtID.setText(null);
	    				
	    			}
	    			else{
		    		    if (txtID.getText().toString().equals("")){
		  		           JOptionPane.showMessageDialog(null, "请输入ID", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		  		         }
		                 else if (txtName.getText().toString().equals("")){
		  		            JOptionPane.showMessageDialog(null, "请输入姓名", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		  		         }
		                 else if (txtSex.getText().toString().equals("")){
		  		            JOptionPane.showMessageDialog(null, "请输入性别", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		  		         }
		                 else if (txtCatagory.getText().toString().equals("")){
		  		             JOptionPane.showMessageDialog(null, "请输入医疗人员类别", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		  		         }
		                 else if (txtInstitution.getText().toString().equals("")){
		  		            JOptionPane.showMessageDialog(null, "请输入定点医疗机构", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		                 }

		                 else{
		    		       int j=0;
		    		       person[cou][j++]=txtID.getText();
		    		       person[cou][j++]=txtName.getText();
		    		       person[cou][j++]=txtSex.getText();
		    		       person[cou][j++]=txtCatagory.getText();
		    		       person[cou][j++]=txtInstitution.getText();
		    		       person[cou][6]="0";

		    		       cou++;                                  //数组中学生信息的个数加一
		    		       
		    		       byte a[]=txtID.getText().getBytes();
		    		       byte b[]=txtName.getText().getBytes();
		    		       byte c[]=txtSex.getText().getBytes();
		    		       byte d[]=txtCatagory.getText().getBytes();
		    		       byte e[]=txtInstitution.getText().getBytes();

		    		  
		    		       try{
		    			      FileOutputStream out=new FileOutputStream(file,true);  //把学生信息写入文件
		    			      out.write(a);
		    			      out.write('\t');
		    			      out.write(b);
		    			      out.write('\t');
		    			      out.write(c);
		    		    	  out.write('\t');
		    			      out.write(d);
		    			      out.write('\t');
		    			      out.write(e);
		    			      out.write('\t');
		    			      out.close();
		    			   
		    		      }
		    		       catch(IOException e1){}
		    		       JOptionPane.showMessageDialog(null,"已成功添加","温馨提示",JOptionPane.INFORMATION_MESSAGE);
		    		       txtName.setText(null);
		    		       txtSex.setText("男");       //设置默认值为男
		    		       txtCatagory.setText(null);
		    		       txtInstitution.setText(null);
		    		       int temp=Integer.parseInt(txtID.getText());
		    		       temp++;                                              //实现ID自动编号功能，也就是自动加一
		    		       txtID.setText(String.valueOf(temp));
		                 }
		            }
		    	}
		   }
	}
	   
	   
	   class SearchPerson extends JFrame implements ActionListener{      //实现人员对象删除和查询的窗口
		   JPanel jpl = new JPanel();
    	   JLabel SCH = new JLabel("查询人员信息",JLabel.CENTER);
    	   Font f = new Font("楷体",Font.BOLD+Font.ITALIC,30);
    	   JLabel labelID = new JLabel("请输入ID：",JLabel.CENTER);
    	   JButton btnQuery = new JButton("查询");
    	   JLabel labelname = new JLabel("姓名：",JLabel.CENTER);
    	   JLabel labelsex = new JLabel("性别：",JLabel.CENTER);
    	   JLabel labelcatagory = new JLabel("医疗人员类别：",JLabel.CENTER);
    	   JLabel labelinstitution = new JLabel("定点医疗机构：",JLabel.CENTER);
    	   JTextField number = new JTextField();
    	   JTextField name = new JTextField();
     	   JTextField sex = new JTextField();   	   
     	   JTextField catagory = new JTextField();
    	   JTextField institution = new JTextField();

    	   JButton btnDelete = new JButton("删除");
    	   JButton btnCancel = new JButton("取消");
    	
    	public SearchPerson(){
    		super("查询或删除人员信息");
    	    this.setSize(500,350);
    	    setLocation(300,300);
    		this.setVisible(true);
    		this.setResizable(false);
    		SCH.setForeground(Color.red);
    		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		this.add(jpl);
    		jpl.setBackground(Color.gray);
    		
    		jpl.setLayout(null);
    		btnQuery.addActionListener(this);
    	    btnDelete.addActionListener(this);
    		btnCancel.addActionListener(this);
    		SCH.setBounds(100,20,300,20);
    		SCH.setFont(new Font("华文行楷", Font.PLAIN, 20));
    		jpl.add(SCH);
    		labelID.setBounds(100,60,100,20);
    		jpl.add(labelID);
    		number.setBounds(220,60,140,20);
    		jpl.add(number);
    		btnQuery.setBounds(120,100,90,20);
    	    btnDelete.setBounds(230,100,90,20);
    		btnCancel.setBounds(340,100,90,20);
    		jpl.add(btnQuery);
    		jpl.add(btnDelete);
    		jpl.add(btnCancel);
    		labelname.setBounds(100,150,95,20);
    		jpl.add(labelname);
    		name.setBounds(205,150,140,20);
    		jpl.add(name);
    		labelsex.setBounds(100,180,95,20);
    		jpl.add(labelsex);
    		sex.setBounds(205,180,140,20);
    		jpl.add(sex);
    		labelcatagory.setBounds(100,210,95,20);
    		jpl.add(labelcatagory);
    		catagory.setBounds(205,210,140,20);
    		jpl.add(catagory);
    		labelinstitution.setBounds(100,240,95,20);
    		jpl.add(labelinstitution);
    		institution.setBounds(205,240,140,20);
    		jpl.add(institution);

    		
    		btnDelete.setEnabled(false);    //取消删除按钮的功能
    	    name.setEditable(false);
    	    sex.setEditable(false);
    	    catagory.setEditable(false);
    	    institution.setEditable(false);
    	    setVisible(true);
    	    number.requestFocus();
    	}
            
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==btnQuery){            //查询操作
    			String temp=number.getText();
    			boolean bool=true;
    			for(int i=0;i<cou;i++){
    				if(temp.equals(person[i][0])){        //如果存在该查找的ID执行
    					name.setText(person[i][1]);
    					sex.setText(person[i][2]);
    					catagory.setText(person[i][3]);
    					institution.setText(person[i][4]);
    					bool=false;
    					btnDelete.setEnabled(true);
    					break;
    				}
    			 }
				 if(bool){
					 JOptionPane.showMessageDialog(null,"不存在记录，请重新输入!","温馨提示",JOptionPane.INFORMATION_MESSAGE);
						number.setText(null);
						name.setText(null);
						sex.setText(null);
						catagory.setText(null);
						institution.setText(null);
					    btnDelete.setEnabled(false);
    			}
    		}
    		if(e.getSource()==btnCancel){      //返回
    			 dispose();
    		}
    		if(e.getSource()==btnDelete){
    			String temp=number.getText();
    			for(int i=0;i<cou;i++){
    				if(temp.equals(person[i][0])){
    					for(int j=0;j<5;j++){
    						person[i][j]=null;      //删除操作
    				    }
                            JOptionPane.showMessageDialog(null,"记录删除","温馨提示",JOptionPane.INFORMATION_MESSAGE);
                            break;
    				}
    			}
				
				
				number.setText(null);
				name.setText(null);
				sex.setText(null);
				catagory.setText(null);
				institution.setText(null);

    		}
    	}
	   }
	
	   
	   class DeletePerson extends JFrame implements ActionListener{      //实现人员对象删除和查询的窗口
		   JPanel jpl = new JPanel();
    	   JLabel SCH = new JLabel("删除人员信息",JLabel.CENTER);
    	   Font f = new Font("楷体",Font.BOLD+Font.ITALIC,30);
    	   JLabel labelID = new JLabel("请输入ID：",JLabel.CENTER);
    	   JButton btnQuery = new JButton("查询");
    	   JLabel labelname = new JLabel("姓名：",JLabel.CENTER);
    	   JLabel labelsex = new JLabel("性别：",JLabel.CENTER);
    	   JLabel labelcatagory = new JLabel("医疗人员类别：",JLabel.CENTER);
    	   JLabel labelinstitution = new JLabel("定点医疗机构：",JLabel.CENTER);
    	   JTextField number = new JTextField();
    	   JTextField name = new JTextField();
     	   JTextField sex = new JTextField();   	   
     	   JTextField catagory = new JTextField();
    	   JTextField institution = new JTextField();

    	   JButton btnDelete = new JButton("删除");
    	   JButton btnCancel = new JButton("取消");
    	
    	public DeletePerson(){
    		super("查询或删除人员信息");
    	    this.setSize(500,350);
    	    setLocation(300,300);
    		this.setVisible(true);
    		this.setResizable(false);
    		SCH.setForeground(Color.red);
    		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		this.add(jpl);
    		jpl.setBackground(Color.gray);
    		
    		jpl.setLayout(null);
    		btnQuery.addActionListener(this);
    	    btnDelete.addActionListener(this);
    		btnCancel.addActionListener(this);
    		SCH.setBounds(100,20,300,20);
    		SCH.setFont(new Font("华文行楷", Font.PLAIN, 20));
    		jpl.add(SCH);
    		labelID.setBounds(100,60,100,20);
    		jpl.add(labelID);
    		number.setBounds(220,60,140,20);
    		jpl.add(number);
    		btnQuery.setBounds(120,100,90,20);
    	    btnDelete.setBounds(230,100,90,20);
    		btnCancel.setBounds(340,100,90,20);
    		jpl.add(btnQuery);
    		jpl.add(btnDelete);
    		jpl.add(btnCancel);
    		labelname.setBounds(100,150,95,20);
    		jpl.add(labelname);
    		name.setBounds(205,150,140,20);
    		jpl.add(name);
    		labelsex.setBounds(100,180,95,20);
    		jpl.add(labelsex);
    		sex.setBounds(205,180,140,20);
    		jpl.add(sex);
    		labelcatagory.setBounds(100,210,95,20);
    		jpl.add(labelcatagory);
    		catagory.setBounds(205,210,140,20);
    		jpl.add(catagory);
    		labelinstitution.setBounds(100,240,95,20);
    		jpl.add(labelinstitution);
    		institution.setBounds(205,240,140,20);
    		jpl.add(institution);


    		
    		btnDelete.setEnabled(false);    //取消删除按钮的功能
    	    name.setEditable(false);
    	    sex.setEditable(false);
    	    catagory.setEditable(false);
    	    institution.setEditable(false);;
    	    setVisible(true);
    	    number.requestFocus();
    	}
            
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==btnQuery){            //查询操作
    			String temp=number.getText();
    			boolean bool=true;
    			for(int i=0;i<cou;i++){
    				if(temp.equals(person[i][0])){        //如果存在该查找的ID执行
    					name.setText(person[i][1]);
    					sex.setText(person[i][2]);
    					catagory.setText(person[i][3]);
    					institution.setText(person[i][4]);
    					bool=false;
    					btnDelete.setEnabled(true);
    					break;
    				}
    			 }
				 if(bool){
					 JOptionPane.showMessageDialog(null,"不存在记录，请重新输入!","温馨提示",JOptionPane.INFORMATION_MESSAGE);
						number.setText(null);
						name.setText(null);
						sex.setText(null);
						catagory.setText(null);
						institution.setText(null);
					    btnDelete.setEnabled(false);
    			}
    		}
    		if(e.getSource()==btnCancel){      //返回
    			 dispose();
    		}
    		if(e.getSource()==btnDelete){
    			String temp=number.getText();
    			for(int i=0;i<cou;i++){
    				if(temp.equals(person[i][0])){
    					for(int j=0;j<5;j++){
    						person[i][j]=null;      //删除操作
    				    }
                            JOptionPane.showMessageDialog(null,"记录删除","温馨提示",JOptionPane.INFORMATION_MESSAGE);
                            break;
    				}
    			}
				

				number.setText(null);
				name.setText(null);
				sex.setText(null);
				catagory.setText(null);
				institution.setText(null);


    		}
    	}
	   }
	   
	   
	   class RevisePerson extends JFrame implements ActionListener{      //实现人员对象修改的窗口
		   JPanel jpl = new JPanel();
    	   JLabel SCH = new JLabel("查询人员信息",JLabel.CENTER);
    	   Font f = new Font("楷体",Font.BOLD+Font.ITALIC,30);
    	   JLabel labelID = new JLabel("请输入ID：",JLabel.CENTER);
    	   JButton btnQuery = new JButton("查询");
    	   JLabel labelname = new JLabel("姓名：",JLabel.CENTER);
    	   JLabel labelsex = new JLabel("性别：",JLabel.CENTER);
    	   JLabel labelcatagory = new JLabel("医疗人员类别：",JLabel.CENTER);
    	   JLabel labelinstitution = new JLabel("定点医疗机构：",JLabel.CENTER);
    	   JTextField number = new JTextField();
    	   JTextField name = new JTextField();
     	   JTextField sex = new JTextField();   	   
     	   JTextField catagory = new JTextField();
    	   JTextField institution = new JTextField();

    	   JButton btnDelete = new JButton("删除");
    	   JButton btnCancel = new JButton("取消");
    	
    	public RevisePerson(){
    		super("查询或删除人员信息");
    	    this.setSize(500,350);
    	    setLocation(300,300);
    		this.setVisible(true);
    		this.setResizable(false);
    		SCH.setForeground(Color.red);
    		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		this.add(jpl);
    		jpl.setBackground(Color.gray);
    		
    		jpl.setLayout(null);
    		btnQuery.addActionListener(this);
    	    btnDelete.addActionListener(this);
    		btnCancel.addActionListener(this);
    		SCH.setBounds(100,20,300,20);
    		SCH.setFont(new Font("华文行楷", Font.PLAIN, 20));
    		jpl.add(SCH);
    		labelID.setBounds(100,60,100,20);
    		jpl.add(labelID);
    		number.setBounds(220,60,140,20);
    		jpl.add(number);
    		btnQuery.setBounds(120,100,90,20);
    	    btnDelete.setBounds(230,100,90,20);
    		btnCancel.setBounds(340,100,90,20);
    		jpl.add(btnQuery);
    		jpl.add(btnDelete);
    		jpl.add(btnCancel);
    		labelname.setBounds(100,150,95,20);
    		jpl.add(labelname);
    		name.setBounds(205,150,140,20);
    		jpl.add(name);
    		labelsex.setBounds(100,180,95,20);
    		jpl.add(labelsex);
    		sex.setBounds(205,180,140,20);
    		jpl.add(sex);
    		labelcatagory.setBounds(100,210,95,20);
    		jpl.add(labelcatagory);
    		catagory.setBounds(205,210,140,20);
    		jpl.add(catagory);
    		labelinstitution.setBounds(100,240,95,20);
    		jpl.add(labelinstitution);
    		institution.setBounds(205,240,140,20);
    		jpl.add(institution);


    		
    		btnDelete.setEnabled(false);    //取消删除按钮的功能
    	    name.setEditable(false);
    	    sex.setEditable(false);
    	    catagory.setEditable(false);
    	    institution.setEditable(false);;
    	    setVisible(true);
    	    number.requestFocus();
    	}
            
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==btnQuery){            //查询操作
    			String temp=number.getText();
    			boolean bool=true;
    			for(int i=0;i<cou;i++){
    				if(temp.equals(person[i][0])){        //如果存在该查找的ID执行
    					name.setText(person[i][1]);
    					sex.setText(person[i][2]);
    					catagory.setText(person[i][3]);
    					institution.setText(person[i][4]);
    					bool=false;
    					btnDelete.setEnabled(true);
    					break;
    				}
    			 }
				 if(bool){
					 JOptionPane.showMessageDialog(null,"不存在记录，请重新输入!","温馨提示",JOptionPane.INFORMATION_MESSAGE);
						number.setText(null);
						name.setText(null);
						sex.setText(null);
						catagory.setText(null);
						institution.setText(null);
					    btnDelete.setEnabled(false);
    			}
    		}
    		if(e.getSource()==btnCancel){      //返回
    			 dispose();
    		}
    		
    		
    		
    		
    		
    		if(e.getSource()==btnDelete){
    			String temp=number.getText();
    			for(int i=0;i<cou;i++){
    				if(temp.equals(person[i][0])){
    					for(int j=0;j<5;j++){
    						person[i][j]=null;      //删除操作
    				    }
                            JOptionPane.showMessageDialog(null,"记录删除","温馨提示",JOptionPane.INFORMATION_MESSAGE);
                            break;
    				}
    			}
				
				number.setText(null);
				name.setText(null);
				sex.setText(null);
				catagory.setText(null);
				institution.setText(null);


    		}
    	}
	   }
	   
	   
	   class DInfo extends JFrame implements ActionListener{
		   JButton button1,button2,button3,button4,button5;
		   JPanel jp=new JPanel();
	    	JLabel label;
	    	public DInfo(){
	    		super("药品信息管理");
	    		jp.setLayout(null);
	    		add(jp);

	    		setVisible(true);
	    		setResizable(false);
	    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		setBounds(350,250,400,300);
	    		
	    		button1=new JButton("增加药品");
	    		button2=new JButton("删除药品信息");
	    		button3=new JButton("修改药品信息");
	    		button4=new JButton("药品查询");
	    		button5=new JButton("返回");
	    		
	    		button1.setBounds(50,50,115,38);
	    	    button2.setBounds(50,150,115,38);
	    	    button3.setBounds(220,50,115,38);
	    	    button4.setBounds(220,150,115,38);
	    	    button5.setBounds(275,220,60,30);
	    	    
	    	    jp.add(button1);
	    	    jp.add(button2);
	    	    jp.add(button3);
	    	    jp.add(button4);
	    	    jp.add(button5);
	    	    
	    	    button1.addActionListener(this);
	    	    button2.addActionListener(this);
	    	    button3.addActionListener(this);
	    	    button4.addActionListener(this);
	    	    button5.addActionListener(this);
	    	}
	    	    
	    	    public void actionPerformed(ActionEvent e){
	        		if(e.getSource()==button1){             
	        			new AddDrug().setVisible(true);
	        		}
	        		else if(e.getSource()==button2){
	        			new DeleteDrug().setVisible(true);
	        		}
	        		else if(e.getSource()==button3){
	        			new ReviseDrug().setVisible(true);
	        		}
	        		else if(e.getSource()==button4){
	        			new SearchDrug().setVisible(true);
	        		}
	        		else if(e.getSource()==button5){
	        			dispose();
	        		}
	    	    }
	   }                                                       //药品信息界面结束
	   
	   
	   class AddDrug extends JFrame implements ActionListener{          //实现增加药品对象的窗口
		    JLabel label1 = new JLabel("添加基本信息",JLabel.CENTER);
		    JLabel labCode=new JLabel("编码：",JLabel.CENTER);
		    JLabel labName=new JLabel("名称：",JLabel.CENTER);
		    JLabel labprice = new JLabel("单价：",JLabel.CENTER);
		    JLabel labcatagory=new JLabel("收费类别：",JLabel.CENTER);
		    JLabel labprompt=new JLabel("（输入甲、乙或丙）",JLabel.CENTER);
		    JLabel labgrade=new JLabel("医院等级：",JLabel.CENTER);

		    JTextField txtCode=new JTextField(20);
		    JTextField txtName=new JTextField(20);
		    JTextField txtPrice=new JTextField(18);		    
            JTextField txtCatagory=new JTextField(20);
		    JTextField txtGrade=new JTextField(20);

		    JButton btnAdd=new JButton("添加");
		    JButton btnCancel=new JButton("返回");
		    JButton btnReset = new JButton("重置");
		    JPanel jpl=new JPanel();
		    File file=new File("D:/医保","药品.txt");  //打开文件
		    
			public AddDrug(){
				super("添加药品信息");
				this.setResizable(false);
				this.setSize(510,400);
				this.setVisible(true);
				this.setLocation(300,300);
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.add(jpl);
				jpl.setLayout(null);
				btnAdd.addActionListener(this);
				btnReset.addActionListener(this);
				btnCancel.addActionListener(this);
				
				jpl.setBackground(Color.cyan);
				label1.setBounds(100,20,300,20);
				label1.setFont(new Font("华文行楷", Font.PLAIN, 20));
				jpl.add(label1);
				labCode.setBounds(100,50,70,20);
				jpl.add(labCode);
				txtCode.setBounds(190,50,140,20);
				jpl.add(txtCode);
				labName.setBounds(100,90,70,20);
				jpl.add(labName);
				txtName.setBounds(190,90,140,20);
				jpl.add(txtName);
				labprice.setBounds(100,130,60,20);
				jpl.add(labprice);
				txtPrice.setBounds(190,130,140,20);
				jpl.add(txtPrice);
			    labcatagory.setBounds(100,170,100,20);
				jpl.add(labcatagory);
				txtCatagory.setBounds(190,170,140,20);
				jpl.add(txtCatagory);
				labprompt.setBounds(100,200,140,20);
				jpl.add(labprompt);
				labgrade.setBounds(100,230,100,20);
				jpl.add(labgrade);
				txtGrade.setBounds(190,230,140,20);
				jpl.add(txtGrade);
				btnReset.setBounds(80,320,90,20);
				btnAdd.setBounds(200,320,90,20);
				btnCancel.setBounds(320,320,90,20);
				jpl.add(btnReset);
				jpl.add(btnAdd);
				jpl.add(btnCancel);

				try{
					file.createNewFile();
				}
				catch(Exception e){}
			}
				
			public void actionPerformed(ActionEvent ee){
		    	if(ee.getSource()==btnReset){        //重置
		    		   txtCode.setText(null);
		    		   txtName.setText(null);
		    		   txtPrice.setText(null);
		    		   txtCatagory.setText(null);
		    		   txtGrade.setText(null);
		    	}
		    	
		    	if(ee.getSource()==btnCancel){     //返回
		    		dispose();
		    	}
		    	
		    	if(ee.getSource()==btnAdd){
	    			boolean bool=false;
	    			for(int i=0;i<count;i++){
	    				String temp=txtCode.getText();
	    				if(temp.equals(drug[i][0])){     //判断编码是否已存在
	    					bool=true;
	    					break;
	    				}
	    			}
	    			if(bool){                                   //若编码已经存在  错误提示
	    				JOptionPane.showMessageDialog(null, "编码重复，请重新输入", "错误提示", JOptionPane.INFORMATION_MESSAGE);
	    				txtCode.setText(null);
	    				
	    			}
	    			else{
		    		    if (txtCode.getText().toString().equals("")){
		  		           JOptionPane.showMessageDialog(null, "请输入编码", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		  		         }
		                 else if (txtName.getText().toString().equals("")){
		  		            JOptionPane.showMessageDialog(null, "请输入姓名", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		  		         }
		                 else if (txtPrice.getText().toString().equals("")){
		  		            JOptionPane.showMessageDialog(null, "请输入单价", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		  		         }
		                 else if (txtCatagory.getText().toString().equals("")){
		  		             JOptionPane.showMessageDialog(null, "请输入收费类别", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		  		         }
		                 else if (txtGrade.getText().toString().equals("")){
		  		            JOptionPane.showMessageDialog(null, "请输入医院等级", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
		                 }

		                 else{
		    		       int j=0;
		    		       drug[count][j++]=txtCode.getText();
		    		       drug[count][j++]=txtName.getText();
		    		       drug[count][j++]=txtPrice.getText();
		    		       drug[count][j++]=txtCatagory.getText();
		    		       drug[count][j++]=txtGrade.getText();

		    		       count++;                                  //数组中药品信息的个数加一
		    		       
		    		       byte a[]=txtCode.getText().getBytes();
		    		       byte b[]=txtName.getText().getBytes();
		    		       byte c[]=txtPrice.getText().getBytes();
		    		       byte d[]=txtCatagory.getText().getBytes();
		    		       byte e[]=txtGrade.getText().getBytes();

		    		  
		    		       try{
		    			      FileOutputStream out=new FileOutputStream(file,true);  //把药品信息写入文件
		    			      out.write(a);
		    			      out.write('\t');
		    			      out.write(b);
		    			      out.write('\t');
		    			      out.write(c);
		    		    	  out.write('\t');
		    			      out.write(d);
		    			      out.write('\t');
		    			      out.write(e);
		    			      out.write('\t');
		    			      out.close();
		    			   
		    		      }
		    		       catch(IOException e1){}
		    		       JOptionPane.showMessageDialog(null,"已成功添加","温馨提示",JOptionPane.INFORMATION_MESSAGE);
		    		       txtName.setText(null);
		    		       txtPrice.setText(null);       
		    		       txtCatagory.setText(null);
		    		       txtGrade.setText(null);
		    		       int temp=Integer.parseInt(txtCode.getText());        //强制类型转换
		    		       temp++;                                              //实现ID自动编号功能，也就是自动加一
		    		       txtCode.setText(String.valueOf(temp));
		                 }
		            }
		    	}
		   }
	}
	   
	   
	   class SearchDrug extends JFrame implements ActionListener{      //实现药品对象删除和查询的窗口
		   JPanel jpl = new JPanel();
    	   JLabel SCH = new JLabel("查询药品信息",JLabel.CENTER);
    	   Font f = new Font("楷体",Font.BOLD+Font.ITALIC,30);
    	   JLabel labelCode = new JLabel("请输入编码：",JLabel.CENTER);
    	   JButton btnQuery = new JButton("查询");
    	   JLabel labelname = new JLabel("名称：",JLabel.CENTER);
    	   JLabel labelprice = new JLabel("单价：",JLabel.CENTER);
    	   JLabel labelcatagory = new JLabel("收费类别：",JLabel.CENTER);
    	   JLabel labelgrade= new JLabel("医院等级：",JLabel.CENTER);
    	   JTextField number = new JTextField();
    	   JTextField name = new JTextField();
     	   JTextField price = new JTextField();   	   
     	   JTextField catagory = new JTextField();
    	   JTextField grade = new JTextField();

    	   JButton btnDelete = new JButton("删除");
    	   JButton btnCancel = new JButton("取消");
    	
    	public SearchDrug(){
    		super("查询或删除药品信息");
    	    this.setSize(500,350);
    	    setLocation(300,300);
    		this.setVisible(true);
    		this.setResizable(false);
    		SCH.setForeground(Color.red);
    		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		this.add(jpl);
    		jpl.setBackground(Color.gray);
    		
    		jpl.setLayout(null);
    		btnQuery.addActionListener(this);
    	    btnDelete.addActionListener(this);
    		btnCancel.addActionListener(this);
    		SCH.setBounds(100,20,300,20);
    		SCH.setFont(new Font("华文行楷", Font.PLAIN, 20));
    		jpl.add(SCH);
    		labelCode.setBounds(100,60,100,20);
    		jpl.add(labelCode);
    		number.setBounds(220,60,140,20);
    		jpl.add(number);
    		btnQuery.setBounds(120,100,90,20);
    	    btnDelete.setBounds(230,100,90,20);
    		btnCancel.setBounds(340,100,90,20);
    		jpl.add(btnQuery);
    		jpl.add(btnDelete);
    		jpl.add(btnCancel);
    		labelname.setBounds(100,150,95,20);
    		jpl.add(labelname);
    		name.setBounds(205,150,140,20);
    		jpl.add(name);
    		labelprice.setBounds(100,180,95,20);
    		jpl.add(labelprice);
    		price.setBounds(205,180,140,20);
    		jpl.add(price);
    		labelcatagory.setBounds(100,210,95,20);
    		jpl.add(labelcatagory);
    		catagory.setBounds(205,210,140,20);
    		jpl.add(catagory);
    		labelgrade.setBounds(100,240,95,20);
    		jpl.add(labelgrade);
    		grade.setBounds(205,240,140,20);
    		jpl.add(grade);

    		btnDelete.setEnabled(false);    //取消删除按钮的功能
    	    name.setEditable(false);
    	    price.setEditable(false);
    	    catagory.setEditable(false);
    	    grade.setEditable(false);;
    	    setVisible(true);
    	    number.requestFocus();
    	}
            
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==btnQuery){            //查询操作
    			String temp=number.getText();
    			boolean bool=true;
    			for(int i=0;i<count;i++){
    				if(temp.equals(drug[i][0])){        //如果存在该查找的编码执行
    					name.setText(drug[i][1]);
    					price.setText(drug[i][2]);
    					catagory.setText(drug[i][3]);
    					grade.setText(drug[i][4]);
    					bool=false;
    					btnDelete.setEnabled(true);
    					break;
    				}
    			 }
				 if(bool){
					 JOptionPane.showMessageDialog(null,"不存在记录，请重新输入!","温馨提示",JOptionPane.INFORMATION_MESSAGE);
						number.setText(null);
						name.setText(null);
						price.setText(null);
						catagory.setText(null);
						grade.setText(null);
					    btnDelete.setEnabled(false);
    			}
    		}
    		if(e.getSource()==btnCancel){      //返回
    			 dispose();
    		}
    		if(e.getSource()==btnDelete){
    			String temp=number.getText();
    			for(int i=0;i<count;i++){
    				if(temp.equals(drug[i][0])){
    					for(int j=0;j<5;j++){
    						drug[i][j]=null;      //删除操作
    				    }
                            JOptionPane.showMessageDialog(null,"记录删除","温馨提示",JOptionPane.INFORMATION_MESSAGE);
                            break;
    				}
    			}
				
				number.setText(null);
				name.setText(null);
				price.setText(null);
				catagory.setText(null);
				grade.setText(null);

    		}
    	}
	   }
	   
	   
	   class DeleteDrug extends JFrame implements ActionListener{      //实现药品对象删除和查询的窗口
		   JPanel jpl = new JPanel();
    	   JLabel SCH = new JLabel("删除药品信息",JLabel.CENTER);
    	   Font f = new Font("楷体",Font.BOLD+Font.ITALIC,30);
    	   JLabel labelCode = new JLabel("请输入编码：",JLabel.CENTER);
    	   JButton btnQuery = new JButton("查询");
    	   JLabel labelname = new JLabel("名称：",JLabel.CENTER);
    	   JLabel labelprice = new JLabel("单价：",JLabel.CENTER);
    	   JLabel labelcatagory = new JLabel("收费类别：",JLabel.CENTER);
    	   JLabel labelgrade= new JLabel("医院等级：",JLabel.CENTER);
    	   JTextField number = new JTextField();
    	   JTextField name = new JTextField();
     	   JTextField price = new JTextField();   	   
     	   JTextField catagory = new JTextField();
    	   JTextField grade = new JTextField();

    	   JButton btnDelete = new JButton("删除");
    	   JButton btnCancel = new JButton("取消");
    	
    	public DeleteDrug(){
    		super("查询或删除药品信息");
    	    this.setSize(500,350);
    	    setLocation(300,300);
    		this.setVisible(true);
    		this.setResizable(false);
    		SCH.setForeground(Color.red);
    		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		this.add(jpl);
    		jpl.setBackground(Color.gray);
    		
    		jpl.setLayout(null);
    		btnQuery.addActionListener(this);
    	    btnDelete.addActionListener(this);
    		btnCancel.addActionListener(this);
    		SCH.setBounds(100,20,300,20);
    		SCH.setFont(new Font("华文行楷", Font.PLAIN, 20));
    		jpl.add(SCH);
    		labelCode.setBounds(100,60,100,20);
    		jpl.add(labelCode);
    		number.setBounds(220,60,140,20);
    		jpl.add(number);
    		btnQuery.setBounds(120,100,90,20);
    	    btnDelete.setBounds(230,100,90,20);
    		btnCancel.setBounds(340,100,90,20);
    		jpl.add(btnQuery);
    		jpl.add(btnDelete);
    		jpl.add(btnCancel);
    		labelname.setBounds(100,150,95,20);
    		jpl.add(labelname);
    		name.setBounds(205,150,140,20);
    		jpl.add(name);
    		labelprice.setBounds(100,180,95,20);
    		jpl.add(labelprice);
    		price.setBounds(205,180,140,20);
    		jpl.add(price);
    		labelcatagory.setBounds(100,210,95,20);
    		jpl.add(labelcatagory);
    		catagory.setBounds(205,210,140,20);
    		jpl.add(catagory);
    		labelgrade.setBounds(100,240,95,20);
    		jpl.add(labelgrade);
    		grade.setBounds(205,240,140,20);
    		jpl.add(grade);

    		btnDelete.setEnabled(false);    //取消删除按钮的功能
    	    name.setEditable(false);
    	    price.setEditable(false);
    	    catagory.setEditable(false);
    	    grade.setEditable(false);;
    	    setVisible(true);
    	    number.requestFocus();
    	}
            
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==btnQuery){            //查询操作
    			String temp=number.getText();
    			boolean bool=true;
    			for(int i=0;i<count;i++){
    				if(temp.equals(drug[i][0])){        //如果存在该查找的编码执行
    					name.setText(drug[i][1]);
    					price.setText(drug[i][2]);
    					catagory.setText(drug[i][3]);
    					grade.setText(drug[i][4]);
    					bool=false;
    					btnDelete.setEnabled(true);
    					break;
    				}
    			 }
				 if(bool){
					 JOptionPane.showMessageDialog(null,"不存在记录，请重新输入!","温馨提示",JOptionPane.INFORMATION_MESSAGE);
						number.setText(null);
						name.setText(null);
						price.setText(null);
						catagory.setText(null);
						grade.setText(null);
					    btnDelete.setEnabled(false);
    			}
    		}
    		if(e.getSource()==btnCancel){      //返回
    			 dispose();
    		}
    		if(e.getSource()==btnDelete){
    			String temp=number.getText();
    			for(int i=0;i<count;i++){
    				if(temp.equals(drug[i][0])){
    					for(int j=0;j<5;j++){
    						drug[i][j]=null;      //删除操作
    				    }
                            JOptionPane.showMessageDialog(null,"记录删除","温馨提示",JOptionPane.INFORMATION_MESSAGE);
                            break;
    				}
    			}
				
				number.setText(null);
				name.setText(null);
				price.setText(null);
				catagory.setText(null);
				grade.setText(null);

    		}
    	}
	   
	  }
	   
	   
	   class ReviseDrug extends JFrame implements ActionListener{      //实现药品对象修改的窗口
		   JPanel jpl = new JPanel();
    	   JLabel SCH = new JLabel("查询药品信息",JLabel.CENTER);
    	   Font f = new Font("楷体",Font.BOLD+Font.ITALIC,30);
    	   JLabel labelCode = new JLabel("请输入编码：",JLabel.CENTER);
    	   JButton btnQuery = new JButton("查询");
    	   JLabel labelname = new JLabel("名称：",JLabel.CENTER);
    	   JLabel labelprice = new JLabel("单价：",JLabel.CENTER);
    	   JLabel labelcatagory = new JLabel("收费类别：",JLabel.CENTER);
    	   JLabel labelgrade= new JLabel("医院等级：",JLabel.CENTER);
    	   JTextField number = new JTextField();
    	   JTextField name = new JTextField();
     	   JTextField price = new JTextField();   	   
     	   JTextField catagory = new JTextField();
    	   JTextField grade = new JTextField();

    	   JButton btnDelete = new JButton("删除");
    	   JButton btnCancel = new JButton("取消");
    	
    	public ReviseDrug(){
    		super("查询或删除药品信息");
    	    this.setSize(500,350);
    	    setLocation(300,300);
    		this.setVisible(true);
    		this.setResizable(false);
    		SCH.setForeground(Color.red);
    		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		this.add(jpl);
    		jpl.setBackground(Color.gray);
    		
    		jpl.setLayout(null);
    		btnQuery.addActionListener(this);
    	    btnDelete.addActionListener(this);
    		btnCancel.addActionListener(this);
    		SCH.setBounds(100,20,300,20);
    		SCH.setFont(new Font("华文行楷", Font.PLAIN, 20));
    		jpl.add(SCH);
    		labelCode.setBounds(100,60,100,20);
    		jpl.add(labelCode);
    		number.setBounds(220,60,140,20);
    		jpl.add(number);
    		btnQuery.setBounds(120,100,90,20);
    	    btnDelete.setBounds(230,100,90,20);
    		btnCancel.setBounds(340,100,90,20);
    		jpl.add(btnQuery);
    		jpl.add(btnDelete);
    		jpl.add(btnCancel);
    		labelname.setBounds(100,150,95,20);
    		jpl.add(labelname);
    		name.setBounds(205,150,140,20);
    		jpl.add(name);
    		labelprice.setBounds(100,180,95,20);
    		jpl.add(labelprice);
    		price.setBounds(205,180,140,20);
    		jpl.add(price);
    		labelcatagory.setBounds(100,210,95,20);
    		jpl.add(labelcatagory);
    		catagory.setBounds(205,210,140,20);
    		jpl.add(catagory);
    		labelgrade.setBounds(100,240,95,20);
    		jpl.add(labelgrade);
    		grade.setBounds(205,240,140,20);
    		jpl.add(grade);

    		btnDelete.setEnabled(false);    //取消删除按钮的功能
    	    name.setEditable(false);
    	    price.setEditable(false);
    	    catagory.setEditable(false);
    	    grade.setEditable(false);;
    	    setVisible(true);
    	    number.requestFocus();
    	}
            
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==btnQuery){            //查询操作
    			String temp=number.getText();
    			boolean bool=true;
    			for(int i=0;i<count;i++){
    				if(temp.equals(drug[i][0])){        //如果存在该查找的编码执行
    					name.setText(drug[i][1]);
    					price.setText(drug[i][2]);
    					catagory.setText(drug[i][3]);
    					grade.setText(drug[i][4]);
    					bool=false;
    					btnDelete.setEnabled(true);
    					break;
    				}
    			 }
				 if(bool){
					 JOptionPane.showMessageDialog(null,"不存在记录，请重新输入!","温馨提示",JOptionPane.INFORMATION_MESSAGE);
						number.setText(null);
						name.setText(null);
						price.setText(null);
						catagory.setText(null);
						grade.setText(null);
					    btnDelete.setEnabled(false);
    			}
    		}
    		if(e.getSource()==btnCancel){      //返回
    			 dispose();
    		}
    		if(e.getSource()==btnDelete){
    			String temp=number.getText();
    			for(int i=0;i<count;i++){
    				if(temp.equals(drug[i][0])){
    					for(int j=0;j<5;j++){
    						drug[i][j]=null;      //删除操作
    				    }
                            JOptionPane.showMessageDialog(null,"记录删除","温馨提示",JOptionPane.INFORMATION_MESSAGE);
                            break;
    				}
    			}
				
				number.setText(null);
				name.setText(null);
				price.setText(null);
				catagory.setText(null);
				grade.setText(null);

    		}
    	}
	   
	   }
	   
	   
	   class Reimbursement extends JFrame implements ActionListener{    //实现中心报销环节的窗口
		    int sum=0;       //计算的是一次费用明细录入后的报销价格，其中考虑了药品收费类别,定点医疗机构和人员类别
		    int total=0;     //计算的是一个人可以报销的总价格
		    double TOTAL=0;     //计算的是医保中心报销的费用
		   
	    	JLabel label1 = new JLabel("数据定位");
	    	JLabel label2 = new JLabel("身份证号ID");
	    	JLabel label3 = new JLabel("人员信息");
	    	JLabel label4 = new JLabel("姓名");
	    	JLabel label5 = new JLabel("性别");
	    	JLabel label6 = new JLabel("医疗人员类别");
	    	JLabel label7 = new JLabel("定点医疗机构");
	    	JLabel label8 = new JLabel("报销录入");
	    	JLabel label9 = new JLabel("药品编号");
	    	JLabel label10 = new JLabel("药品信息");
	    	JLabel label11 = new JLabel("药品名称");
	    	JLabel label12 = new JLabel("单价");
	    	JLabel label13 = new JLabel("收费类别");
	    	JLabel label14 = new JLabel("数量");
	    	JLabel label15 = new JLabel("费用明细");
	    	JLabel label16 = new JLabel("就诊医疗机构");
	    	JLabel label17 = new JLabel("医保中心报销费用");
	    	JLabel label18 = new JLabel("医保中心报销费用比例：可报销部分0~1000元50%，1000~10000元60%，10000元以上80%");
	    	
	    	
	    	JTextField txt1=new JTextField(20);
	    	JTextField txt2=new JTextField(20);
	    	JTextField txt3=new JTextField(20);
	    	JTextField txt4=new JTextField(20);
	    	JTextField txt5=new JTextField(20);
	    	JTextField txt6=new JTextField(20);
	    	JTextField txt7=new JTextField(20);
	    	JTextField txt8=new JTextField(20);
	    	JTextField txt9=new JTextField(20);
	    	JTextField txt10=new JTextField(20);
	    	JTextField txt11=new JTextField(20);
	    	JTextField txt12=new JTextField(20);
	    	
            JTextArea wbq=new JTextArea(100,100);       //增加了个大文本框
	    	
	    	JButton btn1=new JButton("查询");
	    	JButton btn2=new JButton("确定");
	    	JButton btn3=new JButton("费用明细录入");
	    	JButton btn4=new JButton("确认报销");
	    	JButton btn5=new JButton("取消报销");
	    	
	    	JPanel jpl=new JPanel();
	    	
	    	public Reimbursement(){
	    		super("医疗项目报销");
	    		this.setResizable(false);
				this.setSize(1000, 700);
				this.setVisible(true);
				this.setLocation(120,10);
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.add(jpl);
				jpl.setLayout(null);
				
				btn1.addActionListener(this);
				btn2.addActionListener(this);
				btn3.addActionListener(this);
				btn4.addActionListener(this);
				btn5.addActionListener(this);
				
				jpl.setBackground(Color.white);
				
				label1.setBounds(20,20,80,20);  //数据定位
				label1.setFont(new Font("华文行楷", Font.PLAIN, 18));
				jpl.add(label1);
				
				label2.setBounds(100,40,90,20);   //ID
				jpl.add(label2);
				txt1.setBounds(190,40,140,20);
				jpl.add(txt1); 
				
				label3.setBounds(20,70,80,20);   //人员信息
				label3.setFont(new Font("华文行楷", Font.PLAIN, 18));
				jpl.add(label3);  
				
				label4.setBounds(100,90,60,20);  //姓名
				jpl.add(label4);
				txt2.setBounds(190,90,140,20);
				jpl.add(txt2);
				
				label5.setBounds(390,90,70,20);  //性别
				jpl.add(label5);
				txt3.setBounds(460,90,100,20);   
				jpl.add(txt3);
			    
				label6.setBounds(625,90,100,20);  //医疗人员类别
				jpl.add(label6);
				txt4.setBounds(745,90,140,20);
				jpl.add(txt4);
				
				label7.setBounds(100,130,90,20);  //定点医疗机构
				jpl.add(label7);
				txt5.setBounds(190,130,140,20);
				jpl.add(txt5);
				
				label16.setBounds(390,130,90,20);  //就诊医疗机构
				jpl.add(label16);
				txt11.setBounds(480,130,140,20);
				jpl.add(txt11);
				
				label8.setBounds(20,160,80,20);  //报销录入
				label8.setFont(new Font("华文行楷", Font.PLAIN, 18));
				jpl.add(label8);
				
				label9.setBounds(100,180,70,20);  //药品编号
				jpl.add(label9);
				txt6.setBounds(190,180,140,20);
				jpl.add(txt6);
		        
				label10.setBounds(20,210,80,20);  //药品信息
				label10.setFont(new Font("华文行楷", Font.PLAIN, 18));
				jpl.add(label10);
				
				label11.setBounds(100,230,70,20);  //药品名称
				jpl.add(label11);
				txt7.setBounds(190,230,140,20);
				jpl.add(txt7);
				
				label12.setBounds(390,230,70,20);  //单价
				jpl.add(label12);
				txt8.setBounds(460,230,100,20);
				jpl.add(txt8);
				
				label13.setBounds(625,230,100,20);  //收费类别
				jpl.add(label13);
				txt9.setBounds(720,230,140,20);
				jpl.add(txt9);
				
				label14.setBounds(100,270,70,20);  //数量
				jpl.add(label14);
				txt10.setBounds(190,270,120,20);
				jpl.add(txt10);
				
				label15.setBounds(15,320,100,20);  //费用明细
				label15.setFont(new Font("华文行楷", Font.PLAIN, 22));
				jpl.add(label15);
				
				label17.setBounds(15,600,180,22);  //医保中心报销费用
				label17.setFont(new Font("华文行楷", Font.PLAIN, 22));
				jpl.add(label17);
				txt12.setBounds(215,600,120,23);
				jpl.add(txt12);
				
				label18.setBounds(35,650,600,15);  //报销比例（小字）
				label18.setFont(new Font("华文行楷", Font.PLAIN, 15));
				jpl.add(label18);
				
				wbq.setBounds(130, 325, 740, 240);  //明细显示板
				wbq.setFont(new Font("标楷体", Font.BOLD, 16));
				wbq.setLineWrap(true);// 激活自动换行功能
				wbq.setWrapStyleWord(true);// 激活断行不断字功能
				wbq.setBackground(Color.yellow);
				jpl.add(wbq);
				
				btn1.setBounds(380,38,70,23);//查询
				btn2.setBounds(380,178,70,23);//确定
				btn3.setBounds(360,268,120,23);//费用明细录入
				btn4.setBounds(400,600,90,35);//确认报销
				btn5.setBounds(700,600,90,35);//取消报销
				
				jpl.add(btn1);
				jpl.add(btn2);
				jpl.add(btn3);
				jpl.add(btn4);
				jpl.add(btn5);
				
				btn2.setEnabled(false);    //取消确定按钮的功能
				btn3.setEnabled(false);    //取消费用明细录入按钮的功能
				btn4.setEnabled(false);    //取消确认报销按钮的功能
				
				txt2.setEditable(false);
				txt3.setEditable(false);
				txt4.setEditable(false);
				txt5.setEditable(false);
				txt6.setEditable(false);
				txt7.setEditable(false);
				txt8.setEditable(false);
				txt9.setEditable(false);
				txt10.setEditable(false);
				txt12.setEditable(false);
				
				wbq.setEditable(false);
				
				txt1.requestFocus();//光标给到输入ID的一栏
			}
	    	
	    	public void actionPerformed(ActionEvent e){
	    		if(e.getSource()==btn1){            //查询操作
	    			String temp=txt1.getText();
	    			boolean bool=true;
	    			for(int i=0;i<cou;i++){
	    				if(temp.equals(person[i][0])){        //如果存在该查找的ID  执行
	    					txt2.setText(person[i][1]);
	    					txt3.setText(person[i][2]);
	    					txt4.setText(person[i][3]);
	    					txt5.setText(person[i][4]);
	    					bool=false;
	    					txt6.setEditable(true);         //药品编号一项可以输入了
	    					btn2.setEnabled(true);          //确定键可以按了
	    					break;
	    				}
	    			 }
					 if(bool){
						 JOptionPane.showMessageDialog(null,"不存在记录，请重新输入!","温馨提示",JOptionPane.INFORMATION_MESSAGE);
							txt1.setText(null);
							txt2.setText(null);
							txt3.setText(null);
							txt4.setText(null);
							txt5.setText(null);
	    			}
	    			
	    		}  //查询按钮监听器部分结束
	    		
	    		if(e.getSource()==btn2){           //确定报销药品的操作
	    			String temp=txt6.getText();
	    			boolean bool=true;
	    			for(int i=0;i<count;i++){
	    				if(temp.equals(drug[i][0])){        //如果存在该查找的ID  执行
	    					txt7.setText(drug[i][1]);
	    					txt8.setText(drug[i][2]);
	    					txt9.setText(drug[i][3]);     //这里不显示药品的医院等级

	    					bool=false;
	    					txt10.setEditable(true);         //数量一项可以输入了	
	    					btn1.setEnabled(false);         //不能再改人了
	    					btn3.setEnabled(true);          //费用明细录入键可以按了
	    					txt11.setEditable(false);         //就诊医疗机构一项不可以输入了	

	    					break;
	    				}
	    			 }
					 if(bool){
						 JOptionPane.showMessageDialog(null,"不存在记录，请重新输入!","温馨提示",JOptionPane.INFORMATION_MESSAGE);
							txt6.setText(null);
							txt7.setText(null);
							txt8.setText(null);
							txt9.setText(null);
	    			}
	    				
	    		}  //确认药品监听器部分
	    		
	    		if(e.getSource()==btn3){
	    			String name=txt7.getText();
	    			String price=txt8.getText();
	    			String catagory=txt9.getText();
	    			String number=txt10.getText();
	    			String all="项目名称："+name+"           单价："+price+"           项目类别："+catagory+"           数量："+number+"\n";
	    			wbq.append(all);
	    			
                    
                    int temp1=Integer.parseInt(txt8.getText());
                    int temp2=Integer.parseInt(txt10.getText());
                    sum=temp1*temp2;
                    if (txt9.getText().toString().equals("甲")){
                    	sum*=1;
                    }
                    else if(txt9.getText().toString().equals("乙")){
                    	sum*=0.5;
                    }
                    else{
                    	sum*=0;
                    }
                    if(txt5.getText().toString().equals(txt11.getText().toString())){
                    	if(txt4.getText().toString().equals("在职职工")){
                    		sum*=0.8;
                    	}
                    	else if(txt4.getText().toString().equals("退休人员")){
                    		sum*=1;
                    	}
                    	else sum*=0.5;
                    }
                    else {
                    	sum=0;
                    }
                    total+=sum;
                    String s1 = Integer.toString(total);
                    wbq.append("可以报销总费用："+s1+"\n");
                    
                    if(total<=1000){
                    	TOTAL=total*0.5;
                    }
                    else if(total>1000&&total<=10000){
                    	TOTAL=500+0.6*(total-1000);
                    }
                    else{
                    	TOTAL=500+5400+0.8*(total-10000);
                    }
                    String s2 = Double.toString(TOTAL);
                    
                    txt12.setText(s2);

	    			
	    			txt6.setText(null);
					txt7.setText(null);
					txt8.setText(null);
					txt9.setText(null);
                    txt10.setText(null);
                    
                    btn4.setEnabled(true);   //确认报销键可以按了
	    			
	    			
	    		}  //费用明细录入监听器部分结束，计算总费用的过程也应该在其中！！
	    		
	    		if(e.getSource()==btn4){
	    			String temp=txt1.getText();
	    			for(int i=0;i<cou;i++){
	    				if(temp.equals(person[i][0])){
	    					
	    					person[i][5]=txt12.getText();
	    					double temp3=Double.parseDouble(txt12.getText());
	    					
	    					double temp4=Double.parseDouble(person[i][6]);
	    					temp4+=temp3;
	    					person[i][6] = Double.toString(temp4);
	    					
	    					break;
	    				}
	    			}    //把本次报销额存进去
	    			
	    			
	    			
	    			
	    			
	    			JOptionPane.showMessageDialog(null,"报销成功！！","温馨提示",JOptionPane.INFORMATION_MESSAGE);
	    			txt1.setText(null);
	    			txt2.setText(null);
	    			txt3.setText(null);
	    			txt4.setText(null);
	    			txt5.setText(null);
	    			txt6.setText(null);
	    			txt7.setText(null);
	    			txt8.setText(null);
	    			txt9.setText(null);
	    			txt10.setText(null);
	    			txt12.setText(null);
	    			
	    			wbq.setText(null);
	    			btn1.setEnabled(true);
	    			btn2.setEnabled(false);
	    			btn3.setEnabled(false);
	    			btn4.setEnabled(false);
	    			
	    			sum=0;
	    			total=0;
	    			TOTAL=0;

	    			
	    				
	    		}   
	    		
	    		if(e.getSource()==btn5){
	    			dispose();
	    		}   
	    		
	    			
	    		
	    	}//actionPerformed的右括号
		   
	   }//中心报销结束
	   
	   
	   class SearchR extends JFrame implements ActionListener{         //实现人员报销信息查询的窗口
		   JPanel jpl = new JPanel();
    	   JLabel SCH = new JLabel("查询人员报销信息",JLabel.CENTER);
    	   Font f = new Font("楷体",Font.BOLD+Font.ITALIC,30);
    	   JLabel labelID = new JLabel("请输入ID：",JLabel.CENTER);
    	   JButton btnQuery = new JButton("查询");
    	   JLabel labelname = new JLabel("姓名：",JLabel.CENTER);
    	   JLabel labelsex = new JLabel("性别：",JLabel.CENTER);
    	   JLabel labelcatagory = new JLabel("医疗人员类别：",JLabel.CENTER);
    	   JLabel labelinstitution = new JLabel("定点医疗机构：",JLabel.CENTER);
    	   JLabel labelR = new JLabel("上次报销费用：",JLabel.CENTER);
    	   JLabel labelZ = new JLabel("总报销费用：",JLabel.CENTER);
    	   JTextField number = new JTextField();
    	   JTextField name = new JTextField();
     	   JTextField sex = new JTextField();   	   
     	   JTextField catagory = new JTextField();
    	   JTextField institution = new JTextField();
    	   JTextField r = new JTextField();
    	   JTextField z = new JTextField();
    	   
    	   JButton btnBack = new JButton("返回");


    	
    	public SearchR(){
    		super("查询人员报销信息");
    	    this.setSize(500,390);
    	    setLocation(200,200);
    		this.setVisible(true);
    		this.setResizable(false);
    		SCH.setForeground(Color.red);
    		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		this.add(jpl);
    		jpl.setBackground(Color.lightGray);
    		
    		jpl.setLayout(null);
    		btnQuery.addActionListener(this);
    		btnBack.addActionListener(this);
    		SCH.setBounds(100,20,300,20);
    		jpl.add(SCH);
    		labelID.setBounds(100,60,100,20);
    		jpl.add(labelID);
    		number.setBounds(205,60,130,20);
    		jpl.add(number);
    		
    		btnQuery.setBounds(390,58,66,23);
    		jpl.add(btnQuery);

    		labelname.setBounds(100,100,95,20);
    		jpl.add(labelname);
    		name.setBounds(205,100,140,20);
    		jpl.add(name);
    		labelsex.setBounds(100,130,95,20);
    		jpl.add(labelsex);
    		sex.setBounds(205,130,140,20);
    		jpl.add(sex);
    		labelcatagory.setBounds(100,160,95,20);
    		jpl.add(labelcatagory);
    		catagory.setBounds(205,160,140,20);
    		jpl.add(catagory);
    		labelinstitution.setBounds(100,190,95,20);
    		jpl.add(labelinstitution);
    		institution.setBounds(205,190,140,20);
    		jpl.add(institution);
    		labelR.setBounds(100,220,95,20);
    		jpl.add(labelR);
    		r.setBounds(205,220,140,20);
    		jpl.add(r);
    		labelZ.setBounds(100,250,95,20);
    		jpl.add(labelZ);
    		z.setBounds(205,250,140,20);
    		jpl.add(z);
    		
    		btnBack.setBounds(380,300,70,28);
    		jpl.add(btnBack);

    		
    	    name.setEditable(false);
    	    sex.setEditable(false);
    	    catagory.setEditable(false);
    	    institution.setEditable(false);
    	    r.setEditable(false);
    	    z.setEditable(false);
    	    setVisible(true);
    	    number.requestFocus();
    	}
            
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==btnQuery){            //查询操作
    			String temp=number.getText();
    			boolean bool=true;
    			for(int i=0;i<cou;i++){
    				if(temp.equals(person[i][0])){        //如果存在该查找的ID执行
    					name.setText(person[i][1]);
    					sex.setText(person[i][2]);
    					catagory.setText(person[i][3]);
    					institution.setText(person[i][4]);
    					r.setText(person[i][5]);
    					z.setText(person[i][6]);
    					bool=false;
    					break;
    				}
    			 }
				 if(bool){
					 JOptionPane.showMessageDialog(null,"不存在记录，请重新输入!","温馨提示",JOptionPane.INFORMATION_MESSAGE);
						number.setText(null);
						name.setText(null);
						sex.setText(null);
						catagory.setText(null);
						institution.setText(null);
						r.setText(null);
						z.setText(null);

    			}
    		}
    		if(e.getSource()==btnBack){          
    			 dispose();
    		}
    		
    	}
		   
	 }
	   
}
