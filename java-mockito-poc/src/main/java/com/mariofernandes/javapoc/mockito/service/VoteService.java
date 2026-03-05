package com.mariofernandes.javapoc.mockito.service;

import com.mariofernandes.javapoc.mockito.model.Vote;
import com.mariofernandes.javapoc.mockito.repository.PersonRepository;
import com.mariofernandes.javapoc.mockito.repository.VoteRepository;

public class VoteService {

    private final VoteRepository voteRepository;
    private final PersonRepository personRepository;
    private final DeduplicationService deduplicationService;

    public VoteService(VoteRepository voteRepository, PersonRepository personRepository, DeduplicationService deduplicationService) {
        this.voteRepository = voteRepository;
        this.personRepository = personRepository;
        this.deduplicationService = deduplicationService;
    }

    String processVote(Vote vote) {
        validateVote(vote);
        if (personRepository.findById(vote.getPersonId()).isEmpty()) {
            throw new IllegalArgumentException("Person with id " + vote.getPersonId() + " does not exist");
        }
        if (deduplicationService.isDuplicateVote(vote.getPersonId(), vote.getSession())) {
            throw new IllegalArgumentException("Duplicate vote detected for personId: " + vote.getPersonId() + " and session: " + vote.getSession());
        }

        Vote savedVote = voteRepository.insertVote(vote);

        return "Vote processed successfully with id: " + savedVote.getId();
    }

    private void validateVote(Vote vote) {
        if (vote.getOption() == null || vote.getOption().isEmpty()) {
            throw new IllegalArgumentException("Vote option cannot be null or empty");
        }
        if (vote.getSession() == null || vote.getSession().isEmpty()) {
            throw new IllegalArgumentException("Vote session cannot be null or empty");
        }
        if (vote.getPersonId() == null) {
            throw new IllegalArgumentException("Vote personId cannot be null");
        }
    }
}
