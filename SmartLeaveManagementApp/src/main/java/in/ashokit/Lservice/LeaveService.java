package in.ashokit.Lservice;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;
import in.ashokit.entity.LeaveRequest;

@Service
public interface LeaveService {
	void applyLeave(LeaveRequest leave);
    List<LeaveRequest> getAllLeaves();
    List<LeaveRequest> getLeavesByEmployee(Employee emp);
    void updateStatus(Integer id, String status);

}
