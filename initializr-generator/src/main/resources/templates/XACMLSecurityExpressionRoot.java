import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.axiomatics.sdk.context.SDKResponse;

package {{packageName}};

// Don't alter the annotations above the class name - they are needed.
@Component
@Lazy
public class XACMLSecurityExpressionRoot {
	
	public XACMLSecurityExpressionRoot(Authentication a) {
		super(a);
	}
	
    
	@Override
	protected void setDefaultAttributes() {
	
		// We can add attributes that are always present like so:
/*		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		attrCatAry.add("SUBJECT");
		attrTypeAry.add("STRING");
		attrIdAry.add("com.axiomatics.someThing");
		attrValAry.add(auth.getName());
		Collection<?> authorities = auth.getAuthorities();
		for (Iterator<?> roleIter = authorities.iterator(); roleIter.hasNext();){
			GrantedAuthority grantedAuthority = (GrantedAuthority) roleIter.next();
			attrCatAry.add("SUBJECT");
			attrTypeAry.add("STRING");
			attrIdAry.add("role");
			attrValAry.add(grantedAuthority.getAuthority());
		}*/
	}
	
	@Override
	protected void postAuthzDecisionSetDefaultAttributes() {
		// called during @PostAuthorize(...)
		
	}
	@Override
	protected void postFilterDecisionSetDefaultAttributes() {
		// called during @PostFilter(...)
		
	}
	@Override
	protected void preAuthzDecisionSetDefaultAttributes() {
	
	
		// called for @PreAuthorize(...)

		
	}
	@Override
	protected void preFilterDecisionSetDefaultAttributes() {
		// called for @PreFilter(...)
		
	}
	
	@Override
	public boolean processXACMLResponse(SDKResponse response){
	// the default processXACMLResponse can be overridden to define what happens 
	// when a decision is made. 
	/*	if(response.getDecision()==0) {
			System.out.println("allowed! ");
			return permitAll;
		}else {
			System.out.println("denied! ");
			return denyAll;
		}*/

	}


}
