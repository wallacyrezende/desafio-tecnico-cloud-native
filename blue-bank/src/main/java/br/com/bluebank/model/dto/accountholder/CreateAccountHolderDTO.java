package br.com.bluebank.model.dto.accountholder;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class CreateAccountHolderDTO {

    @NotBlank
    private String CPF;
    @NotNull
    private Long account;
    @NotNull
    private String branch;
}
