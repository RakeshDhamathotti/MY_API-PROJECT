package Api.build.SecurityConfig;

import java.io.IOException;
import java.time.LocalDateTime;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import Api.build.Service.implementation.CustUserDetailsService;
import Api.build.Service.implementation.JwtUtilService;
// import api.exm.build.Entity.User;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtFilter extends OncePerRequestFilter{


	final JwtUtilService jwtUtil;

	
	final ApplicationContext applicationContext;


	JwtFilter(JwtUtilService jwtUtil, ApplicationContext applicationContext) {
		this.jwtUtil = jwtUtil;
		this.applicationContext = applicationContext;
	}


    

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		 

		String header =request.getHeader("Authorization");
		String token=null;
		String username=null;

		try{

			if(header!=null &&header.startsWith("Bearer "))
			{

				token=header.substring(7);

				username=jwtUtil.extractUserName(token);

			}



			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
			{


				UserDetails userDetails=applicationContext.getBean(CustUserDetailsService.class).loadUserByUsername(username);



				if(jwtUtil.validatToken(token, userDetails))
				{
					UsernamePasswordAuthenticationToken auth =new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

					auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));


					SecurityContextHolder.getContext().setAuthentication(auth);




				}


			}

			filterChain.doFilter(request,response);
		}catch(ExpiredJwtException ex)
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("application/json");

			response.getWriter().write(
				"""
					"timestamp": "%s",
                    "status": 401,
                    "error": "Unauthorized",
                    "message": "JWT Token Expired.login Again",
                    "path": "%s"
						""".formatted(LocalDateTime.now(),request.getRequestURI())
			);
		}


		}
	}

