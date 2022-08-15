package br.com.bluebank.repository.accountholder;

import br.com.bluebank.model.entities.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long>{

    Optional<AccountHolder> findByCpf(String cpf);
}
