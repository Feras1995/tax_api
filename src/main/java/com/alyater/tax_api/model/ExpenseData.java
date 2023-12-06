package com.alyater.tax_api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseData {
    private int expenseValue;
    private String code;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date date;
    
    private String expenseType;
    private String number;
    private String incomingCode;
    private String exProgram;




    // Adjust the annotations based on your specific requirements and the JSON structure.
}

