package in.ashokit.Repository;   // keep package exactly as it is

import org.springframework.data.jpa.repository.JpaRepository;
import in.ashokit.entity.LeaveRequest;
import in.ashokit.entity.Employee;
import java.util.List;

public interface LeaveRepository
        extends JpaRepository<LeaveRequest, Integer> {   // ✔ domain type = LeaveRequest

    List<LeaveRequest> findByEmployee(Employee emp);
}

