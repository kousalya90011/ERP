package com.jfsd.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfsd.erp.models.Section;
import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {
	public Section findBySectionno(String sectionno);

}
