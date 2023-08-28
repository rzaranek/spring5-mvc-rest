package guru.springfamework.repositories;

import guru.springfamework.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by robertZ on 2023-08-26.
 */
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
