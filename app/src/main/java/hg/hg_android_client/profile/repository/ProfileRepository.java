package hg.hg_android_client.profile.repository;

import hg.hg_android_client.model.User;

public interface ProfileRepository {

    User retrieve(String token);

    User retrieveCached();

    User update(String token, User user);

}
