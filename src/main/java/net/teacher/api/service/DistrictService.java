package net.teacher.api.service;

import net.teacher.api.model.District;

public interface DistrictService {
	void create(District district);
	void update(District district);
	District findOne(int id);
}
