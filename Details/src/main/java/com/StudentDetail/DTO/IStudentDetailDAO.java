package com.StudentDetail.DTO;


import java.util.List;

import com.StudentDetail.Model.Students;

public interface IStudentDetailDAO {
	public boolean registerStudent(Students objectStudent);

	public boolean removeStudent(Students objectStudent);

	public boolean modifyStudent(Students objectStudent);

	public void searchStudent(Students objectStudent);

	public List<Students> listStudent();

	public boolean sortByRollNumber(Students objectStudent);

	public boolean sortByname(Students objectStudent);

	public boolean sortByAddress(Students objectStudent);

	public boolean sortByCity(Students objectStudent);

	public boolean sortByPassword(Students objectStudent);
}
