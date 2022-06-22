import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "FilterB", urlPatterns = { "*.do" })
public class FilterB implements Filter {

	private FilterConfig filterConfig = null;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Pre:" + filterConfig.getFilterName());
		chain.doFilter(request, response);
		System.out.println("Post:" + filterConfig.getFilterName());
		System.out.println("=====================================");
	}

	public void destroy() {
	}

	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
		if (filterConfig != null) {

		}
	}

	@Override
	public String toString() {
		if (filterConfig == null) {
			return ("FilterA()");
		}
		StringBuffer sb = new StringBuffer("FilterA(");
		sb.append(filterConfig);
		sb.append(")");
		return (sb.toString());
	}

	public void log(String msg) {
		filterConfig.getServletContext().log(msg);
	}
}
