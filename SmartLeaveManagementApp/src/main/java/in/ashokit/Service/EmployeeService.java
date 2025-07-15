package in.ashokit.Service;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;
@Service
public interface EmployeeService {
	boolean registerEmployee(Employee emp);
    Employee login(String email, String password);

}
