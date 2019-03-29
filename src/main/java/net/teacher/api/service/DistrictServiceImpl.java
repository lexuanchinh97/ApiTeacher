package net.teacher.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.teacher.api.dao.DistrictDao;
import net.teacher.api.model.District;

@Transactional
@Service("districtService")
public class DistrictServiceImpl implements DistrictService{
	@Autowired private DistrictDao dao;
	@Override
	public void create(District district) {
		// TODO Auto-generated method stub
		dao.create(district);
	}

	@Override
	public void update(District district) {
		// TODO Auto-generated method stub
		dao.update(district);
	}

	@Override
	public District findOne(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}
