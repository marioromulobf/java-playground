package com.mariofernandes.javapoc.mockito.service;

import com.mariofernandes.javapoc.mockito.repository.VoteRepository;

public class DeduplicationService {

    private final VoteRepository voteRepository;

    public DeduplicationService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public boolean isDuplicateVote(Long personId, String session) {
        return voteRepository.getVoteByPersonIdAndSession(personId, session).isPresent();
    }
}
