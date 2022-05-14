package de.dhbw.ase.mangacollector.repository;

import de.dhbw.ase.mangacollector.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
    public interface AuthorRepository extends JpaRepository<Author, Integer> {
        // intentionally left blank, see JpaRepository interface definition

        /** CREATE **/

        /** READ **/

        /** UPDATE **/

        /** DELETE **/

    }

