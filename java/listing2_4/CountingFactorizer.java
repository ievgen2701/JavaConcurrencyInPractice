package listing2_4;

import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public final class CountingFactorizer
        implements Servlet {

    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return this.count.get();
    }

    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(final ServletRequest servletRequest, final ServletResponse servletResponse) throws ServletException, IOException {
        this.count.incrementAndGet();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
