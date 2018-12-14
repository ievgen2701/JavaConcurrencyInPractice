package listing2_2;

import net.jcip.annotations.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {

    private long count = 0;

    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(final ServletRequest servletRequest, final ServletResponse servletResponse) throws ServletException, IOException {
        final BigInteger fromRequest = extractFromRequest(servletRequest);
        final BigInteger[] factors = factor(fromRequest);
        ++this.count;
        encodeIntoResponse(servletResponse, factors);
    }

    private static void encodeIntoResponse(final ServletResponse resp, final BigInteger[] factors) {

    }

    private static BigInteger[] factor(final BigInteger fromRequest) {
        return new BigInteger[0];
    }

    private static BigInteger extractFromRequest(final ServletRequest req) {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
