package mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

public class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);//初使化Mock
    }

    @Test
    public void testCreateNewUser() throws Exception {

        User user = new User();
        user.setId(1L);
        user.setName("Vikey");

        //mock
        doNothing().when(userDao).insertUser(any(User.class));

        userServiceImpl.createNewUser(user);
    }


}