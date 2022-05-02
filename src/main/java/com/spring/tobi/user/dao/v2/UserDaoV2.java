package com.spring.tobi.user.dao.v2;

import com.spring.tobi.user.domain.User;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDaoV2 {

    private SimpleConnectionMaker connectionMaker;

    public UserDaoV2(SimpleConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection c = connectionMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection c = connectionMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public void delete() throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement(
                "delete from users");

        ps.executeUpdate();

        ps.close();
        c.close();
    }
}
