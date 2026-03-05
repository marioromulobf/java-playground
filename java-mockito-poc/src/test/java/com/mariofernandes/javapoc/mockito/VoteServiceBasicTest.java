package com.mariofernandes.javapoc.mockito;

import com.mariofernandes.javapoc.mockito.model.Person;
import com.mariofernandes.javapoc.mockito.model.Vote;
import com.mariofernandes.javapoc.mockito.repository.PersonRepository;
import com.mariofernandes.javapoc.mockito.repository.VoteRepository;
import com.mariofernandes.javapoc.mockito.service.DeduplicationService;
import com.mariofernandes.javapoc.mockito.service.VoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VoteServiceBasicTest {
    @Mock
    private VoteRepository voteRepository;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private DeduplicationService deduplicationService;
    @InjectMocks
    private VoteService voteService;
    @Captor
    private ArgumentCaptor<Vote> voteCaptor;

    @Test
    void testProcessVote_ValidVote_ShouldProcessSuccessfully() {
        Vote vote = new Vote.Builder()
                .withPersonId(1L)
                .withOption("Option A")
                .withSession("Session 1")
                .build();

        // stubbing
        when(personRepository.findById(1L)).thenReturn(
                Optional.of(new Person.Builder().withId(1L).withName("Mario").build()));
        when(deduplicationService.isDuplicateVote(1L, "Session 1")).thenReturn(false);
        // stubbing using built-in any(class) and callback
        when(voteRepository.insertVote(any(Vote.class))).thenAnswer(invocation -> {
            Vote savedVote = invocation.getArgument(0); // get first argument
            savedVote.setId(100L);
            return savedVote;
        });

        String result = voteService.processVote(vote);

        Assertions.assertEquals("Vote processed successfully with id: 100", result);
        verify(personRepository).findById(1L);
        verify(deduplicationService).isDuplicateVote(eq(1L), eq("Session 1"));
        verify(voteRepository).insertVote(any(Vote.class));
    }

}
