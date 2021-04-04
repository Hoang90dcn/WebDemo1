package com.fsot.demoWeb1.Repo;

import com.fsot.demoWeb1.Entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepo extends JpaRepository<ProviderEntity,Long> {
}
