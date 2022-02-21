package com.ceiba.configuracion;

import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.ServicioActualizarAlquiler;
import com.ceiba.alquiler.servicio.ServicioCrearAlquiler;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;
import com.ceiba.motocicleta.servicio.ServicioCrearMotocicleta;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioActualizarAlquiler servicioActualizarAlquiler(RepositorioAlquiler repositorioAlquiler, DaoAlquiler daoAlquiler){
        return new ServicioActualizarAlquiler(repositorioAlquiler,daoAlquiler);
    }

    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, RepositorioMotocicleta repositorioMotocicleta, DaoMotocicleta daoMotocicleta){
        return new ServicioCrearAlquiler(repositorioAlquiler, repositorioMotocicleta, daoMotocicleta);
    }

    @Bean
    public ServicioCrearMotocicleta servicioCrearMotocicleta(RepositorioMotocicleta repositorioMotocicleta){
        return new ServicioCrearMotocicleta(repositorioMotocicleta);
    }
    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	

}
