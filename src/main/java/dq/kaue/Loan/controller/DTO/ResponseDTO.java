package dq.kaue.Loan.controller.DTO;

import java.util.List;

public record ResponseDTO(String costumer, List<LoanResponse> loan) {
    
}
