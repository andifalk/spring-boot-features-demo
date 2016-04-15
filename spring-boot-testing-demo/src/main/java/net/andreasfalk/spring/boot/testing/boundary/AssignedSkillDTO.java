package net.andreasfalk.spring.boot.testing.boundary;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * DTO for assigned skill.
 */
public class AssignedSkillDTO implements Serializable {

    @NotNull
    @Valid
    private SkillDTO skill;

    @NotNull
    private KnowledgeLevel knowledgeLevel;

    public AssignedSkillDTO ( SkillDTO skill, KnowledgeLevel knowledgeLevel ) {
        this.skill = skill;
        this.knowledgeLevel = knowledgeLevel;
    }

    public SkillDTO getSkill () {
        return skill;
    }

    public KnowledgeLevel getKnowledgeLevel () {
        return knowledgeLevel;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this )
                .append ( "skill", skill )
                .append ( "knowledgeLevel", knowledgeLevel )
                .toString ();
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;

        if ( o == null || getClass () != o.getClass () ) return false;

        AssignedSkillDTO that = (AssignedSkillDTO) o;

        return new EqualsBuilder ()
                .append ( skill, that.skill )
                .append ( knowledgeLevel, that.knowledgeLevel )
                .isEquals ();
    }

    @Override
    public int hashCode () {
        return new HashCodeBuilder ( 17, 37 )
                .append ( skill )
                .append ( knowledgeLevel )
                .toHashCode ();
    }
}
