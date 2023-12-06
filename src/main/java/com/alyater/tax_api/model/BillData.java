package com.alyater.tax_api.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillData {
    private String billValue;
    private String billNumber;
    private String code;
    private String currency;
    private String exProgram;
    private String date;
    private String billType;
    private List<BillItem> billItems;
    private List<BillTax> billTaxes;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BillItem {
        private String item;
        private String amount;
        private String sourceName;
        private String sourceCode;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BillTax {
        private String tax;
        private String value;

    }

}
