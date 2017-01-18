package com.movieService.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.movieService.types.GetAllUsersResonce;

public class UserListExtractor implements ResultSetExtractor<List<GetAllUsersResonce>> {

	public List<GetAllUsersResonce> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<GetAllUsersResonce> getAllUsersList = new ArrayList<GetAllUsersResonce>();
		GetAllUsersResonce getAllUsersResonce = null;
		while (rs.next()) {
			getAllUsersResonce = new GetAllUsersResonce();
			getAllUsersResonce.setUsername(rs.getString("username"));
			getAllUsersList.add(getAllUsersResonce);
		}
		return getAllUsersList;
	}

}
