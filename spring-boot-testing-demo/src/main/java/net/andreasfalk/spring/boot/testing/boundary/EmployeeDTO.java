package net.andreasfalk.spring.boot.testing.boundary;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * DTO for employee.
 */
public class EmployeeDTO implements Serializable {

    @NotNull
    private Gender gender;

    @NotNull
    @Size(min = 1, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 30)
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private Set<AssignedSkillDTO> assignedSkills = new HashSet<> ();

    public EmployeeDTO ( Gender gender, String firstName, String lastName, String email) {
        this(gender,firstName,lastName,email,new HashSet<> ());
    }


    public EmployeeDTO ( Gender gender, String firstName, String lastName, String email, Set<AssignedSkillDTO> assignedSkills ) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.assignedSkills = assignedSkills;
    }

    public Gender getGender () {
        return gender;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public String getEmail () {
        return email;
    }

    public Set<AssignedSkillDTO> getAssignedSkills () {
        return assignedSkills;
    }

    public void setAssignedSkills ( Set<AssignedSkillDTO> assignedSkills ) {
        this.assignedSkills = assignedSkills;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;

        if ( o == null || getClass () != o.getClass () ) return false;

        EmployeeDTO that = (EmployeeDTO) o;

        return new EqualsBuilder ()
                .append ( gender, that.gender )
                .append ( firstName, that.firstName )
                .append ( lastName, that.lastName )
                .append ( email, that.email )
                .append ( assignedSkills, that.assignedSkills )
                .isEquals ();
    }

    @Override
    public int hashCode () {
        return new HashCodeBuilder ( 17, 37 )
                .append ( gender )
                .append ( firstName )
                .append ( lastName )
                .append ( email )
                .append ( assignedSkills )
                .toHashCode ();
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this )
                .append ( "gender", gender )
                .append ( "firstName", firstName )
                .append ( "lastName", lastName )
                .append ( "email", email )
                .append ( "assignedSkills", assignedSkills )
                .toString ();
    }
}
