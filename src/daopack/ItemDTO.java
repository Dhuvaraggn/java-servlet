package daopack;

import java.io.Serializable;

public class ItemDTO  implements Serializable,Cloneable{
		private int itemid;
		private String itemname;
		private String itemtype;
		private int price;
	
		private static ItemDTO itemdto;
		synchronized public ItemDTO getItemObject()
		{
			if(itemdto==null) {
				itemdto=new ItemDTO();
			}
			return itemdto.createClone();
		}
		private ItemDTO createClone() {
			try {
			return (ItemDTO)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public ItemDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ItemDTO(int itemid, String itemname, String itemtype, int price) {
			super();
			this.itemid = itemid;
			this.itemname = itemname;
			this.itemtype = itemtype;
			this.price = price;
		}
		@Override
		public String toString() {
			return "ItemDTO [itemid=" + itemid + ", itemname=" + itemname + ", itemtype=" + itemtype + ", price="
					+ price + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + itemid;
			result = prime * result + ((itemname == null) ? 0 : itemname.hashCode());
			result = prime * result + ((itemtype == null) ? 0 : itemtype.hashCode());
			result = prime * result + price;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItemDTO other = (ItemDTO) obj;
			if (itemid != other.itemid)
				return false;
			if (itemname == null) {
				if (other.itemname != null)
					return false;
			} else if (!itemname.equals(other.itemname))
				return false;
			if (itemtype == null) {
				if (other.itemtype != null)
					return false;
			} else if (!itemtype.equals(other.itemtype))
				return false;
			if (price != other.price)
				return false;
			return true;
		}
		public final int getItemid() {
			return itemid;
		}
		public final String getItemname() {
			return itemname;
		}
		public final String getItemtype() {
			return itemtype;
		}
		public final int getPrice() {
			return price;
		}
		public final void setItemid(int itemid) {
			this.itemid = itemid;
		}
		public final void setItemname(String itemname) {
			this.itemname = itemname;
		}
		public final void setItemtype(String itemtype) {
			this.itemtype = itemtype;
		}
		public final void setPrice(int price) {
			this.price = price;
		}
						
}
