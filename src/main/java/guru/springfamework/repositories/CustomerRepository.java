package guru.springfamework.repositories;

import guru.springfamework.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by robertZ on 2023-08-10.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
