package net.teacher.api.service;

import net.teacher.api.model.ClassMate;

public interface ClassMateService {
	void create(ClassMate classMate);
	void update(ClassMate classMate);
	ClassMate findOne(int id);
}
