package com.linyf.demo.jdbc_template.service;

import com.linyf.demo.jdbc_template.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addUser1(User user) {
        return jdbcTemplate.update("insert into tb_jdbctemplate (id,username,address) values (?,?,?);", user.getId(), user.getUsername(), user.getAddress());
    }

    /**
     * 在数据插入的过程中希望实现主键回填
     * @param user
     * @return
     */
    public int addUser2(User user) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        int update = jdbcTemplate.update(connection -> {
            int generatedKeys = Statement.RETURN_GENERATED_KEYS;
            PreparedStatement ps = connection.prepareStatement("insert into tb_jdbctemplate (username,address) values (?,?);", generatedKeys);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getAddress());
            return ps;
        }, keyHolder);
        System.out.println(keyHolder.getKey().longValue());
        return update;
    }

    public int deleteUserById(Long id) {
        return jdbcTemplate.update("delete from tb_jdbctemplate where id=?", id);
    }

    public int updateUserById(User user) {
        return jdbcTemplate.update("update tb_jdbctemplate set username=?,address=? where id=?", user.getUsername(), user.getAddress(),user.getId());
    }

    /**
     * 查询的时候需要提供一个 RowMapper，就是需要自己手动映射，将数据库中的字段和对象的属性一一对应起来
     * @return
     */
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from tb_jdbctemplate", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                String username = resultSet.getString("username");
                String address = resultSet.getString("address");
                long id = resultSet.getLong("id");
                User user = new User();
                user.setAddress(address);
                user.setUsername(username);
                user.setId(id);
                return user;
            }
        });
    }

    /**
     * 如果数据库中的字段和对象属性的名字一模一样的话
     * @return
     */
    public List<User> getAllUsers2() {
        return jdbcTemplate.query("select * from tb_jdbctemplate", new BeanPropertyRowMapper<>(User.class));
    }
}
