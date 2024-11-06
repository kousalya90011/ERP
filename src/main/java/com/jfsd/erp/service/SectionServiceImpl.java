package com.jfsd.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Course;
import com.jfsd.erp.models.Section;
import com.jfsd.erp.repository.SectionRepository;

@Service
public class SectionServiceImpl implements SectionService {
	
	@Autowired 
	private SectionRepository sectionRepository;
	
	@Override
	 public Section findSectionById(int sectionId) {
	        // Use the repository to find the course
	        Section section = sectionRepository.findById(sectionId).get();
	        return section; // Return the course if found, or null if not found
	    }

	@Override
	public List<Section> findAllSections() {
		// TODO Auto-generated method stub
		return sectionRepository.findAll();
	}

	@Override
	public Section findSectionByNo(String sectionNo) {
		// TODO Auto-generated method stub
		return sectionRepository.findBySectionno(sectionNo);
	}

}
