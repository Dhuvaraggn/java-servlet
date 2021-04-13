package daopack;

import java.io.Serializable;

public class UserDTO implements Serializable,Cloneable {
	private int userid;
	private String username;
	private String password;
	private UserDTO userdto;
	private int flag;
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(int userid, String username, String password,int flag) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.flag=0;
	}
	
	public final int getFlag() {
		return flag;
	}
	public final void setFlag(int flag) {
		this.flag = flag;
	}
	public UserDTO getUserObject()
	{
		if(userdto==null) {
			userdto=new UserDTO();
		}
		return userdto.createClone();
	}
	private UserDTO createClone()
	{
		try {
			return (UserDTO)super.clone();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public final int getUserid() {
		return userid;
	}
	public final String getUsername() {
		return username;
	}
	public final String getPassword() {
		return password;
	}
	public final void setUserid(int userid) {
		this.userid = userid;
	}
	public final void setUsername(String username) {
		this.username = username;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserDTO other = (UserDTO) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userid != other.userid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	
}
