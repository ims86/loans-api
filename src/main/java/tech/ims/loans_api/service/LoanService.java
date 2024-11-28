package tech.ims.loans_api.service;


import org.springframework.stereotype.Service;
import tech.ims.loans_api.controller.dto.CustomerLoanRequest;
import tech.ims.loans_api.controller.dto.CustomerLoanResponse;
import tech.ims.loans_api.controller.dto.LoanResponse;
import tech.ims.loans_api.domain.Loan;
import tech.ims.loans_api.domain.enums.LoanType;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest){

        var customer = loanRequest.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if(loan.isPersonalLoanAvailable()){
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if(loan.isConsigmentLoanAvailable()){
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsigmentLoanInterestRate()));
        }

        if(loan.isGuaranteedLoanAvailable()){
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return new CustomerLoanResponse(loanRequest.name(), loans);

    }
}
