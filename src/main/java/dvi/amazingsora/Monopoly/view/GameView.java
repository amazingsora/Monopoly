package dvi.amazingsora.Monopoly.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dvi.amazingsora.Monopoly.MenuFrame.MonopolyMenu;
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
	private JButton backbtn;
	JFrame frame;
	
	public GameView(JFrame frame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 897, 732);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		this.setBounds(150, 173, 563, 472);
		frame.getContentPane().add(this);

		this.setLayout(null);

		try {
			Grid grid = new Grid();

			grid.init(this);

			backbtn = new JButton("返回");
			backbtn.setBounds(784, 27, 87, 23);
			this.add(backbtn);
			backbtn.addActionListener(this);

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

		if (jb == backbtn) {
			// 隐藏关闭菜单窗口
			frame.setVisible(false);
//			this.frame.dispose();
			frame.setContentPane(new MonopolyMenu());
			frame.setVisible(true);

		}

	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
