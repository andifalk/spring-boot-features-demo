package net.andreasfalk.spring.boot.testing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.andreasfalk.spring.boot.testing.entity.Employee;

/**
 * Repository for {@link Employee employees}.
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e from Employee e join fetch e.assignedSkills")
    List<Employee> findAllWithSkills();
}
