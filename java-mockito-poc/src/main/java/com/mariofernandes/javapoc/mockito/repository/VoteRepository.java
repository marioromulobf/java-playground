package com.mariofernandes.javapoc.mockito.repository;

import com.mariofernandes.javapoc.mockito.model.Vote;

import java.util.List;
import java.util.Optional;

public interface VoteRepository {

    Vote insertVote(Vote vote);

    Optional<Vote> getVoteById(Long id);

    List<Vote> getVotesByPersonId(Long personId);

    Optional<Vote> getVoteByPersonIdAndSession(Long personId, String session);
}
