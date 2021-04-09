package daopack;

import java.sql.Date;
import java.time.LocalDateTime;

public class InvoiceMasterDTO {
	private String invoiceid;
	private Date invoicedate;
	private String custname;
	private InvoiceMasterDTO invoicedto;
	public InvoiceMasterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceMasterDTO(String invoiceid, Date invoicedate, String custname, InvoiceMasterDTO invoicedto) {
		super();
		this.invoiceid = invoiceid;
		this.invoicedate = invoicedate;
		this.custname = custname;
		this.invoicedto = invoicedto;
	}



	public final Date getInvoicedate() {
		return invoicedate;
	}

	public final String getCustname() {
		return custname;
	}

	public final InvoiceMasterDTO getInvoicedto() {
		return invoicedto;
	}


	public final String getInvoiceid() {
		return invoiceid;
	}

	public final void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}

	public final void setInvoicedate(Date invoicedate) {
		this.invoicedate = invoicedate;
	}

	public final void setCustname(String custname) {
		this.custname = custname;
	}

	public final void setInvoicedto(InvoiceMasterDTO invoicedto) {
		this.invoicedto = invoicedto;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceid=" + invoiceid + ", invoicedate=" + invoicedate + ", custname=" + custname
				+ ", invoicedto=" + invoicedto + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		if (custname == null) {
			if (other.custname != null)
				return false;
		} else if (!custname.equals(other.custname))
			return false;
		if (invoicedate == null) {
			if (other.invoicedate != null)
				return false;
		} else if (!invoicedate.equals(other.invoicedate))
			return false;
		if (invoicedto == null) {
			if (other.invoicedto != null)
				return false;
		} else if (!invoicedto.equals(other.invoicedto))
			return false;
		if (invoiceid != other.invoiceid)
			return false;
		return true;
	}

	synchronized public InvoiceMasterDTO getInvoicemObject()
	{
		if(invoicedto==null) {
			invoicedto=new InvoiceMasterDTO();
		}
		return invoicedto.createClone();
	}
	private InvoiceMasterDTO createClone()
	{
		try {
			return(InvoiceMasterDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	}
