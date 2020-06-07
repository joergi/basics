package io.joergi.basics.models;

public enum StatusCode {

    SUCCESS("success"),
    EMAIL_IS_ALREADY_IN_USE("emailIsAlreadyInUse"),
    EMAIL_NOT_FOUND("emailNotFound"),
    USERNAME_IS_ALREADY_IN_USE("usernameIsAlreadyInUse");


    public final String value;

    StatusCode(String value){
        this.value = value;
    }
}
