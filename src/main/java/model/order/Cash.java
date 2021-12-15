package model.order;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("CASH")
@PrimaryKeyJoinColumn(name = "PaymentID")
public class Cash extends Payment{
	
	private float cashTendered;

	public float getCashTendered() {
		return cashTendered;
	}

	public void setCashTendered(float cashTendered) {
		this.cashTendered = cashTendered;
	}
	
	
}
