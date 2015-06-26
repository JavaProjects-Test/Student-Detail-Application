package com.StudentDetail.Service;

import java.util.List;

import com.StudentDetail.Model.Students;

public interface IStudentDetailService {

	public boolean registerStudent(Students objectStudent);

	public boolean removeStudent(Students objectStudent);

	public boolean modifyStudent(Students objectStudent);

	public boolean searchStudent(Students objectStudent);

	public List<Students> listStudent();

	public boolean sortByRollNumber(Students objectStudent);

	public boolean sortByname(Students objectStudent);

	public boolean sortByAddress(Students objectStudent);

	public boolean sortByCity(Students objectStudent);

	public boolean sortByPassword(Students objectStudent);

}
