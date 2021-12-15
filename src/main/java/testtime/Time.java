package testtime;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "times")
public class Time implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6417290275289104423L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatTime() {
		return createTime;
	}

	public void setCreatTime(Date creatTime) {
		this.createTime = creatTime;
	}
	
	
}
