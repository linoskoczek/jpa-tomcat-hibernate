package repositories;

import javassist.NotFoundException;

public interface IUserRepository {
    boolean checkPassword(String login, String password);

    boolean exists(String login);

    int findIdByLogin(String login) throws NotFoundException;
}
