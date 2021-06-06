package com.example.udemypractise1.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.Generated;
import javax.naming.Name;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "student_18")
public class Student {
//    @JsonProperty("First Name")
    @Column(name = "FirstName")
    // Displays json Property mentioned name instead of key fname.
    private String fname;

//    @JsonProperty("Last Name")
    @Column(name = "LastName")
    private String lname;

    @Column(name = "ID")
    @Id
//    @JsonIgnore
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // To ignore ID Field in output JSON which is done by Jackson Library Internally
    private int id;

    @Column(name = "Email")
    String email;
}
