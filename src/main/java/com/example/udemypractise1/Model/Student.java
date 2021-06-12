package com.example.udemypractise1.Model;

import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // To ignore ID Field in output JSON which is done by Jackson Library Internally
    private int id;

    @Column(name = "Email")
    String email;

//    @Transient
//    String fullName;

    public Student(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
//        this.id = id;
        this.email = email;
//        this.fullName = fname+" "+lname;
    }

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
