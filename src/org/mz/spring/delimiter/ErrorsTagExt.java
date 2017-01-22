package org.mz.spring.delimiter;

import javax.servlet.jsp.JspException;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.tags.form.ErrorsTag;
import org.springframework.web.servlet.tags.form.TagWriter;

public class ErrorsTagExt extends ErrorsTag{
	private static final long serialVersionUID = 1L;
	private boolean firstErrorOnly = true;

	@Override
	protected void renderDefaultContent(TagWriter tagWriter) throws JspException {
		tagWriter.startTag(getElement());
		writeDefaultAttributes(tagWriter);
		String delimiter = ObjectUtils.getDisplayString(evaluate("delimiter", getDelimiter()));
		String[] errorMessages = getBindStatus().getErrorMessages();
		for(int i = 0; i < errorMessages.length; i++) {
			String errorMessage = errorMessages[i];
			if (i > 0) {
				tagWriter.appendValue(delimiter);
			}
			tagWriter.appendValue(getDisplayString(errorMessage));
			if (firstErrorOnly) break;
		}
		tagWriter.endTag();
	}

	public boolean isFirstErrorOnly() {
		return firstErrorOnly;
	}
	public void setFirstErrorOnly(boolean firstErrorOnly) {
		this.firstErrorOnly = firstErrorOnly;
	}
}