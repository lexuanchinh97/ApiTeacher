package net.teacher.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.teacher.api.helper.ResponseStatusEnum;
import net.teacher.api.model.Teacher;
import net.teacher.api.model.request.BaseResponse;
import net.teacher.api.service.TeacherService;

@RestController
@RequestMapping("/api/docs/teachers")
public class TeacherController {
	@Autowired private TeacherService teacherService;
	
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
	public ResponseEntity<BaseResponse> create(){
		return null;
		
	}
}
