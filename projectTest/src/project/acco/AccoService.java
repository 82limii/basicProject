package project.acco;

import java.util.List;

public class AccoService {
	// 싱글톤 패턴
	private static AccoService instance = new AccoService();
	public static AccoService getInstance() {
		return instance;
	}
	private AccoService() {}
		
	// DAO
	private AccoDao accoDao = AccoDao.getInstance();
	
	public int createAcco(AccoVO vo) {
		return accoDao.createAcco(vo);
	}
	
	public List<AccoVO> readAcco() {
		return accoDao.readAcco();
	}
	
	public int updateAccoAdd(AccoVO vo) {
		return accoDao.updateAccoAdd(vo);
	}
	
	public int updateAccoRate(AccoVO vo) {
		return accoDao.updateAccoRate(vo);
	}
	
	public int delteAcco(AccoVO vo) {
		return accoDao.delteAcco(vo);
	}
}	// end of class
