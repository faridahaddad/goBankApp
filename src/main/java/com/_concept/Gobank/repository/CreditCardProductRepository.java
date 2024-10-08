package com._concept.Gobank.repository;

import com._concept.Gobank.model.CreditCardProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardProductRepository extends JpaRepository<CreditCardProduct, Long> {
}
