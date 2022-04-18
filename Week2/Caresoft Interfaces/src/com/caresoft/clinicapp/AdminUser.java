package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    
    private String role;
    private ArrayList<String> securityIncidents;
    
    public AdminUser(Integer id, String role) {
    	super(id);
    	this.setRole(role);
    	this.securityIncidents = new ArrayList<String>();
    }
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    @Override
    public boolean assignPin(int pin) {
    	// TODO Auto-generated method stub
    	if( String.valueOf(pin).length() < 6 ) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	// TODO Auto-generated method stub
    	if( confirmedAuthID == this.id ) {
			return true;
		}
		else {
			this.authIncident();
			return false;
		}
    }
    @Override
    public ArrayList<String> reportSecurityIncidents() {
    	// TODO Auto-generated method stub
    	return this.securityIncidents;
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    // TO DO: Setters & Getters
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
	

}
