package br.com.bluebank.model.dto.accountholder;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class CreateAccountHolderDTO {

    @NotBlank
    @Size(max = 14)
    private String CPF;
    @NotNull
    private Long account;
    @NotNull
    private String branch;
}
