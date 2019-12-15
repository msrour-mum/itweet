package mum.itweet.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{RootConfig.class};
//    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyWebMvcConfigure.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
