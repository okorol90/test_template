package utils;

import dataProviders.DataProviders;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformation implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
        if (method.getName().equals("verifySearch")) {
            iTestAnnotation.setDataProviderClass(DataProviders.class);
            iTestAnnotation.setDataProvider(System.getProperty("dp"));
        }
    }
}
