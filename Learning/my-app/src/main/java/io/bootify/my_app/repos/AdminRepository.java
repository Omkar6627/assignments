package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin, Long> {

    boolean existsByAdminNameIgnoreCase(String adminName);

    boolean existsByAdminEmailIgnoreCase(String adminEmail);

}
