package org.springboard.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Participant {

    @Getter
    @NonNull
    @Setter
    @JsonDeserialize
    String userId;
    
    @Getter
    @NonNull
    @Setter
    @JsonDeserialize
    String firstName;
    
    @Getter
    @NonNull
    @Setter
    @JsonDeserialize
    String lastName;
    
    @Getter
    @NonNull
    @Setter
    @JsonDeserialize
    String email;
    
    @Getter
    @NonNull
    @Setter
    @JsonDeserialize
    String phone;
    
    @Getter
    @NonNull
    @Setter
    @JsonDeserialize
    String status;
    
    @Getter
    @NonNull
    @Setter
    @JsonDeserialize
    String DOB;
    
}
