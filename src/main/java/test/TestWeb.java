package test;

/**

 * @author Administrator

 * @create 2018-03-20 12:31

 * @desc TestWeb

 **/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class TestWeb extends JFrame {
	private static final long serialVersionUID = 4859858380825456963L;
	private JPanel contentPane;
	private final String URL = "http://www.baidu.com";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UIUtils.setPreferredLookAndFeel();
		NativeInterface.open();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWeb frame = new TestWeb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		NativeInterface.runEventPump();
	}

	public TestWeb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JWebBrowser jWebBrowser = new JWebBrowser();
		jWebBrowser.setBounds(0, 0, 888, 561);
		jWebBrowser.navigate(URL);
		jWebBrowser.setButtonBarVisible(false);
		jWebBrowser.setMenuBarVisible(false);
		jWebBrowser.setBarsVisible(false);
		jWebBrowser.setStatusBarVisible(false);
		contentPane.add(jWebBrowser);
	}
}