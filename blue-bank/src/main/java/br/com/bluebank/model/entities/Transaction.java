package br.com.bluebank.model.entities;


import br.com.bluebank.model.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


@Getter
@Setter
@Builder
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_account_holder")
    private AccountHolder accountHolder;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(nullable = false)
    private Double amount;

}
