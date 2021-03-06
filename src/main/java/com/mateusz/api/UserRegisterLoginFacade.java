package com.mateusz.api;

import com.mateusz.model.User;

public interface UserRegisterLoginFacade {
    String registerUser(User user);
    boolean loginUser(String login, String password);
}
