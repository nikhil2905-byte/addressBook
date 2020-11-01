package com.Simple.Address.Book;

public interface AddressBookInfo {
		 public void add();
		    public void edit(String firstName);
		    public void delete(String firstName);
		    public void sortAlphabetically();
		    public void sortZip();
		    public void sortCity();
		    public void sortState();
		    public void viewByCity(String city);
		    public void viewByState(String state);
		    public void searchPersonInCity(String firstName);
		    public void searchPersonInState(String firstName);
	}
