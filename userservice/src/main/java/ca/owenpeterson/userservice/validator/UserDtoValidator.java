package ca.owenpeterson.userservice.validator;

import org.springframework.stereotype.Component;

import ca.owenpeterson.userservice.models.UserDto;

@Component
public interface UserDtoValidator {
	
	public boolean isInvalidForCreate(UserDto userDto);
}
