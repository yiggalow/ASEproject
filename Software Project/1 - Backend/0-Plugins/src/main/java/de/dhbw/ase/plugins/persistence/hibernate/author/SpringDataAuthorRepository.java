package de.dhbw.ase.plugins.persistence.hibernate.author;

import de.dhbw.ase.mangacollector.domain.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
    public interface SpringDataAuthorRepository extends JpaRepository<Author, Integer> {
        // intentionally left blank, see JpaRepository interface definition

        /** CREATE **/

        /** READ **/

        /** UPDATE **/

        /** DELETE **/

    }

