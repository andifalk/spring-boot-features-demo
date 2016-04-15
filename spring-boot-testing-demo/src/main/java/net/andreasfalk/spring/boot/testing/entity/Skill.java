package net.andreasfalk.spring.boot.testing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Skill type to assign to an employee.
 */
@Entity
public class Skill extends AbstractPersistable<Long> {

    @Version
    private long version;

    @NotNull
    @Size(min = 1,max = 255)
    @Column(nullable = false, unique = true, length = 255)
    private String name;

    @NotNull
    @Column(nullable = false)
    private boolean mandatory;

    public Skill () {
    }

    public Skill ( String name, boolean mandatory ) {
        this.name = name;
        this.mandatory = mandatory;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public boolean isMandatory () {
        return mandatory;
    }

    public void setMandatory ( boolean mandatory ) {
        this.mandatory = mandatory;
    }

    @Override
    public String toString () {
        return new org.apache.commons.lang3.builder.ToStringBuilder ( this )
                .append ( "name", name )
                .append ( "mandatory", mandatory )
                .toString ();
    }
}
