package br.com.bluebank.model.dto.accountholder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AccountHolderDTO {

    private String cpf;
    private Long account;
    private String branch;
    private Double balance;
}
