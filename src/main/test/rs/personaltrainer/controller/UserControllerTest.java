package rs.personaltrainer.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import rs.personaltrainer.model.User;
import rs.personaltrainer.service.UserService;
import rs.personaltrainer.util.UserUtil;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
//
//    //@Mock
//    private UserService userService;
//
//    private UserController userController;

//    @Before
//    public void setUp() throws Exception {
//        userController = new UserController(userService);
//    }
//
//    @Ignore
//    @Test
//    public void shouldCreateUser() throws Exception {
//        final User savedUser = stubServiceToReturnStoredUser();
//        final User user = UserUtil.createUser();
//        //User returnedUser = userController.createUser(user);
//        // verify user was passed to UserService
//        //verify(userService, times(1)).save(user);
//        //assertEquals("Returned user should come from the service", savedUser, returnedUser);
//    }
//
//    private User stubServiceToReturnStoredUser() {
//        final User user = UserUtil.createUser();
//        //when(userService.save(any(User.class))).thenReturn(user);
//        return user;
//    }
//
//
//    @Ignore
//    @Test
//    public void shouldListAllUsers() throws Exception {
//        stubServiceToReturnExistingUsers(10);
//        Collection<User> users = userController.listUsers();
//        assertNotNull(users);
//        assertEquals(10, users.size());
//        // verify user was passed to UserService
//        verify(userService, times(1)).getList();
//    }
//
//    private void stubServiceToReturnExistingUsers(int howMany) {
//        when(userService.getList()).thenReturn(UserUtil.createUserList(howMany));
//    }
}
