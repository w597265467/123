package test;

import java.awt.Color;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

/**
 * 贪吃蛇
 */
public class SnakeFrame extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;
	private JButton food;//食物对象
	private Random rd = new Random();//随机对象
	private LinkedList<JButton> snake = new LinkedList<>();//装蛇的集合
	private boolean game = false;//游戏状态  默认暂停
	private int code;
	public SnakeFrame() {
		//窗口标题
		setTitle("贪吃蛇");
		//位置大小
		setBounds(300, 50, 800, 600);
		//设置点击窗口关闭按钮退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置不能改变大小
		setResizable(false);
		//设置布局为空
		setLayout(null);
		//设置背景颜色
		//虽然add()方法可以把组件假如到frame窗口中,但是最终是添加到窗口中的内容面板中的,
		//设置背景颜色如果直接窗口的背景颜色不能显示效果,需要设置到内容面板中 getContentPane()方法是获取内容面板对象
		getContentPane().setBackground(Color.BLACK);
		//调用初始化蛇的方法,因为这个方法 只需要执行一次,所有就放在构造器中就行。如果需要给游戏加重新开始按钮，可以把这个方法放进线程中
		initSnake();
		//设置显示
		setVisible(true);
		//给窗口添加全局监听器,监听用户操作来操作游戏启动/暂停 和 蛇的移动方向
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		//此操作会把键盘按下和按住 弹起封装到一个事件中   所以需要把其他两个操作过滤  只留下键盘按下操作
		manager.addKeyEventPostProcessor(new KeyEventPostProcessor() {
			public boolean postProcessKeyEvent(KeyEvent e) {
				//获取键盘按下的 字符代码
				//enter  10
				//上 38 下 40 左 37 右  39
				int code = e.getKeyCode();
				String code2 = e.paramString() ;
				//如果按下enter键  并且是键盘按下
				if (code==10&&code2.contains("KEY_PRESSED")) {
					//切换游戏状态  开始<-->暂停
					game=!game;
				}
				//按了上键
				if (game&&(code==37||code==38||code==39||code==40)&&code2.contains("KEY_PRESSED")) {
					SnakeFrame.this.code = code;
				}
				return true;
			}
		});
	}
	public static void main(String[] args) {
		SnakeFrame snake = new SnakeFrame();
		Thread t = new Thread(snake);
		t.start();
	}

	/**
	 * 线程方法
	 */
	public void run() {
		while(true) {
			//一直调用 生成食物的方法
			createFood();
			//一直调用 如果游戏开始  蛇移动的方法
			if (game) {
				snakeRun();
			}
			//碰撞检测
			collision();
			repaint();
			try {
				Thread.sleep(200);
			} catch (Exception e) {
			}
		}
	}
	/**
	 * 碰撞检测
	 */
	private void collision() {
		/**
		 * 检测碰撞到食物
		 * 只需要检测头就行,因为整条蛇只有头的坐标会最先发生改变,所以只需要检测头的当前坐标就能知道蛇知否碰撞到食物了
		 * 1.首先获取头对象，在获取当前坐标
		 * 2.获取食物的坐标
		 * 3.判断坐标是否交叉,出现交叉就算碰撞到了
		 * 4.碰撞到之后,食物设置为null,重新出现,蛇身体末尾在追加一个按钮
		 */
		//1.获取蛇头对象
		JButton head = snake.getFirst();
		//2.获取蛇头当前坐标
		//将碰撞食物的代码封装到代码块中,作为一个整体
		int x = head.getX();
		int y = head.getY();
		{
			//3.获取食物坐标
			int x2 = food.getX();
			int y2 = food.getY();
			//4.判断坐标是否交叉
			/**
			 * 判断坐标是否交叉
			 *
			 * 需要得到食物或蛇头的x坐标范围  四个顶点坐标进行判断
			 *
			 * 使用蛇头的左上角  左下角 右上角 右下角进行判断,是否在食物坐标范围内
			 */
			//碰撞到了
			if ((x>=x2&&x<=x2+50&&y>=y2&&y<=y2+50)//蛇头的左上角在食物坐标范围内
					||(x>=x2&&x<=x2+50&&y+50>=y2&&y+50<=y2+50)//蛇头的左下角在食物的坐标范围内
					||(x+50>=x2&&x+50<=x2+50&&y>=y2&&y<=y2+50)//蛇头的右上角在食物的坐标范围内
					||(x+50>=x2&&x+50<=x2+50&&y+50>=y2&&y+50<=y2+50)//蛇头的右下角在食物的坐标范围内
					) {
				//从窗口删除食物
				remove(food);
				//将装食物的变量设置为空
				food = null;
				//给蛇添加一个新的身体
				JButton btn = new JButton();
				btn.setSize(50,50);
				btn.setBackground(Color.green);
				btn.setBorder(new LineBorder(Color.PINK,1));
				//将蛇身体添加到 蛇集合
				snake.addLast(btn);
				//将蛇添加到窗口
				add(btn);
			}
		}
		/**
		 * 检测碰撞到身体
		 *
		 * 跟食物类似,但是需要蛇头跟身体的每一个按钮坐标进行判断
		 */
		/**
		 * 检测碰撞到墙
		 */
	}
	/**
	 * 蛇运动的方法
	 *
	 *
	 *
	 */
	private void snakeRun() {
		//先让头走
		int x = 0;//记录头或前一个按钮走之前的位置
		int y = 0;//记录头或前一个按钮走之前的位置
		JButton head = snake.getFirst();
		x = head.getX();
		y = head.getY();
		if (code==38) {
			head.setLocation(x,y-50);
		}else if (code==40) {
			head.setLocation(x,y+50);
		}else if (code==37) {
			head.setLocation(x-50,y);
		}else {
			head.setLocation(x+50,y);
		}
		//身体走
		for (int i = 1; i < snake.size(); i++) {
			JButton btn = snake.get(i);
			int x2 = btn.getX();
			int y2 = btn.getY();
			//走到前一个按钮的位置
			btn.setLocation(x,y);
			//将当前按钮的位置记录
			x = x2;
			y = y2;
		}
		validate();
		revalidate();
	}
	/**
	 * 初始化 蛇身体
	 * 1.蛇的身体需要装入集合 因为蛇需要动起来  如果不把蛇身体装起来，在蛇动起来的方法中不能获取蛇身体
	 * ，而且蛇身体中对象由多个组成，且可变，所有需要装进集合
	 * 2.集合(集合可以看出蛇身体,蛇身体由一个个按钮(JButton也可以是其他组件,无所谓)组成,而集合中就是装的每一个按钮)需要在身体动的方法中调用
	 * ，所以集合需要设置为成员变量。但是按钮对象不需要设置为成员变量，首先不知道到底多少个按钮组成一条蛇(吃到食物会增加)。而且我们拿到集合就能
	 * 直接拿到集合中装的按钮对象了。
	 * 3.因为我们需要操作蛇的头和尾,头开始动  吃到食物添加到蛇的尾部  所以使用linkedList比较方便，因为它能快速的操作头尾
	 */
	private void initSnake() {
		JButton btn_1 = new JButton();
		btn_1.setBounds(0, 0, 50, 50);
		btn_1.setBackground(Color.green);
		//设置颜色为粉红色  厚度为1的边框
		btn_1.setBorder(new LineBorder(Color.PINK,1));
		add(btn_1);


		JButton btn_2 = new JButton();
		btn_2.setBounds(50, 0, 50, 50);
		btn_2.setBackground(Color.green);
		btn_2.setBorder(new LineBorder(Color.PINK,1));
		add(btn_2);


		JButton btn_3 = new JButton();
		btn_3.setBounds(100, 0, 50, 50);
		btn_3.setBackground(Color.green);
		btn_3.setBorder(new LineBorder(Color.PINK,1));
		add(btn_3);

		//将按钮装进集合中
		snake.addLast(btn_2);
		snake.addLast(btn_1);
		//将按钮3装进集合头中,作为蛇头
		snake.addFirst(btn_3);
	}

	/**
	 * 随机生成食物的方法
	 * 1.生成的食物不能超出窗口界面。所有 随机生成的坐标必须在窗口范围内 x:0-800左右(窗口边框有几像素的位置)  y:0-600
	 * 2.食物对象必须能在蛇吃食物的方法中被调用    (需要把食物设置为成员变量)
	 * 3.食物如果被吃,成员变量需要清空   而且能够再次生成食物
	 * 	a.生创建食物对象前,需要先判断食物对象为不为null
	 * 		i.为null    执行生成食物的方法
	 * 		ii.不为null  不执行任何操作
	 * 	b.需要在线程中一直执行生成食物的方法,当食物对象为空(null)时,就执行生成食物的代码。不为空时就不执行任何代码
	 */
	private void createFood() {
		//判断食物对象如果为空  生成食物
		if (food==null) {
			//创建食物对象
			food = new JButton();
			//设置位置
			//随机数有个特点  生成的随机数 左闭右开  [0,800)
			int x =rd.nextInt(800);
			int y =rd.nextInt(600);
			food.setBounds(x, y, 100, 100);
			//设置背景颜色
			food.setBackground(Color.green);
			//取消边框
			food.setBorder(new LineBorder(Color.green, 12));
			//将食物添加到内容面板中
			add(food);
		}
	}
	/**
	 * 键盘按下时间,使用内部类实现,因为需要使用成员变量来记录游戏状态(开始还是暂停)
	 * @author Administrator
	 *1.当用户按下enter键 游戏开始 再次按下 游戏暂停
	 *2.当用户上下左右,改变蛇移动的方向
	 *	a.
	 *	b.
	 */
	class MyKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e) {
			System.err.println(1);
		}
		public void keyPressed(KeyEvent e) {
			System.err.println(2);
		}
		public void keyReleased(KeyEvent e) {
			System.err.println(3);
		}

	}
}
