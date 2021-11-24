package eus.birt.dam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.birt.dam.repository.CyclistRepository;


	@Service
	public class CyclistServiceImpl implements CyclistService {

		@Autowired
		private CyclistRepository cyclistRepository;

		@Override
		public void deleteById(Long id) {
			cyclistRepository.deleteById(id);
		}

	}
