package com.main.iapps.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.iapps.entity.NewsPaper;

@Repository
public interface NewsPaperRepository extends JpaRepository<NewsPaper, String> {

	Page<NewsPaper> findByNewsPaperNameContains(String name, Pageable pageable);

}
