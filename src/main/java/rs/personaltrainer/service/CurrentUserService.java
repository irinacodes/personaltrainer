package rs.personaltrainer.service;


import rs.personaltrainer.model.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
