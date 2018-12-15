package listing2_6;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

@ThreadSafe
public final class CachedFactorizer implements Servlet {

    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits() {
        return this.hits;
    }

    public synchronized double getCacheRatio() {
        return (double) this.cacheHits / (double) this.hits;
    }

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
        BigInteger[] factors = null;
        synchronized (this) {
            ++this.hits;
            if (fromRequest.equals(this.lastNumber)) {
                ++this.cacheHits;
                factors = this.lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(fromRequest);
            synchronized (this) {
                this.lastNumber = fromRequest;
                this.lastFactors = factors.clone();
            }
        }
        encodeIntoResponse(servletResponse, factors);
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
