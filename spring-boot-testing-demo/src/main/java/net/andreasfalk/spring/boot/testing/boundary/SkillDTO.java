package net.andreasfalk.spring.boot.testing.boundary;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * DTO for skill.
 */
public class SkillDTO implements Serializable {

    @NotNull
    @Size (min = 1,max = 255)
    private String name;

    private boolean mandatory;

    public SkillDTO ( String name, boolean mandatory ) {
        this.name = name;
        this.mandatory = mandatory;
    }

    public String getName () {
        return name;
    }

    public boolean isMandatory () {
        return mandatory;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;

        if ( o == null || getClass () != o.getClass () ) return false;

        SkillDTO skillDTO = (SkillDTO) o;

        return new EqualsBuilder ()
                .append ( mandatory, skillDTO.mandatory )
                .append ( name, skillDTO.name )
                .isEquals ();
    }

    @Override
    public int hashCode () {
        return new HashCodeBuilder ( 17, 37 )
                .append ( name )
                .append ( mandatory )
                .toHashCode ();
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this )
                .append ( "name", name )
                .append ( "mandatory", mandatory )
                .toString ();
    }
}
