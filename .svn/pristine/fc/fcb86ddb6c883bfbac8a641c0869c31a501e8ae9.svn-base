package com.hyva.idm.filter;

/**
 * Created by tnataraj on 1/15/18.
 */

//@Component
public class AuthenticationFilter {

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = asHttp(servletRequest);
//        HttpServletResponse httpResponse = asHttp(servletResponse);
//        String resourcePath = new UrlPathHelper().getPathWithinApplication(httpRequest);
//        String username = httpRequest.getHeader("X-Auth-Username");
//        String password = httpRequest.getHeader("X-Auth-Password");
//        String token = httpRequest.getHeader("X-Auth-Token");
//        try {
//
//            if (postToAuthenticateUserNamePassword(httpRequest, resourcePath)) {
//                processUsernamePasswordAuthentication(httpResponse, username, password);
//            }
//
////            if(token != null){
////                processTokenAuthentication(token);
////            }
//            filterChain.doFilter(servletRequest, servletResponse);
//        } catch (InternalAuthenticationServiceException internalAuthenticationServiceException) {
//            SecurityContextHolder.clearContext();
//            httpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        } catch (AuthenticationException authenticationException) {
//            SecurityContextHolder.clearContext();
//            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
//        } finally {
//        }
//    }
//
//    private HttpServletRequest asHttp(ServletRequest request) {
//        return (HttpServletRequest) request;
//    }
//
//    private HttpServletResponse asHttp(ServletResponse response) {
//        return (HttpServletResponse) response;
//    }
//
//    private boolean postToAuthenticateUserNamePassword(HttpServletRequest httpRequest, String resourcePath) {
//        return EndpointConstants.AUTHENTICATION_USER_PASS.equalsIgnoreCase(resourcePath) && httpRequest.getMethod().equals("POST");
//    }
//
//    private void processUsernamePasswordAuthentication(HttpServletResponse httpResponse, String username, String password) throws IOException {
//        Authentication resultOfAuthentication = tryToAuthenticateWithUsernameAndPassword(username, password);
//        SecurityContextHolder.getContext().setAuthentication(resultOfAuthentication);
//        httpResponse.setStatus(HttpServletResponse.SC_OK);
//        httpResponse.addHeader("Content-Type", "application/json");
////        httpResponse.addHeader("X-Auth-Token", resultOfAuthentication.getDetails().toString());
//    }
//
//    private Authentication tryToAuthenticateWithUsernameAndPassword(String username, String password) {
//        UsernamePasswordAuthenticationToken requestAuthentication = new UsernamePasswordAuthenticationToken(username, password);
//        return tryToAuthenticate(requestAuthentication);
//    }
//
//    private Authentication tryToAuthenticate(Authentication requestAuthentication) {
//        Authentication responseAuthentication = authenticationManager.authenticate(requestAuthentication);
//        if (responseAuthentication == null || !responseAuthentication.isAuthenticated()) {
//            throw new InternalAuthenticationServiceException("Unable to authenticate Domain User for provided credentials");
//        }
//        return responseAuthentication;
//    }
//
////    private Authentication tryToAuthenticateWithToken(String token) {
////        PreAuthenticatedAuthenticationToken requestAuthentication = new PreAuthenticatedAuthenticationToken(token, null);
////        return tryToAuthenticate(requestAuthentication);
////    }
//
//    @Override
//    public void destroy() {
//
//    }
}
