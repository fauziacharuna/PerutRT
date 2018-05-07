package dao;

import object.user;
import object.*;
import java.util.List;

public interface implementUser {

    public Integer insert(user b);
    
    public user getUser(Integer user_id);

    public void update(user b);

    public void delete(Integer user_id);

    public List<user> getAll();

    public List<user> getCari(String user_Username);
    
    public Integer getCount();
    
    public Integer getValidLogin(String username, String password);
}
