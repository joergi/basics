package io.joergi.basics.utils;

import io.joergi.basics.models.User;

public class UserUtils {

    public static User createRandomUser() {
        return new User("xxx"+Math.random(),"email"+Math.random()+"@email.de","securepassword");
    }
}
