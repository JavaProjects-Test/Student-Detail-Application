package com.StudentDetail.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.StudentDetail.Model.Students;
import com.StudentDetail.Service.IStudentDetailService;
import com.StudentDetail.Service.StudentServiceDetailImpl;

public class StudentMain {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Students objectStudents = new Students();
		IStudentDetailService objDetailService = new StudentServiceDetailImpl();

		while (true) {
			try {
				System.out.println("Welcome to Student world!!");
				System.out.println("Access Available:");
				System.out
						.println("1. Register a new Student\n2. Remove an exist Student\n3. Modify an exist Student\n4. Search Student \n5. List of all Students\n6. Exit");
				int userChoice;
				userChoice = Integer.parseInt(br.readLine());
				if (userChoice == 6) {
					System.out.println("Thanks...");
					break;
				} else if (userChoice < 1 || userChoice > 6) {
					System.out.println("Access Denied");
				}
				switch (userChoice) {
				case 1: {
					System.out.println("Enter Roll Number");
					objectStudents
							.setRollNumber(Integer.parseInt(br.readLine()));
					System.out.println("Enter Name");
					objectStudents.setName(br.readLine());
					System.out.println("Enter Address");
					objectStudents.setAddress(br.readLine());
					System.out.println("Enter City");
					objectStudents.setCity(br.readLine());
					System.out.println("Enter Password");
					objectStudents.setPassword(br.readLine());

					objDetailService.registerStudent(objectStudents);

					break;
				}
				case 2: {
					System.out.println("Enter Roll number");
					objectStudents
							.setRollNumber(Integer.parseInt(br.readLine()));
					objDetailService.removeStudent(objectStudents);
					break;
				}
				case 3: {
					System.out.println("Enter Roll Number");
					objectStudents
							.setRollNumber(Integer.parseInt(br.readLine()));

					System.out.println("Enter new Name");
					objectStudents.setName(br.readLine());

					/*
					 * System.out.println("Enter new Address");
					 * objectStudents.setAddress(br.readLine());
					 * 
					 * System.out.println("Enter new City");
					 * objectStudents.setCity(br.readLine());
					 * 
					 * System.out.println("Enter new Password");
					 * objectStudents.setPassword(br.readLine());
					 */

					objDetailService.modifyStudent(objectStudents);
					break;
				}
				case 4: {
					System.out.println("Enter Roll Number");
					objectStudents
							.setRollNumber(Integer.parseInt(br.readLine()));
					objDetailService.searchStudent(objectStudents);
					System.out.println("No roll Number available");
					break;
				}
				case 5: {

					System.out
							.println("How do you want to see List: \n1. Sorted\n2. Unsorted");
					switch (Integer.parseInt(br.readLine())) {
					case 1: {
						System.out
								.println("Sort by: \n1. Roll Number\n2. Name\n3. Address\n4. City\n5. Password");
						switch (Integer.parseInt(br.readLine())) {
						case 1: {
							objDetailService.sortByRollNumber(objectStudents);
							break;
						}
						case 2: {
							objDetailService.sortByname(objectStudents);
							break;
						}
						case 3: {
							objDetailService.sortByAddress(objectStudents);
							break;
						}
						case 4: {
							objDetailService.sortByCity(objectStudents);
							break;
						}
						case 5: {
							objDetailService.sortByPassword(objectStudents);
							break;
						}
						default:
							System.out.println("WRONG INPUT!!");
							break;
						}
						break;
					}
					case 2: {
						List<Students> list = objDetailService.listStudent();
						Iterator<Students> iterator = list.iterator();
						System.out
						.println("ROLL NUMBER\t\tNAME\t\tADDRESS\t\tCITY\t\tPASSWORD");
						while (iterator.hasNext()) {
							Students listOfStudent = iterator.next();
							System.out.println(listOfStudent.getRollNumber()
									+ "\t\t\t" + listOfStudent.getName() + "\t\t"
									+ listOfStudent.getAddress() + "\t\t"
									+ listOfStudent.getCity() + "\t\t"
									+ listOfStudent.getPassword());
							System.out.println();
						}

						break;
					}
					default:
						System.out.println("WRONG INPUT!!");
					}

				}
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

			catch (NumberFormatException e) {
				System.err.println("Use numeric volue only!!");
			}
		}
	}

}
