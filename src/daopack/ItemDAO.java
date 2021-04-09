package daopack;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
	public ItemDTO getByName(String itemname) throws SQLException;
	public ItemDTO getById(Integer itemid) throws SQLException;
	public List<ItemDTO> getAllByType(String itemtype) throws SQLException;
	public List<ItemDTO> getAll()throws SQLException;
	public int insertItem(ItemDTO itemdto)throws SQLException;
	public void updateItem(ItemDTO itemdto)throws SQLException;
	public int deleteItembyid(Integer itemid)throws SQLException;
}
