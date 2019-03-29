package net.teacher.api.dao;

import net.teacher.api.model.ClassMate;

public interface ClassMateDao {
	void create(ClassMate classMate);
	void update(ClassMate classMate);
	ClassMate findOne(int id);
}
