package com.movieService.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.movieService.extractor.LoginExtractor;
import com.movieService.extractor.UserListExtractor;
import com.movieService.service.LoginService;
import com.movieService.types.DeleteRequest;
import com.movieService.types.DeleteResponce;
import com.movieService.types.GetAllUsersResonce;
import com.movieService.types.LoginCrediantialExtractor;
import com.movieService.types.LoginRequest;
import com.movieService.types.LoginResponce;
import com.movieService.util.QueryConstant;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public LoginResponce login(LoginRequest crediantials) {
		LoginResponce loginResponce = null;
		List<String> intList = new ArrayList<String>();
		intList.add(crediantials.getUserName());
		LoginCrediantialExtractor crediantialExtractor = (LoginCrediantialExtractor) jdbcTemplate
				.query(QueryConstant.LOGINQUERY, intList.toArray(), new LoginExtractor());
		if (crediantialExtractor != null) {
			if (crediantialExtractor.getStatus() != null) {
				if (crediantialExtractor.getStatus().equalsIgnoreCase("A")) {
					loginResponce = new LoginResponce();
					loginResponce.setUserName(crediantials.getUserName());
					loginResponce.setStatus(QueryConstant.USERSTATUSACTIVE);
				} else if (crediantialExtractor.getStatus().equalsIgnoreCase("D")) {
					loginResponce = new LoginResponce();
					loginResponce.setUserName(crediantials.getUserName());
					loginResponce.setStatus(QueryConstant.USERSTATUSDEACTIVE);
				}
			} else {
				loginResponce = new LoginResponce();
				loginResponce.setUserName(crediantials.getUserName());
				loginResponce.setStatus(QueryConstant.USERSTATUSNOTEXIST);
			}
		} else {
			loginResponce = new LoginResponce();
			loginResponce.setUserName(crediantials.getUserName());
			loginResponce.setStatus(QueryConstant.USERSTATUSNOTEXIST);
		}
		return loginResponce;
	}

	public DeleteResponce delete(DeleteRequest deleteRequest) {
		DeleteResponce deleteResponce = null;
		List<String> intList = new ArrayList<String>();
		intList.add(deleteRequest.getUserName());
		int result = jdbcTemplate.update(QueryConstant.UPDATE_TO_DEACTIVATE, intList.toArray());
		if (result > 0) {
			deleteResponce.setStatus("DELETED");
		} else {
			deleteResponce.setStatus("NOT DELETED");
		}
		return deleteResponce;
	}

	public List<GetAllUsersResonce> getAllUsers() {
		List<GetAllUsersResonce> allUsersResonces = new ArrayList<GetAllUsersResonce>();
		allUsersResonces = jdbcTemplate.query(QueryConstant.GETALLUSERS, new UserListExtractor());
		return allUsersResonces;
	}

}
