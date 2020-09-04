package io.joergi.basics.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    @Setter(AccessLevel.NONE)
    @ApiModelProperty(hidden = true)
    private String id;

    @NonNull
    @NotEmpty(message = "first name must not be empty")
    private String username;

    // TODO UNIQUE
    @NonNull
    @NotEmpty(message = "email must not be empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    // TODO password encoding
    // TODO password checkIfSecureEnough
    @NonNull
    @NotEmpty(message = "password must not be empty")
    private String password;
}
