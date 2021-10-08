package dvi.amazingsora.Monopoly.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dvi.amazingsora.Monopoly.model.DataSaveObject;
import dvi.amazingsora.Monopoly.model.Grid;
import dvi.amazingsora.Monopoly.model.Player;

public class GameView extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int W = 300;

	public static final int H = 200;

	JButton jb1, jb2;
	JButton backBtn;
	JFrame frame;

	public GameView(JFrame frame) {
		frame = new JFrame();
		this.frame = frame;
		frame.setBounds(100, 100, 950, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		this.setBounds(150, 173, 563, 472);
		frame.getContentPane().add(this);

		this.setLayout(null);

		try {
			Grid grid = new Grid();

			grid.init(this);

			JPanel panel = new JPanel();
			panel.setBounds(723, 597, 201, 154);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			 backBtn = new JButton("返回");
			backBtn.setBounds(10, 59, 181, 53);
			backBtn.addActionListener(this);
			panel.add(backBtn);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Player player = new Player(4000, "test", "test", 4000);
		player.setFrame(frame);
		player.setMun(DataSaveObject.getSetting().getPlayerCount());
		player.init();
		/**/

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton) e.getSource();

		if (jb == backBtn) {
			System.out.println("dddd");
			// 隐藏关闭菜单窗口
			frame.setVisible(false);
			new MonopolyMeum(new JFrame());

		}

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	

}
