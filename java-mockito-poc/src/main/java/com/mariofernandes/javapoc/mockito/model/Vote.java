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

    public static class Builder {
        private Long id;
        private Long personId;
        private String option;
        private String session;
        private Long timestamp;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withPersonId(Long personId) {
            this.personId = personId;
            return this;
        }

        public Builder withOption(String option) {
            this.option = option;
            return this;
        }

        public Builder withSession(String session) {
            this.session = session;
            return this;
        }

        public Builder withTimestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Vote build() {
            Vote vote = new Vote();
            vote.setId(id);
            vote.setPersonId(personId);
            vote.setOption(option);
            vote.setSession(session);
            vote.setTimestamp(timestamp);
            return vote;
        }
    }

    public String toString() {
        return "Vote{id=" + id + ", personId=" + personId + ", option='" + option + "', session='" + session + "', timestamp=" + timestamp + "}";
    }

}
