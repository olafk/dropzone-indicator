package de.olafkock.liferay.dropzone;

import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate=true,
		service=DynamicInclude.class
)
public class DropzoneIndicatorDynamicInclude implements DynamicInclude {

	@Override
	public void include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String key)
			throws IOException {

		PrintWriter pw = httpServletResponse.getWriter();
		pw.println( "<style>" + 
			".portlet-dropzone {\n" + 
			"  transition: padding 0.5s linear;\n" + 
			"}\n" + 
			".yui3-dd-drop-active-valid .portlet-dropzone {\n" + 
			"  outline: 1px dotted black;\n" + 
			"  padding: 10px;\n" + 
			"  margin: 3px;\n" + 
			"  min-height: 50px;\n" + 
			"}" +
			"</style>"
		);
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register("/html/common/themes/bottom.jsp#post");
	}
}
