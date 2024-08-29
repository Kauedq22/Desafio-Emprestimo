package dq.kaue.Loan.controller;

import org.springframework.web.bind.annotation.RestController;

import dq.kaue.Loan.controller.DTO.ResponseDTO;
import dq.kaue.Loan.controller.DTO.ResquestDTO;
import dq.kaue.Loan.service.LoanService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
public class LoanController {

    private LoanService service;
    
    @PostMapping(value = "/customer-loans")
    public ResponseEntity<ResponseDTO> loan(@RequestBody @Valid ResquestDTO request) {
        var resp = service.check(request);

        return ResponseEntity.ok(resp);
    }
    
}
