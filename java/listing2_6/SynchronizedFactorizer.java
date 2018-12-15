package listing2_6;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

@ThreadSafe
public final class SynchronizedFactorizer implements Servlet {

    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;

    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public synchronized void service(final ServletRequest servletRequest, final ServletResponse servletResponse) throws ServletException, IOException {
        final BigInteger fromRequest = fromRequest(servletRequest);
        if (fromRequest.equals(this.lastNumber)) {
            encodeIntoResponse(servletResponse, this.lastFactors);
        } else {
            final BigInteger[] factors = factor(fromRequest);
            this.lastNumber = fromRequest;
            this.lastFactors = factors;
            encodeIntoResponse(servletResponse, factors);
        }
    }

    private static BigInteger[] factor(final BigInteger fromRequest) {
        return new BigInteger[0];
    }

    private static void encodeIntoResponse(final ServletResponse servletResponse, final BigInteger[] bigIntegers) {

    }

    private static BigInteger fromRequest(final ServletRequest servletRequest) {
        return new BigInteger(1, new Random());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
