package com.exe201.backend.irepository;

import com.exe201.backend.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, String> {
    public VoteEntity findVoteEntityById(String voteId);

    public List<VoteEntity> findByBookingIdInAndDeletedIsFalse(List<String> subYardId);

    public List<VoteEntity> findAllByBookingIdInAndDeletedFalse(Collection<String> listBookingId);

}
