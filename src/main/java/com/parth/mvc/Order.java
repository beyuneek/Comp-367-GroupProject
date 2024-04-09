package com.parth.mvc;

//MVC model class
public class Order {
	
	    //declaration of properties
		public String firstname;
		public String lastname;
		public String middleName;
		private String contactNumber;
	    private String billingAddress;
	    private String emailAddress;
	    public String getPhoneBrand() {
			return phoneBrand;
		}
		public void setPhoneBrand(String phoneBrand) {
			this.phoneBrand = phoneBrand;
		}
		public String getPhoneModel() {
			return phoneModel;
		}
		public void setPhoneModel(String phoneModel) {
			this.phoneModel = phoneModel;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		private String phoneBrand;
	    private String phoneModel;
	    private int quantity;


	    
	    
	    
	    
		  public String getEmailAddress() {
			return emailAddress;
		}
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		public String getBillingAddress() {
			return billingAddress;
		}
		public void setBillingAddress(String billingAddress) {
			this.billingAddress = billingAddress;
		}
			
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		
		 public double calculateTotalPrice() {
		        double pricePerUnit = 0;

		        // Basic price list (you can expand this or retrieve it from a database)
		        if ("Apple".equalsIgnoreCase(phoneBrand) && "iPhone 13".equalsIgnoreCase(phoneModel)) {
		            pricePerUnit = 799; // Just an example price
		        } else if ("Samsung".equalsIgnoreCase(phoneBrand) && "Samsung Galaxy S22".equalsIgnoreCase(phoneModel)) {
		            pricePerUnit = 999; // Just an example price
		        }

		        return pricePerUnit * quantity;
		    }
		

	
		
	

}
