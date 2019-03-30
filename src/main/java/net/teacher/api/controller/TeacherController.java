package net.teacher.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.teacher.api.helper.ResponseStatusEnum;
import net.teacher.api.model.ClassMate;
import net.teacher.api.model.District;
import net.teacher.api.model.Subject;
import net.teacher.api.model.Teacher;
import net.teacher.api.model.TeacherClass;
import net.teacher.api.model.TeacherSubject;
import net.teacher.api.model.request.BaseResponse;
import net.teacher.api.model.request.TeacherRequest;
import net.teacher.api.service.ClassMateService;
import net.teacher.api.service.DistrictService;
import net.teacher.api.service.SubjectService;
import net.teacher.api.service.TeacherClassService;
import net.teacher.api.service.TeacherService;
import net.teacher.api.service.TeacherSubjectService;

@RestController
@RequestMapping("/api/docs/teachers")
public class TeacherController {
	@Autowired private TeacherService teacherService;
	
	@Autowired private TeacherSubjectService teacherSubjectService;
	
	@Autowired private TeacherClassService teacherClassService;
	
	@Autowired private SubjectService subjectService;
	
	@Autowired private ClassMateService classMateService;
	
	@Autowired private DistrictService districtService;
	
	@RequestMapping(value="",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BaseResponse> getAll(){
		BaseResponse response=new BaseResponse();
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setStatus(ResponseStatusEnum.SUCCESS);
		List<Teacher> teachers=teacherService.findAll();
		response.setData(teachers);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BaseResponse> searchTeacher(@RequestParam(name="subjectId", required=false, defaultValue="-1") int subjectId,
			@RequestParam(name="gender") int gender,
			@RequestParam(name="classId", required=false, defaultValue="-1") int classId,
			@RequestParam(name="districtId", required=false, defaultValue="-1") int districtId
			
			){
		BaseResponse response=new BaseResponse();
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setStatus(ResponseStatusEnum.SUCCESS);
		List<Teacher> teachers=teacherService.findAll(gender,subjectId,classId,districtId);
		response.setData(teachers);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BaseResponse> create(@RequestBody TeacherRequest request) {
		BaseResponse response=new BaseResponse();
		response.setData(null);
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setStatus(ResponseStatusEnum.SUCCESS);
		Teacher check=teacherService.findByPhone(request.getPhone());
		if(check!=null) {
			response.setMessageError("Số điện thoại đã được sử dụng");
			response.setStatus(ResponseStatusEnum.FAIL);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		Teacher teacher=new Teacher();
		teacher.setStatus((byte)1);
		teacher.setAddress(request.getAddress());
		teacher.setDescription(request.getDescription());
		teacher.setEmail(request.getEmail());
		teacher.setGender((byte)request.getGender());
		teacher.setJob(request.getJob());
		teacher.setName(request.getName());
		teacher.setPhone(request.getPhone());
		teacher.setUniversity(request.getUniversity());
		teacher.setSalary(request.getSalary());	
		District district=districtService.findOne(request.getDistrictId());
		teacher.setDistrict(district);
		teacherService.create(teacher);
		Teacher teacherTemp=teacherService.findByPhone(request.getPhone());
		String[] listSubjectId=request.getListSubjectId().split(",");
		for(String id:listSubjectId) {
			TeacherSubject teacherSubject=new TeacherSubject();
			Subject subject=subjectService.findOne(Integer.parseInt(id));
			teacherSubject.setSubject(subject);
			teacherSubject.setTeacher(teacherTemp);		
			teacherSubjectService.create(teacherSubject);
		}
		
		String[] listClassId=request.getListClassId().split(",");
		for(String id:listClassId) {
			TeacherClass teacherClass=new TeacherClass();
			ClassMate classMate=classMateService.findOne(Integer.parseInt(id));
			teacherClass.setClassMate(classMate);
			teacherClass.setTeacher(teacherTemp);	
			teacherClassService.create(teacherClass);
		}
		
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		
	}
}
