package com.mateusz.api;

import com.mateusz.exception.UserLoginAlreadyExistException;
import com.mateusz.exception.UserShortLengthLoginException;
import com.mateusz.exception.UserShortLengthPasswordException;
import com.mateusz.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException;

    void removeUserById(int userId) throws IOException;

    List<User> getAllUsers() throws IOException;
    User getUserById(int userId) throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password);
}
