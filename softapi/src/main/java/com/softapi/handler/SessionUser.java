package com.softapi.handler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * retorna a sessao do usuario atual.
 * @author osvaldoairon
 *
 */
public class SessionUser {
	public static User getSessionUser() {
		return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
