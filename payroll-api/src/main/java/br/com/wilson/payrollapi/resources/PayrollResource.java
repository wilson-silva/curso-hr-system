package br.com.wilson.payrollapi.resources;

import br.com.wilson.payrollapi.domain.Payroll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return ResponseEntity.ok().body(
                new Payroll("Valdir",
                        payment.getDescription(),
                        payment.getHourlyPrice(),
                        payment.getWorkedHours(),
                        payment.getWorkedHours() * payment.getHourlyPrice())
        );
    }
}
