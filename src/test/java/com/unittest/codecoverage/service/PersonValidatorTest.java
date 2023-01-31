package com.unittest.codecoverage.service;

import com.unittest.codecoverage.models.Gender;
import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.models.validators.PersonValidator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class PersonValidatorTest {

	PersonValidator validator = new PersonValidator();

	@Test
	public void testValidate_shouldValidatePersonWithSuccessWhenAllPersonsInfoIsFilled() {
		Person person = new Person();
		person.setName("Name");
		person.setAge(21);
		person.setGender(Gender.M);
		validator.validate(person);
		Assertions.assertDoesNotThrow(() -> validator.validate(person));
	}

}
