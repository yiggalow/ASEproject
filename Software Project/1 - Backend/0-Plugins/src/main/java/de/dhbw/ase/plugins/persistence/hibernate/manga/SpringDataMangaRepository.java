package de.dhbw.ase.plugins.persistence.hibernate.manga;

import de.dhbw.ase.mangacollector.domain.manga.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SpringDataMangaRepository extends JpaRepository<Manga, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/
    List<Manga> findAllByGenre_Id(int genreId);
    /** UPDATE **/

    /** DELETE **/
    void deleteById(int id);
}

