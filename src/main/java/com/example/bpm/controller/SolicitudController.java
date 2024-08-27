package com.example.bpm.controller;

import com.example.bpm.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService solicitudService;

    @GetMapping("/")
    public String listarSolicitudes(Model model) {
        model.addAttribute("solicitudes", solicitudService.obtenerTodas());
        return "solicitudes";
    }

    @PostMapping("/crear")
    public String crearSolicitud(@RequestParam String descripcion) {
        solicitudService.crearSolicitud(descripcion);
        return "redirect:/";
    }

    @PostMapping("/aprobar")
    public String aprobarSolicitud(@RequestParam Long id) {
        solicitudService.aprobarSolicitud(id);
        return "redirect:/";
    }

    @PostMapping("/rechazar")
    public String rechazarSolicitud(@RequestParam Long id) {
        solicitudService.rechazarSolicitud(id);
        return "redirect:/";
    }
}
