package hg.hg_android_client.profile.event;

import hg.hg_android_client.model.User;

public class RetrieveSuccess {

    private User user;

    public RetrieveSuccess(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
