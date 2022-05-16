package com.pfa.clickandcollect.Repositories;

import com.pfa.clickandcollect.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
