package net.andreasfalk.spring.boot.testing;

import net.andreasfalk.spring.boot.testing.boundary.EmployeeDTO;
import net.andreasfalk.spring.boot.testing.boundary.Gender;
import net.andreasfalk.spring.boot.testing.entity.Employee;
import net.andreasfalk.spring.boot.testing.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestCallIntegrationTest {

    @MockBean
    private EmployeeService employeeService;

	@Autowired
	private TestRestTemplate restTemplate;

    @Before
    public void init() {
        when(employeeService.findAll()).thenReturn(
                Stream.of(new Employee(Gender.MALE, "Hans", "Huber", "test@example.com"))
                .collect(Collectors.toList())
        );
    }

	@Test
	public void verifyRestCall() {
		ParameterizedTypeReference<Collection<EmployeeDTO>> response = new ParameterizedTypeReference<Collection<EmployeeDTO>>() {};
		ResponseEntity<Collection<EmployeeDTO>> responseEntity = restTemplate.exchange("/employee", HttpMethod.GET, null, response);
		assertThat(responseEntity.getBody().size(), is(1));
	}
}
