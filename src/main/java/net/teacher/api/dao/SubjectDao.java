package net.teacher.api.dao;

import net.teacher.api.model.Subject;

public interface SubjectDao {
	void create(Subject subject);
	void update(Subject subject);
	Subject findOne(int id);
}
