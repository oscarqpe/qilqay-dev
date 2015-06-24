package com.os.foro.servlets;

import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.googlecode.objectify.ObjectifyService;
import com.os.foro.entity.ComentarioDto;
import com.os.foro.entity.TemaComentarioDto;
import com.os.foro.entity.TemaDto;
import com.os.foro.entity.UsuarioDto;

public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 7003530042096811840L;
    private static final Logger LOGGER = Logger.getLogger(InitServlet.class.getName());

    public static void initApp() {

        //ObjectifyService.register(ConfigurationDto.class);
        ObjectifyService.register(UsuarioDto.class);
        ObjectifyService.register(TemaDto.class);
        ObjectifyService.register(ComentarioDto.class);
        ObjectifyService.register(TemaComentarioDto.class);

        //ConfigUtil config = ConfigUtil.getInstance();
        //config.copyPropertiesIntoDatastore(true);

    }

    @Override
    public void init() throws ServletException {
        initApp();
    }
}
