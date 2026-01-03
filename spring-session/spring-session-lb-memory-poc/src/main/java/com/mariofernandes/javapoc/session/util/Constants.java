package com.mariofernandes.javapoc.session.util;

public final class Constants {
    public static final String ATTRIBUTE_ACCESS_COUNT = "access_count";

    public static final String RESPONSE_SESSION_DETAILS_TEMPLATE =
            "Session Access Count: %d"
            + "<br><br> <h3><b>Details Session</b></h3> "
            + "<br> - <b>ID</b>: %s"
            + "<br> - <b>Creation Time</b>: %d"
            + "<br> - <b>Last Accessed Time</b>: %d"
            + "<br> - <b>Max Inactive Interval</b>: %d seconds"
            + "<br> - <b>Is New</b>: %b";

    private Constants() {}
}
