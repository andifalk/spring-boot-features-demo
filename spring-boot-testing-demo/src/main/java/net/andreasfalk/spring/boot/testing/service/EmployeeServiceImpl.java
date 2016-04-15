package net.andreasfalk.spring.boot.testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andreasfalk.spring.boot.testing.entity.Employee;
import net.andreasfalk.spring.boot.testing.repository.EmployeeRepository;

/**
 * Service to manage {@link Employee employees}.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll () {
        return employeeRepository.findAll ();
    }

    @Override
    @Transactional
    public Employee save ( Employee employee ) {
        return employeeRepository.save ( employee );
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findOne ( Long aLong ) {
        return employeeRepository.findOne ( aLong );
    }

    @Override
    @Transactional(readOnly = true)
    public long count () {
        return employeeRepository.count ();
    }

    @Override
    @Transactional
    public void delete ( Long aLong ) {
        employeeRepository.delete ( aLong );
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findOne ( Example<Employee> example ) {
        return employeeRepository.findOne ( example );
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll ( Example<Employee> example ) {
        return employeeRepository.findAll ( example );
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAllWithSkills () {
        return employeeRepository.findAllWithSkills ();
    }
}
