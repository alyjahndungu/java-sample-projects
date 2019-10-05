package com.turnkeyproject.turnkey.Repository;

import com.turnkeyproject.turnkey.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{

}

