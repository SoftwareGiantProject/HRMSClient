package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class MainFrame {
	public static void main(String[] args){
		

		JFrame mFrame = new JFrame();
		mFrame.setSize(1200, 900);
		mFrame.setLocation(300, 300);
		mFrame.setVisible(true);
		JPanel mPanel=new JPanel();
		mPanel.setSize(900,900);
		mPanel.setVisible(true);
		mFrame.add(mPanel);
		
		mFrame.setName("login");
		
	
	}
	public void middleFrame(String name){
		
		JFrame mFrame = new JFrame();
		mFrame.setSize(1200, 900);
		mFrame.setLocation(300, 300);
		mFrame.setVisible(true);
	}

}