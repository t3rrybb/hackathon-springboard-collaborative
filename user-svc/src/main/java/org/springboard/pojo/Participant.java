package org.springboard.pojo;

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
    String userId;
    
    @Getter
    @NonNull
    @Setter
    String firstName;
    
    @Getter
    @NonNull
    @Setter
    String lastName;
    
    @Getter
    @NonNull
    @Setter
    String email;
    
    @Getter
    @NonNull
    @Setter
    String phone;
    
    @Getter
    @NonNull
    @Setter
    String status;
    
    @Getter
    @NonNull
    @Setter
    String DOB;
    
}
