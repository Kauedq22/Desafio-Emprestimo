package dq.kaue.Loan.controller.DTO;

import dq.kaue.Loan.model.Costumer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record ResquestDTO(@Min(value = 18) @NotNull Integer age,
                        @CPF String cpf,
                        @NotBlank String name,
                        @Min(value = 1000) @NotNull Double income,
                        @NotBlank String location) {
                            
    public Costumer toCostumer(){
        return new Costumer(age, cpf, name, income, location);
    }
}
