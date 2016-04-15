package net.andreasfalk.spring.boot.testing.service;

import java.util.List;

import org.springframework.data.domain.Example;

import net.andreasfalk.spring.boot.testing.entity.Employee;

/**
 * Service to manage {@link Employee employees}.
 */
public interface EmployeeService {

    List<Employee> findAll ();

    Employee save ( Employee employee );

    Employee findOne ( Long aLong );

    long count ();

    void delete ( Long aLong );

    Employee findOne ( Example<Employee> example );

    List<Employee> findAll ( Example<Employee> example );

    List<Employee> findAllWithSkills ();
}
