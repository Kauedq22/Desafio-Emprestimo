package dq.kaue.Loan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dq.kaue.Loan.controller.DTO.LoanResponse;
import dq.kaue.Loan.controller.DTO.ResponseDTO;
import dq.kaue.Loan.controller.DTO.ResquestDTO;
import dq.kaue.Loan.model.Loan;
import dq.kaue.Loan.model.LoanType;

@Service
public class LoanService {
    
    public ResponseDTO check(ResquestDTO resquest){
        var costumer = resquest.toCostumer();
        var loan = new Loan(costumer);

        List<LoanResponse> loans = new ArrayList<>();

        if(loan.IsPersoal()){
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonal()));
        }
        if(loan.isGuaranteed()){
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteed()));
        }
        if(loan.isConsignment()){
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignment()));
        }

        return new ResponseDTO(resquest.name(), loans);
    }
}
