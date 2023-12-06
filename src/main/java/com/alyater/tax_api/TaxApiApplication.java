package com.alyater.tax_api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alyater.tax_api.controller.TaxService;
import com.alyater.tax_api.model.AuthenticatedUser;
import com.alyater.tax_api.model.BillData;
import com.alyater.tax_api.model.ExpenseData;
import com.alyater.tax_api.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootApplication
public class TaxApiApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(TaxApiApplication.class, args);

		// login
		User user = new User("علي صالح", "321456", "888888880043");
		TaxService taxService = new TaxService();
		AuthenticatedUser authUser = taxService.login(user);

		// // getAllTax
		// System.out.println(taxService.getAllTaxs(authUser.getToken()));

		// // getAllItem
		// System.out.println(taxService.getAllItem(authUser.getToken()));

		// // getAllBillType
		// System.out.println(taxService.getAllBillType(authUser.getToken()));

		// // getAllExpenseType
		// System.out.println(taxService.GetAllExpensesType(authUser.getToken()));

		// addBill

		BillData.BillItem billItem = new BillData.BillItem();
		billItem.setItem("1001002");
		billItem.setAmount("5");
		billItem.setSourceName("string");
		billItem.setSourceCode("string");

		// Create a BillTax object
		BillData.BillTax billTax = new BillData.BillTax();
		billTax.setTax("Tax_EXT1");
		billTax.setValue("1");

		// Create a list for billItems and billTaxes
		ArrayList<BillData.BillItem> billItems = new ArrayList<>();
		billItems.add(billItem);

		ArrayList<BillData.BillTax> billTaxes = new ArrayList<>();
		billTaxes.add(billTax);

		// Create a BillData object using the constructor
		BillData billData = new BillData(
				"10",
				"200",
				"1A954A7F-1A19-40FD-AA05-D32B3FC8487a",
				"sp",
				"string_0.0",
				"2023-02-14T08:48:11.152Z",
				"T2",
				billItems,
				billTaxes);

		// ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		// String json = ow.writeValueAsString(billData);
		// Print the created BillData object
		System.out.println(taxService.addBill(billData, authUser.getToken()));



		// // AddExpense

		// // Create a SimpleDateFormat instance to parse the date string
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

		// Date date = null;
		// // Parse the date string
		// try {
		// 	date = dateFormat.parse("2023-09-28T06:19:52.026Z");
		// } catch (Exception e) {
		// 	// TODO: handle exception
		// }

		// // Create an ExpenseData object using the constructor
		// ExpenseData expenseData = new ExpenseData();
		// expenseData.setExpenseValue(0);
		// expenseData.setCode("3fa85f42-5717-2563-b3fc-2c963f66afa7");
		// expenseData.setDate(date);
		// expenseData.setExpenseType("Expen1");
		// expenseData.setNumber("1");
		// expenseData.setIncomingCode("1A950A7F-1A09-40DC-BA25-D32B3FA8488B");
		// expenseData.setExProgram("string_0.0");
		// System.out.println(taxService.addExpense(expenseData, authUser.getToken()));

	}

}
