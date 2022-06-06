package repository;

import base.repository.BaseRepository;
import domain.User;

public interface UserRepository
        extends BaseRepository<User, Long> {

    User findByUsername(String username);

    User loginToUser();

    User defineNewUser();
}
