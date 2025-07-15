package in.ashokit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Repository.Employeerepository;
import in.ashokit.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private Employeerepository repo;
	
	@Override
	public boolean registerEmployee(Employee emp) {
		
		 if (repo.findByEmail(emp.getEmail()) != null)
			 {
			 return false;
			 }
		 repo.save(emp);
	        return true;

	}

	@Override
	public Employee login(String email, String password) {
		Employee emp = repo.findByEmail(email);
        if (emp != null && emp.getPassword().equals(password)) {
            return emp;
        }
        return null;
		
	}

}
