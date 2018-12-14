package listing2_5;

import net.jcip.annotations.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

@NotThreadSafe
public final class UnsafeCachingFactorizer implements Servlet {

    private final AtomicReference<BigInteger> lastNumber =
            new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors =
            new AtomicReference<>();

    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(final ServletRequest servletRequest, final ServletResponse servletResponse) throws ServletException, IOException {
        final BigInteger fromRequest = fromRequest(servletRequest);
        if (fromRequest.equals(this.lastNumber.get())) {
            encodeIntoResponse(servletResponse, this.lastFactors.get());
        } else {
            final BigInteger[] factors = factor(fromRequest);
            this.lastNumber.set(fromRequest);
            this.lastFactors.set(factors);
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
