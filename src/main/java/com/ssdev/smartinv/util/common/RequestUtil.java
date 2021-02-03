package com.ssdev.smartinv.util.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class RequestUtil {
    public static List<String> getFieldNamesFromBindingResult(BindingResult result) {
        List<String> fieldNames = new ArrayList<>();
        if(result.hasErrors()) {
            result.getAllErrors().forEach(e -> {
                FieldError fieldError = (FieldError)e;
                fieldNames.add(fieldError.getField());
            });
        }
        return fieldNames;
    }
}
