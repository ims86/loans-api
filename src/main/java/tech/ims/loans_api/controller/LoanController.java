package tech.ims.loans_api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.ims.loans_api.controller.dto.CustomerLoanRequest;
import tech.ims.loans_api.controller.dto.CustomerLoanResponse;
import tech.ims.loans_api.service.LoanService;

@RestController
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping(value = "/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest request){

        var loanResponse = service.checkLoanAvailability(request);

        return ResponseEntity.ok(loanResponse);

    }
}
