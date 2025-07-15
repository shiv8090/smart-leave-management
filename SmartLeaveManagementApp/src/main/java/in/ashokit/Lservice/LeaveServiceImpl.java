package in.ashokit.Lservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Repository.LeaveRepository;
import in.ashokit.entity.Employee;
import in.ashokit.entity.LeaveRequest;
@Service
public class LeaveServiceImpl implements LeaveService {
	
    @Autowired
    private LeaveRepository repo;

	@Override
	public void applyLeave(LeaveRequest leave) {
		// TODO Auto-generated method stub
		repo.save(leave);
		
		
		

	}

	@Override
	public List<LeaveRequest> getAllLeaves() {
		// TODO Auto-generated method stub
		  return repo.findAll();
		
	}

	@Override
	public List<LeaveRequest> getLeavesByEmployee(Employee emp) {
		// TODO Auto-generated method stub
		  return repo.findByEmployee(emp);
		
	}

	@Override
	public void updateStatus(Integer id, String status) {
		// TODO Auto-generated method stub
		 LeaveRequest leave = repo.findById(id).orElseThrow();
	        leave.setStatus(status);
	        repo.save(leave);

	}

}
