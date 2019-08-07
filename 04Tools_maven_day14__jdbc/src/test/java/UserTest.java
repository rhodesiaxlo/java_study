import com.lsx.dao.UserDao;
import com.lsx.dao.impl.UserDaoImpl;
import com.lsx.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UserTest {

    @Test
    public void findAll(){
        UserDao dao = new UserDaoImpl();
        try {
            List<User> list = dao.getAll();
            System.out.println(list);
            Assert.assertNotNull(list);
            System.out.println(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
