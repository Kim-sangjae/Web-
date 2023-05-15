package dao;

import java.util.List;

public interface BoardDAO {
	
	public int insert(Object ob);
	public List<Object> selectList();
	public int update(Object ob);
	public int delete(int idx);
}
