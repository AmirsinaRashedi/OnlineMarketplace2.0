package util;

import domain.User;

public class SecurityContext {

    private User currentUser = null;

    public SecurityContext() {
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void logout() {
        currentUser = null;
    }
}
