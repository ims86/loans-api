package tech.ims.loans_api.controller.dto;

import java.util.List;

public record CustomerLoanResponse(String customer, List<LoanResponse> loans) {
}
