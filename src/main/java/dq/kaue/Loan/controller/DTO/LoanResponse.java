package dq.kaue.Loan.controller.DTO;

import dq.kaue.Loan.model.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
    
}
