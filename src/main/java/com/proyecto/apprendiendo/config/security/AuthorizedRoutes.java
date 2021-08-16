package com.proyecto.apprendiendo.config.security;

import com.proyecto.apprendiendo.entities.Classroom;
import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectNewDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.entities.dtos.UserLoginDTO;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.CreateAvatarBodyPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.CreateAvatarService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.CreateClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.UpdateClassroomStudentsService;
import com.proyecto.apprendiendo.services.abm_services.project_services.CreateProjectService;
import com.proyecto.apprendiendo.services.abm_services.project_services.GetProjectStudentsService;
import com.proyecto.apprendiendo.services.abm_services.project_services.UpdateProjectStudentsService;
import com.proyecto.apprendiendo.services.abm_services.user_services.CreateUserService;
import com.proyecto.apprendiendo.services.abm_services.user_services.GetStudentService;
import com.proyecto.apprendiendo.services.abm_services.user_services.GetUserDetailsService;
import com.proyecto.apprendiendo.services.JwtTokenFilter;
import com.proyecto.apprendiendo.services.abm_services.user_services.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import static java.lang.String.format;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class AuthorizedRoutes extends WebSecurityConfigurerAdapter {
    private final JwtTokenFilter jwtTokenFilter;
    private final GetUserDetailsService getUserDetailsService;

    @Autowired
    public AuthorizedRoutes(JwtTokenFilter jwtTokenFilter, GetUserDetailsService getUserDetailsService) {
        this.jwtTokenFilter = jwtTokenFilter;
        this.getUserDetailsService = getUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getUserDetailsService);
    }

    // Set password encoding schema
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint((request, response, ex) ->
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage()))
                .and();

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register/admin").permitAll()
                .antMatchers("/class","/class/**").hasAnyRole(UserType.ADMIN.getValue())
                .antMatchers("/register/student", "/register/teacher").hasAnyRole(UserType.ADMIN.getValue())
                .anyRequest().authenticated();

        http.addFilterBefore(
                jwtTokenFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }

    private CreateUserService createUserService;
    private CreateClassroomService createClassroomService;
    private CreateProjectService createProjectService;
    private CreateAvatarService createAvatarService;
    private CreateAvatarBodyPartService createAvatarBodyPartService;
    private GetUserService getUserService;
    private GetClassroomService getClassroomService;
    private GetProjectStudentsService getProjectStudentsService;
    private UpdateProjectStudentsService updateProjectStudentsService;
    private GetClassroomStudentsService getClassroomStudentsService;
    private UpdateClassroomStudentsService updateClassroomStudentsService;
    private GetStudentService getStudentService;


    private void populateTestEnvironment(CreateUserService createUserService,
                                         CreateClassroomService createClassroomService,
                                         CreateProjectService createProjectService,
                                         CreateAvatarService createAvatarService,
                                         CreateAvatarBodyPartService createAvatarBodyPartService,
                                         GetUserService getUserService, GetClassroomService getClassroomService,
                                         GetProjectStudentsService getProjectStudentsService,
                                         UpdateProjectStudentsService updateProjectStudentsService,
                                         GetClassroomStudentsService getClassroomStudentsService,
                                         UpdateClassroomStudentsService updateClassroomStudentsService,
                                         GetStudentService getStudentService){

        this.createUserService = createUserService;
        this.createProjectService = createProjectService;
        this.createClassroomService = createClassroomService;
        this.createAvatarService = createAvatarService;
        this.createAvatarBodyPartService = createAvatarBodyPartService;
        this.getUserService = getUserService;
        this.getClassroomService = getClassroomService;
        this.getProjectStudentsService = getProjectStudentsService;
        this.updateProjectStudentsService = updateProjectStudentsService;
        this.getClassroomStudentsService = getClassroomStudentsService;
        this.updateClassroomStudentsService = updateClassroomStudentsService;
        this.getStudentService = getStudentService;

        Long adminId = createUserService.execute(UserLoginDTO.builder().username("admin").password("admin").build(),UserType.ADMIN);
        Long andreaId = createUserService.execute(UserLoginDTO.builder().username("andrea").password("andrea").build(),UserType.TEACHER);
        Long pabloId = createUserService.execute(UserLoginDTO.builder().username("pablo").password("pablo").build(),UserType.TEACHER);
        Long javiId = createUserService.execute(UserLoginDTO.builder().username("javi").password("javi").build(),UserType.STUDENT);
        Long agusId = createUserService.execute(UserLoginDTO.builder().username("agus").password("agus").build(),UserType.STUDENT);
        Long nazaId = createUserService.execute(UserLoginDTO.builder().username("naza").password("naza").build(),UserType.STUDENT);
        Long paoId = createUserService.execute(UserLoginDTO.builder().username("pao").password("pao").build(),UserType.STUDENT);
        Long mariId = createUserService.execute(UserLoginDTO.builder().username("mari").password("mari").build(),UserType.STUDENT);

        Long superCursoId = createClassroomService.execute(ClassroomDTO.builder().name("super curso").teacherId(andreaId).build());
        Long superCurso2Id = createClassroomService.execute(ClassroomDTO.builder().name("super curso").teacherId(pabloId).build());

        Long superProyectoId = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("super proyecto").methodologyId(Integer.toUnsignedLong(0)).build(),superCursoId);
        Long ultraProyectoId = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("ultra proyecto").methodologyId(Integer.toUnsignedLong(0)).build(),superCurso2Id);
        Long megaProyectoId = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("mega proyecto").methodologyId(Integer.toUnsignedLong(0)).build(),superCurso2Id);


        ArrayList<StudentDTO> estudiantesSuperCurso = new ArrayList<>();
        estudiantesSuperCurso.add(getStudentService.execute(javiId));
        estudiantesSuperCurso.add(getStudentService.execute(agusId));
        estudiantesSuperCurso.add(getStudentService.execute(nazaId));
        estudiantesSuperCurso.add(getStudentService.execute(paoId));

        ArrayList<StudentDTO> estudiantesSuperProyecto = new ArrayList<>();
        estudiantesSuperProyecto.add(getStudentService.execute(javiId));
        estudiantesSuperProyecto.add(getStudentService.execute(agusId));

        ArrayList<StudentDTO> estudiantesCurso2 = new ArrayList<>();
        estudiantesCurso2.add(getStudentService.execute(mariId));
        estudiantesCurso2.add(getStudentService.execute(paoId));
        estudiantesCurso2.add(getStudentService.execute(nazaId));

        ArrayList<StudentDTO> estudiantesUltraProyecto = new ArrayList<>();
        estudiantesUltraProyecto.add(getStudentService.execute(paoId));
        estudiantesUltraProyecto.add(getStudentService.execute(nazaId));

        ArrayList<StudentDTO> estudiantesMegaProyecto = new ArrayList<>();
        estudiantesMegaProyecto.add(getStudentService.execute(mariId));
        estudiantesMegaProyecto.add(getStudentService.execute(paoId));

        updateClassroomStudentsService.execute(superCursoId,estudiantesSuperCurso);
        updateProjectStudentsService.execute(superProyectoId,estudiantesSuperProyecto);

        updateClassroomStudentsService.execute(superCurso2Id,estudiantesCurso2);
        updateProjectStudentsService.execute(megaProyectoId,estudiantesMegaProyecto);
        updateProjectStudentsService.execute(ultraProyectoId,estudiantesUltraProyecto);
    }
}
