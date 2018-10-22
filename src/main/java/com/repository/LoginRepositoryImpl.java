package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dto.Login;
import com.exception.DatabaseException;
import com.util.EnumUtil;

@Repository
public class LoginRepositoryImpl implements LoginRepository{

	@Autowired JdbcTemplate template;
	@Autowired NamedParameterJdbcTemplate namedTemplate;
	
	private static final class LoginMapper implements RowMapper<Login> {
		@Override
		public Login mapRow(ResultSet rs, int arg) throws SQLException {
			Login login = new Login();
			login.setLoginId(rs.getInt("LOGIN_ID"));
			login.setName(rs.getString("NAME"));
			login.setEmail(rs.getString("EMAIL"));
			login.setPassword(rs.getString("PASSWORD"));
			login.setRole(EnumUtil.stringToUserRole(rs.getString("ROLE")));
			return login;
		}
	}
	
	@Override
	public boolean emailExist(Login login) {
		login = template.queryForObject("select * from login where email = ?", 
				new Object[] {login.getEmail()}
				, new LoginMapper());
		if (login == null) 
			return false;
		return true;
	}
	
	@Override
	public Login getLogin(Login login) {
		login = template.queryForObject("select * from login where email = ? and password = ? and role = ?", 
				new Object[] {login.getEmail(), login.getPassword(), login.getRole().toString()}
				, new LoginMapper());
		return login;
	}

	@Override
	public Login addLogin(Login login) throws DatabaseException {
		SqlParameterSource sqlParamSource= new BeanPropertySqlParameterSource(login);
		int row = namedTemplate.update("insert into login values (:email, :name, :password, :role)"
				, sqlParamSource);
		if (row == 0)
			throw new DatabaseException("Unable to insert login data.");
		login = template.queryForObject("select * from login where email = ? and password = ? and role = ?", 
				new Object[] {login.getEmail(), login.getPassword(), login.getRole().toString()}
				, new LoginMapper());
		if (login == null)
			throw new DatabaseException("Unable to get login data.");
		return login;
	}

}
