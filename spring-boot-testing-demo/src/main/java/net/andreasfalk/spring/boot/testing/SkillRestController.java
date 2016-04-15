package net.andreasfalk.spring.boot.testing;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.andreasfalk.spring.boot.testing.boundary.EmployeeDTO;
import net.andreasfalk.spring.boot.testing.entity.Employee;
import net.andreasfalk.spring.boot.testing.service.EmployeeService;

/**
 * Rest controller for employee skills.
 */
@RestController
public class SkillRestController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/employee")
    public Collection<EmployeeDTO> findAllEmployees() {
        List<Employee> employeeList = employeeService.findAll ();

        return employeeList
                .stream ()
                .map ( e -> new EmployeeDTO ( e.getGender (), e.getFirstName (), e.getLastName (), e.getEmail () ) )
                .collect ( Collectors.toList () );
    }

}
