package model.order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.customer.Customer;

@Entity
@Access(AccessType.FIELD)
public class Cart implements Serializable{
	private static final long serialVersionUID = -8940513765238936413L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate")
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name = "CustomerID")
	private Customer customer;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
	private List<LineItem> lineitems;
	
	/**
	 * use for JPA purpose
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderID", nullable = true)
	private Order order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<LineItem> getLineitems() {
		return lineitems;
	}

	public void setLineitems(List<LineItem> lineitems) {
		this.lineitems = lineitems;
	}
	
	/**
	 * this method only use for mapping while persisting object in JPA
	 * @param order The order (role: Target in JPA) instance already in the active persistence context
	 */
	public void setAssociationTargetOrder(Order order) {
		this.order = order;
	}
}
