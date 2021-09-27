package project.main;

import project.acco.AccoController;
import project.admin.AdminController;
import project.cancel.CancelController;
import project.cormember.CormemberController;
import project.event.EventController;
import project.member.MemberController;
import project.reservation.ReservationController;
import project.review.ReviewController;
import project.room.RoomController;
import project.util.MenuNotFoundException;

public class Home {
	private AccoController accoController = AccoController.getInstance();
	private AdminController adminController = AdminController.getInstance();
	private CancelController cancelController = CancelController.getInstance();
	private CormemberController cormemberController = CormemberController.getInstance();
	private EventController eventController = EventController.getInstance();
	private MemberController memberController = MemberController.getInstance();
	private ReservationController reservationController = ReservationController.getInstance();
	private ReviewController reviewController = ReviewController.getInstance();
	private RoomController roomController = RoomController.getInstance();
	
	private View view = View.getInstance();
	
	public void initialize() {
		home(view.init());
	}

	private void home(int number) {
		loop:
			while (true) {
				try {
					HomeMenu menu = HomeMenu.findMenu(number);
					System.out.println(menu.getMenuString());
					switch (menu) {
					case HOME:
					case 
					}
				} catch (MenuNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.println(HomeMenu.HOME.getMenuString());
				}
				System.out.println();
			}
	}
}
