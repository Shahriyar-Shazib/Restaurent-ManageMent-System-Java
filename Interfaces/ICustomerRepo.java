package Interfaces;

import java.lang.*;

import Entity.*;

public interface ICustomerRepo
{
	//Customer getCustomer(String customerId, String name);
	public void insertInDB(Customer c);
	public void deleteFromDB(String cistomerId);
	public void updateInDB(Customer c);
	public String[][] getAllTable();
	public String[][] getAllFooditem();
	//public Table BookTable(String tableId);
}