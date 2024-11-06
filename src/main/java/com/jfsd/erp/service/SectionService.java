package com.jfsd.erp.service;

import java.util.List;

import com.jfsd.erp.models.Section;

public interface SectionService {
	public Section findSectionById(int sectionId) ;
	public List<Section> findAllSections();
	public Section findSectionByNo(String sectionNo);
}
