package daopack;

import java.io.Serializable;

public class InvoiceTransDTO implements Serializable,Cloneable {

	private String invoiceid;
	private String itemname;
	private int qty;
	private InvoiceTransDTO invoicetdto;
	public InvoiceTransDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceTransDTO(String invoiceid, String itemid, int qty) {
		super();
		this.invoiceid = invoiceid;
		this.itemname = itemid;
		this.qty = qty;
	}
	synchronized public InvoiceTransDTO getInvoiceTransObject()
	{
		if(invoicetdto==null) {
			invoicetdto=new InvoiceTransDTO();
		}
		return invoicetdto.createClone();
	}
	private InvoiceTransDTO createClone()
	{
		try
		{
			return (InvoiceTransDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String toString() {
		return "InvoiceTransDTO [invoiceid=" + invoiceid + ", itemname=" + itemname + ", qty=" + qty + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceTransDTO other = (InvoiceTransDTO) obj;
		if (invoiceid != other.invoiceid)
			return false;
		if (itemname != other.itemname)
			return false;
		if (qty != other.qty)
			return false;
		return true;
	}

	public final int getQty() {
		return qty;
	}

	
	public final String getInvoiceid() {
		return invoiceid;
	}
	public final void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public final String getItemname() {
		return itemname;
	}
	public final void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public final void setQty(int qty) {
		this.qty = qty;
	}
}
