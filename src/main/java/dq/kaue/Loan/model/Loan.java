package dq.kaue.Loan.model;

import dq.kaue.Loan.exception.LoanException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Loan {
    
    private final Costumer costumer;


    public boolean IsPersoal(){
        return basic();
    }
    public boolean isConsignment(){
        return costumer.IsIncomeGraterOrEqualThan(5000.00);
    }
    public boolean isGuaranteed(){
        return basic();
    }


    public double getPersonal(){
        if(IsPersoal()){
            return 4.0;
        }
        throw new LoanException();
    }
    public double getGuaranteed(){
        if(isGuaranteed()){
            return 3.0;
        }
        throw new LoanException();
    }
    public double getConsignment(){
        if(isConsignment()){
            return 2.0;
        }
        throw new LoanException();
    }


    private boolean basic(){
        if(costumer.IsIncomeLowerOrEqualThan(3000.00)){
            return true;
        }
        return costumer.IsIncomeBetween(3000.00, 5000.00)
        && costumer.isAgeEqual(30)
        && costumer.isFromLocation("SC");
    }
}
