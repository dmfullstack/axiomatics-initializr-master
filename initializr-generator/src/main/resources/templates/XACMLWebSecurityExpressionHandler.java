
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.stereotype.Component;

package {{packageName}};

@Component
public class XACMLWebSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {
	@Autowired
	ApplicationContext applicationContext;
	
	
    private final AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

    protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, FilterInvocation fi) {
        WebSecurityExpressionRoot root = (XACMLWebSecurityExpressionRoot) applicationContext.getBean("XACMLWebSecurityExpressionRoot", authentication, fi);
        root.setPermissionEvaluator(getPermissionEvaluator());	
        root.setTrustResolver(trustResolver);					
        root.setRoleHierarchy(getRoleHierarchy());				
        return root;
    }
}
