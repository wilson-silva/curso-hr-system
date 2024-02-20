package br.com.wilson.payrollapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Payroll {

    private String workerName;
    private String description;
    private String hourlyPrice;
    private String workedHours;
    private String totalPayment;
}
