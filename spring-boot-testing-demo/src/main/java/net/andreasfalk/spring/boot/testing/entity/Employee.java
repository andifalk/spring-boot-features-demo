package net.andreasfalk.spring.boot.testing.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.jpa.domain.AbstractPersistable;

import net.andreasfalk.spring.boot.testing.boundary.Gender;

/**
 * Employee entity.
 */
@Entity
public class Employee extends AbstractPersistable<Long> {

    @Version
    private long version;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String lastName;

    @Email
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<AssignedSkill> assignedSkills = new HashSet<> ();

    public Employee () {
    }

    public Employee ( Gender gender, String firstName, String lastName, String email ) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Gender getGender () {
        return gender;
    }

    public void setGender ( Gender gender ) {
        this.gender = gender;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public Set<AssignedSkill> getAssignedSkills () {
        return assignedSkills;
    }

    public void setAssignedSkills ( Set<AssignedSkill> assignedSkills ) {
        this.assignedSkills = assignedSkills;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this )
                .append ( "assignedSkills", assignedSkills )
                .append ( "email", email )
                .append ( "lastName", lastName )
                .append ( "firstName", firstName )
                .append ( "gender", gender )
                .toString ();
    }
}
