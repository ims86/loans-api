package tech.ims.loans_api.controller.dto;

import tech.ims.loans_api.domain.enums.LoanType;

public record LoanResponse(LoanType type,
                           Double interestRate) {
}
