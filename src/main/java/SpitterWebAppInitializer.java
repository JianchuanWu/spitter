import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 返回带有@Configuration注解的类，用来定义DispatcherServlet应用上下文中的bean
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 返回带有@Configuration注解的类，用来配置DispatcherServlet应用上下文中的bean
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 将DispatcherServlet映射到 "/"
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
