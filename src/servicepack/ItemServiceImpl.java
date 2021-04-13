package servicepack;

import java.sql.SQLException;
import java.util.List;

import daopack.ItemDAO;
import daopack.ItemDAOImpl;
import daopack.ItemDTO;

public  class ItemServiceImpl implements ItemService,Cloneable {
	private static ItemServiceImpl itemServ;
	private ItemDAO itemDAO;
	private ItemServiceImpl()
	{
	}
	public static ItemServiceImpl getItemServ() {
		if(itemServ==null)
		{
			itemServ=new ItemServiceImpl();
		}
		return itemServ.createClone();
	}
	private ItemServiceImpl createClone() {
		try {
			return (ItemServiceImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public ItemServiceImpl(ItemDAO itemdao) {
		this.itemDAO=itemdao;
	}
	@Override
	public List<ItemDTO> getAllByType(String itemtype) {
		try {
			return itemDAO.getAllByType(itemtype);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public final ItemDAO getItemDAO() {
		return itemDAO;
	}
	public final void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	@Override
	public List<ItemDTO> getAll() {
		try {
			return itemDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
