package dao;

import object.user;
import object.*;
import java.util.List;

public interface implementUser {

    public int insert(user b);
    
    public user getUser(int user_id);

    public void update(user b);

    public void delete(int user_id);

    public List<user> getAll();

    public List<user> getCari(String user_Username);
    
    public int getCount();
    
    public int getValidLogin(String username, String password);
}
