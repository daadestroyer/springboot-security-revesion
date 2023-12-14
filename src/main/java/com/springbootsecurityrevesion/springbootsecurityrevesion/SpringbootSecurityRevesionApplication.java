package com.springbootsecurityrevesion.springbootsecurityrevesion;

import com.springbootsecurityrevesion.springbootsecurityrevesion.Constant.RoleConstant;
import com.springbootsecurityrevesion.springbootsecurityrevesion.Model.Role;
import com.springbootsecurityrevesion.springbootsecurityrevesion.Repo.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class SpringbootSecurityRevesionApplication implements CommandLineRunner {


	@Autowired
	private RoleRepo roleRepo;


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityRevesionApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		Role role1 = new Role();
		role1.setRoleId(RoleConstant.ADMIN_ROLE);
		role1.setRole("ROLE_ADMIN");

		Role role2 = new Role();
		role2.setRoleId(RoleConstant.USER_ROLE);
		role2.setRole("ROLE_USER");

		List<Role> roles = List.of(role1,role2);
		List<Role> result = this.roleRepo.saveAll(roles);
		System.out.println("Default role assigned"+roles);
	}
}
