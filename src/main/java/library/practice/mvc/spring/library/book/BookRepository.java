package library.practice.mvc.spring.library.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    @Query("SELECT t FROM tb_book t WHERE t.id = ?1")
    Optional<Book> getBookByUUID(UUID uuid);



    @Transactional
    @Modifying
    @Query("DELETE FROM tb_book t WHERE t.id = ?1")
    void deleteBookByUUID(UUID uuid);


}