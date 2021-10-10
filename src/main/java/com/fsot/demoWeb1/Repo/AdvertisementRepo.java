package com.fsot.demoWeb1.Repo;

import com.fsot.demoWeb1.Entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepo extends JpaRepository<Advertisement, Long> {
}
