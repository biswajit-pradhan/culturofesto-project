package com.feedbackservice.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.feedbackservice.entity.User;
import com.feedbackservice.repository.UserRepository;
import com.feedbackservice.role.Role;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#getUserById(Long)}
     */
    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.User);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(user, userServiceImpl.getUserById(1L));
        verify(userRepository).findById(Mockito.<Long>any());
    }
}

