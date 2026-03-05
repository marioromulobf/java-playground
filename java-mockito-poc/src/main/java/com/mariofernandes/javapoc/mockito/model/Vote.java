package com.mariofernandes.javapoc.mockito.model;

public class Vote {
    private Long id;
    private Long personId;
    private String option;
    private String session;
    private Long timestamp;

    public Vote(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String toString() {
        return "Vote{id=" + id + ", personId=" + personId + ", option='" + option + "', session='" + session + "', timestamp=" + timestamp + "}";
    }

}
