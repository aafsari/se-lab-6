package com.unittest.codecoverage.service;

import com.unittest.codecoverage.exceptions.PersonException;
import com.unittest.codecoverage.models.Gender;
import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.repositories.PersonRepository;
import com.unittest.codecoverage.services.PersonService;
import com.unittest.codecoverage.services.impl.PersonServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonRepositoryTest {

	PersonRepository repository = new PersonRepository();

	@Test
	public void testInsert_shouldInsertPersonWithSuccessWhenAllPersonsInfoIsFilled() {
		Person person = new Person();
		person.setName("Name");
		person.setAge(21);
		person.setGender(Gender.M);
		Person returnedPerson = repository.insert(person);
		Assertions.assertEquals(returnedPerson, person );
	}
	
	@Test
	public void testInsert_shouldThrowPersonExceptionWhenPersonIsNull() {
		
		List<String> expectedErrors = Lists.newArrayList("person can't be null");
		String expectedMessage = String.join(";", expectedErrors);
		Person person = null;
		
		assertThatThrownBy(() -> repository.insert(person))
			.isInstanceOf(NullPointerException.class)
			.hasMessage(expectedMessage);
	}

	@Test
	public void testUpdate_shouldThrowPersonExceptionWhenPersonIsNull() {

		List<String> expectedErrors = Lists.newArrayList("person can't be null");
		String expectedMessage = String.join(";", expectedErrors);
		Person person = null;

		assertThatThrownBy(() -> repository.update(person))
				.isInstanceOf(NullPointerException.class)
				.hasMessage(expectedMessage);
	}

}
