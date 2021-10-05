package dvi.amazingsora.test.T1;

import java.rmi.activation.ActivationInstantiator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class MenuFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int W = 300;

	public static final int H = 200;

	JButton jb1, jb2;

	public MenuFrame() {
		JPanel jp = new JPanel();

		BoxLayout box = new BoxLayout(jp, BoxLayout.Y_AXIS);// 垂直方向的布局

		jp.setLayout(box);

		jb1 = new JButton("益智扫雷");

		jb1.addActionListener(this);

		jb2 = new JButton("围棋春秋");

		jb2.addActionListener(this);

		JButton jb3 = new JButton("再续前缘");

		JButton jb4 = new JButton("退隐江湖");

		JButton jb5 = new JButton("帮助文档");

		jp.add(jb1);

		jp.add(jb2);

		jp.add(jb3);

		jp.add(jb4);

		jp.add(jb5);

		add(jp);

		setLayout(new FlowLayout());

		setTitle("java Game Center");

		setSize(W, H);

		setLocationRelativeTo(null);// 窗口居中

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new MenuFrame().setVisible(true);// 启动菜单窗口

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();

		if (jb == jb1) {
			// 隐藏关闭菜单窗口

			this.setVisible(false);

			this.dispose();

			// 打开扫雷窗口

			new SL().setVisible(true);

		}

	}

}