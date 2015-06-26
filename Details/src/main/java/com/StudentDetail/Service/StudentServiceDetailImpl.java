package com.StudentDetail.Service;

import java.util.List;

import com.StudentDetail.DTO.IStudentDetailDAO;
import com.StudentDetail.DTO.StudentDetailDAOImpl;
import com.StudentDetail.Model.Students;

public class StudentServiceDetailImpl implements IStudentDetailService {

	IStudentDetailDAO objectDetailDAO = new StudentDetailDAOImpl();

	public boolean registerStudent(Students objectStudent) {

		boolean status = false;
		if (objectStudent.getRollNumber() > 0
				|| objectStudent.getName() != null
				|| objectStudent.getAddress() != null
				|| objectStudent.getCity() != null
				|| objectStudent.getPassword() != null) {

			status = true;
		}
		objectDetailDAO.registerStudent(objectStudent);

		return status;
	}

	public boolean removeStudent(Students objectStudent) {
		boolean status = false;
		if (objectStudent.getRollNumber() > 0) {
			status = true;
		}
		objectDetailDAO.removeStudent(objectStudent);
		return status;
	}

	public boolean modifyStudent(Students objectStudent) {
		boolean status = false;
		if (objectStudent != null) {
			status = true;
		} else {
			System.out.println("Insert some data");
		}
		objectDetailDAO.modifyStudent(objectStudent);
		return status;
	}

	public boolean searchStudent(Students objectStudent) {
		boolean status = false;
		if (objectStudent.getRollNumber() > 0) {
			status = true;
		}
		objectDetailDAO.searchStudent(objectStudent);
		return status;
	}

	public List<Students> listStudent() {

		return objectDetailDAO.listStudent();
	}

	public boolean sortByRollNumber(Students objectStudent) {
		boolean status = false;
		if (objectStudent.getRollNumber() > 0) {

			status = true;
		}
		objectDetailDAO.sortByRollNumber(objectStudent);
		return status;
	}

	public boolean sortByname(Students objectStudent) {
		boolean status = false;
		if (objectStudent.getRollNumber() > 0) {
			status = true;
		}
		objectDetailDAO.sortByname(objectStudent);
		return status;
	}

	public boolean sortByAddress(Students objectStudent) {
		boolean status = false;
		if (objectStudent.getRollNumber() > 0) {
			status = true;
		}
		objectDetailDAO.sortByAddress(objectStudent);
		return status;
	}

	public boolean sortByCity(Students objectStudent) {
		boolean status = false;
		if (objectStudent.getRollNumber() > 0) {
			status = true;
		}
		objectDetailDAO.sortByCity(objectStudent);
		return status;
	}

	public boolean sortByPassword(Students objectStudent) {
		boolean status = false;
		if (objectStudent.getRollNumber() > 0) {
			status = true;
		}
		objectDetailDAO.sortByPassword(objectStudent);
		return status;
	}

}
