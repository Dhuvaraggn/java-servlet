package servicepack;

import java.util.List;

import daopack.ItemDTO;

public interface ItemService {
	public List<ItemDTO> getAllByType(String itemtype);
}	
