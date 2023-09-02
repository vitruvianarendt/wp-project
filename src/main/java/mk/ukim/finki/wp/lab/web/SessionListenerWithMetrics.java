package mk.ukim.finki.wp.lab.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionListenerWithMetrics implements HttpSessionListener {

    private final AtomicInteger activeSessions;

    public SessionListenerWithMetrics() {
        super();

        activeSessions = new AtomicInteger();
    }

    public int getTotalActiveSession() {
        //servletcontext
        return activeSessions.get();
    }

    public void sessionCreated(final HttpSessionEvent event) {
        activeSessions.incrementAndGet();
    }
    public void sessionDestroyed(final HttpSessionEvent event) {
        activeSessions.decrementAndGet();
    }
}