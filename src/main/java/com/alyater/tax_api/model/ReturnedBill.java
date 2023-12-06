package com.alyater.tax_api.model;

import java.util.List;

public class ReturnedBill {
 private String bill;
    private String returnedBillValue;
    private String date;
    private List<BillItem> billItems;
    private List<BillTax> billTaxes;

    

    public ReturnedBill() {
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getReturnedBillValue() {
        return returnedBillValue;
    }

    public void setReturnedBillValue(String returnedBillValue) {
        this.returnedBillValue = returnedBillValue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }

    public List<BillTax> getBillTaxes() {
        return billTaxes;
    }

    public void setBillTaxes(List<BillTax> billTaxes) {
        this.billTaxes = billTaxes;
    }

    public static class BillItem {
        private String item;
        private String amount;
        public String getItem() {
            return item;
        }
        public void setItem(String item) {
            this.item = item;
        }
        public String getAmount() {
            return amount;
        }
        public void setAmount(String amount) {
            this.amount = amount;
        }
        public BillItem() {
        }

        
    }

    public static class BillTax {
        private String tax;
        private String value;
        
        public String getTax() {
            return tax;
        }
        public void setTax(String tax) {
            this.tax = tax;
        }
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public BillTax() {
        }

        
    }

    
}

