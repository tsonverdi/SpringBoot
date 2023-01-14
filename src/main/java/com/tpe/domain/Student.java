package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)//setlemek istemedigimiz yapilar icin
    private Long id;

//    @Getter
    @NotNull(message = "First name can not be null")
    @NotBlank(message = "First name can not be white space")
    @Size(min = 2,max = 25,message = "First name '${validatedValue}' must be between {min} and {max} long")
    @Column(nullable = false,length = 25)
    /*final*/ private String name;//Finalleri parameterli constructorda gormek icin yaptik

    @Column(nullable = false,length = 25)
    /*final*/ private String lastName;

    /*final*/ private Integer grade;

    @Column(nullable = false,length = 50,unique = true)
    @Email(message = "Provide valid email")
    /*final*/ private String email;

    /*final*/ private String phoneNumber;

    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate = LocalDateTime.now();//Anlik versin diye direkt setledik.

    //Getter ve Setter
    //Lombok yaptik

    //Constructor ve Param
    //lombok yaptik
}
