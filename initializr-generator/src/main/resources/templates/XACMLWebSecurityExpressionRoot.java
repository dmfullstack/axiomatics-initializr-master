
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.axiomatics.spring.security.xacml.AbstractXACMLWebSecurityExpressionRoot;

package {{packageName}};
@Component
@Lazy
public class XACMLWebSecurityExpressionRoot extends AbstractXACMLWebSecurityExpressionRoot {

	public XACMLWebSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
		super(a, fi);
	}


	/*
	 * Details about the http request can be retrieved using the getters provided by
	 * AbstractXACMLWebSecurityExpressionRoot
	 */
	HttpServletRequest request = super.getRequest();
	String fullRequesrUrl = super.getFullRequestUrl();

	/**
	 * Implementation of method called by all XACML decision instance Can be used to
	 * set attribute details that are generic to the decision scope.
	 * <p>
	 * The idea is that this is the place to set extra attributes that might be
	 * needed for the XACML decision making process and is not already present in
	 * the AbstractXACMLWebSecurityExpressionRoot implementation.
	 * <p>
	 * Make sure to add to all the four arrayList.
	 */
	@Override
	public void setDefaultAttributes() {
		// This will set all default attributes for methods called that are part of this class. This
		// is separate from XACMLSecurityExpressionRoot setDefaultAttributes()
		// IMPORTANT NOTE:
		// Like in the XACMLSecurityExpressionRoot, all arrays must be added
		// to in the methods for this class. 
		// These arrays are: attrCatAry, attrTypeAry, attrIdAry,
		// and attrValAry;
	}

	/**
	 * Implementation of method that is called when XACML is used in taglib for UI
	 * display control
	 */
	@Override
	public void uiDecisionSetDefaultAttributes() {
		// Add default attributes for decisions related to UI elements access
	

	}

	/**
	 * Implementation of method that is called when XACML is used to control access
	 * to URLs. We are not using this method in this tutorial.
	 */
	@Override
	public void urlDecisionSetDefaultAttributes() {
		// Add default attributes for decisions related to URL access

	}

}