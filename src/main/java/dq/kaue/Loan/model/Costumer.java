package dq.kaue.Loan.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Costumer {
    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public boolean IsIncomeLowerOrEqualThan(double value){
        return income <= value;
    }
    public boolean IsIncomeGraterOrEqualThan(double value){
        return income >= value;
    }
    public boolean IsIncomeBetween(double min, double max){
        return income >= min && income <= max;
    }
    public boolean isFromLocation(String location){
        return this.location.equalsIgnoreCase(location);
    }
    public boolean isAgeEqual(int value){
        return age <= value;
    }

}
