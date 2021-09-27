package reserveAcco.controller;

import reserveAcco.util.View;

public class Controller {
	public static void main(String[] args) {
		new Controller().start();
	}
	
	public int start() {
		int view = View.HOME;
		
		while(true) {
			swtich(view) {
				case View.HOME: view = home(); break;
				case View.LOGIN: view = home(); break;
				case View.JOIN: view = home(); break;
				case View.MAIN: view = home(); break;
				
			}
		}
		
	}
}
