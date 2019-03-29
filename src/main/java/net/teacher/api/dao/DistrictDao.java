package net.teacher.api.dao;

import net.teacher.api.model.District;

public interface DistrictDao {
	void create(District district);
	void update(District district);
	District findOne(int id);
}
