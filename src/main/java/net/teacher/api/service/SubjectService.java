package net.teacher.api.service;

import net.teacher.api.model.Subject;

public interface SubjectService {
	void create(Subject subject);
	void update(Subject subject);
	Subject findOne(int id);
}
