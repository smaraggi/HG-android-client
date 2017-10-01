package hg.hg_android_client.profile.repository;

public class ProfileRepositoryFactory {

    public ProfileRepository getRepository() {
        return new MockProfileRepository();
    }

}
