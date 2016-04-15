package net.andreasfalk.spring.boot.testing;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import net.andreasfalk.spring.boot.testing.entity.AssignedSkill;
import net.andreasfalk.spring.boot.testing.entity.Employee;
import net.andreasfalk.spring.boot.testing.boundary.Gender;
import net.andreasfalk.spring.boot.testing.boundary.KnowledgeLevel;
import net.andreasfalk.spring.boot.testing.entity.Skill;
import net.andreasfalk.spring.boot.testing.repository.EmployeeRepository;

/**
 * Example test using just the JPA slice using @DataJpaTest annotation.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void verify() {

		Skill skill = entityManager.persist ( new Skill ( "Java", true ) );
		Employee employee = new Employee ( Gender.MALE, "Hans", "Mustermann", "test@example.com" );
		employee.setAssignedSkills ( Collections.singleton ( new AssignedSkill ( employee, skill, KnowledgeLevel.ADVANCED ) ) );
		entityManager.persist ( employee );

		Employee searchObject = new Employee ();
		searchObject.setLastName ( "mustermann" );
		List<Employee> employeeList = employeeRepository.findAll (
				Example.of ( searchObject, ExampleMatcher.matching ().withIgnoreCase ("lastName") ) );

		assertThat ("Should have returned expected number of matches", employeeList.size (), is (1));
	}

}
