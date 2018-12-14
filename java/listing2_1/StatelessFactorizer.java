package listing2_1;

import annotation.ThreadSafe;

import javax.servlet.*;
import java.math.BigInteger;

@ThreadSafe
public final class StatelessFactorizer implements Servlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        final BigInteger i = extractFromRequest(req);
        final BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {

    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[0];
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
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
