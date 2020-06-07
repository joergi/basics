package io.joergi.basics.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;

@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    @Setter(AccessLevel.NONE)
    @ApiModelProperty(hidden = true)
    private String id;

    // TODO UNIQUE
    @NonNull
    private String username;

    // TODO UNIQUE
    @NonNull
    @Email(message = "Please provide a valid email address")
    private String email;

    // TODO password encoding
    // TODO password checkIfSecureEnough
    @NonNull
    private String password;
}
