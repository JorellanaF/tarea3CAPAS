package com.example.tarea3capas.controller;

import com.example.tarea3capas.domain.Estudiante;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.ls.LSOutput;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class MainController{

    @GetMapping("/agregarEstudiante")
    public String enviarForm(Estudiante estudiante){
        return "agregarEstudiante";
    }

    @PostMapping("/agregarEstudiante")
    public ModelAndView procesarForm(@ModelAttribute(name = "estudiante") Estudiante estudiante, HttpServletResponse resp) throws IOException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoAnnio = new SimpleDateFormat("yyyy");
        Date fecha = null;
        try {
            fecha = formatoFecha.parse(estudiante.getFecha());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String annio = formatoAnnio.format(fecha);
        int annioI = Integer.parseInt(annio);
        System.out.println(annio);
        System.out.println(estudiante.getLugar().length());

        boolean err1 = true;
        boolean err2 = true;
        boolean err3 = true;
        boolean err4 = true;
        boolean err5 = true;
        boolean err6 = true;
        boolean err7 = true;

        if(estudiante.getNombre().length() >= 1 && estudiante.getNombre().length() < 25){
            err1 = true;
        }else {
            err1 = false;
        }

        if(estudiante.getApellido().length() >= 1 && estudiante.getApellido().length() < 25){
            err2 = true;
        }else {
            err2 = false;
        }

        if(annioI >= 2003){
            err3 = true;
        }else {
            err3 = false;
        }

        if(estudiante.getLugar().length() >= 1 && estudiante.getApellido().length() < 25){
            err4 = true;
        }else {
            err4 = false;
        }

        if(estudiante.getInstituto().length() >= 1 && estudiante.getApellido().length() < 100){
            err5 = true;
        }else {
            err5 = false;
        }

        if(estudiante.getCelular().length() == 8){
            err6 = true;
        }else {
            err6 = false;
        }

        if(estudiante.getTelefono().length() == 8){
            err7 = true;
        }else {
            err7 = false;
        }

        if(err1 && err2 && err3 && err4 && err5 && err6 && err7){
            ModelAndView form = new ModelAndView();
            form.setViewName("redirect:/exito");
            return form;
        }else {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<body>");

            if(err1 == false){
                out.println("<h2>");
                out.println("El nombre ingresado esta vacio o excede los caracteres");
                out.println("</h2>");
            }else {
                out.println("<h2>");
                out.println("</h2>");
            }

            if(err2 == false){
                out.println("<h2>");
                out.println("El apellido ingresado esta vacio o excede los caracteres");
                out.println("</h2>");
            }else {
                out.println("<h2>");
                out.println("</h2>");
            }

            if(err3 == false){
                out.println("<h2>");
                out.println("La fecha ingresada no puede ser menor a 2003");
                out.println("</h2>");
            }else {
                out.println("<h2>");
                out.println("</h2>");
            }

            if(err4 == false){
                out.println("<h2>");
                out.println("El lugar de nacimiento ingresado esta vacio o excede los caracteres");
                out.println("</h2>");
            }else {
                out.println("<h2>");
                out.println("</h2>");
            }

            if(err5 == false){
                out.println("<h2>");
                out.println("El instituto ingresado esta vacio o excede los caracteres");
                out.println("</h2>");
            }else {
                out.println("<h2>");
                out.println("</h2>");
            }

            if(err6 == false){
                out.println("<h2>");
                out.println("El celular ingresado esta vacio o excede los caracteres");
                out.println("</h2>");
            }else {
                out.println("<h2>");
                out.println("</h2>");
            }

            if(err7 == false){
                out.println("<h2>");
                out.println("El telefono ingresado esta vacio o excede los caracteres");
                out.println("</h2>");
            }else {
                out.println("<h2>");
                out.println("</h2>");
            }

            out.println("<a href=\"agregarEstudiante\">Regresar</a>");

            out.println("</body>");
            out.println("</html>");
        }
        return null;
    }

    @GetMapping("/fallo")
    public String fallo() throws FileNotFoundException {

        return "fallo";
    }

    @PostMapping("/fallo")
    public String procesF(){

        return "fallo";
    }

    @GetMapping("/exito")
    public String formE(){
        return "exito";
    }

    @PostMapping("/exito")
    public ModelAndView procesE(){
        ModelAndView form = new ModelAndView();
        form.setViewName("redirect:/agregarEstudiante");
        return form;
    }
}
