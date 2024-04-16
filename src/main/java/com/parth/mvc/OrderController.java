package com.parth.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//MVC controller class
@Controller
public class OrderController {
	
	 //Request mapping to process index page request
	
	 @RequestMapping("/login")
	 public String login(@ModelAttribute(name="loginForm") Order loginBean, Model m) {

		 
		 String firstname = loginBean.getFirstname();
		 String lastname = loginBean.getLastname();
		 String middleName = loginBean.getMiddleName();
		 String emailAddress = loginBean.getEmailAddress();
		 String contactNumber = loginBean.getContactNumber();
		 String billingAddress = loginBean.getBillingAddress();
		 String phoneBrand = loginBean.getPhoneBrand();
		 String phoneModel = loginBean.getPhoneModel();
		 int quantity = loginBean.getQuantity();
		 String phoneId = generatePhoneId(phoneModel);  // This is a new method you'll create

		 double totalPrice = loginBean.calculateTotalPrice();

         m.addAttribute("fname", "First Name: " + firstname + ".");
         m.addAttribute("Mname", "Middle Name: " + middleName + ".");
         m.addAttribute("lname", "Last Name: " + lastname + ".");
         m.addAttribute("email", "Email Address: " + emailAddress + ".");
         m.addAttribute("contact", "Contact Number: " + contactNumber + ".");
         m.addAttribute("billing", "Billing Address: " + billingAddress + ".");
         
         m.addAttribute("brand", "Phone Brand: " + phoneBrand + ".");
		 m.addAttribute("model", "Phone Model: " + phoneModel + ".");
		 m.addAttribute("quantity", "Quantity: " + quantity + ".");
		 m.addAttribute("phoneId", "Unique Phone ID: " + phoneId + ".");
		 m.addAttribute("totalPrice", "Total Price: $" + totalPrice);

		 
		
    	//return to the success-login Thymeleaf page
         	return "result";
      	

   		
    	
      }
	 
	 @GetMapping("/aboutmyself")
	    public String showAboutPage() {
	        return "aboutmyself"; // Return the name of your homepage template

	 }
	 
	 @RequestMapping("/")
	 public String showHomePage(Model model) {
		 return "index";
	 }
	 
	 private String generatePhoneId(String phoneModel) {
		    // A simple way to generate unique ID based on phone model and current time
		    return phoneModel.replace(" ", "") + System.currentTimeMillis();
		}
	  
	}


