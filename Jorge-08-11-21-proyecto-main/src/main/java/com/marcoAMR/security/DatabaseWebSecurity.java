package com.marcoAMR.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//auth.jdbcAuthentication().dataSource(dataSource);
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, estatus from usuarios where username=?")
		.authoritiesByUsernameQuery("select u.username, p.perfil from usuarioperfil up " + 
		"inner join usuarios u on u.id = up.idUsuario " + 
		"inner join Perfiles p on p.id = up.idPerfil " + 
		"where u.username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	// Los recursos est�ticos no requieren autenticaci�n
	.antMatchers(
			"/bootstrap/**", 
			"/images/**",
			"/tinymce/**",
			"/logos/**").permitAll()
	// Las vistas p�blicas no requieren autenticaci�n
	.antMatchers("/", 
			"/registro",
			"/guardar",
			"/vacantes/detalles/**").permitAll()
	
	
	
	
	
	// Asignar permisos a URLs por ROLES
	.antMatchers("/vacantes/**").hasAnyAuthority("Supervisor","Administrador")
	.antMatchers("/categorias/**").hasAnyAuthority("Supervisor","Administrador")
	.antMatchers("/perfiles/**").hasAnyAuthority("Administrador")
	.antMatchers("/usuarios/**").hasAnyAuthority("Administrador")
	
	
	
	// Todas las dem�s URLs de la Aplicaci�n requieren autenticaci�n
	.anyRequest().authenticated()
	// El formulario de Login no requiere autenticacion
	.and().formLogin().permitAll();
	}
	
}
