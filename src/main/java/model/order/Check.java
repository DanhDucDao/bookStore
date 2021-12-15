package model.order;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "PaymentID")
@DiscriminatorValue("CHECK")
public class Check extends Payment{
	private String name;
	
	private String bankId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	@Override
	public String toString() {
		return "Check [name=" + name + ", bankId=" + bankId + "]";
	}
}
