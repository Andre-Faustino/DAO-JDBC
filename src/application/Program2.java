package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;


public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao DepartmentDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("===TEST 1: Department findById ===");
		Department department = DepartmentDao.findById(1);
		
		System.out.println(department);
		
			
		System.out.println("\n===TEST 2: Department findByAll ===");
		
		List<Department> list = DepartmentDao.findAll();
		
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===TEST 3: Department insert ===");
		Department newdepartment = new Department(null, "Music");
		DepartmentDao.insert(newdepartment);
		System.out.println("Inserted! new id = " + newdepartment.getId());
		
		
		System.out.println("\n===TEST 4: Department update ===");
		department = DepartmentDao.findById(1);
		department.setName("Food");
		DepartmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n===TEST 5: Department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		DepartmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		
		sc.close();
	}

}
