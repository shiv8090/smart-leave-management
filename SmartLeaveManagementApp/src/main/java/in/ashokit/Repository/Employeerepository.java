package in.ashokit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Employee;

public interface Employeerepository extends JpaRepository<Employee, Integer> {
	Employee findByEmail(String email);

}
