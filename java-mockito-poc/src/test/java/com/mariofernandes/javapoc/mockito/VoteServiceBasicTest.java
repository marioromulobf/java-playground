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
import org.mockito.ArgumentMatcher;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
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

    @Test
    void testBasicMockito_MockList() {
        List<String> mockedList = mock(List.class);

        mockedList.add("new item");
        mockedList.clear();

        verify(mockedList).add("new item");
        verify(mockedList).clear();
    }

    @Test
    void testBasicMockito_Stubbing() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("my item");
        when(mockedList.get(1)).thenThrow(new RuntimeException("My exception"));

        Assertions.assertEquals("my item", mockedList.get(0));
        RuntimeException exception = Assertions.assertThrowsExactly(RuntimeException.class, ()  -> mockedList.get(1));
        Assertions.assertEquals("My exception", exception.getMessage());
        Assertions.assertNull(mockedList.get(666));

        verify(mockedList).get(0);
        verify(mockedList).get(1);
        verify(mockedList).get(666);
    }

    @Test
    void testBasicMockito_ArgumentMatchers() {
        List<String> mockedList = mock(List.class);

        // anyInt() matches any int value
        when(mockedList.get(anyInt())).thenReturn("my element");

        // custom argument matcher
        when(mockedList.contains(argThat(isValid()))).thenReturn(true);

        mockedList.add("any string");

        Assertions.assertEquals("my element", mockedList.get(666));
        Assertions.assertFalse(mockedList.contains(666));
        Assertions.assertTrue(mockedList.contains("It's me, Mario!"));

        // verify with argument matchers
        verify(mockedList).get(anyInt());
        verify(mockedList).add(argThat(str -> str.length() > 5));
    }


    @Test
    void testBasicMockito_ExactNumberOfInvocations() {
        List<String> mockedList = mock(List.class);

        mockedList.add("only one");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("should be 3");
        mockedList.add("should be 3");
        mockedList.add("should be 3");

        // times(1) is default, so we can omit it
        verify(mockedList).add("only one");
        verify(mockedList, times(1)).add("only one");

        // verify exact number of invocations
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("should be 3");

        // never() is an alias for times(0)
        verify(mockedList, times(0)).add("never called");
        verify(mockedList, never()).add("never called");

        // verify at least/most
        verify(mockedList, atLeastOnce()).add("only one");
        verify(mockedList, atMostOnce()).add("only one");
        verify(mockedList, atLeast(2)).add("should be 3");
        verify(mockedList, atMost(5)).add("should be 3");
    }

    private ArgumentMatcher<Object> isValid() {
        return arg -> {
            if (arg instanceof String str) {
                return str.contains("Mario");
            }
            return false;
        };
    }
}
