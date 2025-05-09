package lemonadestand.model;

public class Customer implements Person {
  /**
	 * 
	 */
	private static final long serialVersionUID = -5243658913641133659L;

	private String name;
	private String phoneNumber;

	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public Customer() {
  }
  
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public String getPhoneNumber() {
		return phoneNumber;
	}

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
		return name;
	}
  
  public void setName(String name) {
    this.name = name;
  }

  @Override
	public String toString() {
		return "Customer {name=" + getName() + ", phoneNumber=" + phoneNumber + "}";
	}
	
	@Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
    Customer other = (Customer) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (phoneNumber == null) {
      if (other.phoneNumber != null)
        return false;
    } else if (!phoneNumber.equals(other.phoneNumber))
      return false;
    return true;
  }
}
