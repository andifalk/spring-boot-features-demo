package net.andreasfalk.spring.boot.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andreasfalk.spring.boot.testing.entity.Skill;

/**
 * Repository for {@link Skill skills}.
 */
public interface SkillRepository extends JpaRepository<Skill,Long> {
}
