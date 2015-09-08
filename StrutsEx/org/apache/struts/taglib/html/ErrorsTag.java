package org.apache.struts.taglib.html;

import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.MessageResources;

public class ErrorsTag extends TagSupport {

    protected static MessageResources messages = MessageResources.getMessageResources("org.apache.struts.taglib.html.LocalStrings");
    protected String bundle = null;
    protected String locale = "org.apache.struts.action.LOCALE";
    protected String name = "org.apache.struts.action.ERROR";
    protected String property = null;
    protected String header = null;
    protected String footer = null;
    protected String prefix = null;
    protected String suffix = null;

    public String getBundle() {
        return this.bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getHeader() {
        return this.header == null ? "errors.header" : this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return this.footer == null ? "errors.footer" : this.footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getPrefix() {
        return this.prefix == null ? "errors.prefix" : this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return this.suffix == null ? "errors.suffix" : this.suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int doStartTag() throws JspException {

        ActionMessages errors = null;

        try {
            errors = TagUtils.getInstance().getActionMessages(this.pageContext,this.name);
        } catch (JspException e) {
            TagUtils.getInstance().saveException(this.pageContext, e);
            throw e;
        }

        if ((errors == null) || (errors.isEmpty())) {
            return 1;
        }

        boolean headerPresent = TagUtils.getInstance().present(this.pageContext, this.bundle, this.locale, getHeader());
        boolean footerPresent = TagUtils.getInstance().present(this.pageContext, this.bundle, this.locale, getFooter());
        boolean prefixPresent = TagUtils.getInstance().present(this.pageContext, this.bundle, this.locale, getPrefix());
        boolean suffixPresent = TagUtils.getInstance().present(this.pageContext, this.bundle, this.locale, getSuffix());

        StringBuffer results = new StringBuffer();
        boolean headerDone = false;
        String message = null;
        Iterator reports = this.property == null ? errors.get() : errors.get(this.property);

        while (reports.hasNext()) {
            ActionMessage report = (ActionMessage) reports.next();

            if (report != null && report.getKey() != null && !report.getKey().isEmpty()) {

                if (!headerDone) {
                    if (headerPresent) {
                        message = TagUtils.getInstance().message(this.pageContext, this.bundle, this.locale,getHeader());
                        results.append(message);
                    }
                    headerDone = true;
                }

                if (prefixPresent) {
                    message = TagUtils.getInstance().message(this.pageContext,this.bundle, this.locale, getPrefix());
                    results.append(message);
                }

                if (report.isResource()) {
                    message = TagUtils.getInstance().message(this.pageContext,this.bundle, this.locale, report.getKey(),report.getValues());
                } else {
                    message = report.getKey();
                }

                if (message != null) {
                    results.append(message);
                }

                if (suffixPresent) {
                    message = TagUtils.getInstance().message(this.pageContext,this.bundle, this.locale, getSuffix());
                    results.append(message);
                }
            }
        }

        if ((headerDone) && (footerPresent)) {
            message = TagUtils.getInstance().message(this.pageContext,this.bundle, this.locale, getFooter());
            results.append(message);
        }

        TagUtils.getInstance().write(this.pageContext, results.toString());

        return 1;
    }

    public void release() {
        super.release();
        this.bundle = "org.apache.struts.action.MESSAGE";
        this.locale = "org.apache.struts.action.LOCALE";
        this.name = "org.apache.struts.action.ERROR";
        this.property = null;
        this.header = null;
        this.footer = null;
        this.prefix = null;
        this.suffix = null;
    }
}
