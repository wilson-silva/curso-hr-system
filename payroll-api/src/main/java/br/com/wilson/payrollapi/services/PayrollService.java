package br.com.wilson.payrollapi.services;

import br.com.wilson.payrollapi.domain.Payroll;
import br.com.wilson.payrollapi.domain.User;
import br.com.wilson.payrollapi.feignClients.UserFeign;
import br.com.wilson.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {

    private final Environment env;

    private final UserFeign feign;

    public Payroll getPayment(Long workedId, Payroll payroll){
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        try {
            User user = feign.findById(workedId).getBody();
            if(Objects.nonNull(user)){
                return new Payroll(user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice());
            }

        }catch (FeignException.FeignClientException.NotFound ex){
            throw new ObjectNotFoundException("Object not found");
        }catch (Exception ex){
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }

}
