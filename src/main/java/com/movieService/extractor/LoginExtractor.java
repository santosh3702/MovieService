package com.movieService.extractor;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.movieService.types.LoginCrediantialExtractor;


public class LoginExtractor implements ResultSetExtractor<Object>  {

	public LoginCrediantialExtractor extractData(ResultSet rs) throws SQLException, DataAccessException {
		LoginCrediantialExtractor loginCrediantials = null;
		if (rs.next()) {
			loginCrediantials = new LoginCrediantialExtractor();
			loginCrediantials.setPassword(rs.getString("password"));
			loginCrediantials.setUserName(rs.getString("username"));
			loginCrediantials.setStatus(rs.getString("status"));
		}
		return loginCrediantials;
	}

}
