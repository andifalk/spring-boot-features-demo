package net.andreasfalk.spring.boot.testing.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import net.andreasfalk.spring.boot.testing.boundary.KnowledgeLevel;

/**
 * Assigned skill for an employee.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint (name = "IDX_UQ_EmployeeSkill", columnNames = {"employee_id","skill_id"})})
public class AssignedSkill extends AbstractPersistable<Long> {

    @Version
    private long version;

    @NotNull
    @Valid
    @ManyToOne(optional = false)
    private Employee employee;

    @NotNull
    @Valid
    @ManyToOne(optional = false)
    private Skill skill;

    @NotNull
    @Enumerated( EnumType.STRING)
    private KnowledgeLevel knowledgeLevel;

    public AssignedSkill () {
    }

    public AssignedSkill ( Employee employee, Skill skill, KnowledgeLevel knowledgeLevel ) {
        this.employee = employee;
        this.skill = skill;
        this.knowledgeLevel = knowledgeLevel;
    }

    public Employee getEmployee () {
        return employee;
    }

    public void setEmployee ( Employee employee ) {
        this.employee = employee;
    }

    public Skill getSkill () {
        return skill;
    }

    public void setSkill ( Skill skill ) {
        this.skill = skill;
    }

    public KnowledgeLevel getKnowledgeLevel () {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel ( KnowledgeLevel knowledgeLevel ) {
        this.knowledgeLevel = knowledgeLevel;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this )
                .append ( "employee", employee )
                .append ( "skill", skill )
                .append ( "knowledgeLevel", knowledgeLevel )
                .toString ();
    }
}
