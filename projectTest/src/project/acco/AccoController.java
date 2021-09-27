package project.acco;

import java.util.List;

public class AccoController {
	// �̱��� ����
	private static AccoController instance = new AccoController();
	public static AccoController getInstance() {
		return instance;
	}
	private AccoController() {}
	
	// ���� ��ü ����
	private AccoService accoService = AccoService.getInstance();
	
	public int createAcco(AccoVO vo) {
		return accoService.createAcco(vo);
	}
	
	public List<AccoVO> readAcco() {
		return accoService.readAcco();
	}
	
	public int updateAccoAdd(AccoVO vo) {
		return accoService.updateAccoAdd(vo);
	}
	
	public int updateAccoRate(AccoVO vo) {
		return accoService.updateAccoRate(vo);
	}
	
	public int delteAcco(AccoVO vo) {
		return accoService.delteAcco(vo);
	}
}	// end of class
